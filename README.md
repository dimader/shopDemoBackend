# Shop-Demo SpringBoot Backend

Für eine kleine Shop-Verwaltung Demo die ich gebastelt habe ist dies das Backend.

Es werden über eine REST-API CRUD-Services für verschiedene Entitäten bereitgestellt.

Der CustomerController (/src/main/java/com/softwarechallange/shopDemo/controller/CustomerController.java) bietet die beste Vorlage wenn ihr sehen wollt wie CRUD-Services über eine REST-API bereitgestellt werden können. 

Zu diesem Backend gibt es einen passenden Angular-Client. Das Repository dazu findet ihr auch auf meiner GitHub-Seite.

## Kurzbeschreibung Fachlichkeit

Über eine REST-API können
* Kunden (Customers) gepflegt werden, alle CRUD-Operationen werden bereitgestellt. Wie die Anfragen aussehen kann in /rest/rest.customers.http nachgeschaut werden.
* Kunden können mehrere Adressen haben. Adressen können nur angelegt und gelöscht werden.
* Es gibt Produkte (Product), alle CRUD-Operationen werden bereitgestellt.
* Produkte können in einer Bestellung (Order) gesammelt werden. 
* Die Zuweisung von Produkten zu einer Bestellung erfolgt über ein OrderItem.
* Der Preis eines Produkts kann in einer Bestellung abweichen.

## Features

* CRUD Operationen über REST-API
* Anbindung einer relationalen Datenbank (PostgreSQL)
* API Dokumentation mit Spring-Doc
* Swagger eingerichtet, aufrufbar unter http://localhost:5000/swagger-ui/index.html#/
* SpringBoot Actuator aktiv, aufrufbar unter http://localhost:5000/actuator
* Logging eingerichtet
* CORS und CSRF sind deaktiviert, REST-Services können ohne Authentifizierung genutzt werden.

## Wie wird das Backend gestartet

Die Anwendung benötigt zwingend eine PostgreSQL-Datenbank.
Die Verbingunsdetails sind in der application.properties unter "spring.datasource.url" definiert.
Eine Anleitung zum Einrichten der DB findet ihr weiter unten in dieser readme.

## REST-API Ausprobieren mit HttpYac

Die bereitgestellte REST-API kann über die Anfragen in /rest/rest.*.http ausprobiert werden. 
Um diese Anfragen direkt in der Datei ausführen zu können wird die VS-Code Erweiterung HttpYac benötigt.

### DB einrichten

Für die Datenbank kann wird eine Docker-Compose definiert, diese liegt im /db Verzeichnis und kann mit
```
docker-compose up
```
gestartet werden (Docker und Docker-Compose müssen natürlich installiert sein, der Befehl muss im /db Verzeichnis ausgeführt werden.)

Damit wird auch ein Container mit pgAdmin gestartet. Dieser kann über http://localhost:8888/browser/ geöffnet werden, die Login Informationen findet ihr in der Datei /db/docker-compose.yml unter PGADMIN_DEFAULT_EMAIL und PGADMIN_DEFAULT_PASSWORD.

Zuerst muss eine neue Datenbank angelegt werden mit dem Namen "shopdb".

Die notwendigen Tabellen können mit dem Skript /db/01_create_tables.sql erstellt werden.

Optional können auch Testdaten eingespielt werden mit dem Skript /db/02_...

Die Anwendung kann nicht gestartet werden solange die Datenbank nicht erreichbar ist.

Bei Problemen prüft die Verbindungseinstellungen der Anwendung in der application.properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/shopdb?schema=public
spring.datasource.username=dbuser
spring.datasource.password=a907dfa9df7a
```
