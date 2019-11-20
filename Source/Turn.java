import java.util.ArrayList;
import java.util.List;

class Turn {
    private static int count;


    Turn(){
        count++;
        System.out.println("-------------------------------");
        System.out.println("Round: " + count + " ended.");
        System.out.println("-------------------------------");
    }
}