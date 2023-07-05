package com.java.ruleengine.model.implementation;

import com.java.ruleengine.model.Rule;
import com.java.ruleengine.model.interfaces.IRuleEngine;
import com.java.ruleengine.model.interfaces.IRuleNode;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@Component
public class SimpleRuleEngine implements IRuleEngine {
    IRuleNode rule;

    public void setRules(List<? extends Rule> rules) {
        rule = new RuleNode(rules);
    }

    public void executeRules(Object... inputData){
        IRuleNode curRule = rule;
        while (curRule != null) {
            curRule.execute(inputData);
            curRule = (IRuleNode) curRule.getNext();
        }

    }

}
