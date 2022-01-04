package com.example.crudoperation.service;

import com.example.crudoperation.module.sellerModule;
import com.example.crudoperation.repository.sellerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class sellerService {
    @Autowired
    private sellerrepository sellerrepo;

    public List<sellerModule> Get() {                        //(int pagenumber,int pagesize
//        Pageable obj = PageRequest.of(pagenumber,pagesize);
        return sellerrepo.findAll();                                      //(obj).toList()
    }
    public Optional<sellerModule> getOne(int id) {
        return sellerrepo.findById(id);
    }
    public sellerModule post(sellerModule sellermodule) {
        return sellerrepo.save(sellermodule);
    }
    public Optional<sellerModule> put(int id, sellerModule sellermodule) {
        Optional<sellerModule> optionalSellerModule=sellerrepo.findById(id);
        sellerModule sellerExisted=optionalSellerModule.get();
        if (sellermodule != null) {
//            sellerExisted.setSid(sellermodule.getSid());
            sellerExisted.setSname(sellermodule.getSname());
            sellerExisted.setOwnerof(sellermodule.getOwnerof());
            sellerExisted.setSmobile(sellermodule.getSmobile());
        }
        sellerrepo.save(sellerExisted);
        return sellerrepo.findById(id);
    }

    public void toDelete(int id) {
        sellerrepo.deleteById(id);
    }
}
