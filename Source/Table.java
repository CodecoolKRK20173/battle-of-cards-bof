import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Table {
    private List<Player> playerList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    Table(int amountOfPlayers, int amountOfCards){
        for(int i = 0; i < amountOfPlayers; i++){
            playerList.add(new Human(amountOfCards));
        }
    }

    void playerTurn(){
        int i;
        int j;
        int theNulls = 0;
        for (i = 0; i < playerList.size(); i++){
            displayArena();
            System.out.println("Player " + (i+1) + "'s turn");

            playerList.get(i).playCard();
        }
        for(j = 0; j < playerList.size(); j++){
            if(playerList.get(j).getCardInPlay() == null){
                System.out.println("Player " + (j+1) + " has an empty hand.");
                theNulls++;
            } else if(theNulls == playerList.size()){
                System.out.println("You're all dead.");
            } else {
                System.out.println("Player " + (j+1) + " plays " + playerList.get(j).getCardInPlay().toString());
            }
        }
    }

    private void displayArena(){
        int i;
        Card cardToDisplay;
        System.out.println("___________Cards in play___________________");
        for (i = 0; i < playerList.size(); i++){
            cardToDisplay  = playerList.get(i).getCardInPlay();
            if(cardToDisplay != null){
                System.out.println("Player " + (i+1) + "'s card " + cardToDisplay.toString());
            }
        }
        System.out.println("___________________________________________");
    }

    void fight() {
        Card tempCard;
        int i;
        for (i = 0; i < playerList.size(); i++) {
            tempCard = playerList.get(i).getCardInPlay();
            if(tempCard != null) {
//                Card.compareAtt(tempCard, );
            }
            playerList.get(i).getCardInPlay();
        }
    }

//    Player winningHand(){
//        Player winner;
//        (Card)playerList.sort(Card::compareAtt);
//        return playerList.get(playerList.size());
//    }
//
//    static int compareAtt(Card card1, Card card2) {
//        return Integer.compare(card1.getAttack(), card2.getAttack());

    // list of players who're still playing if > !1 playing = false
    // last player is victorious
    // else it's a tie
}
