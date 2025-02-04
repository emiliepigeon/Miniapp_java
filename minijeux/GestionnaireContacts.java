
// Je déclare que cette classe fait partie du package minijeux
package minijeux;

// J'importe la classe ArrayList de java.util pour pouvoir créer une liste dynamique de contacts
import java.util.ArrayList;

// Cette classe gère la liste des contacts
public class GestionnaireContacts {
    // Je crée une ArrayList pour stocker les contacts
    private ArrayList<Contact> contacts = new ArrayList<>();

    // Le constructeur de la classe
    public GestionnaireContacts() {
        // J'ajoute deux contacts prédéfinis à la liste
        contacts.add(new Contact("Paul", "Personne", "PaulP@gmail.com"));
        contacts.add(new Contact("Georgette", "Courgette", "coucou@coucou.fr"));
    }

    // Cette méthode ajoute un nouveau contact à la liste
    public void ajouterContact(String nom, String prenom, String email) {
        contacts.add(new Contact(nom, prenom, email));
        System.out.println("Contact ajouté avec succès !");
    }

    // Cette méthode affiche tous les contacts de la liste
    public void afficherContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Aucun contact enregistré.");
        } else {
            System.out.println("Liste des contacts :");
            for (int i = 0; i < contacts.size(); i++) {
                // J'affiche le numéro du contact (i+1) et ses informations
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    // Cette méthode supprime un contact de la liste
    public void supprimerContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            Contact contactSupprime = contacts.remove(index);
            System.out.println("Contact '" + contactSupprime.getNom() + " " + contactSupprime.getPrenom() + "' supprimé avec succès.");
        } else {
            System.out.println("Numéro de contact invalide.");
        }
    }

    // Cette méthode modifie un contact existant dans la liste
    public void modifierContact(int index, String nom, String prenom, String email) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);
            contact.setNom(nom);
            contact.setPrenom(prenom);
            contact.setEmail(email);
            System.out.println("Contact modifié avec succès.");
        } else {
            System.out.println("Numéro de contact invalide.");
        }
    }

    // Cette méthode vérifie si la liste de contacts est vide
    public boolean estVide() {
        return contacts.isEmpty();
    }

    // Cette méthode retourne un contact spécifique de la liste
    public Contact getContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            return contacts.get(index);
        }
        return null;
    }
}

// Cette classe représente un contact individuel
class Contact {
    private String nom;
    private String prenom;
    private String email;

    // Le constructeur de la classe Contact
    public Contact(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters et setters pour accéder et modifier les attributs du contact
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Cette méthode retourne une représentation en chaîne de caractères du contact
    @Override
    public String toString() {
        return nom + " " + prenom + " (" + email + ")";
    }
}
