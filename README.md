# Sicve
## Corso di Programmazione 3
## Progetto Esame
## Docente: Proﬀ. Angelo Ciaramella e Raﬀaele Montella
## A.A. 2020/2021
## Studente
- Cognome: Mabilia
- Nome: Francesco
- Matricola: 124/1910

# Traccia - SICVE autostradale

Si vuole sviluppare un sistema SICVE (Sistema Informativo per il Controllo del-
la Velocita) autostradale, detto anche Tutor (vedi sotto). Il Tutor è un sistema
per la misurazione della velocita media dei veicoli.
Il Tutor è costituito da una serie di postazioni o sensori (Autovelox), che collegati
ad un computer, oltre a svolgere le normali funzioni, operano il calcolo della
velocita media.
Ove sia attivo un sistema Tutor (composto da una stazione di rilevazione detta
“entrata” e da una stazione detta “uscita”), è possibile fare tre infrazioni che
verranno intese come unica, il computer selezionera la piu grave e la inviera al
comando di Polizia per la trascrizione.
Il superamento della velocita massima quando si transita sotto ai sensori è
anch’esso sanzionato.
Qualora l’eccesso di velocita perduri tanto a lungo da coprire piu tratte sorve-
gliate da diversi sistemi di tutor, potranno essere verbalizzate piu di una multa
per la ripetizione della stessa eﬀrazione al codice stradale in comuni diversi fra
loro.
Scrivere un programma per la gestione del sistema Tutor. Il sistema automati-
camente riconosce gli autoveicoli che hanno commesso un’infrazione (istantanea
o media) e invia un avviso alla Stazione di Polizia di competenza.
Il sistema deve prevedere l’accesso in modalita amministratore e in modalita
autoveicolo.
L’amministratore puo eﬀettuare le seguenti operazioni
- inserire una nuova tratta autostradale controllata da Tutor
- modiﬁcare i parametri per il controllo di una tratta
- eﬀettuare periodicamente statistiche sulle velocita per le singole tratte coperte dai Tutor
L’utente (autoveicolo) puo eﬀettuare le seguenti operazioni
- entrare e uscire da una tratta coperta da Tutor
- richiedere di essere avvisato automaticamente dal sistema (e.g., sms) quando sta entrando in una tratta controllata dal Tutor

# Sistema SICVE
Per i dettagli di sviluppo vedere: https://it.wikipedia.org/wiki/SICVE

# Note di sviluppo
La prova d’esame richiede la progettazione e lo sviluppo della traccia proposta.
Lo studente po scegliere di sviluppare il progetto nelle due modalita: Applica-
zione Web o programma standalone con supporto graﬁco.
Il progetto deve essere sviluppato secondo le seguenti linee:
- usare almeno due pattern (almeno uno per chi sceglie la modalit`a Web
Application) tra i design pattern noti;
- attenersi ai principi della programmazione SOLID;
- usare il linguaggio Java;
- inserire suﬃcienti commenti (anche per Javadoc) e annotazioni;
- gestione delle eccezioni;
- usare i ﬁle o database.
Lo studente deve presentare una relazione sintetica (per chi usa latex è possibile
scaricare un template dalla piattaforma e-learning). La relazione deve contenere:
- una breve descrizione dei requisiti del progetto;
- il diagramma UML delle classi;
- altri diagrammi se opportuni;
- parti rilevanti del codice sviluppato.


# Consegna progetto
La relazione e il codice del progetto devono essere messi a disposizine secondo le
modalita ritenute piu opportune (Dropbox, Google Drive, Piattaforma Sebeto,
Pendrive, CD, . . .) entro la data di scadenza della prenotazione on-line
dell’esame.

# Modalita di esame
La prima parte della prova di esame vertera sulla discussione del progetto. Lo
studente deve preparare una presentazione sintetica (slide) per descrivere
il progetto svolto. La seconda parte della prova vertera sulla discussione degli
argomenti aﬀrontati a lezione.
