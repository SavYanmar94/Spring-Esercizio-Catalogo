package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Admin;
import it.corso.service.AdminService;

@RestController
@RequestMapping("/catalogue/admin")

public class AdminController {
	@Autowired
	private AdminService adminService;
	
	//endpoint #1:login ammistratore localhost:8080/catalogue/admin/login
	@PutMapping("/login")
	public ResponseEntity<ObjectNode>adminLogin(@RequestBody Admin admin){
		ObjectNode response = adminService.adminLogin(admin);
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
/*@PutMapping("/login"): Questa annotazione indica che il metodo gestisce le richieste HTTP 
* di tipo PUT inviate all'URL "/catalogue/admin/login". Questo endpoint è progettato per gestire le richieste 
* di login degli amministratori.
* public ResponseEntity<ObjectNode> adminLogin(@RequestBody Admin 
* admin): Questa è la firma del metodo. @RequestBody indica che l'oggetto Admin viene estratto
* dal corpo della richiesta HTTP. Il metodo restituirà un oggetto ResponseEntity<ObjectNode> che 
* contiene la risposta HTTP.
* ObjectNode response = adminService.adminLogin(admin);: Qui viene chiamato il metodo adminLogin dell'
* oggetto adminService (probabilmente una classe di servizio) per gestire il processo di 
ore. Il metodo restituirà un oggetto ObjectNode che rappresenta la risposta alla richiesta di 
login.
return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));: 
Infine, viene creata e restituita una risposta HTTP contenente l'oggetto response come corpo della risposta. 
Il codice di stato HTTP viene ottenuto dall'oggetto response e viene utilizzato per creare un oggetto ResponseEntity.

In breve, questa parte di codice definisce un endpoint di login per gli amministratori. 
Quando viene inviata una richiesta PUT all'URL specificato, il metodo adminLogin gestisce 
la richiesta, invoca il servizio di login e restituisce una risposta HTTP contenente la risposta 
strutturata e il codice di stato appropriato.
	 * 
	 */
	
	//endpoint #2 logout amministratore localhost:8080/catalogue/admin/logout/(admin-token)
	@GetMapping("/logout/{tkn}")
	public ResponseEntity<ObjectNode>adminLogout(@PathVariable("tkn") String token){
		ObjectNode response = adminService.adminLogout(token);
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
		//get("code").asInt() presume che l'oggetto response contenga una chiave "code" con un valore intero che rappresenta il codice di stato HTTP
	}
}

/*@RestController è un'annotazione in Spring Framework che combina le annotazioni 
 * @Controller e @ResponseBody. Un controller è una classe che gestisce le richieste HTTP e 
 * restituisce risposte. L'annotazione @ResponseBody indica che il valore restituito dai metodi 
 * del controller dovrebbe essere interpretato come il corpo della risposta HTTP, piuttosto 
 * che come una vista da risolvere.
 */

/* L'acronimo "REST" sta per "Representational State Transfer". È uno stile architetturale 
 * basato su un insieme di principi progettati per creare servizi web ben strutturati 
 * Un controller REST accetta richieste HTTP, 
 * comprese le operazioni GET, POST, PUT, DELETE, e restituendo risposte sotto forma 
 * di dati strutturati (come JSON) secondo lo standard REST. */

/*GET – utilizzato per accedere in lettura ad una risorsa
POST – utilizzato per creare una nuova risorsa
PUT – utilizzato per aggiornare una risorsa esistente
DELETE – utilizzato per cancellare una risorsa*/
