package it.corso.dao;

import org.springframework.data.repository.CrudRepository;


import it.corso.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

    // Questa è un'interfaccia che estende CrudRepository e definisce operazioni
    // di accesso ai dati per la classe Product.

    Product findByCode(String code);
    // Questo è un metodo dichiarato nell'interfaccia per recuperare un oggetto Product
    // in base al suo codice. Spring Data JPA fornirà automaticamente
    // un'implementazione di questo metodo senza la necessità di scriverlo manualmente.
    // Questo è possibile grazie alla convenzione di denominazione dei metodi di query di Spring Data JPA.
}