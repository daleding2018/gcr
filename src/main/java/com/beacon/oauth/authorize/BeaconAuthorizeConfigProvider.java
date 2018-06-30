package com.beacon.oauth.authorize;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 实现自定义声明的接口
 */
//@Component
//@Order(Integer.MAX_VALUE)//定义执行顺序为最后一个
public class BeaconAuthorizeConfigProvider implements AuthorizeConfigProvider {
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
//        config.anyRequest().access("@rbacService.hasPermission(request,authentication)");
    }
}
