package com.example.tacoproject.Data;


import com.example.tacoproject.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository  extends CrudRepository<Order, Long> {

    //public List<Order> findByUserOrderByPlacedAtDesc(String name, Pageable pageable);
}
