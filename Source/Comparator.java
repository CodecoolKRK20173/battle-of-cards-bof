import java.util.List;

class Comparator implements Comparable{


    public int compareTo(Player otherPlayer) {
        return (this.getRanking() - otherPlayer.getRanking());
    }
    // compare all the arena cards by any stat
    // remember not to attack itself
}
