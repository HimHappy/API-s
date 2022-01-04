package com.example.crudoperation.controller;

import com.example.crudoperation.module.sellerModule;
import com.example.crudoperation.service.sellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seller")
public class sellerController {

    @Autowired
    private sellerService sellerservice;

    @GetMapping(path = "All",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<sellerModule> GetSeller(){
        return sellerservice.Get();
    }

    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<sellerModule> GetoneSeller(@PathVariable("id") int id){
        return sellerservice.getOne(id);
    }

    @PostMapping(path = "All",produces = MediaType.APPLICATION_JSON_VALUE)
    public sellerModule posting(@RequestBody sellerModule sellermodule){
        return sellerservice.post(sellermodule);
    }

    @PutMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<sellerModule> put(@PathVariable("id")int id, @RequestBody sellerModule sellermodule){
        return sellerservice.put(id,sellermodule);
    }

    @DeleteMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") int id){
        sellerservice.toDelete(id);
    }
}
