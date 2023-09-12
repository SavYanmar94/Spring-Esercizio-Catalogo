package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer> {

    // Questa è un'interfaccia che estende CrudRepository e definisce operazioni
    // di accesso ai dati per la classe Admin.

    Admin findByUsernameAndPassword(String username, String password);
    // Questo è un metodo dichiarato nell'interfaccia per recuperare un oggetto Admin
    // in base a un nome utente e una password. Spring Data JPA fornirà automaticamente
    // un'implementazione di questo metodo senza la necessità di scriverlo manualmente.
    // Questo è possibile grazie alla convenzione di denominazione dei metodi di query di Spring Data JPA.

    Admin findByAuthToken(String authToken);
    // Questo è un altro metodo dichiarato nell'interfaccia per recuperare un oggetto Admin
    // in base a un token di autenticazione. Anche questo metodo avrà un'implementazione
    // automatica fornita da Spring Data JPA.
}