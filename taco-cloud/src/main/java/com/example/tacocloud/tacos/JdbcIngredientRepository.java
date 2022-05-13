package com.example.tacocloud.tacos;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}
