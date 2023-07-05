package com.java.ruleengine.model.implementation;

import com.java.ruleengine.model.interfaces.IAction;
import com.java.ruleengine.model.interfaces.ICondition;
import com.java.ruleengine.model.interfaces.IConditionNode;
import com.java.ruleengine.model.interfaces.INode;

import java.util.List;

public class ConditionNode implements IConditionNode {
    INode next;
    ICondition condition;

    ConditionNode(ICondition condition) {
        this.condition = condition;
    }

    ConditionNode(List<ICondition> conditions) {
        ICondition curCondition;
        ConditionNode cur = this;

        curCondition = conditions.get(0);
        cur.condition = curCondition;

        for (int i = 1; i < conditions.size(); i++) {
            curCondition = conditions.get(i);
            cur.next = new ConditionNode(curCondition);
            cur = (ConditionNode) cur.next;
        }
    }

    @Override
    public Boolean evaluateCondition(Object... inputData) {
        return true;
    }

    @Override
    public void setNext(INode next) {
        this.next = next;
    }

    @Override
    public INode getNext() {
        return next;
    }
}
