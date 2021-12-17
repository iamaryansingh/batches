package com.example.batches1;

public class User {
    private String id;
    private String myname;
    private String phone;

    public User(String nid,String nmyname,String nphone){
        id=nid;
        myname=nmyname;
        phone=nphone;
    }

    public String getId() {
        return id;
    }

    public String getMyname() {
        return myname;
    }

    public String getPhone() {
        return phone;
    }
}

