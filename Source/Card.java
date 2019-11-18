class Card {
    private String name;
    private int attack;
    private int defence;
    private int initiative;
    private int hp;


    Card(String newName, int newAttack, int newDefence, int newInitiative, int newHp){
        this.name = newName;
        this.attack = newAttack;
        this.defence = newDefence;
        this.initiative = newInitiative;
        this.hp = newHp;
    }

    @Override
    public String toString(){
        return (this.name +
                " Att: " + this.attack +
                " Def: " + this.defence +
                " Ini: " + this.initiative +
                " HP: " + this.hp);
    }
}
