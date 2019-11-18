class Main {


    public static void main(String[] args) {
        Hand hand = new Hand(5);
        for(Card card : hand.getCards()){
            System.out.println(card.toString());
        }

    }
}
