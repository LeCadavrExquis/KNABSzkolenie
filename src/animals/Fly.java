package animals;

// DZIEDZICZENIE
// Klasa Fly dziedziczy pola attack i life po klasie Animal
// za pomocą super() używamy konstruktora zawartego w klasie Animal
public class Fly extends Animal {
    public Fly() {
        super("Fly", 5, 2);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }
}
