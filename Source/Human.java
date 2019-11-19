import java.util.Scanner;

class Human extends Player {
    private Scanner scanner = new Scanner(System.in);
    private String myString;
    private boolean passed;
    private boolean cardChosen = false;

    Human(int amountOfCards) {
        super(amountOfCards);
    }

    void passTurn() {
        myString = scanner.next();
        if (myString == null) {
            this.passed = true;
        }
    }

    public boolean isPassed() {
        return this.passed;
    }

    int chooseWhichCard() {
        cardChosen = false;
        try {
            while (!cardChosen) {
                int myInt = scanner.nextInt();
                if(myInt <= (this.getCards().size() -1)) {
                    cardChosen = true;
                    return myInt;
                }
            }
        } catch (Exception e) {
            // TODO
        }
        return 0;
    }
}