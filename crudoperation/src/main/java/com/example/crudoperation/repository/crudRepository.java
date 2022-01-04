package com.example.crudoperation.repository;

import com.example.crudoperation.module.crudModule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface crudRepository extends MongoRepository<crudModule,Integer> {
}
