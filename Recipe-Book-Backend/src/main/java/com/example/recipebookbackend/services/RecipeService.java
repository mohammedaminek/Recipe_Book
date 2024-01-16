package com.example.recipebookbackend.services;

import com.example.recipebookbackend.entities.Ingredient;
import com.example.recipebookbackend.entities.Recipe;
import com.example.recipebookbackend.repositories.IngredientRepository;
import com.example.recipebookbackend.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe createRecipe(Recipe recipe) {

        recipeRepository.save(recipe);
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.setRecipe(recipe);
            ingredientRepository.save(ingredient);
        }
        return recipe;
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        if (recipeRepository.existsById(id)) {
            updatedRecipe.setId(id);
            return recipeRepository.save(updatedRecipe);
        }
        return null;
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public void saveAllRecipes(List<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.setRecipe(recipe);
            }
        }
        recipeRepository.saveAll(recipes);
    }
}

