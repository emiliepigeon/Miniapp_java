03/02/2025 Début
De la transformation du Mini App Version Objet en Python -> vers POO en JAVA Vanilla 
avec Vs Code.

Complilation
javac main.java

Lecture du script
java main

Structure du projet
Miniapp_java/
├── main.java
└── minijeux/
    ├── Menu.java
    ├── Calculatrice.java
    ├── MenuContact.java
    └── [autres classes du package minijeux]

    Pour chaque jeux ou fonctionnalités = un objet = une class
    Rappel:
    Nom du fichier java = nom de la class

    
Stucture
Miniapp_java/
├── Main.java              # Fichier principal, point d'entrée du programme.
└── minijeux/
    ├── Menu.java          # Contient le menu principal.
    ├── Calculatrice.java  # Contient la logique de la calculatrice.
    └── [autres fichiers]  # Placez ici les autres classes comme MenuContact, etc.

Si problème de cache penser à jetter les fichiers de compilation en bytecode (non.class) ... Cela peut résoudre certain problèmes (exemple: après compilation et lecture du script aucune erreurs en console mais aucune modification visible) ...

///////////////////////////////////////////////////////////////////////////////
MiniApp : Une Collection de Mini-Jeux et Utilitaires Java
📝 Description
MiniApp est un projet Java interactif proposant une collection de mini-jeux et utilitaires, conçu pour les débutants souhaitant pratiquer la programmation orientée objet.
🎮 Fonctionnalités
Jeux

    Juste Prix : Devinez le nombre mystère
    Jeu du Pendu : Trouvez le mot caché
    Lancé de Dés : Simulez des lancers de dés
    Décodeur César : Chiffrez et déchiffrez des messages

Utilitaires

    Calculateur de Remise : Calculez le prix après remise
    Horloge Numérique : Affichez l'heure en temps réel
    Gestionnaire de Contacts : Gérez une liste de contacts
    Calculatrice Simple : Effectuez des calculs basiques

🛠 Technologies

    Langage : Java
    Paradigme : Programmation Orientée Objet
    Niveau : Débutant

📦 Prérequis

    Java Development Kit (JDK) 8 ou supérieur
    Un IDE Java (recommandé)

🚀 Installation

    Clonez le repository
    Ouvrez dans votre IDE
    Compilez et exécutez Main.java

🤝 Contribution
Les contributions sont les bienvenues ! N'hésitez pas à proposer des améliorations ou de nouveaux jeux.
📄 Licence
Projet open-source - Libre utilisation et modification
👨‍💻 Auteur
Votre Nom
🌟 Bonus

    Code commenté pour les débutants
    Structure modulaire
    Facile à étendre
////////////////////////////////////////////////////////////////////////////////////
Fichiers en détailles
-----------------------------------------------------------------------------------------
Main.java 
= point d'entrée sur lequel on lance toujours la compilation et le lancement du script.

Explication de la logique et de la complexité :

Dans ce fichier Main.java, j'utilise une approche très simple pour démarrer mon programme.
Je fais appel à une seule méthode statique qui va gérer tout le menu principal de mon application.

La logique est la suivante :
1. Mon programme commence son exécution dans la méthode main.
2. J'appelle directement la méthode afficherMenu() de la classe Menu.
3. Cette méthode va prendre le contrôle et gérer toutes les interactions avec l'utilisateur.

En termes de complexité, ce fichier est très simple (complexité O(1)) car il ne fait qu'une seule
opération : appeler une méthode. Toute la complexité de mon programme se trouve dans les autres
classes, notamment dans la classe Menu qui va gérer les différentes options et sous-menus.

Cette approche me permet d'avoir un point d'entrée clair et simple pour mon application, tout en
séparant la logique du menu principal dans une autre classe. C'est une bonne pratique de
programmation car cela rend mon code plus organisé et plus facile à maintenir.

-------------------------------------------------------------------
Fichiers de mon package minijeux
---------------------------------
Mon Menu (principal) appelé dans mon Main.java
Menu.java

Explication de la logique et de la complexité :

Dans ce fichier Menu.java, j'utilise une boucle do-while pour afficher continuellement le menu
principal jusqu'à ce que l'utilisateur choisisse de quitter. Voici la logique principale :

1. J'affiche les options du menu.
2. Je lis le choix de l'utilisateur.
3. J'exécute l'action correspondante au choix de l'utilisateur.
4. Je répète ces étapes jusqu'à ce que l'utilisateur choisisse de quitter.

La complexité de ce code est O(n), où n est le nombre de fois que l'utilisateur fait un choix
avant de quitter. Chaque itération de la boucle prend un temps constant O(1) pour afficher le menu
et traiter le choix de l'utilisateur.

