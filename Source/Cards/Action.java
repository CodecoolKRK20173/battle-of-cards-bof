class Action {
    private String name;


    Action(){
        this.name = "Potion";
    }

    static int compareName(Action action1,Action action2){
        return action1.getName().compareToIgnoreCase(action2.getName());
    }

    private String getName(){ return this.name; }

    @Override
    public String toString(){
        return this.name;
    }

    void heal(FinalStats theseStats){
        theseStats.setHp(theseStats.getHp()+10);
    }
}