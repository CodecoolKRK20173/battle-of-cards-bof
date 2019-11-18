import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Hand {
    private List<Card> cards = new ArrayList<>();
    private String[] stats = new String[5];
    private Random random = new Random();
    private Read read = new Read("Resources/Monster.csv");


    Hand(int amountOfCards){
        createHand(amountOfCards, read.maxCards());
    }


    private void createHand(int amountOfCards, int maxCards) {
        String tempString;
        for (int i = 0; i < amountOfCards; i ++){
            tempString = read.getAllCards().get(randInt(random, 0, read.maxCards()));
            stats = tempString.split("-");
            for (String string : stats){
                System.out.println(string);
            }
        }
    }

    private static int randInt(Random random, int low, int high) {
        return random.nextInt(high) + low;
    }

    List<Card> getCards(){
        return this.cards;
    }
}

/*
stats = strCurrentLine.split("-");
                    this.cards.add(new Card(stats[0],
                            Integer.parseInt(stats[1]),
                            Integer.parseInt(stats[2]),
                            Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4])));
 */
