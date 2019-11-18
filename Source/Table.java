import java.util.ArrayList;
import java.util.List;

class Table {
    private List<Player> playerList = new ArrayList<>();


    Table(int amountOfPlayers, int amountOfCards){
        for(int i = 0; i < amountOfPlayers; i++){
            playerList.add(new Human(amountOfCards));
        }
    }



    // list of players who're still playing if > !1 playing = false
    // last player is victorious
    // else it's a tie
}
