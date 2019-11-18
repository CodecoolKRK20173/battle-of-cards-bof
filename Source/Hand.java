import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Hand implements Readable {
    private List<Card> cards = new ArrayList<>();
    private String[] stats = new String[5];


    Hand(int amountOfCards){
        createHand(amountOfCards);
    }

    @Override
    public void createHand(int amountOfCards) {
        for (int i = 0; i < amountOfCards; i++) {
            BufferedReader objReader = null;
            try {
                String strCurrentLine;
                objReader = new BufferedReader(new FileReader("Resources/Monster.csv"));
                while ((strCurrentLine = objReader.readLine()) != null) {
                    stats = strCurrentLine.split("-");
                    this.cards.add(new Card(stats[0],
                            Integer.parseInt(stats[1]),
                            Integer.parseInt(stats[2]),
                            Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4])));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (objReader != null)
                        objReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    List<Card> getCards(){
        return this.cards;
    }
}
