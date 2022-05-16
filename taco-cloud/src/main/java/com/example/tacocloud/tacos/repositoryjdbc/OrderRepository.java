package com.example.tacocloud.tacos.repositoryjdbc;

import com.example.tacocloud.tacos.entity.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
