public abstract class Character {
    // 1. Encapsulated Attributes for all lifeforms (Kapselung)
    private String name;
    private int health;

    // 2. Super-Constructor ((Invoked by subclasses via super())
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // 3. Common Getters
    public String getName() { return name; }
    public int getHealth() { return health; }

    // 4. Abstract Method: Every concrete character MUST define their battle logic
    // (Jede konkrete Unterklasse muss selbst festlegen, wie sie diese implementiert.)
    public abstract void executeShowdown();

    @Override
    public String toString() {
        return "CharakterEntity[Name='" + name + "', Health=" + health + "]";
    }
}