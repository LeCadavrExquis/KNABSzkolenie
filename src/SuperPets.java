import animals.*;

import java.util.ArrayList;

public class SuperPets {
    public static void main(String[] args) {
        // Programowanie obiektowe
        // Paradygmaty:
        //  -> Abstrakcja
        //  -> Hermetyzacja
        //  -> Polimorfizm
        //  -> Dziedziczenie

        // do tworzenia używamy konstruktora poprzedzonym słowem kluczowym 'new'
        Fly mucha = new Fly();
        Cow krowa = new Cow("Paula");
        Bird pingwin = new Bird("Pingwin", 3, 2, false);
        Bird kruk = new Bird("Kruk", 4, 3, true);

        // zamiast z surowych tablic możemy używać obiektów typu ArrayList<[tutaj typ jaki chcemy przechowywać]>
        ArrayList<Animal> team1 = new ArrayList<Animal>();
        team1.add(krowa);
        team1.add(mucha);
        team1.add(new Fly());
        team1.add(kruk);

        ArrayList<Animal> team2 = new ArrayList<Animal>();
        team2.add(new Fly());
        team1.add(pingwin);
        team2.add(new Cow("Milka"));
        team2.add(new Bird("Orzeł", 6, 4, true));

        while (!team1.isEmpty() && !team2.isEmpty()) {
            // get first animal from list
            Animal candidate1 = team1.get(0);
            Animal candidate2 = team2.get(0);

            System.out.println(candidate1.getName() + " vs " + candidate2.getName());
            while (!candidate1.isDead() && !candidate2.isDead()) {
                candidate2.takeDamage(candidate1.attack());
                candidate1.takeDamage(candidate2.attack());

                if (candidate1.isDead()) {
                    team1.remove(candidate1);
                    System.out.println("Animal " + candidate1.getName() + " died");
                } else if (candidate1 instanceof Healable) {
                    // if animal implements Healable interface it knows how to regenerate
                    ((Healable) candidate1).regenerate();
                }
                if (candidate2.isDead()) {
                    team2.remove(candidate2);
                    System.out.println("Animal " + candidate2.getName() + " died");
                } else if (candidate2 instanceof Healable) {
                    ((Healable) candidate2).regenerate();
                }
            }
        }

        if (team1.isEmpty()) {
            System.out.println("\nTeam 1 won!");
        }
        if (team2.isEmpty()) {
            System.out.println("\nTeam 2 won!");
        }
    }
}
