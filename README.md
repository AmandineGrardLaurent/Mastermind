# 🎯 Mastermind - Jeu en Java

Mastermind est un jeu de réflexion dans lequel le joueur doit deviner un **code secret** à 4 chiffres généré aléatoirement par l'ordinateur. Après chaque tentative, le joueur reçoit des indices pour savoir combien de chiffres sont **bien placés** et combien sont **mal placés**. 🕵️‍♂️💡

---

## ✨ Fonctionnalités

- 🎲 Génération d’un code secret aléatoire à 4 chiffres (0000 à 9999).  
- 📝 Saisie sécurisée de l’utilisateur avec validation du format.  
- ✅ Calcul du nombre de chiffres correctement placés.  
- ❌ Calcul du nombre de chiffres présents mais mal placés.  
- 📊 Affichage clair des résultats pour guider le joueur.  
- 🔄 Boucle jusqu’à ce que le code secret soit trouvé.  

---

## 🔧 Fonctions principales

#### 1️⃣ `getUserNumber(Scanner scan)`
- Récupère la saisie de l’utilisateur.  
- Vérifie que la saisie contient exactement 4 chiffres.  

#### 2️⃣ `stringToIntArray(String str)`  
- Convertit une chaîne en tableau d'entiers.  
- Exemple : `"1234"` → `[1, 2, 3, 4]`.  

#### 3️⃣ `intArrayToString(int[] array)`  
- Convertit un tableau d’entiers en chaîne.  
- Exemple : `[1, 2, 3, 4]` → `"1234"`.  

#### 4️⃣ `generateRandomCode()`  
- Génère un code secret aléatoire à 4 chiffres. 🎲  

#### 5️⃣ `countDigitsMisplaced(int[] secretCode, int[] userCode)`  
- Compte les chiffres présents mais **mal placés**.  
- Gère correctement les doublons. 🔄  

#### 6️⃣ `countDigitsCorrectPosition(int[] secretCode, int[] userCode)`  
- Compte les chiffres **bien placés**. ✅  

#### 7️⃣ `displayInformations(String prompt, int number)`  
- Affiche les informations formatées pour l’utilisateur. 💬  

---

## 🕹️ Comment jouer ?

1. Compiler le fichier Java :

```bash
javac Mastermind.java
```

2. Lancer le programme :

```bash
java Mastermind
```

3. Saisir un nombre à 4 chiffres lorsque le programme le demande.

4. Le programme affichera :

- Chiffres bien placés

- Chiffres mal placés

5. Répéter les essais jusqu’à ce que le code secret soit trouvé. 🎉

---
## 📌 Exemple de sortie

```yaml
================================
Votre nombre à 4 chiffres :
1234
Essai n°1
2 chiffre(s) de mal placés 
1 chiffre(s) de bien placés 
...
Bravo vous avez trouvé le code secret : 5678 

```