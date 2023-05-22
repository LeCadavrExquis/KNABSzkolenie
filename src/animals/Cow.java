package animals;

// DZIEDZICZENIE
// W javie możemy dziedziczyć tylko po jednej klasie,
// dlatego jeżeli chcemy rozszerzyć funkcje klasy używamy interfejsów
public class Cow extends Animal implements Healable {
    public Cow(String name) {
        super(name, 2, 5);
    }

    @Override
    public void regenerate() {
        if (this.life < 5) {
            this.life = this.life + 2;
            System.out.println(this.name + " has regenerated 2 live!");
        }
    }
}
