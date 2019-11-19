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
        for (int i = 0; i < playerList.size(); i++){
            System.out.println("The arena is: ");
            System.out.println("Your deck is: ");
            System.out.println("Provide input.");
                int myInt = scanner.nextInt();
                System.out.println("Player " + (i+1) + " input: " + myInt);
        }
    }



    // list of players who're still playing if > !1 playing = false
    // last player is victorious
    // else it's a tie
}
