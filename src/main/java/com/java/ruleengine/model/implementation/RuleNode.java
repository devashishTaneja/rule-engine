package com.java.ruleengine.model.implementation;

import com.java.ruleengine.model.Rule;
import com.java.ruleengine.model.interfaces.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RuleNode implements IRuleNode {

    IConditionNode conditionNode;
    IActionNode actionNode;
    IRuleNode next;
    Object[] inputData;

    RuleNode(Rule rule) {
        actionNode = new ActionNode(rule.getActions());
        conditionNode = new ConditionNode(rule.getConditions());
    }

    RuleNode(List<? extends Rule> rules) {

        Rule rule = rules.get(0);
        RuleNode curRule = this;
        curRule.conditionNode = new ConditionNode(rule.getConditions());
        curRule.actionNode = new ActionNode(rule.getActions());

        for (int i = 1; i < rules.size(); i++) {
            rule = rules.get(i);
            curRule.next = new RuleNode(rule);
            curRule = (RuleNode) curRule.next;
        }
    }

    public void setNext(INode next) {
        this.next = (IRuleNode) next;
    }

    @Override
    public void execute(Object... inputData) {
        this.inputData = inputData;
        if(conditionSatisfied(inputData)){
            executeActions();
        }
    }

    @Override
    public Boolean conditionSatisfied(Object... inputData) {
        Boolean conditionPassed = true;
        ConditionNode curNode = (ConditionNode) conditionNode;
        while (curNode != null) {
            if(!curNode.evaluateCondition(inputData)) conditionPassed = false;
            curNode = (ConditionNode) curNode.next;
        }
        return conditionPassed;
    }

    public void executeActions() {
        ActionNode curNode = (ActionNode) actionNode;
        while (curNode != null) {
            curNode.execute(inputData);
            curNode = (ActionNode) curNode.next;
        }
    }
}
