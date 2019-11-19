import java.util.ArrayList;
import java.util.List;

class Turn {
    private static int count;
    private boolean playing = true;
    private List<Card> cardsInPlay = new ArrayList<>();


    Turn(){
        count++;


        // display arena 1st
        // display deck 2nd
        // players choose action 3rd
        // compare all cards in the arena with comparator
        // display combat log at the end
    }

    public List<Card> getArena(){
        return this.cardsInPlay;
    }
}