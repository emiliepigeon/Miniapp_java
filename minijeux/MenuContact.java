// Je dis que cette classe fait aussi partie du package minijeux
package minijeux;

// J'importe la classe Scanner pour lire les entrées de l'utilisateur
import java.util.Scanner;

public class MenuContact {
    // Je crée un gestionnaire de contacts pour gérer ma liste de contacts
    private GestionnaireContacts gestionnaire = new GestionnaireContacts();
    // Je crée un Scanner pour lire ce que l'utilisateur va taper
    private Scanner scanner = new Scanner(System.in);

    // Cette méthode lance le menu de gestion des contacts
    public void run() {
        boolean continuer = true;
        while (continuer) {
            // J'affiche le menu et je lis le choix de l'utilisateur
            afficherMenu();
            String choix = scanner.nextLine();

            // Selon le choix de l'utilisateur, je fais différentes actions
            switch (choix) {
                case "1":
                    ajouterContact();
                    break;
                case "2":
                    gestionnaire.afficherContacts();
                    break;
                case "3":
                    modifierContact();
                    break;
                case "4":
                    supprimerContact();
                    break;
                case "5":
                    continuer = false;
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // Cette méthode affiche le menu de gestion des contacts
    private void afficherMenu() {
        System.out.println("\n=== Gestionnaire de Contacts ===");
        System.out.println("1. Ajouter un contact");
        System.out.println("2. Afficher tous les contacts");
        System.out.println("3. Modifier un contact");
        System.out.println("4. Supprimer un contact");
        System.out.println("5. Retour au menu principal");
        System.out.print("Choisissez une option : ");
    }

    // Cette méthode permet d'ajouter un nouveau contact
    private void ajouterContact() {
        System.out.print("Entrez le nom du contact : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom du contact : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez l'email du contact : ");
        String email = scanner.nextLine();
        gestionnaire.ajouterContact(nom, prenom, email);
    }

    // Cette méthode permet de modifier un contact existant
    private void modifierContact() {
        if (gestionnaire.estVide()) {
            System.out.println("Aucun contact à modifier.");
            return;
        }
        gestionnaire.afficherContacts();
        System.out.print("Entrez le numéro du contact à modifier : ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            Contact contact = gestionnaire.getContact(index);
            if (contact != null) {
                System.out.print("Nouveau nom (" + contact.getNom() + ") : ");
                String nom = scanner.nextLine();
                System.out.print("Nouveau prénom (" + contact.getPrenom() + ") : ");
                String prenom = scanner.nextLine();
                System.out.print("Nouvel email (" + contact.getEmail() + ") : ");
                String email = scanner.nextLine();
                
                nom = nom.isEmpty() ? contact.getNom() : nom;
                prenom = prenom.isEmpty() ? contact.getPrenom() : prenom;
                email = email.isEmpty() ? contact.getEmail() : email;
                
                gestionnaire.modifierContact(index, nom, prenom, email);
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un numéro valide.");
        }
    }

    // Cette méthode permet de supprimer un contact
    private void supprimerContact() {
        if (gestionnaire.estVide()) {
            System.out.println("Aucun contact à supprimer.");
            return;
        }
        gestionnaire.afficherContacts();
        System.out.print("Entrez le numéro du contact à supprimer : ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            gestionnaire.supprimerContact(index);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un numéro valide.");
        }
    }
}