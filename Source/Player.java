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

    void playCard(int cardChosen){
        this.hand.getCards().get(cardChosen);
        // remove from hand
        // put into card in play
    }

    String deckToString(){
        StringBuilder cards = new StringBuilder();
        for(Card card : this.hand.getCards()){
            cards.append(card.toString()).append("\n");
        }
        return cards.toString();
    }
}