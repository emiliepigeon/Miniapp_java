package minijeux;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DecodeurCesar {
    // Je déclare mes variables d'instance
    private List<String> alphabet = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
    private String operation;
    private String message;
    private int cleDeChiffrement;
    private StringBuilder resultatMessage;

    // Constructeur
    public DecodeurCesar() {
        this.resultatMessage = new StringBuilder();
    }

    // Méthode pour définir l'opération (chiffrer ou déchiffrer)
    private String setOperation() {
        Scanner scanner = new Scanner(System.in);
        String operation;
        do {
            System.out.print("1 : pour chiffrer | 2 : pour dechiffrer : ");
            operation = scanner.nextLine();
            if (!operation.equals("1") && !operation.equals("2")) {
                System.out.println("Saisir 1 ou 2");
            }
        } while (!operation.equals("1") && !operation.equals("2"));
        return operation;
    }

    // Méthode pour saisir le message
    private String setMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisir le msg : ");
        return scanner.nextLine().toUpperCase(); // Je convertis en majuscules pour correspondre à l'alphabet
    }

    // Méthode pour définir la clé de chiffrement
    private int setCleChiffrement() {
        Scanner scanner = new Scanner(System.in);
        int cle;
        do {
            System.out.print("Indiquer la clé de chiffrement (entre 0 et 25) : ");
            cle = Integer.parseInt(scanner.nextLine());
            if (cle < 0 || cle > 25) {
                System.out.println("La clé de chiffrement doit être comprise entre 0 et 25");
            }
        } while (cle < 0 || cle > 25);
        return cle;
    }

    // Méthode principale pour exécuter le décodeur César
    public void run() {
        this.operation = setOperation();
        this.message = setMessage();
        this.cleDeChiffrement = setCleChiffrement();

        for (char lettre : this.message.toCharArray()) {
            if (alphabet.contains(String.valueOf(lettre))) {
                int index = alphabet.indexOf(String.valueOf(lettre));
                int newIndex;
                if (this.operation.equals("2")) {
                    // Déchiffrement
                    newIndex = (index - this.cleDeChiffrement + 26) % 26; // +26 pour éviter les indices négatifs
                } else {
                    // Chiffrement
                    newIndex = (index + this.cleDeChiffrement) % 26;
                }
                this.resultatMessage.append(alphabet.get(newIndex));
            } else {
                // Si ce n'est pas une lettre, je la garde telle quelle
                this.resultatMessage.append(lettre);
            }
        }

        if (this.operation.equals("2")) {
            System.out.println("Message déchiffré : " + this.resultatMessage);
        } else {
            System.out.println("Message chiffré : " + this.resultatMessage);
        }

        // Je réinitialise les variables pour une prochaine utilisation
        this.message = "";
        this.resultatMessage.setLength(0);
    }
}
