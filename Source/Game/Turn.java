class Turn {
    private static int count = 0;

    Turn(){
        count++;
        System.out.println("-------------------------------");
        System.out.println("Round: " + count + " ended.");
        System.out.println("-------------------------------");
    }

    static int getCount(){
        return count;
    }
}
