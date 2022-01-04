package com.example.crudoperation.module;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "crudDB")
public class crudModule {
    @Id
    private int cid;
    private String cname;
    private String cmail;
    private String cpass;
    private long mobile;


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCmail() {
        return cmail;
    }

    public void setCmail(String cmail) {
        this.cmail = cmail;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "crudController{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cmail='" + cmail + '\'' +
                ", cpass='" + cpass + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
