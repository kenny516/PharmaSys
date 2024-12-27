
# PharmaSys - Application de gestion de vente et de stock de pharmacie

**PharmaSys** est une application web de gestion des ventes et des stocks d'une pharmacie. Ce projet utilise **Spring Boot** et **Thymeleaf** pour le backend et le frontend, permettant de suivre les ventes, gérer les stocks, et effectuer diverses actions CRUD sur les médicaments, laboratoires, public cible, maladies et utilisateurs.

## Table des matières
1. [Description du projet](#description-du-projet)
2. [Fonctionnalités](#fonctionnalités)
3. [Prérequis](#prérequis)
4. [Installation](#installation)
5. [Structure du projet](#structure-du-projet)
6. [Technologies utilisées](#technologies-utilisées)
7. [Contribuer](#contribuer)
8. [Licence](#licence)

## Description du projet
PharmaSys permet aux utilisateurs de gérer les ventes et les stocks de médicaments d'une pharmacie, avec des fonctionnalités variées telles que :
- Un **dashboard** de suivi des ventes et des médicaments les plus vendus.
- Un système CRUD complet pour gérer les médicaments, les laboratoires, les publics cibles et les maladies.
- La possibilité de rechercher des médicaments selon des critères (public cible, budget, maladie).
- Gestion des utilisateurs avec des rôles distincts (admin, vendeur) pour définir les permissions d'accès.
  
Ce projet a été développé avec **Spring Boot** pour le backend, et **Thymeleaf** pour le frontend afin de fournir une interface utilisateur dynamique et interactive.

## Fonctionnalités
- **Dashboard de vente** : Suivi des ventes en temps réel et des médicaments les plus vendus.
- **CRUD des médicaments** : Ajouter, modifier, supprimer des médicaments.
- **Gestion des laboratoires** : CRUD pour gérer les laboratoires des médicaments.
- **Gestion des publics cibles et maladies** : CRUD pour gérer les publics cibles et les maladies associées aux médicaments.
- **Historique des ventes et des mouvements de stock** : Suivi détaillé des transactions et des changements dans le stock.
- **Recherche de médicaments** : Filtrer les médicaments en fonction du public cible, du budget et des maladies.
- **Gestion des utilisateurs et des rôles** : Définir des rôles (admin, vendeur) et attribuer des permissions spécifiques.

## Prérequis
Avant de pouvoir exécuter l'application, vous devez vous assurer que les prérequis suivants sont installés :

- **Java 17+** (pour compiler et exécuter l'application Spring Boot)
- **Maven** (pour la gestion des dépendances)
- **IDE** comme **IntelliJ IDEA** ou **Eclipse** (optionnel)
- **PostgreSQL** pour la gestion de la base de données

## Installation

### 1. Clonez le dépôt
```bash
git clone https://github.com/kenny516/PharmaSys.git

```

### 2. Accédez au répertoire du projet
```bash
cd pharmasys
```

### 3. Configurez la base de données
- Assurez-vous que PostgreSQL est installé et une base de données est configurée.
- Mettez à jour les paramètres de connexion à la base de données dans le fichier `src/main/resources/application.properties`.

### 4. Exécutez l'application
#### Avec Maven
```bash
./mvnw spring-boot:run
```

#### Avec Gradle
```bash
./gradlew bootRun
```

### 5. Accédez à l'application
L'application sera disponible sur `http://localhost:8080`.

## Structure du projet

```
pharmasys/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.mg.app/
│   │   │       └── pharmasys/
│   │   │           ├── controller/
│   │   │           ├── model/
│   │   │           ├── repository/
│   │   │           └── service/
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   ├── templates/
│   │   │   └── application.properties
│   └── test/
│       ├── java/
│       └── resources/
│
└── pom.xml (si vous utilisez Maven)
```

## Technologies utilisées
- **Spring Boot** : Framework pour créer l'API REST et gérer la logique backend.
- **Thymeleaf** : Moteur de templates pour la gestion du frontend dynamique.
- **PostgreSQL** : Base de données pour stocker les données de l'application.
- **Spring Security** : Gestion des utilisateurs et des rôles.
- **Maven** : Gestion des dépendances du projet.

## Contribuer
Les contributions sont les bienvenues! Si vous souhaitez contribuer à ce projet, veuillez suivre ces étapes :

1. Fork le projet.
2. Créez une branche pour vos modifications (`git checkout -b feature/nom-fonctionnalite`).
3. Faites vos modifications.
4. Committez vos changements (`git commit -m 'Ajout de la fonctionnalité X'`).
5. Poussez vos modifications sur votre fork (`git push origin feature/nom-fonctionnalite`).
6. Ouvrez une Pull Request.

## Licence
Ce projet est sous **Licence MIT**.

---

Merci de contribuer à ce projet!