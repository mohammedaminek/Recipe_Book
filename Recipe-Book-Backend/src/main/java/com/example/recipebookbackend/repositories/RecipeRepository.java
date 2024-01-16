package com.example.recipebookbackend.repositories;

import com.example.recipebookbackend.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
