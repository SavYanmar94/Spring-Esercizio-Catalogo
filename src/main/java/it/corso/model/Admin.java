package it.corso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * La classe `Admin` rappresenta un amministratore nel sistema.
 * È un'entità JPA (Java Persistence API) che viene mappata su una tabella di database "admins".
 */
@Entity
@Table(name = "admins")
public class Admin {

    // Identificatore primario per l'amministratore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // Nome utente dell'amministratore
    @Column(name = "username")
    private String username;
    
    // Password dell'amministratore
    @Column(name = "password")
    private String password;
    
    // Token di autenticazione dell'amministratore
    @Column(name = "auth_token")
    private String authToken;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	
}
