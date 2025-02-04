// Je suis le fichier principal qui lance mon programme
// Je n'ai pas besoin de package car je suis à la racine du projet

public class Main {
    // La méthode main est le point de départ de mon programme
    public static void main(String[] args) {
        // J'appelle la méthode afficherMenu de la classe Menu qui est dans le package minijeux
        // C'est comme si je disais "Va dans le dossier minijeux, trouve la classe Menu, et lance sa méthode afficherMenu"
        minijeux.Menu.afficherMenu(); 
    }
}