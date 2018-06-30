package com.beacon.oauth.support;

import com.beacon.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.*;

public class MyUserDetails extends User   {


    private int userid;
    private String englishname;
    private String chinesename;
    private String email;
    private String company;
    private String dept;
    private String phone;
    private String country;
    private String area;
    private String extension;
    private int loginnum;
    private String token;
    private String head;
    private String face;
    private String finger;
    private String usertype;
    private Date expiredate;
    private Date firstlogin;
    private Date lastlogin;
    private Date recentlogin;
    private String bu;
    private String bg;
    private String subbg;
    private String subbu;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getLoginnum() {
        return loginnum;
    }

    public void setLoginnum(int loginnum) {
        this.loginnum = loginnum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFinger() {
        return finger;
    }

    public void setFinger(String finger) {
        this.finger = finger;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Date getExpire_date() {
        return expiredate;
    }

    public void setExpire_date(Date expire_date) {
        this.expiredate = expire_date;
    }

    public Date getFirstlogin() {
        return firstlogin;
    }

    public void setFirstlogin(Date firstlogin) {
        this.firstlogin = firstlogin;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Date getRecentlogin() {
        return recentlogin;
    }

    public void setRecentlogin(Date recentlogin) {
        this.recentlogin = recentlogin;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getSubbg() {
        return subbg;
    }

    public void setSubbg(String subbg) {
        this.subbg = subbg;
    }

    public String getSubbu() {
        return subbu;
    }

    public void setSubbu(String subbu) {
        this.subbu = subbu;
    }

    public MyUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MyUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /**
     *  private int userid;
     private String englishname;
     private String chinesename;
     private String email;
     private String company;
     private String dept;
     private String phone;
     private String country;
     private String area;
     private String extension;
     private int loginnum;
     private String token;
     private String head;
     private String face;
     private String finger;
     private String usertype;
     private Date expire_date;
     private Date firstlogin;
     private Date lastlogin;
     private Date recentlogin;
     private String bu;
     private String bg;
     private String subbg;
     private String subbu;
     * @param account
     */

    public void setMyUserDetails(Account account){
        this.userid = account.getUserid();
        this.englishname = account.getEnglishname();
        this.chinesename = account.getChinesename();
        this.email = account.getEmail();
        this.company = account.getCompany();
        this.dept = account.getDept();
        this.phone = account.getPhone();
        this.country = account.getCountry();
        this.area = account.getArea();
        this.extension = account.getExtension();
        this.loginnum = account.getLoginnum();
        this.token = account.getToken();
        this.head = account.getHead();
        this.face = account.getFace();
        this.finger = account.getFinger();
        this.usertype = account.getUsertype();
        this.expiredate = account.getExpire_date();
        this.firstlogin = account.getFirstlogin();
        this.lastlogin = account.getLastlogin();
        this.recentlogin = account.getRecentlogin();
        this.bu = account.getBu();
        this.bg = account.getBg();
        this.subbg = account.getSubbg();
        this.subbu = account.getSubbu();
        if (account.getIsactive()==1){
            this.isAccountNonExpired();
        }

    }


}
