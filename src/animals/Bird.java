package animals;

public class Bird extends Animal implements Healable {

    // HERMETYZACJA
    // nie chcemy, żeby można było modyfikować to pole z poza klasy (private)
    private final double dodgeProbability;

    public Bird(String name, int attack, int lives, boolean canFly) {
        super(name, lives, attack);

        if (canFly) {
            this.dodgeProbability = 0.4;
        } else {
            this.dodgeProbability = 0.0;
        }
    }

    @Override
    public void takeDamage(int damage) {
        double randomNumber = Math.random();
        if (randomNumber < this.dodgeProbability) {
            System.out.println(this.name + " [BIRD] has dodged an attack!");
        } else {
            super.takeDamage(damage);
        }
    }

    @Override
    public void regenerate() {
        if (this.life < 2) {
            System.out.println(this.name + " [BIRD] has regenerated 1 live!");
            this.life = this.life + 1;
        }
    }
}
