package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.ICondition;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Condition implements ICondition {
    @Override
    public Boolean evaluateCondition() {
        return true;
    }
}
