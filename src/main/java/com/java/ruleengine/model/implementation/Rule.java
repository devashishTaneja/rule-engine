package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@AllArgsConstructor
public class Rule implements IRule{
    private IConditionNode conditionNode;
    private IActionNode actionNode;
    private Integer order;

    @Override
    public void execute(Object... inputData) {
        if(conditionNode.evaluateCondition(inputData)) actionNode.execute(inputData);
    }

    @Override
    public Boolean conditionSatisfied(Object... inputData) {
        return conditionNode.evaluateCondition(inputData);
    }
}
