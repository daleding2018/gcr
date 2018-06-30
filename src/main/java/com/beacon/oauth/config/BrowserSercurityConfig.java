package com.beacon.oauth.config;

import com.beacon.oauth.authorize.AuthorizeConfigManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 实现浏览器认证配置
 */
@Configuration
@Slf4j
public class BrowserSercurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    /**
     * 密码加解密
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        //这里可以返回自定义加密，比如MD5
        return new BCryptPasswordEncoder();
    }


    /**
     * 重写http请求配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//配置表单登录
                .and()  //添加配置
                .authorizeRequests()//添加请求认证
                .antMatchers("/health","/hystrix.stream").permitAll()
                .anyRequest()       //所有请求都是
                .authenticated()    //需要认证
                .and()
                .csrf().disable()   //暂时关闭跨站请求伪造防护暂时关闭
                ;

        //自定义权限配置
        authorizeConfigManager.config(http.authorizeRequests());

    }
}
