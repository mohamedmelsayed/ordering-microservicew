package com.profdev.ordering.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.profdev.ordering.models.Orders;

@Repository
public interface OrderingRepository extends CrudRepository<Orders,Long>  {

}
