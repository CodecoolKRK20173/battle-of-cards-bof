import java.util.ArrayList;
import java.util.List;

class CardInPlay {
    private List<Card> inPlay = new ArrayList<>();


    CardInPlay(){

    }

    Card getInPlay(){
        return this.inPlay.get(0);
    }

    void setInPlay(Card newCard){
        this.inPlay.set(0, newCard);
    }
}
