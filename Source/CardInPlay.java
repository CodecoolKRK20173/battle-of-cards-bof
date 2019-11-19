import java.util.ArrayList;
import java.util.List;

class CardInPlay {
    private Card inPlay = null;


    CardInPlay(){

    }

    Card getInPlay(){
        return this.inPlay;
    }

    void setInPlay(Card newCard){
        this.inPlay = newCard;
    }
}
