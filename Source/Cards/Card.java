class Card {
    private String name;
    private int attack;
    private int defence;
    private int initiative;
    private int maxHp;
    private int hp;
    private boolean alive;

    Card(String newName, int newAttack, int newDefence, int newInitiative, int newMaxHp) {
        this.name = newName;
        this.attack = newAttack;
        this.defence = newDefence;
        this.initiative = newInitiative;
        this.maxHp = newMaxHp + 10;
        this.hp = this.maxHp + 10;
        this.alive = true;
    }

     String getName() {
        return this.name;
    }
     int getAttack() { return this.attack; }
     int getDefence() { return this.defence; }
     int getInitiative() { return this.initiative; }
     int getHp() { return this.hp; }
     int getMaxHp() { return this.maxHp; }
     void setHp(int newHp) { this.hp = newHp; }

    @Override
    public String toString() {
        return (this.name +
                " Att: " + this.attack +
                " Def: " + this.defence +
                " Ini: " + this.initiative +
                " HP: " + this.hp);
    }

    static int compareAtt(Card card1, Card card2) {
        return Integer.compare(card1.getAttack(), card2.getAttack());
    }

    static int compareName(Card card1,Card card2){
        return card1.getName().compareToIgnoreCase(card2.getName());
    }

    static int compareDef(Card card1,Card card2){
        return Integer.compare(card1.getDefence(), card2.getDefence());
    }

    static int compareIni(Card card1,Card card2){
        return Integer.compare(card1.getInitiative(), card2.getInitiative());
    }

    static int compareHp(Card card1,Card card2){
        return Integer.compare(card1.getHp(), card2.getHp());
    }
}
