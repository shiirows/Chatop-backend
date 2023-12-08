# Chatop-backend

## Table des matières

- [Présentation](#présentation)
- [Technologies](#technologies)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Configuration](#configuration)
- [Swagger](#Swagger)

## Présentation

Le Chatop-backend est le composant backend d'un portail de mise en relation entre les futurs locataires et les propriétaires pour des locations saisonnières. Initialement axé sur la côte basque, notre projet vise à faciliter la recherche, la réservation et la gestion des locations de vacances. Nous connectons les locataires à des propriétaires de manière transparente, offrant une expérience utilisateur fluide.

### Objectifs

- Simplifier la recherche de locations saisonnières sur la côte basque, offrant aux utilisateurs une variété d'options adaptées à leurs besoins.
- Faciliter la communication entre les locataires et les propriétaires pour garantir une expérience de location agréable.
- Élargir progressivement notre portail pour couvrir des locations saisonnières dans toute la France.

Notre backend, développé avec Spring Boot, gère les fonctionnalités essentielles de cette plateforme, offrant une base solide pour l'expansion future de notre service.

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework de développement d'applications Java basé sur Spring.
- [Autres dépendances et bibliothèques]

## Prérequis

Décrivez les logiciels ou les composants nécessaires à l'installation et à l'exécution de votre application.

- [Java](https://www.oracle.com/java/)
- [Maven](https://maven.apache.org/)

## Installation

1. Clônez le dépôt : `https://github.com/shiirows/Chatop-backend.git`
2. Allez dans le répertoire du projet : `cd Chatop-backend`
3. Compilez le projet : `mvn clean install`

## Configuration application properties

# Configuration de l'URL source
spring.datasource.url=jdbc:mysql://localhost:3306/chatop

# Configuration de la data source username
spring.datasource.username=username

# Configuration de la data source password
spring.datasource.password=password

# Configuration du port
server.port=3001

# Configuration du JWT secret
wcslyon.app.jwtSecret=votreSecret

## Swagger UI

L'interface Swagger UI est disponible à l'adresse suivante :

[Swagger UI](http://localhost:8080/swagger-ui/)