package com.example.recipebookbackend.repositories;


import com.example.recipebookbackend.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}