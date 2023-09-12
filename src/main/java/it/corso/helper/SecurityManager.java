package it.corso.helper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Base64;

public class SecurityManager {

	public static String encode(String toEncode) {
		//codifica in base 64
		return Base64.getEncoder().encodeToString(toEncode.getBytes());
	}
	//getBytes() converte la stringa in un array di byte poiché la codifica Base64 viene eseguita su dati binari.
	//encodeToString() prende l'array di byte e lo codifica in una stringa Base64.
	//getEncoder() restituisce un oggetto Base64.Encoder che può essere utilizzato per codificare i dati.
	//Base64 è una classe in Java che fornisce metodi per la codifica e la decodifica in Base64. 
	
	//L'encoder converte i dati da una forma iniziale, spesso in formato binario, in un formato finale
	//Il decoder svolge l'operazione inversa rispetto all'encoder, restituendo i dati alla loro rappresentazione originale o comprensibile.
	
	// non è una criptatura
	public static String decode(String toDecode) {
		return new String (Base64.getDecoder().decode(toDecode));
	}
	
	//code = username 
	public static String generateToken(String username) { //true=admin , false = product.
	    // Ottiene la data e ora correnti
	    LocalDateTime now = LocalDateTime.now();

	    // Converte la data e ora in un istante (punto nel tempo) utilizzando l'offset corrente per ottenere il tempo UTC.
	    Instant instant = now.toInstant(OffsetDateTime.now().getOffset());
	    
	    // Offset : differenza di tempo tra un fuso orario specifico e il Tempo Coordinato Universale (UTC)

	    // Calcola il timestamp Unix in millisecondi dal tempo UTC
	    // Il timestamp Unix è un valore numerico che rappresenta il numero di secondi trascorsi dal 1° gennaio 1970 
	    long timestamp = instant.getEpochSecond() * 1000;

	    //String suffix = type ? "_A" : "_P";
	    // Restituisce il token generato per il cliente
	    // Codifica il nome utente e lo concatena con il timestamp e il suffisso "_C"
	    return encode(username) + "_" + timestamp + "_A";  //token relativo all'admin
	} 
}