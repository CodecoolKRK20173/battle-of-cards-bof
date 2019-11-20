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
        fight();
        showScore();
    }

    boolean isGameOver() {
        int i;
        int numOfPlayers = playerList.size();
        int deadPlayers = 0;
        for (i = 0; i < playerList.size(); i++) {
            if (!playerList.get(i).isAlive()) {
                System.out.println("Player " + (i+1) + " is dead.");
                deadPlayers++;
                if(deadPlayers == numOfPlayers) {
                    System.out.println("Everyone is dead.");
                    return true;
                }
            }
        }
        return false;
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

    private void showScore(){
        int points;
        int i;
        System.out.println("Score so far:");
       for (i = 0; i < playerList.size(); i++){
           points = playerList.get(i).getPoints();
           System.out.println("Player " +(i+1)+ " score: " + points);
        }
    }

    private void fight() {
        Card tempCard;
        int tempIndex;
        int tempValue;
        int i;
        int winningIndex = 0;
        int winningValue = 0;
        for (i = 0; i < playerList.size(); i++) {
            tempCard = playerList.get(i).getCardInPlay();
            if(tempCard != null) {
                tempIndex = i;
                tempValue = tempCard.getAttack();
                if(tempValue > winningValue){
                    winningIndex = tempIndex;
                    winningValue = tempValue;
                }
            }
        }
        playerList.get(winningIndex).addPoint();
        System.out.println("\n" + "Player: " + (winningIndex+1) + " scores." + "\n");
        for (i = 0; i < playerList.size(); i++){
            playerList.get(i).nullifyCardInPlay();
            playerList.get(i).loseCheck();
        }
    }

    void finalScore(){
        int points;
        int tempIndex;
        int tempValue;
        int i;
        int winningIndex = 0;
        int winningValue = 0;
        int j;
        for (i = 0; i < playerList.size(); i++) {
                tempIndex = i;
                tempValue = playerList.get(i).getPoints();
                if(tempValue > winningValue){
                    winningIndex = tempIndex;
                    winningValue = tempValue;
            }
        }
        System.out.println("\n" + "Player: " + (winningIndex+1) + " wins." + "\n");
        System.out.println("Final Score:");
        for (j = 0; j < playerList.size(); j++){
            points = playerList.get(j).getPoints();
            System.out.println("Player " +(j+1)+ " score: " + points);
        }
    }
}
