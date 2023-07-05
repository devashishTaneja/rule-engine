package com.java.ruleengine.model.implementation;

import com.java.ruleengine.model.interfaces.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Rule implements IRule{
    private IConditionNode conditionNode;
    private IActionNode actionNode;
    private Integer order;
    private String description;

    @Override
    public void execute(Object... inputData) {
        log.info("Executing rule : " + this.description);
        if(conditionNode.evaluate(inputData)) actionNode.execute(inputData);
    }

    public Boolean conditionSatisfied(Object... inputData) {
        return conditionNode.evaluate(inputData);
    }
}
