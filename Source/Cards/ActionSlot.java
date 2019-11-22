import java.util.ArrayList;
import java.util.List;

class ActionSlot {
    private List<Action> actionList;


    ActionSlot(){
        actionList = new ArrayList<>();
        for(int actions = 0; actions < 5; actions++){
            actionList.add(new Action());
        }
    }

    List<Action> getActionList(){ return this.actionList; }
}
