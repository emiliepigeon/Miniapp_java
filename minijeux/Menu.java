package minijeux;

import java.util.Scanner;

public class Menu {
    public static void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            // J'affiche le menu principal
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Calculer une remise");
            System.out.println("2. Lance de dé");
            System.out.println("3. Jeu du juste prix");
            System.out.println("4. Horloge numérique");
            System.out.println("5. Jeu du pendu");
            System.out.println("6. Décodeur César");
            System.out.println("7. Gestionnaire de contact");            System.out.println("8. Calculatrice simple");
            System.out.println("0. Quitter");

            System.out.print("\nVotre choix : ");
            
            try {
                choix = Integer.parseInt(scanner.nextLine());
                
                switch (choix) {
                    case 1:
                        new CalculRemise().calculRemise();
                        break;
                    case 2:
                        new LanceDeDes().lancer();
                        break;
                    case 3:
                        new JustePrix().run();
                        break;
                    case 4:
                        new HorlogeNumerique().run();
                        break;
                    case 5:
                        new JeuDuPendu().run();
                        break;
                    case 6:
                        new DecodeurCesar().run();
                        break;
                    case 7:
                        new MenuContact().run();
                        break;
                    case 8:
                        new Calculatrice().calculer(); // Appel correct de la calculatrice
                        break;
                    case 0:
                        System.out.println("*** Fin du programme ***");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
                
            } catch (NumberFormatException e) {
                // Gestion des erreurs si l'utilisateur entre autre chose qu'un entier
                System.out.println("Veuillez entrer un numéro valide.");
                choix = -1; // Réinitialisation pour éviter de quitter
            }
        } while (choix != 0);

        scanner.close(); // Fermeture du scanner après utilisation
    }
}
