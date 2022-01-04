package com.PractiseTillOf.Practise1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "practice")
public class Pmodel {
    @Id
    private UUID pid;
    private String pname;
    private List<String> phobbies;
    private List<String> subjects;
    private List<Float> marks;
    private Date createdTime;
    private Date updatedTime;
    private String status;

    //default constructer
    Pmodel(){
        this.pid=UUID.randomUUID();
        this.createdTime=new Date();
    }
    //parameterized constructer
    public Pmodel(UUID pid, String pname, List<String> phobbies, List<String> subjects, List<Float> marks, Date createdTime, Date updatedTime, String status) {
        this.pid = pid;
        this.pname = pname;
        this.phobbies = phobbies;
        this.subjects = subjects;
        this.marks = marks;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.status = status;
    }

    //setter and getter
    public UUID getPid() {
        return pid;
    }
    public void setPid(UUID pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public List<String> getPhobbies() {
        return phobbies;
    }
    public void setPhobbies(List<String> phobbies) {
        this.phobbies = phobbies;
    }
    public List<String> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
    public List<Float> getMarks() {
        return marks;
    }
    public void setMarks(List<Float> marks) {
        this.marks = marks;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public Date getUpdatedTime() {
        return updatedTime;
    }
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    //toString
    @Override
    public String toString() {
        return "Pmodule{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", phobbies=" + phobbies +
                ", subjects=" + subjects +
                ", marks=" + marks +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", status=" + status+
                '}';
    }
//    public void passornot(List<Float> marks){
//        Float totalmarks=
//    }
}
