import java.util.List;

interface Readable {

    void loadCards(String filePath);
    List<String> getAllCards();
    int maxCards();
}