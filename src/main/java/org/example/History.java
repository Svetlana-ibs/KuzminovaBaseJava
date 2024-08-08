package org.example;

import java.util.ArrayList;
import java.util.List;

public class History {

    private final List<String> actions;

    public History() {
        this.actions = new ArrayList<>();
    }

    public void addAction(String action) {
        actions.add(action);
    }

    public void showHistory() {
        if (actions.isEmpty()){
            System.out.println("История пуста");
        }else {
            System.out.println("История действий: ");
            for (String actions : actions){
                System.out.println(actions);
            }
        }
    }
}
