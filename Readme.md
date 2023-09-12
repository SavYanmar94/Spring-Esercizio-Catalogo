Traccia: RESTful Web Service - Catalogo

Realizzare un web service che permetta la gestione di una piattaforma e-commerce
implementando i seguenti endpoint:

I. Login amministratore piattaforma:

◦ Verifica credenziali pre-registrate in tabella (password codificata)
◦ Ottenimento token autorizzativo univoco in caso positivo

II. Logout amministratore piattaforma (endpoint protetto mediante token):
◦ Cancellazione token autorizzativo

III. Registrazione nuovo prodotto (endpoint protetto mediante token):

◦ Dati prodotto (da validare):
▪ id
▪ codice alfanumerico univoco
▪ marca
▪ modello
▪ descrizione
▪ prezzo


IV. Restituzione catalogo prodotti (endpoint libero):
◦ Informazioni complete di tutti i prodotti
Tutti i dati devono essere gestiti in formato JSON e viene richiesta la strutturazione di
idoneo database MySql.Crea uno Spring Boot Project chiamato “esercitazione-service-catalogo
