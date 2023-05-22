import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        char[] password = {'b', 'o', 'b'};
        char[] playerGuesses = {};
        int lives = 6;

        System.out.println("~~~~~~~~~~~~");
        System.out.println("  WISIELEC  ");
        System.out.println("~~~~~~~~~~~~");

        while (lives > 0) {
            displayBlankedPassword(password, playerGuesses);

            // użytkownik wprowadza literkę
            System.out.print("Podaj literę: ");
            Scanner scanner = new Scanner(System.in);
            char userInput = scanner.nextLine().charAt(0);

            boolean isLetterInPassword = false;
            for (int i = 0; i < password.length; i++) {
                if (userInput == password[i]) {
                    isLetterInPassword = true;
                }
            }
            if (!isLetterInPassword) {
                lives--;
            } // jeżeli litera nie jest w haśle odejmij życie

            // powiększamy tablicę przechowywującą wykorzystane litery o następną, którą wprowadził użytkownik
            char[] newPlayerGuesses = new char[playerGuesses.length + 1];
            for (int i = 0; i < newPlayerGuesses.length; i++) {
                if (i < newPlayerGuesses.length - 1) {
                    newPlayerGuesses[i] = playerGuesses[i];
                } else {
                    newPlayerGuesses[newPlayerGuesses.length - 1] = userInput;
                }
            }
            playerGuesses = newPlayerGuesses;

            displayUsedLetters(playerGuesses);

            boolean isGameEnded = isPasswordGuessed(password, playerGuesses);
            if (isGameEnded) {
                break;
            }

            drawHangman(lives);
        }

        if (lives > 0) {
            System.out.println("\nWYGRANA!\n");
        } else {
            System.out.println("\nPRZEGRANA!\n");
        }
    }

    /**
     * Funkcja rysująca wisielca
     * @param lives - ilość pozostałych żyć
     */
    public static void drawHangman(int lives) {
        char[][] emptyBoard = {
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '},
                {' ',' ',' ',' '}
        };

        if (lives < 6) {
            emptyBoard[1][0] = '|';
            emptyBoard[2][0] = '|';
            emptyBoard[3][0] = '|';
            emptyBoard[4][0] = '|';
        }
        if (lives < 5) {
            emptyBoard[0][0] = '_';
            emptyBoard[0][1] = '_';
            emptyBoard[0][2] = '_';
            emptyBoard[0][3] = '_';
        }
        if (lives < 4) {
            emptyBoard[1][3] = '|';
        }
        if (lives < 3) {
            emptyBoard[2][3] = 'O';
        }
        if (lives < 2) {
            emptyBoard[3][3] = '+';
        }
        if (lives < 1) {
            emptyBoard[4][3] = '^';
        }

        for (int i = 0; i < emptyBoard.length; i++) {
            System.out.println(emptyBoard[i]);
        }
    }

    /**
     * Funkcja wyświetlająca litery dodając przecinek między nimi
     * @param letters tablica znaków do wyświetlenia
     */
    public static void displayUsedLetters(char[] letters) {
        System.out.print("Złużyte literki: ");
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i]);
            if (i != letters.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Funkcja wyświetlająca szukane hasło zastępując nieznane litery znakiem '_'
     * @param password tablica znaków
     * @param guesses tablica znaków zawierająca użyte litery
     */
    public static void displayBlankedPassword(char[] password, char[] guesses) {
        char[] passwordBlanked = new char[2 * password.length - 1];
        for (int i = 0; i < passwordBlanked.length; i++) {
            // operator % (modulo) - zwraca resztę z dzielenia
            if (i % 2 == 0) { // jeżeli i jest parzyste
                passwordBlanked[i] = '_';
            } else {
                passwordBlanked[i] = ' ';
            }
        }
        for (int i = 0; i < password.length; i++) {

            boolean isGuessed = false;
            for (int j = 0; j < guesses.length; j++) {
                if (guesses[j] == password[i]) {
                    isGuessed = true; // if guessed letter is in password set flag to true
                }
            }
            if (isGuessed) { // if is in password show that letter
                passwordBlanked[2*i] = password[i];
            }
        }
        System.out.print("hasło: ");
        System.out.println(passwordBlanked);
    }

    /**
     * Funkcja sprawdzająca, czy wszystkie litery w haśle zostały zgadnięte
     * @param password litery hasła
     * @param usedLetters już użyte litery
     */
    public static boolean isPasswordGuessed(char[] password, char[] usedLetters) {
        for (int i = 0; i < password.length; i++) {
            boolean isLetterGuessed = false;

            for (int j = 0; j < usedLetters.length; j++) {
                if (password[i] == usedLetters[j]) {
                    isLetterGuessed = true;
                }
            }
            if (!isLetterGuessed) { // jeżeli nie ma litery hasła w użytych literkach zakończ funkcję
                // zwracając fałsz, ponieważ nie wszystkie litery zostały zgadnięte
                return false;
            }
        }
        // jeżeli dotraliśmy do tego momentu w kodzie to znaczy, że wszystkie litery hasła zostały znalezione
        return true;
    }
}