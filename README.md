# Test_Driven_Development-Brief

<h2>Contexte du projet</h2>

<p>Afin de réaliser un plan de test et pour but de simplicité, on va réaliser une simple microservice permettant la gestion des clients d’une entreprise B2C.</p>

<img src="tdd.png">

Un client se caractérise par un :

identifiant (générer par une séquence)
email (unique et non nul)
numéro de téléphone (unique, non null et valide pour un numéro de téléphone marocain)
nom complet (non null)
age (valide)
sex (valide, enumeration)
isActive (boolean, default true)
​

Votre 1ʳᵉ mission est de préparer L’API REST qui expose les “endpoints” suivantes :

“/clients/save” → Ajouter un client ou une liste de clients.
“/clients/” → Sélectionner l’ensemble des clients (utilisée la pagination).
“/clients/{id}” → Chercher un client par identifiant.
“/clients/{email}” → Chercher un client par email.
“/clients/all/{sex}” → Chercher l’ensemble des clients par sex.
“/clients/{id}” → Supprimer un client (désactiver).
“/clients/{id}” → Modifier un client.
… vous pouvez ajouter d’autres “endpoints” (optional)
​

Votre 2ᵉ mission est de préparer ainsi qu’exécuter les plans de tests de l’ensemble des couches/fonctionnalités de cette microservice.

“Controller Layer”
“Service Layer”
“Repository Layer”
All layers (end to end).
​

Votre 3ᵉ mission serait un bonus (optional). Mise en place d’un pipeline CI/CD pour le but d’automatisation des tests.

​

Contraintes :

Utiliser Maven.

Utiliser les spring boot starters depuis https://start.spring.io/:

Spring Web : RESTful
Spring Data JPA
MySQL Driver | PostgeSQL Driver
Lombok: générer les POJOS.
Utiliser Junit5 et Mockito.

Utiliser GithubActions. (optional)

