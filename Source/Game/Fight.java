import java.util.List;

class Fight {
private List<Player> playerList;


    Fight(List<Player> playerList) {
        this.playerList = playerList;
    }

    void attack() {
        int attackerIndex = getHighestInitiative(playerList);

        if (attackerHasFinalStats(attackerIndex)) {
            Player attacker = playerList.get(attackerIndex);
            int attackValue = setAttack(attacker);
            for (int i = 0; i < playerList.size(); i++) {
                Player player = playerList.get(i);
                if (confirmTarget(player, attackerIndex)) {

                    String tempCard = player.getCardInPlay().toString();
                    int defenceValue = setDefence(player);
                    int hitPoints = setHp(player);
                    int hpLossValue = setLossValue(attackValue, defenceValue);

                    CombatLog.damageLog(attackerIndex, hpLossValue, i);

                    updateHealth(player, attackValue, defenceValue, hitPoints);

                    if (defenderDied(player)) {
                        killIt(player);
                        CombatLog.cardLost(i, tempCard);
                        if (player.getCards().isEmpty()) {
                            CombatLog.defeat(i, player);
                            player.lose();
                        }
                    }
                }
            }
            setPlayerAttacked(attackerIndex);
        }
    }

    private int setDefence(Player player){
        return player.getFinalStats().getDefence();
    }

    private int setHp(Player player){
        return player.getFinalStats().getHp();
    }

    private int setAttack(Player attacker){
        return attacker.getFinalStats().getAttack();
    }

    private void setPlayerAttacked(int attackerIndex){
        playerList.get(attackerIndex).getFinalStats().didAttack();
    }

    private boolean attackerHasFinalStats(int attackerIndex){
        return playerList.get(attackerIndex).getFinalStats() != null;
    }

    private boolean defenderDied(Player player){
        return player.getFinalStats().getHp() < 1;
    }

    private void killIt(Player player){
        player.getFinalStats().killIt();
        player.killIt();
    }

    private int setLossValue(int attackValue, int defenceValue){
        int hpLossValue = (attackValue - defenceValue);
        if (hpLossValue < 1) {
            return 1;
        }
        return hpLossValue;
    }

    private void updateHealth(Player player, int attackValue, int defenceValue, int hitPoints){
        player.getFinalStats().setHp(damageCalculation(attackValue, defenceValue, hitPoints));
        player.getCardInPlay().setHp(damageCalculation(attackValue, defenceValue, hitPoints));
    }

    void youLose(){

    }

    private boolean confirmTarget(Player player, int attackerIndex){
        if(player.isAlive() && player.getFinalStats() != null && !player.equals(playerList.get(attackerIndex))){
            return (player.getFinalStats().isAlive());
        }
        return false;
    }

    private int damageCalculation(int attackValue, int defenceValue, int hitPoints){
        return hitPoints - setLossValue(attackValue, defenceValue);
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
            if (tempStats != null && tempStats.isAlive() && !tempStats.getAttacked()) {
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