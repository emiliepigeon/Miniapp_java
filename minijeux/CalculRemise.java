package minijeux;

import java.util.Scanner; // J'importe la classe Scanner pour lire les entrées de l'utilisateur

public class CalculRemise {
    // Je déclare mes variables d'instance
    private double montant; // Pour stocker le montant initial
    private double remise;  // Pour stocker le pourcentage de remise

    // Je crée un constructeur par défaut
    public CalculRemise() {
        // J'initialise mes variables à 0
        this.montant = 0;
        this.remise = 0;
    }

    // Je crée ma méthode principale pour calculer la remise
    public void calculRemise() {
        // Je crée un objet Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Je vérifie si le montant et la remise sont à 0 (valeurs par défaut)
        if (this.montant == 0 || this.remise == 0) {
            // Si oui, je demande à l'utilisateur de les saisir
            System.out.print("Votre montant : ");
            // Je lis l'entrée de l'utilisateur et la convertis en double
            this.montant = Double.parseDouble(scanner.nextLine());

            System.out.print("Votre remise (en %) : ");
            // Je fais de même pour la remise
            this.remise = Double.parseDouble(scanner.nextLine());
        }

        // Je calcule le prix après remise
        // Je soustrais du montant initial le produit du montant et de la remise (convertie en décimal)
        double resultat = this.montant - this.montant * (this.remise / 100);

        // J'arrondi le résultat à deux décimales
        resultat = Math.round(resultat * 100.0) / 100.0;

        // J'affiche le résultat
        System.out.println("Le prix de l'article après la remise est de : " + resultat + " €");

        // Je ne ferme pas le scanner ici car il pourrait être utilisé ailleurs dans le programme
    }
}

