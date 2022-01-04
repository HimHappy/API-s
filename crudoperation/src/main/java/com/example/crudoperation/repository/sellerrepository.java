package com.example.crudoperation.repository;

import com.example.crudoperation.module.sellerModule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sellerrepository extends MongoRepository<sellerModule,Integer> {
}
