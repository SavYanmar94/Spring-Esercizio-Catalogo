package it.corso.helper;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class ResponseManager {
	
	// Dichiarazione di un oggetto ObjectMapper per gestire la serializzazione e deserializzazione JSON
	// La serializzazione JSON è il processo di conversione di un oggetto o una struttura dati da un linguaggio di programmazione in una rappresentazione JSON.
	//La deserializzazione JSON è il processo inverso, cioè la conversione di una rappresentazione JSON in un oggetto o una struttura dati in un linguaggio di programmazione. Questo processo è fondamentale quando si ricevono dati JSON da una fonte esterna, come una richiesta HTTP
	
	private ObjectMapper mapper;

	// Costruttore della classe
	public ResponseManager() {
		// Inizializzazione dell'oggetto ObjectMapper nel costruttore
		// Questo oggetto è utilizzato per convertire oggetti Java in formato JSON e viceversa
		mapper = new ObjectMapper();
	}

	// Metodo per ottenere una risposta (ObjectNode) con il codice e il messaggio specificati
	public ObjectNode getResponse(int code, String message) {
		// Creazione di un nuovo ObjectNode (risposta) utilizzando l'oggetto ObjectMapper
		ObjectNode response = mapper.createObjectNode();
		
		// Aggiunta di un campo "code" all'ObjectNode con il codice specificato come valore
		response.put("code", code);
		
		// Aggiunta di un campo "message" all'ObjectNode con il messaggio specificato come valore
		response.put("message", message);
		
		// Restituzione dell'ObjectNode (risposta) creato
		return response;
	}
}