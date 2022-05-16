package com.example.tacocloud.tacos.repositoryjdbc;

import com.example.tacocloud.tacos.entity.Ingredient;

import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
