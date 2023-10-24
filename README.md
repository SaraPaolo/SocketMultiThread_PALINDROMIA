# SocketMultiThread_PALINDROMIA

Protocollo Palindromo
Il seguente protocollo permette l’interazione con un server TCP in grado di verificare se una stringa di caratteri è palindroma oppure no.

Formato dei messaggi:

PALINDROMO XYZYX\n
SI\n
Il client chiede la verifica di una parola ; se è palindroma il server risponde affermativamente. La connessione TCP rimane aperta per altre richieste.

PALINDROMO XYZW\n
NO\n
Il client chiede la verifica di una parola (XYZW nell’esempio); se non è palindroma il server risponde negativamente. La connessione TCP rimane aperta per altre richieste.

FINE\n
SI\n
Il client ha terminato le richieste: la connessione TCP viene chiusa sia dal client che dal server.

XXXXXXXX\n
ERRORE\n
Ogni altra richiesta del client viene ignorata. La connessione TCP rimane aperta per altre richieste.


