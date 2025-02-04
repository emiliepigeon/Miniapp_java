// Je déclare que cette classe fait partie du package minijeux
package minijeux;

// J'importe la classe ArrayList qui me permet de créer des listes dynamiques
import java.util.ArrayList;

// J'importe la classe Arrays qui contient des méthodes utiles pour manipuler des tableaux
import java.util.Arrays;

// J'importe l'interface List qui définit les méthodes communes à toutes les listes
import java.util.List;

// J'importe la classe Random qui me permet de générer des nombres aléatoires
import java.util.Random;

// J'importe la classe Scanner qui me permet de lire les entrées de l'utilisateur
import java.util.Scanner;

public class JeuDuPendu {
    // Je déclare mes variables d'instance
    private List<String> listeMots;  // Liste des mots possibles à deviner
    private String motATrouver;      // Le mot que le joueur doit deviner
    private List<Character> listeLettreMot;     // Liste des lettres du mot à trouver
    private List<Character> affichageMotATrouver;  // Liste pour l'affichage du mot avec des tirets

    // Je crée un constructeur avec une liste de mots par défaut
    public JeuDuPendu() {
        // J'initialise la liste de mots par défaut
        this.listeMots = new ArrayList<>(Arrays.asList("foo", "bar", "barfoo", "foobar"));
        initialiserJeu();
    }

    // Je crée un constructeur qui accepte une liste de mots personnalisée
    public JeuDuPendu(List<String> _listeMots) {
        this.listeMots = _listeMots;
        initialiserJeu();
    }

    // Méthode pour initialiser le jeu
    private void initialiserJeu() {
        // Je choisis un mot au hasard dans la liste
        Random random = new Random();
        this.motATrouver = this.listeMots.get(random.nextInt(this.listeMots.size()));

        // J'initialise les listes pour les lettres du mot et l'affichage
        this.listeLettreMot = new ArrayList<>();
        this.affichageMotATrouver = new ArrayList<>();

        // Je remplis les listes avec les lettres du mot et des tirets
        for (char lettre : this.motATrouver.toCharArray()) {
            this.listeLettreMot.add(lettre);
            this.affichageMotATrouver.add('-');
        }
    }

    // Méthode principale pour jouer au jeu
    public void run() {
        System.out.println("Lancement du Jeu du pendu ...");
        Scanner scanner = new Scanner(System.in);

        // Je continue le jeu tant qu'il reste des tirets dans l'affichage
        while (this.affichageMotATrouver.contains('-')) {
            // J'affiche le mot à trouver (avec les tirets)
            System.out.println("Mot à trouver : " + String.join("", this.affichageMotATrouver.stream().map(String::valueOf).toArray(String[]::new)));

            // Je demande à l'utilisateur de saisir une lettre
            System.out.print("Saisir une lettre : ");
            char lettreUser = scanner.nextLine().charAt(0);

            // Je vérifie si la lettre est dans le mot
            if (this.listeLettreMot.contains(lettreUser)) {
                System.out.println("Bravo, vous avez trouvé une lettre du mot !");
                // Je remplace le tiret par la lettre trouvée
                for (int i = 0; i < this.listeLettreMot.size(); i++) {
                    if (this.listeLettreMot.get(i) == lettreUser) {
                        this.affichageMotATrouver.set(i, lettreUser);
                        this.listeLettreMot.set(i, '0'); // Je marque la lettre comme trouvée
                    }
                }
            } else {
                System.out.println("Cette lettre n'est pas dans le mot.");
            }
        }

        // Le joueur a trouvé le mot
        System.out.println("Félicitations ! Vous avez trouvé le mot : " + this.motATrouver);
    }
}