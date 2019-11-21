import javax.swing.*;
import java.util.List;

abstract class Player {
    private Hand hand;
    private boolean alive;
    private int cardsOnHand;
    private Card cardInPlay;
    private int points;
    private ActionSlot actionSlot;
    private FinalStats finalStats;

    Player(int amountOfCards){
        this.hand = new Hand(amountOfCards);
        this.alive = true;
        this.cardInPlay = null;
        this.points = 0;
        this.actionSlot = new ActionSlot();
        this.finalStats = null;
    }

    List<Card> getCards(){
        return this.hand.getCards();
    }

    void loseCard(){
        this.cardsOnHand += -1;
    }

    ActionSlot getActionSlot(){
        return this.actionSlot;
    }

    void setActionSlot(ActionSlot newActionSlot){
        this.actionSlot = newActionSlot;
    }

    FinalStats getFinalStats(){
        return this.finalStats;
    }

    void setFinalStats(Card card, ActionSlot actionSlot){
        this.finalStats = new FinalStats(card, actionSlot);
    }

    private void lose(){ this.alive = false; }
    void nullifyCardInPlay() { this.cardInPlay = null; }
    boolean isAlive(){ return this.alive; }
    void addPoint(){ this.points++; }
    int getPoints(){ return this.points; }

    void setCardsOnHand(int newCardsOnHand){
        this.cardsOnHand = newCardsOnHand;
    }

    int getCardsOnHand(){
        return this.cardsOnHand;
    }

    private void playCard(){
        int i = 0;
        Card tempCard = this.hand.getCards().get(i);
        this.hand.getCards().remove(i);
        this.cardInPlay = tempCard;
        this.hand.getCards().sort(Card::compareName);
    }

    void takeAction(){

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

    void loseCheck(){
        if(this.cardsOnHand == 0 && cardInPlay == null){
            lose();
        }
    }
}