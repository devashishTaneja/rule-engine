package com.java.ruleengine.model.implementation;

import com.java.ruleengine.model.interfaces.IAction;
import com.java.ruleengine.model.interfaces.ICondition;
import com.java.ruleengine.model.interfaces.IConditionNode;
import com.java.ruleengine.model.interfaces.INode;
import lombok.Getter;

import java.util.List;

@Getter
public class ConditionNode implements IConditionNode {
    INode next;
    ICondition condition;

    public ConditionNode(ICondition condition) {
        this.condition = condition;
    }

    public ConditionNode(List<? extends ICondition> conditions) {
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
    public Boolean evaluate(Object... inputData) {
        Boolean passed = true;
        ConditionNode curConditionNode = this;
        while (curConditionNode != null) {
            passed = passed && curConditionNode.getCondition().evaluate(inputData);
            curConditionNode = (ConditionNode) curConditionNode.getNext();
        }
        return passed;
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
