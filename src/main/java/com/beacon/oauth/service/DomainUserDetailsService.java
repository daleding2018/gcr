package com.beacon.oauth.service;

import com.beacon.entity.Account;
import com.beacon.oauth.support.MyUserDetails;
import com.beacon.properties.SecurityProperties;
import com.beacon.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class DomainUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    //密码加解密
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public UserDetails loadUserByUsername(String employeeid) throws UsernameNotFoundException {
//        System.out.println(securityProperties.getOauth2());
        Account account = null;
        account = userService.queryByName(employeeid);

        if (account!=null){
            String password = passwordEncoder.encode(account.getPassword());
            //匹配自定义密文
//            MyUserDetails myUserDetails = new MyUserDetails(username,"$2a$10$UNzL9mGYw2ZBz9lZxkGaA.rWh9aiyiW6Lvzjr.Wm/ddRtsI48kNxa", AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
            //匹配加密明文
            MyUserDetails myUserDetails = new MyUserDetails(employeeid,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
            //匹配数据库本身就是密文
//            MyUserDetails myUserDetails = new MyUserDetails(username,account.getPasswd(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
            myUserDetails.setMyUserDetails(account);
            return myUserDetails;
        }else {
            throw  new UsernameNotFoundException("用户["+employeeid+"]不存在");
        }
    }




}
