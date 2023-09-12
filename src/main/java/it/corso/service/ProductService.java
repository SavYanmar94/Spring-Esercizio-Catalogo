package it.corso.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Product;

public interface ProductService 
{
	//Metodo per registrare un nuovo prodotto nel sistema.
     
    ObjectNode productRegistration(Product product, String token);
    
    //Metodo per ottenere la lista di tutti i prodotti presenti nel sistema.
     
    List<Product> getProducts();
}