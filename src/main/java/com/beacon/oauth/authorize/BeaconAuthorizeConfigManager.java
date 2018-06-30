package com.beacon.oauth.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  自定义认证规则管理
 */
@Component
public class BeaconAuthorizeConfigManager implements AuthorizeConfigManager {

//    @Autowired
//    private List<AuthorizeConfigProvider> authorizeConfigProviders;

    /**
     * 依次执行权限配置
     * @param config
     */
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

//        for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders){
//            authorizeConfigProvider.config(config);
//        }
        config.anyRequest().authenticated();
    }
}
