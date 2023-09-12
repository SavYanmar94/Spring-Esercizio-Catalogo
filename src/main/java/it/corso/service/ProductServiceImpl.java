package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.AdminDao;
import it.corso.dao.ProductDao;
import it.corso.helper.ResponseManager;
import it.corso.model.Product;



@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private ResponseManager responseManager;
    
    @Autowired
    private AdminDao adminDao;
    
    // Implementazione del metodo per la registrazione di un nuovo prodotto.
    @Override
    public ObjectNode productRegistration(Product product, String token) {
        
        // Verifica se il token dell'amministratore è valido.
        if (adminDao.findByAuthToken(token) == null)
            return responseManager.getResponse(401, "Token Mancante");
        
        // Verifica se il codice del prodotto esiste già nel sistema.
        if (productDao.findByCode(product.getCode()) != null)
            return responseManager.getResponse(406, "Codice Già Esistente");
        
        // Salva il nuovo prodotto nel database.
        productDao.save(product);
        return responseManager.getResponse(201, "Prodotto Registrato");
    }
    
    // Implementazione del metodo per ottenere la lista di tutti i prodotti.
    @Override
    public List<Product> getProducts() {
        // Restituisce tutti i prodotti presenti nel sistema.
        return (List<Product>) productDao.findAll();
    }
}
