class CombatLog {


    static void damageLog(int attackerIndex, int hpLossValue, int i){
        System.out.print("Player " + (attackerIndex + 1) + " deals " + (hpLossValue));
        System.out.println(" to Player " + (i + 1) + "'s card");
    }

    static void cardLost(int i, String tempCard){
        System.out.println("Player " + (i + 1) + " lost his card: " + tempCard);
    }

    static void defeat(int i, Player player){
        System.out.println("Player " + (i + 1) + " lost, his final turn was " + (player.getFinalTurn()));
    }
}
