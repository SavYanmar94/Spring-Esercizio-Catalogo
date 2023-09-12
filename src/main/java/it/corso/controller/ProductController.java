package it.corso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Product;
import it.corso.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/catalogue/product")
public class ProductController {
	
	@Autowired
	//Con Autowired Spring si prende cura di creare automaticamente le istanze dei bean e di iniettarle nei punti in cui sono necessarie, senza doverlo fare manualmente nel codice.
	private ProductService productService;
	
	//endpoint #1 : registrazione prodotto localhost:8080/catalogue/product/reg/{admin token}
	@PostMapping("/reg/{tkn}")
	public ResponseEntity<ObjectNode> productRegistration(@Valid @RequestBody Product product,@PathVariable("tkn") String token){
		ObjectNode response = productService.productRegistration(product,token );
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	//@PostMapping("/reg/{tkn}"): Questa annotazione indica che il metodo gestisce le richieste HTTP di tipo POST inviate all'URL "/catalogue/product/reg/{tkn}". {tkn} è un segnaposto per un valore variabile che verrà estratto dall'URL.
	//@Valid è un'annotazione che indica che l'oggetto Product ricevuto come parametro deve essere sottoposto a validazione. 
	//@RequestBody indica che l'oggetto Product verrà estratto dal corpo della richiesta HTTP. 
	//@PathVariable("tkn") String token indica che il valore {tkn} dall'URL verrà estratto e assegnato alla variabile token
	//productRegistration(product, token); Questo metodo restituirà un oggetto ObjectNode che rappresenta la risposta alla richiesta di registrazione.
	/*In sintesi, questo metodo gestisce le richieste di registrazione prodotto, chiama il 
	 * servizio per effettuare la registrazione e restituisce una risposta HTTP con i dati di 
	 * risposta e il codice di stato appropriato.
	 */
	
	
	//endpoint#2 : visualizzazione prodotti localhost:8080/catalogue/product/get
	@GetMapping("/get")
	public ResponseEntity <List<Product>> getProducts(){
		List<Product> response = productService.getProducts();
		return new ResponseEntity<List<Product>>(response,HttpStatus.OK);
	}
	
	//(@PathVariable("tkn") String token
	
	//metodo per gestione eccezione validazione dati 
		@ExceptionHandler(BindException.class)
		public ResponseEntity <Map<String,String>> handleValidationException(BindException e){
			
			// Più specificamente, BindException viene sollevata quando si verificano errori durante la validazione e l'associazione dei dati forniti in una richiesta HTTP
			// Creazione di un oggetto Map per memorizzare gli errori di validazione
			Map <String,String> errors = new HashMap<>();
			// Map è una struttura dati che memorizza coppie chiave-valore, e in questo caso, entrambe le chiavi e i valori sono di tipo String.
			// Recupero degli errori di validazione dal BindException e li aggiunge all'oggetto Map errors.
			e.getBindingResult().getFieldErrors().
			//getBindingResult() restituisce un oggetto BindingResult, che contiene informazioni sulla validazione dei dati e gli eventuali errori associati.
			//getFieldErrors():è un metodo su BindingResult che restituisce una lista di errori specifici dei campi che sono stati validati
			forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));
			//.forEach(error -> errors.put(error.getField(), error.getDefaultMessage())): Questa parte utilizza un ciclo forEach per iterare attraverso la lista degli errori dei campi.
			// Restituzione di una risposta HTTP con status "Bad Request" (400)
			// La risposta sarà in formato JSON con gli errori di validazione associati ai campi di input.
			return ResponseEntity.badRequest().body(errors);
		}
}