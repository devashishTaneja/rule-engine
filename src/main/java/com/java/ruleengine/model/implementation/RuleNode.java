package com.java.ruleengine.model.implementation;

import com.java.ruleengine.model.interfaces.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RuleNode implements IRuleNode {
    Rule rule;
    RuleNode next;
    Object[] inputData;

    RuleNode(Rule rule) {
        this.rule = rule;
    }

    RuleNode(List<? extends Rule> rules) {

        Rule rule = rules.get(0);
        RuleNode curRule = this;
        curRule.rule = rule;

        for (int i = 1; i < rules.size(); i++) {
            rule = rules.get(i);
            curRule.next = new RuleNode(rule);
            curRule = curRule.next;
        }
    }

    @Override
    public void execute(Object... inputData) {
        RuleNode curRuleNode = this;
        while (curRuleNode != null){
            curRuleNode.getRule().execute(inputData);
            curRuleNode = curRuleNode.getNext();
        }
    }

    @Override
    public void setNext(INode next) {
        this.next = (RuleNode) next;
    }
}
