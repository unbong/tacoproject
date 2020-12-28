package com.example.tacoproject.Data;

import com.example.tacoproject.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
