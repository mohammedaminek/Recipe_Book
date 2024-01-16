package com.example.recipebookbackend;

import com.example.recipebookbackend.entities.Ingredient;
import com.example.recipebookbackend.entities.Recipe;
import com.example.recipebookbackend.services.IngredientService;
import com.example.recipebookbackend.services.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RecipeBookBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeBookBackendApplication.class, args);
        System.out.println("hello a wlad nass");
    }
    @Bean
    public CommandLineRunner initializeData(IngredientService ingredientService, RecipeService recipeService) {
        return args -> {
            // Example data for ingredients
            List<Ingredient> ingredients = new ArrayList<>();
            ingredients.add(new Ingredient("Ingredient1", 100));
            ingredients.add(new Ingredient("Ingredient2", 50));
            ingredients.add(new Ingredient("Ingredient3", 200));

            // Save ingredients
            ingredientService. saveAllIngredients(ingredients);

            // Example data for recipes
            List<Recipe> recipes = new ArrayList<>();
            recipes.add(new Recipe("Recipe1", "Description1", new ArrayList<>()));
            recipes.add(new Recipe("Recipe2", "Description2", new ArrayList<>()));
            recipes.add(new Recipe("Recipe3", "Description3", new ArrayList<>()));

            // Save recipes
            recipeService.saveAllRecipes(recipes);
        };
    }

}
