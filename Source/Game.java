import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {
    private List<Turn> turnList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int myInt;
    private boolean menuChosen = false;
    private Players players;
    private boolean playing = false;


    Game() {

    }

    void Menu() {
        String Welcome = String.format("    %s %s", "Henlo", "\n") +
                String.format(" %s %s", "Press 1 to play with frens.", "\n") +
                String.format(" %s %s", "Press 2 if you don't have frens.", "\n") +
                String.format(" %s", "Press 0 and say byebye.");
        System.out.println(Welcome);
        try {
            while (!menuChosen) {
//                String menuChoices = String.format(" %s%d%s", "What do you say fren: ", scanner.nextInt(), " but make the right choice.");
//                System.out.print(menuChoices);
                myInt = scanner.nextInt();
                if (myInt == 0) {
                    System.out.println("Bye");
                    menuChosen = true;
                } else if (myInt == 1) {
                    System.out.println("Hotseat");
                    this.players = Players.MULTIPLAYER;
                    menuChosen = true;
                    Settings();
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

    private void Settings() {
        boolean numsChosen = false;
        if (this.players == Players.SINGLEPLAYER) {
            System.out.println("Single");
        } else {
            System.out.println("Multi");
            try {
                while (!numsChosen) {
                    System.out.println("How many players?");
                    myInt = scanner.nextInt();
                    System.out.println(myInt + " players will play.");
                    System.out.println("How many cards per player?");
                    int myInt2 = scanner.nextInt();
                    System.out.println(myInt2 + " cards per player.");
                    Table table = new Table(myInt, myInt2);
                    numsChosen = true;
                    Start(table);
                }
            } catch (Exception e){
                // TODO
            }
        }
    }

    private void Start(Table table) {
        int myChoice;
        playing = true;
        System.out.println("Game started.");
        while(playing){
            table.playerTurn();
            new Turn();
        }
    }
}


// display - hand, table, choose cards
// menu