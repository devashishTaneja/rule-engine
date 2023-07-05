package com.java.ruleengine.model.implementation;

import com.java.ruleengine.model.interfaces.*;
import lombok.Getter;

import java.util.List;

@Getter
public class ActionNode implements IActionNode {
    INode next;
    IAction action;

    public ActionNode(IAction action) {
        this.action = action;
    }

    public ActionNode(List<IAction> actions) {
        IAction curAction;
        ActionNode cur = this;

        curAction = actions.get(0);
        cur.action = curAction;

        for (int i = 1; i < actions.size(); i++) {
            curAction = actions.get(i);
            cur.next = new ActionNode(curAction);
            cur = (ActionNode) cur.next;
        }
    }

    @Override
    public Boolean execute(Object... args) {
        return action.execute(args);
    }

    @Override
    public void setNext(INode next) {
        this.next = next;
    }
}
