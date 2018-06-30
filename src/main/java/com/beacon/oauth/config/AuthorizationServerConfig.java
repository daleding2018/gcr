package com.beacon.oauth.config;

import com.beacon.entity.Account;
import com.beacon.oauth.service.DomainUserDetailsService;
import com.beacon.oauth.support.MyUserAuthenticationConverter;
import com.beacon.properties.SecurityProperties;
import com.beacon.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;    // 认证管理器

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;  // redis连接工厂

    @Autowired
    private DomainUserDetailsService domainUserDetailsService;

    @Autowired
    private TokenEnhancer jwtTokenEnhancer;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenStore jwtTokenStore;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityProperties securityProperties;




    /**
     * 令牌存储
     * @return redis令牌存储对象
     */
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * 使用jwt生成器
     * @param
     * @throws Exception
     */
    @Bean //JwtAccessTokenConverter
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //自定义签名
        jwtAccessTokenConverter.setSigningKey("oauth");
        //重写jwt生成规则，使用自定义MyUserAuthenticationConverter
        DefaultAccessTokenConverter defaultAccessTokenConverter =  (DefaultAccessTokenConverter) jwtAccessTokenConverter.getAccessTokenConverter();
        defaultAccessTokenConverter.setUserTokenConverter(new MyUserAuthenticationConverter());
        jwtAccessTokenConverter.setAccessTokenConverter(defaultAccessTokenConverter);
        return jwtAccessTokenConverter;
    }

    /**
     * jwt生成器
     * @return
     */
    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 自定义往返回信息中存放东西增强器
     * @param
     * @throws Exception
     */
    @Bean
    @ConditionalOnMissingBean(name = "jwtTokenEnhancer")//在创建bean的时候覆盖默认的tokenEnhancer
    public TokenEnhancer jwtTokenEnhancer(){
        return new TokenEnhancer() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                Map<String,Object> info = new HashMap<>();
                User user =(User) authentication.getUserAuthentication().getPrincipal();
                Account account = userService.queryByName(user.getUsername());
                info.put("employee_id", account.getEmployeeid());
                info.put("englishname",account.getEnglishname());
                info.put("chinesename",account.getChinesename());
                info.put("email",account.getEmail());
                info.put("company",account.getCompany());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
                return accessToken;
            }
        };
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager) //定义authenticationManager
                .userDetailsService(domainUserDetailsService)       //自定义domainUserDetailsService
                .tokenStore(jwtTokenStore)                           //自定义token存储方式
                .accessTokenConverter(jwtAccessTokenConverter)    //自定义token生成方式为JWT
                ;
        //创建一个token增强器链，加入token生成器和增强器
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancers = new ArrayList<>();
        enhancers.add(jwtAccessTokenConverter);
        enhancers.add(jwtTokenEnhancer);
        tokenEnhancerChain.setTokenEnhancers(enhancers);

        endpoints.tokenEnhancer(tokenEnhancerChain);

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("isAuthenticated()")//客户端来获取jwt秘钥时需要认证
                .checkTokenAccess("isAuthenticated()")
        ;

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder =  clients.inMemory();
        builder.withClient(securityProperties.getOauth2().getClients().getClientId())
                .scopes("all")
                .secret(securityProperties.getOauth2().getClients().getClientSecret())
                .accessTokenValiditySeconds(securityProperties.getOauth2().getClients().getAccessTokenValiditySeconds())   //token有效时间
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")    //支持的模式
        ;
    }




}
