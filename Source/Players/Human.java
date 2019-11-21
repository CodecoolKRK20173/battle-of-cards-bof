import java.util.InputMismatchException;
import java.util.Scanner;

class Human extends Player {
    private Scanner scanner = new Scanner(System.in);
    private boolean cardChosen = false;
    private boolean actionTaken;

    Human(int amountOfCards) {
        super(amountOfCards);
        getHand().getCards().sort(Card::compareName);
    }

    private void skip(){

    }

    @Override
    void takeAction(){
        actionTaken = false;
        String action = String.format("%s\n", "Press 1 to play a turn") +
                String.format("%s\n", "Press 2 to skip a card") +
                String.format("%s\n", "Press 3 to take special action");
        while(!actionTaken){
            System.out.println(action);
            actionChoices();
        }
    }

    private void actionChoices(){
        int actionChoice;
        try{
            actionChoice = scanner.nextInt();
            if(actionChoice == 2 && this.getCardInPlay() != null){
                System.out.println("Play nothing");
                actionTaken = true;
                this.skip();
            } else if(actionChoice == 1){
                System.out.println("Choose a card");
                actionTaken = true;
                this.playCard();
            } else if(actionChoice == 3){
                System.out.println("Choose a special action");
                actionTaken = true;
            } else {
                System.out.println("Try again");
                scanner.next();
            }
        }catch (Exception e){
            System.out.println("Try again");
            scanner.next();
        }
    }

    private void playCard(){
        cardChosen = false;
        int cardIndex = 1;
        System.out.println("\n" + "Choose which card to play.");
        for (Card card : getCards()){
            System.out.println(cardIndex + " " + card.toString());
            cardIndex++;
        }
        while(!cardChosen) {
            chooseWhichCard();
        }
    }

    private void chooseWhichCard() {
        try {
            int cardIndexChoice = (scanner.nextInt() - 1);
            Card tempCard = getHand().getCards().get(cardIndexChoice);
            getHand().getCards().remove(cardIndexChoice);
            setCardInPlay(tempCard);
            getHand().getCards().sort(Card::compareName);
            setCardsOnHand(getHand().getCards().size());
            setFinalStats(getCardInPlay(), null);
            cardChosen = true;
        } catch (InputMismatchException e){
            System.out.println("Try again");
            scanner.next();
        } catch (IndexOutOfBoundsException f){
            System.out.println("You don't have that many cards");
            scanner.next();
        }
    }
}
