package com.beacon.controller;

import com.beacon.entity.Account;
import com.beacon.entity.Result;
import com.beacon.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Slf4j
public class OauthController {

    @Autowired
    private UserService userService;

    //根据id查询用户
    @GetMapping("/user/{name}")
    public Account queryByName(@PathVariable("name") String name){
        return userService.queryByName(name);
    }


    @GetMapping("/check_token")
    public Result hello(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();

        String authorization = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(authorization,"Bearer");

        Claims body = null;
        try {
            Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey("oauth".getBytes("UTF-8")).parseClaimsJws(token);//compactJws为jwt字符串
            body = parseClaimsJws.getBody();//得到body后我们可以从body中获取我们需要的信息
        } catch (Exception e) {
            log.info(e.toString());
        }

        return new Result("200","success",body);
    }

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }

    @GetMapping("/jwt")
    public Object getCurrectUser(Authentication user, HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header,"Bearer ");
        Claims body = null;
        try {
            Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey("oauth".getBytes("UTF-8")).parseClaimsJws(token);//compactJws为jwt字符串
            body = parseClaimsJws.getBody();//得到body后我们可以从body中获取我们需要的信息
        } catch (Exception e) {
            log.info(e.toString());
        }
        return body;
    }

}
