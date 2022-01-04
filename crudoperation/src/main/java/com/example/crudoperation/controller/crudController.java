package com.example.crudoperation.controller;

import com.example.crudoperation.module.crudModule;
import com.example.crudoperation.service.crudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/goto")
public class crudController {

    @Autowired
    private crudService crudservice;

    @GetMapping(path ="/All",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<crudModule> gotoAll(@RequestParam(defaultValue = "0") int pagenumber,@RequestParam(defaultValue ="4") int pagesize){
        return crudservice.gettingAll(pagenumber,pagesize);
    }
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<crudModule> gotoAnyOne(@PathVariable("id") int id){
        return crudservice.gettingAnyOne(id);
    }

    @PostMapping(path = "/All",produces = MediaType.APPLICATION_JSON_VALUE)
    public crudModule Adding(@RequestBody crudModule controller){
        return crudservice.add(controller);
    }

    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public crudModule putting( @RequestBody crudModule crudmodule){ //@PathVariable int id,
                 return crudservice.updating( crudmodule);//id,
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleting(@PathVariable("id") int id){
        crudservice.delete(id);
    }

}
