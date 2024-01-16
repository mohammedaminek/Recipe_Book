package com.example.recipebookbackend.services;


import com.example.recipebookbackend.entities.Ingredient;
import com.example.recipebookbackend.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
    public Optional<Ingredient> getIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
    public Ingredient updateIngredient(Long id, Ingredient updatedIngredient) {
        if (ingredientRepository.existsById(id)) {
            updatedIngredient.setId(id);
            return ingredientRepository.save(updatedIngredient);
        }
        return null;
    }
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    public void saveAllIngredients(List<Ingredient> ingredients) {
         ingredientRepository.saveAll(ingredients);
    }
}
