package animals;

// ABSTRAKCJA
// wyodrębione zostały pola i metody wspólne dla różnych zwierząt
public abstract class Animal {
    // pola klasy oznaczone są jako protected, wiaże się to z:
    // HERMETYZACJA
    // -> tak żeby manipulacja obiektem odbywała się za pomocą metod 'takeDamage' i 'attack'
    // POLIMORFIZM
    // -> klasy pochodne (np. Cow, Bird, Fly) mogą zmieniać te pola
    protected String name;
    protected int attack;
    protected int life;

    public Animal(String name, int attack, int life) {
        this.name = name;
        this.attack = attack;
        this.life = life;
    }

    public void takeDamage(int damage) {
        System.out.println(this.name + " has taken " + damage + " damage");
        this.life = this.life - damage;
    }

    public int attack() {
        return this.attack;
    }

    public boolean isDead() {
        return this.life <= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
