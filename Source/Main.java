import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        while(!game.getMenuChosen()) {
            game.Menu();
        }
    }
}
