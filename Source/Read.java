import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Read implements Readable{
    private List<String> allCards = new ArrayList<>();


    Read(String filePath){
        loadCards(filePath);
    }

    private void loadCards(String filePath){
        BufferedReader objReader = null;
        StringBuilder tempString = new StringBuilder();
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(filePath));
            while ((strCurrentLine = objReader.readLine()) != null) {
                tempString.append(strCurrentLine).append(",");
                allCards = Arrays.asList(tempString.toString().split(","));
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

    @Override
    public List<String> getAllCards() {
        return this.allCards;
    }

    @Override
    public int maxCards() {
        return this.allCards.size();
    }
}
