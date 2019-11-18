import java.util.List;

abstract class Player {
    private Hand hand;
    private boolean alive;
    private int cardsOnHand;


    Player(int amountOfCards){
        this.hand = new Hand(amountOfCards);
        this.alive = true;
    }

    List<Card> getCards(){
        return this.hand.getCards();
    }

    void loseCard(){
        this.cardsOnHand += -1;
    }

    void lose(){
        this.alive = false;
    }

    Card playCard(int i){
        return this.hand.getCards().get(i);
    }

    void displayDeck(){
        for(Card card : this.hand.getCards()){
            System.out.println(card.toString());
        }
    }
}