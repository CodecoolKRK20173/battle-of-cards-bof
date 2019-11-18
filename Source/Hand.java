import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Hand {
    private List<Card> cards = new ArrayList<>();

    Hand(){
        createHand();
    }

    private void createHand(){
        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("Resources/Monster.csv"));
            while ((strCurrentLine = objReader.readLine()) != null) {
                System.out.println(strCurrentLine);

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
