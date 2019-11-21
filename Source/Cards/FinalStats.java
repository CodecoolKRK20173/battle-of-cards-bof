class FinalStats {
    private int attack;
    private int defence;
    private int initiative;
    private int maxHp;
    private int hp;
    private boolean alive;
    private boolean attacked;
    private String name;


    FinalStats(Card cardInHand, ActionSlot actionSlot){
        this.name = cardInHand.getName();
        this.attack = cardInHand.getAttack();
        this.defence = cardInHand.getDefence();
        this.initiative = cardInHand.getInitiative();
        this.maxHp = cardInHand.getMaxHp();
        this.hp = cardInHand.getHp();
        this.alive = true;
        this.attacked = false;
    }

    int getInitiative(){
        return this.initiative;
    }

    int getDefence(){ return this.defence; }

    int getHp(){ return this.hp; }

    void setHp(int newHp){ this.hp = newHp; }

    boolean isAlive(){
        return this.alive;
    }

    boolean getAttacked(){
        return this.attacked;
    }

    void didAttack(){
        this.attacked = true;
    }

    void resetAttack(){
        this.attacked = false;
    }

    int getAttack(){
        return this.attack;
    }

    void killIt() { this.alive = false; }

    @Override
    public String toString(){
        return (this.name +
                " Att: " + this.attack +
                " Def: " + this.defence +
                " Ini: " + this.initiative +
                " MaxHP: " + this.maxHp +
                " HP: " + this.hp);
    }

}
