package com.example.crudoperation.service;

import com.example.crudoperation.module.crudModule;
import com.example.crudoperation.repository.crudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class crudService {
    @Autowired
    private crudRepository crudrepository;

    public List<crudModule> gettingAll(int pagenumber,int pagesize) {
        Pageable pageable= PageRequest.of(pagenumber,pagesize);
        return crudrepository.findAll(pageable).toList();
    }

    public Optional<crudModule> gettingAnyOne(int id) {
        return crudrepository.findById(id);
    }

    public crudModule add(crudModule controller) {
        return crudrepository.save(controller);
    }

    public void delete(int id) {
         crudrepository.deleteById(id);
    }

    public crudModule updating( crudModule crudmodule) {//int id,

         return crudrepository.save(crudmodule);
    }
}