J'utilise un switch pour gérer les différents choix, ce qui est plus efficace qu'une série de
if-else en termes de temps d'exécution. Chaque case du switch crée une nouvelle instance de la
classe correspondante et appelle sa méthode principale.

La gestion des erreurs avec try-catch me permet de gérer les entrées invalides de l'utilisateur
de manière élégante, en affichant un message d'erreur et en continuant l'exécution du programme.

Cette structure de menu est flexible et facilement extensible. Si je veux ajouter de nouvelles
options, je peux simplement ajouter de nouveaux cas au switch et de nouvelles lignes dans
l'affichage du menu.

-----------------------------------------------------
Fonctionnalité 1 = Calcul de remise
CalculRemise.java

Explication de la logique et de la complexité :

Dans ce fichier CalculRemise.java, j'ai créé une classe simple pour calculer le prix d'un article
après application d'une remise. Voici la logique principale :

1. J'initialise les variables montant et remise à 0 dans le constructeur.
2. Dans la méthode calculRemise(), je vérifie si ces valeurs sont toujours à 0.
3. Si oui, je demande à l'utilisateur de les saisir.
4. Je calcule ensuite le nouveau prix en appliquant la formule : 
   nouveau_prix = prix_initial - (prix_initial * pourcentage_remise / 100)
5. J'arrondis le résultat à deux décimales pour avoir un montant en euros cohérent.
6. Enfin, j'affiche le résultat.

La complexité de ce code est O(1), c'est-à-dire en temps constant. Peu importe les valeurs
entrées, le nombre d'opérations reste le même. Il n'y a pas de boucles ou de structures de
données complexes qui pourraient augmenter le temps d'exécution en fonction des entrées.

J'utilise la classe Scanner pour lire les entrées de l'utilisateur, ce qui est une approche
standard en Java pour l'interaction en ligne de commande.

La méthode Math.round() est utilisée pour l'arrondi, ce qui est une façon simple et efficace
de gérer les décimales en Java.

Cette classe est un bon exemple de programmation orientée objet simple, avec des variables
d'instance et une méthode qui effectue un calcul spécifique. Elle pourrait facilement être
étendue pour inclure plus de fonctionnalités liées aux calculs de prix et de remises.

-------------------------------------------------------
Fonctionnalité 2 = Lancé de dés
LanceDeDes.java

Explication de la logique et de la complexité :

Dans ce fichier LanceDeDes.java, j'ai créé une classe qui simule le lancer de dés. Voici la logique principale :

1. J'initialise les variables nbDeLance et nbDeFaces à 0 dans le constructeur.
2. Dans la méthode lancer(), je vérifie si ces valeurs sont toujours à 0.
3. Si oui, je demande à l'utilisateur de les saisir.
4. J'utilise une boucle for pour simuler chaque lancer de dé.
5. Pour chaque lancer, je génère un nombre aléatoire entre 1 et le nombre de faces du dé.
6. J'ajoute chaque résultat à un StringBuilder pour une construction efficace de la chaîne de résultats.
7. Enfin, j'affiche tous les résultats.

La complexité de ce code est O(n), où n est le nombre de lancers de dé (nbDeLance). La boucle for
s'exécute exactement nbDeLance fois, et chaque itération prend un temps constant pour générer un
nombre aléatoire et ajouter le résultat au StringBuilder.

J'utilise la classe Random pour générer des nombres aléatoires, ce qui est une approche standard
en Java pour la génération de nombres pseudo-aléatoires.

L'utilisation de StringBuilder au lieu de String pour construire la chaîne de résultats est une
optimisation importante. StringBuilder est beaucoup plus efficace que la concaténation de String
lorsqu'on doit faire de nombreuses modifications à une chaîne.

Cette classe est un bon exemple de comment on peut utiliser la programmation orientée objet pour
modéliser un processus du monde réel (lancer de dés) en code Java. Elle pourrait facilement être
étendue pour inclure plus de fonctionnalités, comme des statistiques sur les lancers ou différents
types de dés.


------------------------------------------------
Fonctionnalité 3 = Le juste prix
JstePrix.java

Explication de la logique et de la complexité :

Dans ce fichier JustePrix.java, j'ai créé une classe qui simule le jeu du Juste Prix. Voici la logique principale :

1. J'ai deux constructeurs : un qui permet de définir l'intervalle du prix, et un par défaut qui utilise un intervalle de 1 à 10.
2. Dans le constructeur, je génère aléatoirement le prix à trouver dans l'intervalle donné.
3. Dans la méthode run(), j'utilise une boucle do-while pour demander répétitivement à l'utilisateur de deviner le prix.
4. À chaque tentative, je compare la saisie de l'utilisateur avec le prix à trouver et je donne un indice ("C'est plus !" ou "C'est moins !").
5. La boucle continue jusqu'à ce que l'utilisateur trouve le bon prix.

