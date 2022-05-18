package com.example.tacocloud.tacos.repository;

import com.example.tacocloud.tacos.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
    /*TacoOrder save(TacoOrder tacoOrder);*/
}

