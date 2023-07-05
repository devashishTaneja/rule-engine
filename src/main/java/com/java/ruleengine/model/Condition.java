package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.ICondition;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Condition implements ICondition {
    String conditionStatement;

    @Override
    public Boolean evaluate(Object... inputData) {
        if((int)inputData[0] > 10) return true;
        return false;
    }
}
