public class Player extends Character implements TelepathicLink {
    // 1. Encapsulated Attributes (Kapselung)
    private String origin;      // 'Ex-Agent' or 'Smuggler'
    private int credits;
    private int analysisFocus;
    private int loreKnowledge;
    private int psiLevel;

    // 1.1 Story-items in the Inventory
    private boolean hasMedaillion;
    private boolean hasDataCrystal;
    private boolean hasKhariSeal;

    // 2. Overloaded Constructor
    public Player(String name, String origin) {
        super(name, 100); // Calls Character blueprint with name and 100 health [Fahrzeug]
        this.origin = origin;
        this.psiLevel = 0; // default

        // 2.1 Differentiation based on origin
        if (origin.equalsIgnoreCase("Ex-Agent")) {
            this.credits = 120000;
            this.analysisFocus = 95;    // Bonus +10
            this.loreKnowledge = 85;    // Bonus +5
        } else {
            this.credits = 145000;      // Bonus +25000
            this.analysisFocus = 85;
            this.loreKnowledge = 80;
        }
    }

    // 3. Getter
    public String getOrigin() { return origin; }
    public int getCredits() { return credits; }
    public int getAnalysisFocus() { return analysisFocus; }
    public int getLoreKnowledge() { return loreKnowledge; }
    public int getPsiLevel() { return psiLevel; }

    // 3.1 Getter for story-items
    public boolean isHasMedaillion() { return hasMedaillion; }
    public boolean isHasDataCrystal() { return hasDataCrystal; }
    public boolean isHasKhariSeal() { return hasKhariSeal; }

    // 4. Setter for getting credits
    public void modifyCredits(int change) {
        this.credits += change;
    }

    // 4.1 Payment system
    public boolean spendCredits(int amount) {
        if (this.credits >= amount) {
            this.credits -= amount;
            return true;        // successful transaction
        } else {
            System.out.println("\n[TACTICAL ERROR] Insufficient Credits!");
            return false;
        }
    }

    // 4.2 Setter for story-items
    public void setHasMedaillion(boolean hasMedaillion) { this.hasMedaillion = hasMedaillion; }
    public void setHasDataCrystal(boolean hasDataCrystal) { this.hasDataCrystal = hasDataCrystal; }
    public void setHasKhariSeal(boolean hasKhariSeal) { this.hasKhariSeal= hasKhariSeal; }

    // 4.3 Setter for psi-level
    public void setPsiLevel(int level) { this.psiLevel = level; }

    // 💡 Ein eigenes Attribut und Methoden für das Gesundheitssystem
    private int health = 100;

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // 💡 Heilt den Spieler auf das Maximum von 100 HP
    public void heal(int amount) {
        this.health = 100;
    }

    // 💡 Zieht dem Spieler flexibel Lebenspunkte ab
    public void damage(int amount) {
        this.health -= amount;
    }

    // 💡 Erlaubt die flexible Modifikation (Heilung/Schaden)
    public void modifyHealth(int amount) {
        this.health += amount;
    }


    // 4.4 Contract fulfillment (Interface & Abstract Class) [Interfaces, Tier]
    @Override
    public void initialMentalSync(String target) {
        System.out.println("\n[PSI-ACTIVATION] " + getName() + " forces a neural bond with " + target + "!");
    }

    @Override
    public void executeShowdown() {
        System.out.println("\n[SHOWDOWN] " + getName() + " enters the final tactical stand against the Corps.");
    }

    // 5. toString expanded by attributes from the parent class [Auto]
    @Override
    public String toString() {
        return "Player: " + getName() + " -> [Origin: " + origin + " | Credits: " + credits +
                " | Analysis: " + analysisFocus + " | Lore: " + loreKnowledge +
                " | Medaillion: " + hasMedaillion + " | Datacrystal: " + hasDataCrystal + " | Khari-Seal]: " + hasKhariSeal + "]";
    }


}
