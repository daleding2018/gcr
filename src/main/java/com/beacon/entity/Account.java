package com.beacon.entity;


import java.util.Date;

public class Account {

    private int userid;
    /**工号*/
    private String employeeid;
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
    private int isactive;
    private Date expiredate;
    private Date firstlogin;
    private Date lastlogin;
    private Date recentlogin;
    private String bu;
    private String bg;
    private String subbg;
    private String subbu;
    private String password;



    public Account() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public int getId() {
        return userid;
    }

    public void setId(int id) {
        this.userid = id;
    }

    public String getName() {
        return chinesename;
    }

    public void setName(String name) {
        this.chinesename = name;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
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

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Account{" +
                "userid=" + userid +
                ", employeeid='" + employeeid + '\'' +
                ", englishname='" + englishname + '\'' +
                ", chinesename='" + chinesename + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", dept='" + dept + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", area='" + area + '\'' +
                ", extension='" + extension + '\'' +
                ", loginnum=" + loginnum +
                ", token='" + token + '\'' +
                ", head='" + head + '\'' +
                ", face='" + face + '\'' +
                ", finger='" + finger + '\'' +
                ", usertype='" + usertype + '\'' +
                ", isactive=" + isactive +
                ", expiredate=" + expiredate +
                ", firstlogin=" + firstlogin +
                ", lastlogin=" + lastlogin +
                ", recentlogin=" + recentlogin +
                ", bu='" + bu + '\'' +
                ", bg='" + bg + '\'' +
                ", subbg='" + subbg + '\'' +
                ", subbu='" + subbu + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
