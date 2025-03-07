// Package contenant toutes les classes du projet
package minijeux;

import java.util.Scanner;

// Classe publique Calculatrice, qui représente une calculatrice simple
public class Calculatrice {

    // Méthode principale pour exécuter la calculatrice
    public void calculer() {
        Scanner scanner = new Scanner(System.in); // Scanner pour lire les entrées utilisateur
        boolean continuer = true; // Variable pour contrôler la boucle principale

        while (continuer) {
            // Affichage du menu des opérations disponibles
            System.out.println("=== Menu de la Calculatrice ===");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Retour au menu principal");

            System.out.print("Choisissez une opération (1-5) : ");
            String choix = scanner.nextLine(); // Lecture du choix de l'utilisateur

            // Vérification si le choix est valide (entre 1 et 5)
            if (!choix.matches("[1-5]")) {
                System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 5.");
                continue; // Recommence la boucle si le choix est invalide
            }

            // Si l'utilisateur choisit de retourner au menu principal
            if (choix.equals("5")) {
                System.out.println("Retour au menu principal...");
                return; // Quitte la méthode pour retourner au menu principal
            }

            double nombre1, nombre2, resultat = 0;
            String operation = "";

            try {
                // Demande à l'utilisateur d'entrer deux nombres
                System.out.print("Entrez le premier nombre : ");
                nombre1 = Double.parseDouble(scanner.nextLine());

                System.out.print("Entrez le deuxième nombre : ");
                nombre2 = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Gestion des erreurs si l'utilisateur entre une valeur non numérique
                System.out.println("Veuillez entrer des nombres valides.");
                continue; // Recommence la boucle si une erreur est détectée
            }

            // Réalisation de l'opération choisie par l'utilisateur
            switch (choix) {
                case "1":
                    resultat = nombre1 + nombre2;
                    operation = "addition";
                    break;
                case "2":
                    resultat = nombre1 - nombre2;
                    operation = "soustraction";
                    break;
                case "3":
                    resultat = nombre1 * nombre2;
                    operation = "multiplication";
                    break;
                case "4":
                    if (nombre2 == 0) {
                        // Gestion de l'erreur de division par zéro
                        System.out.println("Erreur : Division par zéro n'est pas autorisée.");
                        continue; // Recommence la boucle si division par zéro
                    }
                    resultat = nombre1 / nombre2;
                    operation = "division";
                    break;
                default:
                    System.out.println("Choix invalide.");
                    continue;
            }

            // Affichage du résultat de l'opération
            System.out.printf("Le résultat de la %s entre %.2f et %.2f est : %.2f%n", operation, nombre1, nombre2, resultat);
        }
    }
}
