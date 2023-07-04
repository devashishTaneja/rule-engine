package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.IRule;
import com.java.ruleengine.model.interfaces.IRuleEngine;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@Component
public class SimpleRuleEngine implements IRuleEngine {
    private List<? extends IRule> rules;

    public void setRules(List<? extends IRule> rules){
        this.rules = rules;
    }

    public void executeRules(Object... inputData){
        if(inputData == null) inputData = new Object[]{};
        RuleChain ruleChain = new RuleChain(rules);
        ruleChain.execute(inputData);
    }

}
