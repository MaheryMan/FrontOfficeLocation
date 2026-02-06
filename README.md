# FrontOffice - Système de Location de Voitures

## Description
Application FrontOffice Spring Boot qui affiche la liste des réservations en consommant l'API du BackOffice.

## Architecture
- **FrontOffice** (port 8081) - Interface utilisateur
- **BackOffice** (port 8080) - API REST fournissant les données

## Technologies Utilisées
- Spring Boot 4.0.2
- Spring MVC
- JSP / JSTL
- RestTemplate (pour consommer l'API)
- Maven

## Structure du Projet
```
src/
├── main/
│   ├── java/com/frontOffice/app/
│   │   ├── controller/
│   │   │   └── ReservationController.java   # Contrôleur MVC
│   │   ├── dto/
│   │   │   └── ReservationDTO.java          # Data Transfer Object
│   │   ├── service/
│   │   │   └── ReservationService.java      # Service consommant l'API
│   │   └── AppApplication.java              # Classe principale
│   ├── resources/
│   │   └── application.properties           # Configuration
│   └── webapp/WEB-INF/views/
│       ├── index.jsp                        # Page d'accueil
│       └── reservations.jsp                 # Liste des réservations
```

## Configuration

### application.properties
```properties
# Port du FrontOffice
server.port=8081

# Configuration JSP
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

# URL de l'API BackOffice
backoffice.api.url=http://localhost:8080/api
```

## Étapes pour Exécuter

### 1. Vérifier que le BackOffice est démarré
Le BackOffice doit être en cours d'exécution sur `http://localhost:8080`

### 2. Compiler le projet
```bash
mvnw clean install
```

### 3. Lancer l'application
```bash
mvnw spring-boot:run
```

### 4. Accéder à l'application
- Page d'accueil: http://localhost:8081/
- Liste des réservations: http://localhost:8081/reservations

## Endpoints

| URL | Description |
|-----|-------------|
| `GET /` | Page d'accueil |
| `GET /reservations` | Affiche la liste des réservations depuis l'API BackOffice |

## Flux de Données

1. L'utilisateur accède à `/reservations`
2. Le `ReservationController` reçoit la requête
3. Le `ReservationService` appelle l'API BackOffice via `RestTemplate`
4. L'API retourne un tableau de `ReservationDTO[]`
5. Les données sont passées à la vue JSP
6. La page HTML est générée et affichée

## Dépendances Principales

```xml
<!-- Spring Web pour RestTemplate et MVC -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Support JSP -->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

<!-- JSTL pour les boucles et conditions dans JSP -->
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
</dependency>
```

## Remarques Importantes

1. **Pas de base de données directe** : Le FrontOffice ne se connecte pas à la base de données, il consomme uniquement l'API du BackOffice
2. **Ports différents** : FrontOffice sur 8081, BackOffice sur 8080
3. **DTO synchronisé** : Le `ReservationDTO` doit correspondre aux données retournées par l'API BackOffice

## Troubleshooting

### Erreur: "Connection refused"
- Vérifier que le BackOffice est bien démarré sur le port 8080
- Vérifier l'URL dans `application.properties`

### Les JSP ne s'affichent pas
- Vérifier que les dépendances Tomcat Jasper et JSTL sont présentes
- Vérifier la configuration des vues dans `application.properties`

### Erreur: "RestTemplate cannot be resolved"
- Vérifier que `spring-boot-starter-web` est dans le `pom.xml`
- Faire un `mvnw clean install`
