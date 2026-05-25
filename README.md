# Lab 9 — Web Service PHP + Android (Volley & Gson)

**Cours : Programmation Mobile — Android avec Java**

---

## Objectif

Ce lab montre comment **consommer un Web Service PHP** depuis une application Android en utilisant la bibliothèque **Volley** pour les requêtes HTTP et **Gson** pour parser les réponses JSON.

---

## Concepts clés

| Concept | Rôle |
|---|---|
| **Web Service PHP** | Expose des données MySQL en format JSON via HTTP |
| **Volley** | Bibliothèque Android pour envoyer des requêtes HTTP GET/POST |
| **Gson** | Convertit automatiquement le JSON en objets Java |
| **PDO** | Connexion sécurisée à la base de données MySQL côté PHP |
| **IP locale** | Adresse pour accéder au serveur depuis un vrai téléphone |

---

---

## Fonctionnalités

- **Ajouter un étudiant** : envoie une requête POST avec nom, prénom, ville et sexe
- **Affichage en temps réel** : après ajout les données sont récupérées et loggées via Gson
- **Formulaire complet** : EditText, Spinner, RadioGroup, Button
- **Gestion réseau** : configuration HTTP local pour téléphone réel et émulateur

---

## Captures d'écran

### 1. Formulaire prêt à saisir

<img width="1080" height="2340" alt="Screenshot_20260525_125454_ProjetWS" src="https://github.com/user-attachments/assets/4c516887-2d23-4c1a-91c1-fc721eeff09e" />

### 2. Saisie des données étudiant

<img width="1080" height="2340" alt="Screenshot_20260525_125545_ProjetWS" src="https://github.com/user-attachments/assets/93384c82-23cc-44b2-8cac-08b222855e71" />

### 3. Confirmation — étudiant ajouté avec succès

<img width="1080" height="2340" alt="Screenshot_20260525_125519_ProjetWS" src="https://github.com/user-attachments/assets/81908566-b284-4f2f-88f5-46ac82058a32" />

### 4. Vérification dans phpMyAdmin — données enregistrées

<img width="1111" height="421" alt="Capture d’écran 2026-05-25 131839" src="https://github.com/user-attachments/assets/f35aafc9-b146-4302-be4c-ec11b532d39b" />

---

## Résultats de validation

| Test | Résultat |
|---|---|
| Ajout via formulaire Android | Toast "Étudiant ajouté avec succès !" affiché |
| Données reçues en JSON | Parsées correctement via Gson |
| Vérification phpMyAdmin | Enregistrement visible dans la table Etudiant |
| Connexion téléphone réel | Fonctionne via IP locale WiFi |

---

## Technologies utilisées

- Java
- Android SDK
- Volley 1.2.1
- Gson 2.10.1
- PHP 8 + PDO
- MySQL / phpMyAdmin
- XAMPP
