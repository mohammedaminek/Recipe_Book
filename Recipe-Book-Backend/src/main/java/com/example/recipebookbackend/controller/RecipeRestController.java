package com.example.recipebookbackend.controller;

import com.example.recipebookbackend.entities.Recipe;
import com.example.recipebookbackend.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@EnableMethodSecurity(prePostEnabled = true)
public class RecipeRestController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.createRecipe(recipe);
        return ResponseEntity.ok(createdRecipe);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
        Recipe updated = recipeService.updateRecipe(id, updatedRecipe);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @PutMapping
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<String> updateRecipes(@RequestBody List<Recipe> recipes) {
        System.out.println(recipes);
        recipeService.saveAllRecipes(recipes);
        return ResponseEntity.ok("Recipes updated successfully");
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}
