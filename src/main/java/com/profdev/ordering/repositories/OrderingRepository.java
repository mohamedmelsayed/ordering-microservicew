package com.profdev.ordering.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.profdev.ordering.models.Orders;

@Repository
public interface OrderingRepository extends CrudRepository<Orders,Long>  {
    public Optional<Orders> findById( Long id);
}
