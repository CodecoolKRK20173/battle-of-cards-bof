import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Game {
    private List<Turn> turnList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int menuChoice;
    private boolean menuChosen = false;
    private Players players;
    private String Welcome = String.format("    %s %s", "Welcome to BOF, choose an option.", "\n") +
            String.format(" %s %s", "1 to play with friends.", "\n") +
            String.format(" %s %s", "2 if you don't have friends.", "\n") +
            String.format(" %s", "0 and to do something else with your time.");
    private boolean numsChosen = false;


    Game() {

    }

    boolean getMenuChosen(){
        return this.menuChosen;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void Menu() {
        menuChosen = false;
        clearScreen();
        System.out.println("Of all things in the world you chose to play this game.");
            while (!menuChosen) {
                System.out.println(Welcome);
                menuChoices();
        }
    }

    private void menuChoices(){
        menuChosen = false;
        try {
            menuChoice = scanner.nextInt();
            if (menuChoice == 0) {
                System.out.println("Bye");
                menuChosen = true;
            } else if (menuChoice == 1) {
                System.out.println("Hotseat");
                this.players = Players.MULTIPLAYER;
                menuChosen = true;
                Settings();
            } else if (menuChoice == 2) {
                System.out.println("I'm sorry to hear, see you around");
                this.players = Players.SINGLEPLAYER;
                menuChosen = true;
            } else {
                System.out.println("Try again");
            }
        } catch (InputMismatchException inE) {
            System.out.println("Try again");
            scanner.next();
        }
    }

    private void settingsChoices(){
        try {
            System.out.println("How many players?");
            menuChoice = scanner.nextInt();
            System.out.println(menuChoice + " players will play.");
            System.out.println("How many cards per player?");
            int menuChoice2 = scanner.nextInt();
            System.out.println(menuChoice2 + " cards per player.");
            Table table = new Table(menuChoice, menuChoice2);
            numsChosen = true;
            Start(table);
        } catch (InputMismatchException e) {
            System.out.println("Try again");
            scanner.next();
        }
    }

    private void Settings() {
        numsChosen = false;
        if (this.players == Players.SINGLEPLAYER) {
            System.out.println("Single");
        } else {
            while (!numsChosen) {
                settingsChoices();
            }
        }
    }

    private void Start(Table table) {
        System.out.println("Game started.");
        while(!table.isGameOver()){
            table.turn();
            new Turn();
        }
        menuChosen = false;
    }
}
