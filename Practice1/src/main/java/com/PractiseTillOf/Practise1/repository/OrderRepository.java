package com.PractiseTillOf.Practise1.repository;

import com.PractiseTillOf.Practise1.model.OrdersData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<OrdersData, UUID> {
}
