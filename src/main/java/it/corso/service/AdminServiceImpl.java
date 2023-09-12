package it.corso.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.AdminDao;
import it.corso.helper.ResponseManager;
import it.corso.model.Admin;
import it.corso.helper.SecurityManager;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ResponseManager responseManager;
	
	@Override
	public ObjectNode adminLogin(Admin admin) {
		Admin existing = adminDao.findByUsernameAndPassword(admin.getUsername(), 
				SecurityManager.encode(admin.getPassword()));
		//System.out.println(SecurityManager.encode(admin.getPassword()));
		if ( existing == null)
			return responseManager.getResponse(401,"Not Authorized");
		existing.setAuthToken(SecurityManager.generateToken(existing.getUsername())); //togliamo il true 
		adminDao.save(existing);
		return responseManager.getResponse(202,existing.getAuthToken());
	}
	
	/*Admin existing: Qui stai dichiarando una variabile di tipo Admin chiamata existing. 
	 * Questa variabile verrà utilizzata per memorizzare l'oggetto Admin trovato nel database, 
	 * se esiste.
	 * adminDao.findByUsernameAndPassword(...): adminDao è un'istanza dell'interfaccia AdminDao, 
	 * che è utilizzata per comunicare con il database per le operazioni legate all'entità Admin. 
	 * Il metodo findByUsernameAndPassword(...) è un metodo definito in questa interfaccia, che cerca nel 
	 * database un amministratore con il nome utente e la password corrispondenti.
	 * admin.getUsername(): Qui stai ottenendo il nome utente dell'amministratore passato 
	 * come argomento al metodo.
	 * 
	 * In sintesi, questa riga di codice esegue una query nel database per cercare un 
	 * amministratore corrispondente al nome utente e alla password forniti. Se un 
	 * amministratore corrispondente viene trovato, l'oggetto existing verrà inizializzato 
	 * con i dati di quell'amministratore.

SecurityManager.encode(admin.getPassword()): SecurityManager.encode(...) è un metodo che codifica la password dell'amministratore passata come argomento, probabilmente utilizzando una tecnica di hashing o crittografia. Questo passo è importante per confrontare la password crittografata memorizzata nel database con quella fornita nella richiesta.*/
	
	/*Inizia cercando un oggetto Admin nel database utilizzando adminDao.
	 * findByUsernameAndPassword(). Questo metodo cerca un amministratore esistente 
	 * corrispondente al nome utente (admin.getUsername()) e alla password crittografata (
	 * SecurityManager.encode(admin.getPassword())). La password viene crittografata prima di essere confrontata con quella memorizzata nel database.
	 */

	@Override
	public ObjectNode adminLogout(String token) {
		Admin existing = adminDao.findByAuthToken(token);
		if(existing == null)
			return responseManager.getResponse(401,"Not Authorized");
		existing.setAuthToken(null);
		adminDao.save(existing);
		return responseManager.getResponse(202,"Logout Accepted");
	}

}
