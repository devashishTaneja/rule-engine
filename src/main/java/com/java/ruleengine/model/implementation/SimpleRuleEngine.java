package com.java.ruleengine.model.implementation;

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

    public void setRules(List<? extends RuleDocument> ruleDocuments) {
        List<? extends Rule> rules = ruleDocuments.stream().map(ruleDocument -> new Rule(ruleDocument)).toList();
        rule = new RuleNode(rules);
    }

    public void executeRules(Object... inputData){
        rule.execute(inputData);
    }

}
