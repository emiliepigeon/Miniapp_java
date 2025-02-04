package minijeux;

import java.util.Scanner;
import java.util.Random;

public class LanceDeDes {
    // Je déclare mes variables d'instance
    private int nbDeLance;  // Nombre de lancers de dé
    private int nbDeFaces;  // Nombre de faces du dé
    private StringBuilder resultat;  // Pour stocker les résultats des lancers

    // Je crée un constructeur par défaut
    public LanceDeDes() {
        // J'initialise mes variables
        this.nbDeLance = 0;
        this.nbDeFaces = 0;
        this.resultat = new StringBuilder();  // StringBuilder est plus efficace pour concaténer des chaînes
    }

    // Je crée ma méthode principale pour lancer les dés
    public void lancer() {
        // Je crée un objet Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        // Je crée un objet Random pour générer des nombres aléatoires
        Random random = new Random();

        // Je vérifie si le nombre de lancers et de faces sont à 0 (valeurs par défaut)
        if (this.nbDeLance == 0 && this.nbDeFaces == 0) {
            // Si oui, je demande à l'utilisateur de les saisir
            System.out.print("Choisir un nombre de faces pour le dé : ");
            this.nbDeFaces = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre de lancé : ");
            this.nbDeLance = Integer.parseInt(scanner.nextLine());
        }

        // Je lance les dés le nombre de fois demandé
        for (int lancer = 1; lancer <= this.nbDeLance; lancer++) {
            // Je génère un nombre aléatoire entre 1 et le nombre de faces
            int resultatLance = random.nextInt(this.nbDeFaces) + 1;
            
            // J'ajoute le résultat à ma chaîne de résultats
            this.resultat.append("\nRésultat du lancé n° ")
                        .append(lancer)
                        .append(" : ")
                        .append(resultatLance)
                        .append(" !");
        }

        // J'affiche tous les résultats
        System.out.println("\n" + this.resultat.toString());

        // Je ne ferme pas le scanner ici car il pourrait être utilisé ailleurs dans le programme
    }
}
