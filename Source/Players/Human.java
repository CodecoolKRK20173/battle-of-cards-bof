import java.util.InputMismatchException;
import java.util.Scanner;

class Human extends Player {
    private Scanner scanner = new Scanner(System.in);
    private boolean cardChosen = false;

    Human(int amountOfCards) {
        super(amountOfCards);
        getHand().getCards().sort(Card::compareName);
    }

    @Override
    void playCard(){
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
