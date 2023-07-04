package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.IChain;
import com.java.ruleengine.model.interfaces.IRule;
import com.java.ruleengine.model.interfaces.IRuleChain;

import java.util.List;

public class RuleChain implements IRuleChain {
    private IChain nextChain;
    private IRule rule;

    RuleChain(List<? extends IRule> rules){
        if(rules.isEmpty()) return;
        this.rule = rules.get(0);
        setNext(new RuleChain(rules, 1));
    }

    RuleChain(List<? extends IRule> rules, int startIdx){
        if(startIdx >= rules.size()) return;
        this.rule = rules.get(startIdx);
        setNext(new RuleChain(rules, startIdx+1));
    }

    @Override
    public void execute(Object... inputData) {
        // Execute Rule
        rule.execute(inputData);

        // Go to next Rule
        if(nextChain != null) nextChain.execute();
    }

    @Override
    public void setNext(IChain nextChain) {
        this.nextChain = nextChain;
    }

}
