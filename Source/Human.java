import java.util.Scanner;

class Human extends Player {
    private Scanner scanner;
    private String myString;
    private boolean passed;

    Human(int amountOfCards){
        super(amountOfCards);
        this.scanner = new Scanner(System.in);
    }

    void passTurn(){
        myString = scanner.next();
        if (myString == null) {
            this.passed = true;
        }
    }

    public boolean isPassed(){
        return this.passed;
    }

    void playCard(){

    }
}