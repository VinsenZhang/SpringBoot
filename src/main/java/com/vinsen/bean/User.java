package com.vinsen.bean;

public class User {

    private int uid;

    private String uname;

    private String pwd;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    @Override
    public String toString() {
        return "User:{" +
                "uid:" + uid +
                ", uname:" + uname + '\'' +
                ", pwd:'" + pwd + '\'' +
                '}';
    }
}
