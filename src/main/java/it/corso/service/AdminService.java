package it.corso.service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.model.Admin;

public interface AdminService {

	// interfacce servono ad un discorso di sicurezza 
	
	ObjectNode adminLogin(Admin admin);
	ObjectNode adminLogout(String token);
}

/*ObjectNode è una classe fornita dal framework Jackson,
Jackson permette di convertire oggetti Java in formato JSON e viceversa. 
L'ObjectNode è parte di questa libreria ed è utilizzato per rappresentare un 
oggetto JSON all'interno del codice Java.
L'ObjectNode rappresenta la struttura JSON in Java, consentendo di creare, 
manipolare e accedere ai dati JSON in modo programmatico.
L'uso più comune di ObjectNode è per creare oggetti JSON che rappresentano 
le risposte restituite dalle API.
*/