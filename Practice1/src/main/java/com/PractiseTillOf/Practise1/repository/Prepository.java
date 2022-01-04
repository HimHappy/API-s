package com.PractiseTillOf.Practise1.repository;

import com.PractiseTillOf.Practise1.model.Pmodel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface Prepository extends MongoRepository<Pmodel, UUID> {

    @Query( "{ 'pname' : '?0' }" )
    List<Pmodel> getbyName(String pname);

    @Query("{ 'status' : '?0' }")
    List<Pmodel> getdetailsByStatus(String status);
}

