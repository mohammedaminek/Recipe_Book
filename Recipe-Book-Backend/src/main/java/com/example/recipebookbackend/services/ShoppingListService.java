package com.example.recipebookbackend.services;

import com.example.recipebookbackend.entities.ShoppingList;
import com.example.recipebookbackend.repositories.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public ShoppingList getShoppingListById(Long id) {
        return shoppingListRepository.findById(id).orElse(null);
    }

    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListRepository.findAll();
    }

    public ShoppingList saveShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }
}
