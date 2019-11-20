import java.util.List;

abstract class Player {
    private Hand hand;
    private boolean alive;
    private int cardsOnHand;
    private Card cardInPlay;
    private int points;


    Player(int amountOfCards){
        this.hand = new Hand(amountOfCards);
        this.alive = true;
        this.cardInPlay = null;
        this.points = 0;
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

    void addPoint(){ this.points++; }

    int getPoints(){ return this.points; }

    void playCard(){
        int i = 0;
        Card tempCard = this.hand.getCards().get(i);
        this.hand.getCards().remove(i);
        this.cardInPlay = tempCard;
        this.hand.getCards().sort(Card::compareName);
    }

    void setCardInPlay(Card newCard){
        this.cardInPlay = newCard;
    }

    String deckToString(){
        StringBuilder cards = new StringBuilder();
        for(Card card : this.hand.getCards()){
            cards.append(card.toString()).append("\n");
        }
        return cards.toString();
    }

    Hand getHand(){
        return this.hand;
    }

    Card getCardInPlay(){
        return this.cardInPlay;
    }
}