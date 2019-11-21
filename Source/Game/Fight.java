import java.util.List;

class Fight {


    Fight(List<Player> playerList) {

    }

    void attack(List<Player> playerList) {
        int i;
        int A;
        int D;
        int HP;
        int whoAttacks;
        Player player = null;
        System.out.println("Fight");
        whoAttacks = getHighestInitiative(playerList);
        if (playerList.get(whoAttacks).getFinalStats() != null) {
            playerList.get(whoAttacks).getFinalStats().resetAttack();
            A = playerList.get(whoAttacks).getFinalStats().getAttack();
            for (i = 0; i < playerList.size(); i++) {
                player = playerList.get(i);
                if (player.isAlive() && player.getFinalStats() != null && !player.equals(playerList.get(whoAttacks))) {
                    if (player.getFinalStats().isAlive()) {
                        D = player.getFinalStats().getDefence();
                        HP = player.getFinalStats().getHp();
                        player.getFinalStats().setHp(damageCalculation(A, D, HP));
                    }
                }
            }
            assert player != null;
            assert player.getFinalStats() != null;
            player.getFinalStats().didAttack();
        }
    }

    private int damageCalculation(int A, int D, int HP){
        int newHP;
        A = A - D;
        if(A < 1){
            A = 1;
        }
        newHP = HP - (A - D);
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
