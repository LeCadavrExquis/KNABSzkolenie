public class Basics {
    public static void main(String[] args) {
        // // Zmienne

        int liczbaCalkowita = 5;
        int innaLiczbaCałkowita = liczbaCalkowita - 2; // 3
        double liczbaZmiennoprzecinkowa = 0.2;
        double ulamek = 0.3 + liczbaZmiennoprzecinkowa; // 0.5

        char znak = 'd';
        String zbiorZnakow = "Hello worl"; // "Hello worl"
        String tekst = zbiorZnakow + znak; // "Hello world"
        //!// znak + znak != "dd" //!//

        boolean zmiennaPrawdaFalsz = true;
        boolean zaprzeczenie = !zmiennaPrawdaFalsz; // false
        boolean koniunkcja = zaprzeczenie && zmiennaPrawdaFalsz; // false && true = false
        boolean alternatywa = zaprzeczenie || zmiennaPrawdaFalsz; // false && true = true

        // Tablice
        // to zmienne, które pozwalają przechowywać zbiór zmiennych jednego typu
        int[] tablica = new int[10];
        tablica[0] = 2;
        tablica[1] = 4;
        tablica[2] = 8;
        tablica[3] = 1;
        tablica[4] = 3;
        tablica[5] = 5;
        tablica[6] = 7;
        tablica[7] = 9;
        tablica[8] = 2;
        tablica[9] = 1;
        // tablica = [2, 4, 8, 1, 3, 5, 7, 9, 2, 1];

        char[] tablicaZnakow = new char[3];
        tablicaZnakow[0] = 'k';
        tablicaZnakow[1] = 'o';
        tablicaZnakow[2] = 't';
        // tablicaZnakow = ['k', 'o', 't'] = String (typ String tak naprawdę jest tablicą zmiennych typu char)

        // // Instrukcje

        if (zmiennaPrawdaFalsz) {
            // jeżeli wartość w nawiasach jest prawdą (true), to wykonaj kod w tym bloku
        } else {
            // jeżeli nie, wykonaj kod w tym bloku
        }

        // Pętle
        int licznik = 0;
        while (licznik < 10) { // warunek przerwania pętli (licznik mniejszy od 10)
            System.out.println("licznik = " + licznik);
            licznik = licznik + 1; // co obrót zwiekszamy licznik o jeden
        }
        //        licznik = 0
        //        licznik = 1
        //        licznik = 2
        //        licznik = 3
        //        licznik = 4
        //        licznik = 5
        //        licznik = 6
        //        licznik = 7
        //        licznik = 8
        //        licznik = 9

        for (int i = 0; i < 10; i++) { // petla 'for' realizująca to samo zadanie co powyżej
            System.out.println("licznik = " + i);
        }

        for (int i = 0; i < tablica.length; i++) {
            System.out.println("licznik = " + i);
        }
        //        licznik = 2
        //        licznik = 4
        //        licznik = 8
        //        licznik = 1
        //        licznik = 3
        //        licznik = 5
        //        licznik = 7
        //        licznik = 9
        //        licznik = 2
        //        licznik = 1
    }
}