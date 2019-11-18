import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {
    private List<Turn> turnList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int myInt;
    private boolean menuChosen = false;
    private Players players;


    Game() {

    }

    void Menu() {
        try {
            while (!menuChosen) {
                myInt = scanner.nextInt();
                if(myInt == 0) {
                    System.out.println("Bye");
                    menuChosen = true;
                } else if (myInt == 1) {
                    System.out.println("Hotseat");
                    this.players = Players.MULTIPLAYER;
                    menuChosen = true;
                } else if (myInt == 2) {
                        System.out.println("Solo");
                        this.players = Players.SINGLEPLAYER;
                        menuChosen = true;
                } else {
                    System.out.println("Try again");
                }
            }
        } catch (Exception e) {
            System.out.println("Try again");
        }
    }

    void Start(){
        if(this.players == Players.SINGLEPLAYER){
            System.out.println("Single");
        } else {
            System.out.println("Multi");
        }
    }
}


// display - hand, table, choose cards
// menu