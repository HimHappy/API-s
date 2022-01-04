package com.PractiseTillOf.Practise1.repository;

import com.PractiseTillOf.Practise1.model.ComplaintModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ComplaintRepository extends MongoRepository<ComplaintModel, UUID> {

    @Query( "{ 'status' : '?0' }")
    List<ComplaintModel> gettingbyStstus(String complainStatus);
}
