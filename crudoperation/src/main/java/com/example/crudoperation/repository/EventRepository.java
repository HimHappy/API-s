package com.example.crudoperation.repository;

import com.example.crudoperation.module.EventModule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends MongoRepository<EventModule, UUID> {
}
