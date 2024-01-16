package com.example.recipebookbackend.repositories;

import com.example.recipebookbackend.entities.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}

