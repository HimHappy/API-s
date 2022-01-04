package com.PractiseTillOf.Practise1.controller;

import com.PractiseTillOf.Practise1.model.Pmodel;
import com.PractiseTillOf.Practise1.service.Pservice;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/practice")
public class Pcontroller {

    @Autowired
    private Pservice pservice;

    Logger logger= LoggerFactory.getLogger(Pcontroller.class);

//    @GetMapping("/all")
//    public List<Pmodule> all(@RequestParam(defaultValue = "0") int pagenumber,@RequestParam(defaultValue = "5")int pagesize){
//        logger.trace("In GetMapping All");
//        return pservice.getall(pagenumber,pagesize);
//    }
    @ApiOperation("Get Details of all")
    @GetMapping(path = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pmodel> all(){
        logger.trace("in GetMapping ");
        return pservice.getall();
    }

    @ApiOperation("Get Details by entering Id")
    @GetMapping(path = "/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Pmodel> one(@PathVariable("pid") UUID pid){
        logger.trace("In GetMapping By Id");
        return pservice.getone(pid);
    }
    @ApiOperation("Get Details by entering Name")
    @GetMapping(path = "get-name/{pname}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pmodel> getByName(@PathVariable("pname") String pname){
        logger.trace("In GetMapping By Name");
        return pservice.getbyName(pname);
    }
    @ApiOperation("Get Details of Pass Student")
    @GetMapping(path = "pass-student/{status}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pmodel> pass(@PathVariable("status") String status){
        return pservice.passed(status);
    }

    @ApiOperation("Add Details of new comers")
    @PostMapping(path = "/post",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pmodel> post(@RequestBody Pmodel pmodule){
        logger.trace("In PostMapping All");
        return pservice.add(pmodule);
    }

    @ApiOperation("Delete user from database")
    @DeleteMapping(path = "delete/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("pid") UUID pid){
        logger.trace("In DeleteMapping By Id");
        pservice.remove(pid);
    }

    @ApiOperation("Update Details")
    @PutMapping(path = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public Pmodel put(@RequestBody Pmodel pmodule) {
        logger.trace("In PutMapping ");
        return pservice.update(pmodule);
    }

}
