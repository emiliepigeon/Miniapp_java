package minijeux;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuContact {
    private ArrayList<String> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean continuer = true;
        while (continuer) {
            System.out.println("\n=== Gestionnaire de Contacts ===");
            System.out.println("1. Ajouter un contact");
            System.out.println("2. Afficher tous les contacts");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Retour au menu principal");
            
            System.out.print("Choisissez une option : ");
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    ajouterContact();
                    break;
                case "2":
                    afficherContacts();
                    break;
                case "3":
                    supprimerContact();
                    break;
                case "4":
                    continuer = false;
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void ajouterContact() {
        System.out.print("Entrez le nom du contact : ");
        String nom = scanner.nextLine();
        contacts.add(nom);
        System.out.println("Contact ajouté avec succès !");
    }

    private void afficherContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Aucun contact enregistré.");
        } else {
            System.out.println("Liste des contacts :");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private void supprimerContact() {
        if (contacts.isEmpty()) {
            System.out.println("Aucun contact à supprimer.");
            return;
        }
        afficherContacts();
        System.out.print("Entrez le numéro du contact à supprimer : ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < contacts.size()) {
                String contactSupprime = contacts.remove(index);
                System.out.println("Contact '" + contactSupprime + "' supprimé avec succès.");
            } else {
                System.out.println("Numéro de contact invalide.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un numéro valide.");
        }
    }
}
