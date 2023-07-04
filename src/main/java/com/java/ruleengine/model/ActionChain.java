package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.IAction;
import com.java.ruleengine.model.interfaces.IActionChain;

import java.util.List;

public class ActionChain implements IActionChain {

    private IActionChain nextChain;
    private IAction action;

    ActionChain(List<? extends IAction> actions){
        this.action = actions.get(0);
        setNext(new ActionChain(actions, 1));
    }

    ActionChain(List<? extends IAction> actions, int startIdx){
        if(startIdx >= actions.size()) return;
        this.action = actions.get(startIdx);
        setNext(new ActionChain(actions, startIdx+1));
    }

    @Override
    public void execute(Object... params) {
        // Execute Action
        action.execute();

        // Execute next action
        if(nextChain != null) nextChain.execute();
    }

    @Override
    public void setNext(IActionChain actionChain) {
        this.nextChain = nextChain;
    }
}
