package minijeux;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HorlogeNumerique {
    private int delais;

    public HorlogeNumerique(int _delais) {
        this.delais = _delais;
    }

    public HorlogeNumerique() {
        this(10);  // Par défaut, le délai est de 10 secondes
    }

    public void run() {
        System.out.println("Lancement de l'horloge numérique ...");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (int i = 0; i < this.delais; i++) {
            // Effacement de la console (peut ne pas fonctionner dans tous les environnements)
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Affichage de l'heure actuelle
            LocalTime now = LocalTime.now();
            System.out.println(now.format(formatter));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("L'horloge a été interrompue.");
                return;
            }
        }
        System.out.println("Fin de l'affichage de l'horloge.");
    }
}