La complexité de ce code est O(n), où n est le nombre de tentatives de l'utilisateur. Dans le pire des cas,
si l'utilisateur est très malchanceux, il pourrait avoir besoin d'autant de tentatives qu'il y a de nombres
dans l'intervalle. Cependant, en moyenne, le nombre de tentatives nécessaires sera beaucoup plus faible,
surtout si l'utilisateur utilise une stratégie efficace (comme la recherche dichotomique).

J'utilise la classe Random pour générer le prix à trouver, ce qui assure que chaque partie est unique et imprévisible.

La structure do-while est parfaite pour ce jeu car je veux toujours exécuter le corps de la boucle au moins une fois
(pour la première tentative de l'utilisateur), puis continuer tant que la condition n'est pas remplie.

Cette classe est un bon exemple de jeu simple en Java. Elle pourrait facilement être étendue pour inclure plus de
fonctionnalités, comme un nombre limité de tentatives, des niveaux de difficulté, ou des statistiques sur les parties jouées.

---------------------------------------------------------
Fonctionnalité 4 =  Horloge Numérique
HorlogeNumerique.java

Explication de la logique et de la complexité :

Dans ce fichier HorlogeNumerique.java, j'ai créé une classe qui simule une horloge numérique. Voici la logique principale :

1. J'ai deux constructeurs : un qui permet de définir le délai d'affichage, et un par défaut qui utilise un délai de 10 secondes.
2. Dans la méthode run(), j'utilise une boucle for pour afficher l'heure actuelle pendant le nombre de secondes spécifié.
3. À chaque itération, j'essaie d'effacer la console (ce qui peut ne pas fonctionner dans tous les environnements), puis j'affiche l'heure actuelle.
4. Après chaque affichage, je mets le thread en pause pendant 1 seconde pour simuler le passage du temps.

La complexité de ce code est O(n), où n est le nombre de secondes spécifié par le délai. La boucle s'exécute
exactement n fois, et chaque itération prend un temps constant pour afficher l'heure et attendre une seconde.

J'utilise les classes LocalTime et DateTimeFormatter de Java 8+ pour manipuler et formater l'heure, ce qui est
une approche moderne et robuste pour travailler avec le temps en Java.

L'utilisation de Thread.sleep() pour simuler le passage du temps n'est pas très précise et pourrait conduire à
une dérive de l'horloge sur de longues périodes. Pour une horloge plus précise, on pourrait utiliser un ScheduledExecutorService.

Cette classe est un bon exemple d'utilisation des fonctionnalités de date et d'heure de Java, ainsi que de
la gestion basique des threads. Elle pourrait être étendue pour inclure plus de fonctionnalités, comme
différents formats d'affichage, des alarmes, ou une meilleure gestion des interruptions.


-----------------------------------------
Fonctionnalité 5 = Jeu du pendu => trouver mot....
JeuDuPendu.java

Explication de la logique et de la complexité :

Dans ce fichier JeuDuPendu.java, j'ai créé une classe qui simule le jeu du pendu. Voici la logique principale :

1. J'ai deux constructeurs : un avec une liste de mots par défaut, et un qui accepte une liste personnalisée.
2. La méthode initialiserJeu() choisit un mot au hasard et prépare les structures de données pour le jeu.
3. Dans la méthode run(), j'utilise une boucle while pour continuer le jeu tant que le mot n'est pas entièrement deviné.
4. À chaque tour, j'affiche l'état actuel du mot (avec des tirets pour les lettres non devinées) et je demande une lettre à l'utilisateur.
5. Je vérifie si la lettre est dans le mot et je mets à jour l'affichage en conséquence.
6. Le jeu se termine quand toutes les lettres ont été devinées.

La complexité de ce code varie selon les parties :
- L'initialisation du jeu est O(n), où n est la longueur du mot à deviner.
- Chaque tour de jeu est O(n) car je dois parcourir toutes les lettres du mot pour vérifier et mettre à jour.
- Le nombre total de tours dépend de la performance du joueur et de la longueur du mot, mais ne peut pas dépasser 26 (nombre de lettres dans l'alphabet) * longueur du mot dans le pire des cas.

J'utilise plusieurs structures de données de Java :
- ArrayList pour stocker les mots et les lettres, ce qui permet une manipulation facile.
- Random pour choisir un mot au hasard.
- Scanner pour lire les entrées de l'utilisateur.

Cette implémentation du jeu du pendu est simple mais fonctionnelle. Elle pourrait être améliorée en ajoutant :
- Un nombre limité d'essais avant de perdre.
- Un affichage graphique du pendu.
- Une gestion des lettres déjà proposées.
- Des niveaux de difficulté basés sur la longueur ou la rareté des mots.


------------------------------------------
Fonctionnalité 6 = Décodeur de César
DecodeurCesar.java

Explication de la logique et de la complexité :

Dans ce fichier DecodeurCesar.java, j'ai créé une classe qui implémente le chiffrement et le déchiffrement de César. Voici la logique principale :

1. J'utilise une liste pour représenter l'alphabet, ce qui me permet de facilement trouver l'index d'une lettre et de faire des opérations circulaires.
2. Je demande à l'utilisateur de choisir entre chiffrer et déchiffrer, de saisir un message, et de définir une clé de chiffrement.
3. Pour chaque lettre du message, je trouve son index dans l'alphabet, je calcule le nouvel index en fonction de l'opération et de la clé, puis j'ajoute la nouvelle lettre au résultat.
4. Les caractères qui ne sont pas des lettres sont conservés tels quels.

La complexité de ce code est O(n), où n est la longueur du message. Je parcours chaque caractère du message une seule fois, et pour chaque caractère, je fais des opérations en temps constant (recherche dans une liste de taille fixe, calculs simples).

J'utilise plusieurs concepts de Java :
- Lists et Arrays pour gérer l'alphabet
- StringBuilder pour construire efficacement le message résultant
- Scanner pour lire les entrées de l'utilisateur
- Boucles do-while pour valider les entrées de l'utilisateur
- Opérateur modulo (%) pour gérer la circularité de l'alphabet

Cette implémentation du chiffre de César est simple mais fonctionnelle. Elle pourrait être améliorée en ajoutant :
- La gestion des minuscules
- La possibilité de chiffrer/déchiffrer des fichiers entiers
- Une interface graphique pour une meilleure expérience utilisateur


------------------------------------------
Fonctionnalité 7 = Gestionnaire de contact et son menu
MenuContact.java

Explication de la logique et de la complexité :

Dans ce fichier MenuContact.java, j'ai créé une classe qui gère l'interface utilisateur pour le gestionnaire de contacts. Voici la logique principale :

1. J'utilise une boucle while pour afficher continuellement le menu jusqu'à ce que l'utilisateur choisisse de quitter.
2. Pour chaque choix de l'utilisateur, j'appelle la méthode correspondante (ajouter, afficher, modifier, supprimer).
3. Chaque méthode interagit avec l'utilisateur pour obtenir les informations nécessaires, puis appelle les méthodes appropriées du GestionnaireContacts.

La complexité de ce code varie selon les opérations :
- L'affichage du menu et la lecture du choix sont en O(1) (temps constant).
- Les opérations d'ajout, de modification et de suppression sont généralement en O(1), mais peuvent être en O(n) dans le pire des cas, où n est le nombre de contacts.
- L'affichage de tous les contacts est en O(n).

J'utilise plusieurs concepts de programmation Java :
- Encapsulation : les méthodes privées pour les opérations internes.
- Gestion des exceptions : pour traiter les entrées invalides de l'utilisateur.
- Utilisation d'objets : je crée et manipule des instances de GestionnaireContacts et Contact.

Cette classe MenuContact agit comme une interface entre l'utilisateur et le GestionnaireContacts, suivant le principe de séparation des responsabilités. Elle pourrait être améliorée en ajoutant plus de fonctionnalités, comme la recherche de contacts ou l'exportation/importation de la liste de contacts.

GestionnaireContacts.java

Explication de la logique et de la complexité :

Dans ce fichier GestionnaireContacts.java, j'ai créé deux classes : GestionnaireContacts et Contact.

GestionnaireContacts :
Cette classe gère une liste de contacts. Voici la logique principale :
1. J'utilise une ArrayList pour stocker les contacts, ce qui me permet d'ajouter et de supprimer facilement des contacts.
2. Le constructeur ajoute deux contacts prédéfinis à la liste.
3. Les méthodes ajouterContact, supprimerContact, et modifierContact manipulent la liste de contacts.
4. La méthode afficherContacts parcourt la liste et affiche chaque contact.

La complexité des opérations est généralement O(1) pour l'ajout et l'accès aux éléments, mais O(n) pour la suppression et l'affichage, où n est le nombre de contacts.

Contact :
Cette classe représente un contact individuel avec nom, prénom et email.
1. Elle utilise l'encapsulation en déclarant les attributs comme privés et en fournissant des getters et setters.
2. La méthode toString() est redéfinie pour fournir une représentation en chaîne du contact.

La complexité des opérations sur un Contact individuel est O(1) car elles impliquent simplement l'accès ou la modification d'attributs.

Cette structure de classes suit le principe de responsabilité unique : GestionnaireContacts gère la collection de contacts, tandis que Contact représente les données d'un seul contact. Cela rend le code plus modulaire et plus facile à maintenir.

/////////////////////////////////////////////////////////

Voilà!!!!!!