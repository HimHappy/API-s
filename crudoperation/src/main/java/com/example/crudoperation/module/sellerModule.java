package com.example.crudoperation.module;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sellerDB")
public class sellerModule {
    @Id
    private int sid;
    private  String sname;
    private String ownerof;
    private long smobile;



    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getOwnerof() {
        return ownerof;
    }

    public void setOwnerof(String ownerof) {
        this.ownerof = ownerof;
    }

    public long getSmobile() {
        return smobile;
    }

    public void setSmobile(long smobile) {
        this.smobile = smobile;
    }
    @Override
    public String toString() {
        return "sellerModule{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ownerof='" + ownerof + '\'' +
                ", smobile=" + smobile +
                '}';
    }
}
