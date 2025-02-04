// Je déclare que cette classe fait partie du package minijeux
package minijeux;

// J'importe la classe LocalTime de java.time pour manipuler l'heure actuelle
import java.time.LocalTime;
// J'importe la classe DateTimeFormatter de java.time.format pour formater l'affichage de l'heure
import java.time.format.DateTimeFormatter;

public class HorlogeNumerique {
    // Je déclare une variable d'instance pour stocker le délai d'affichage en secondes
    private int delais;

    // Je crée un constructeur qui prend un délai en paramètre
    public HorlogeNumerique(int _delais) {
        this.delais = _delais;
    }

    // Je crée un constructeur par défaut qui appelle l'autre constructeur avec une valeur par défaut
    public HorlogeNumerique() {
        this(10);  // Par défaut, le délai est de 10 secondes
    }

    // Je crée ma méthode principale pour exécuter l'horloge numérique
    public void run() {
        System.out.println("Lancement de l'horloge numérique ...");
        // Je crée un formateur pour afficher l'heure au format HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Je lance une boucle qui s'exécute pendant le nombre de secondes spécifié par delais
        for (int i = 0; i < this.delais; i++) {
            // J'essaie d'effacer la console (peut ne pas fonctionner dans tous les environnements)
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // J'obtiens l'heure actuelle
            LocalTime now = LocalTime.now();
            // J'affiche l'heure actuelle formatée
            System.out.println(now.format(formatter));

            try {
                // Je mets le thread en pause pendant 1 seconde
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Si le thread est interrompu, j'affiche un message et je quitte la méthode
                System.out.println("L'horloge a été interrompue.");
                return;
            }
        }
        // J'affiche un message quand l'horloge a fini de s'exécuter
        System.out.println("Fin de l'affichage de l'horloge.");
    }
}


