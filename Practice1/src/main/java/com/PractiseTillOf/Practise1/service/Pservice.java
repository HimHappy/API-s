package com.PractiseTillOf.Practise1.service;

import com.PractiseTillOf.Practise1.model.Pmodel;
import com.PractiseTillOf.Practise1.repository.Prepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class Pservice {
    @Autowired
    private Prepository prepository;

//    public List<Pmodule> getall(int pagenumber, int pagesize) {
//        Pageable pgbl= PageRequest.of(pagenumber,pagesize);
//        return prepository.findAll(pgbl).toList() ;
//    }

    public List<Pmodel> getall(){
        return prepository.findAll();
    }
    public Optional<Pmodel> getone(UUID pid) {
        return prepository.findById(pid);
    }
    public List<Pmodel> add(Pmodel pmodule) {
        prepository.save(pmodule);
        return prepository.findAll();
    }
    public void remove(UUID pid) {
            prepository.deleteById(pid);
    }
    public Pmodel update(Pmodel pmodule) {
        Optional<Pmodel> optionalPmodule=prepository.findById(pmodule.getPid());
        AtomicReference<Pmodel> atomicReference=new AtomicReference<>();
        optionalPmodule.ifPresentOrElse(ref-> {
            ref.setUpdatedTime(new  Date());
            ref.setPname(pmodule.getPname() != null ? pmodule.getPname() : ref.getPname());
            ref.setPhobbies(pmodule.getPhobbies() != null ? pmodule.getPhobbies() : ref.getPhobbies());
            ref.setSubjects(pmodule.getSubjects() != null ? pmodule.getSubjects() : ref.getSubjects());
            ref.setMarks(pmodule.getMarks() != null ? pmodule.getMarks() : ref.getMarks());
            ref.setStatus(pmodule.getStatus() != null ? pmodule.getStatus() : ref.getStatus());
            atomicReference.set(prepository.save(ref));
        },()->{
            try {
                        throw new Exception("SORRY ! WHAT ARE YOU LOOKING ABOUT");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        return atomicReference.get();
    }

    public List<Pmodel> getbyName(String pname) {
//        pname=pname.replaceAll("\\(","\\\\(");
//        pname=pname.replaceAll("\\)","\\\\)");
        return prepository.getbyName(pname);
    }

    public List<Pmodel> passed(String status) {
        return prepository.getdetailsByStatus(status);
    }
}






