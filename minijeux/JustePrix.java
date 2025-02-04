package minijeux;

import java.util.Scanner;
import java.util.Random;

public class JustePrix {
    // Je déclare mes variables d'instance
    private int debutInterval;  // Début de l'intervalle pour le prix à deviner
    private int finInterval;    // Fin de l'intervalle pour le prix à deviner
    private int prixATrouver;   // Le prix que le joueur doit deviner

    // Je crée un constructeur avec des paramètres pour personnaliser l'intervalle
    public JustePrix(int _debutInterval, int _finInterval) {
        // J'initialise mes variables avec les valeurs passées en paramètres
        this.debutInterval = _debutInterval;
        this.finInterval = _finInterval;
        
        // Je crée un objet Random pour générer un nombre aléatoire
        Random random = new Random();
        // Je génère le prix à trouver aléatoirement dans l'intervalle donné
        this.prixATrouver = random.nextInt(finInterval - debutInterval + 1) + debutInterval;
    }

    // Je crée un constructeur par défaut qui appelle l'autre constructeur avec des valeurs par défaut
    public JustePrix() {
        this(1, 10);  // Par défaut, l'intervalle est de 1 à 10
    }

    // Je crée ma méthode principale pour jouer au juste prix
    public void run() {
        // Je crée un objet Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lancement du juste prix ...");
        
        int saisieUser;
        do {
            // Je demande à l'utilisateur de saisir un prix
            System.out.print("Saisir un prix : ");
            saisieUser = Integer.parseInt(scanner.nextLine());

            // Je compare la saisie de l'utilisateur avec le prix à trouver
            if (saisieUser > prixATrouver) {
                System.out.println("C'est moins !");
            } else if (saisieUser < prixATrouver) {
                System.out.println("C'est plus !");
            }
        } while (saisieUser != prixATrouver);  // Je continue tant que le prix n'est pas trouvé

        // J'affiche le message de victoire
        System.out.println("Bravo ! Le prix est de : " + prixATrouver + " €");

        // Je ne ferme pas le scanner ici car il pourrait être utilisé ailleurs dans le programme
    }
}

