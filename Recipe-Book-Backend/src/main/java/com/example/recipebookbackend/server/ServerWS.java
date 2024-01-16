/*package com.example.recipebookbackend.server;

import com.example.recipebookbackend.services.ShoppingListService;
import com.example.recipebookbackend.webService.ShoppingListWebService;
import jakarta.xml.ws.Endpoint;

public class ServerWS {
    private static ShoppingListService shoppingListService;

    public static void main(String[] args) {
        String url="http://localhost:8080/soap-api";
        Endpoint.publish(url,new ShoppingListWebService(shoppingListService));
        System.out.println(url+" Deployed");
    }
}
*/