// Je dis que cette classe fait partie du package minijeux
// Ça veut dire qu'elle doit être dans un dossier appelé minijeux
package minijeux;

// J'importe la classe Scanner pour pouvoir lire ce que l'utilisateur tape
import java.util.Scanner;

public class Menu {
    // Cette méthode affiche le menu principal et gère les choix de l'utilisateur
    public static void afficherMenu() {
        // Je crée un Scanner pour lire ce que l'utilisateur va taper
        Scanner scanner = new Scanner(System.in);
        int choix;

        // Je commence une boucle qui va continuer jusqu'à ce que l'utilisateur choisisse de quitter
        do {
            // J'affiche les options du menu
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Calculer une remise");
            System.out.println("2. Lance de dé");
            System.out.println("3. Jeu du juste prix");
            System.out.println("4. Horloge numérique");
            System.out.println("5. Jeu du pendu");
            System.out.println("6. Décodeur César");
            System.out.println("7. Gestionnaire de contact");
            System.out.println("8. Calculatrice simple");
            System.out.println("0. Quitter");

            System.out.print("\nVotre choix : ");
            
            try {
                // Je lis le choix de l'utilisateur et je le transforme en nombre
                choix = Integer.parseInt(scanner.nextLine());
                
                // Selon le choix de l'utilisateur, je lance différentes actions
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
                        // Ici, je crée un nouveau MenuContact et je lance sa méthode run
                        // C'est cette ligne qui pourrait causer l'erreur si MenuContact n'est pas trouvé
                        new MenuContact().run();
                        break;
                    case 8:
                        new Calculatrice().calculer();
                        break;
                    case 0:
                        System.out.println("*** Fin du programme ***");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
                
            } catch (NumberFormatException e) {
                // Si l'utilisateur n'a pas tapé un nombre, je lui dis et je continue la boucle
                System.out.println("Veuillez entrer un numéro valide.");
                choix = -1;
            }
        } while (choix != 0); // Je continue tant que l'utilisateur n'a pas choisi 0 pour quitter

        // Je ferme le Scanner quand j'ai fini de l'utiliser
        scanner.close();
    }
}