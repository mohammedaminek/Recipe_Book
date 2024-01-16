/*package com.example.recipebookbackend.webService;

import com.example.recipebookbackend.entities.Ingredient;
import com.example.recipebookbackend.entities.ShoppingList;
import com.example.recipebookbackend.services.ShoppingListService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@AllArgsConstructor
@WebService(serviceName = "ShoppingListWS")
public class ShoppingListWebService {
    private final ShoppingListService shoppingListService;


    @WebMethod
    public ShoppingList getShoppingList(Long id) {
        return shoppingListService.getShoppingListById(id);
    }

    @WebMethod
    public List<ShoppingList> shoppingLists() {
        return shoppingListService.getAllShoppingLists();
    }

    @WebMethod
    public ShoppingList saveShoppingList(ShoppingList shoppingList) {
        return shoppingListService.saveShoppingList(shoppingList);
    }
}
*/