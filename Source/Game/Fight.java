import java.util.List;

class Fight {


    Fight(List<Player> playerList) {

    }

    void attack(List<Player> playerList) {
        Card tempCard;
        int i;
        int A;
        int D;
        int HP;
        int whoAttacks;
        Player player;
        System.out.println("Fight Debug");
        whoAttacks = getHighestInitiative(playerList);
        if (playerList.get(whoAttacks).getFinalStats() != null) {
            A = playerList.get(whoAttacks).getFinalStats().getAttack();
            for (i = 0; i < playerList.size(); i++) {
                player = playerList.get(i);
                if (player != null) {
                    if (player.isAlive() && player.getFinalStats() != null && !player.equals(playerList.get(whoAttacks))) {
                        if (player.getFinalStats().isAlive()) {
                            D = player.getFinalStats().getDefence();
                            HP = player.getFinalStats().getHp();
                            tempCard = player.getCardInPlay();
                            int AD = (A - D);
                            if(AD < 1){
                                AD = 1;
                            }
                            System.out.print("Player " + (whoAttacks+1) + " attacks and deals " + (AD));
                            player.getFinalStats().setHp(damageCalculation(A, D, HP));
                            player.getCardInPlay().setHp(damageCalculation(A, D, HP));

                            System.out.println(" to Player " + (i+1));
                            // czy zdechł i nulle
                            // jak nie ma już nic w ręce to final turn i gracz zdech
                            // wszystko to wyprintować
                            if (defenderDied(player)) {
                                killIt(player);
                                System.out.println("Player " + (i + 1) + " lost his card: " + tempCard.toString());
                                if (player.getCards().isEmpty()) {
                                    System.out.println("Player " + (i + 1) + " lost, his final turn was " + (player.getFinalTurn()));
                                    player.lose();
                                }
                            }
                        }
                    }
                }
            }
            playerList.get(whoAttacks).getFinalStats().didAttack();
        }
    }

    private boolean defenderDied(Player player){
        return player.getFinalStats().getHp() < 1;
    }

    private void killIt(Player player){
        player.getFinalStats().killIt();
        player.killIt();
    }

    void youLose(){

    }

    private int damageCalculation(int A, int D, int HP){
        int newHP;
        A = A - D;
        if(A < 1){
            A = 1;
        }
        newHP = (HP - A);
        return newHP;
    }

    private int getHighestInitiative(List<Player> playerList) {
        FinalStats tempStats;
        int tempIndex;
        int tempValue;
        int i;
        int winningIndex = 0;
        int highestInitiative = 0;
        for (i = 0; i < playerList.size(); i++) {
            tempStats = playerList.get(i).getFinalStats();
            if (tempStats != null && tempStats.isAlive() && tempStats.getAttacked()) {
                tempIndex = i;
                tempValue = tempStats.getInitiative();
                if (tempValue > highestInitiative) {
                    winningIndex = tempIndex;
                    highestInitiative = tempValue;
                }
            }
        }
//        System.out.println("i: " + winningIndex + " val: " + highestInitiative);
        return winningIndex;
    }
}
