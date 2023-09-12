package it.corso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;

/**
 * La classe `Product` rappresenta un prodotto all'interno del sistema.
 * È un'entità JPA (Java Persistence API) che viene mappata su una tabella di database "products".
 */
@Entity
@Table(name = "products")
public class Product {

    // Identificatore primario per il prodotto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // Codice univoco del prodotto
    @Pattern(regexp = "[A-Z]{3}-\\d{2}", message = "Errore. Il codice deve essere nel formato AAA-NN")
    @Column(name = "code")
    private String code;
    
    // Marca del prodotto
    @Pattern(regexp = "[a-zA-Z0-9\\sàèìòù'-]{1,30}", message = "Errore sulla marca")
    @Column(name = "brand")
    private String brand;
    
    // Modello del prodotto
    @Pattern(regexp = "[a-zA-Z0-9\\sàèìòù'-]{1,30}", message = "Errore sul campo modello")
    @Column(name = "model")
    private String model;
    
    // Descrizione del prodotto
    @Pattern(regexp = "[a-zA-Z0-9\\sàèìòù'?!()-]{1,1000}", message = "Errore sul campo descrizione")
    @Column(name = "description")
    private String description;
    
    // Prezzo del prodotto
    @Digits(integer = 6, fraction = 2)
    @Column(name = "price")
    private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
