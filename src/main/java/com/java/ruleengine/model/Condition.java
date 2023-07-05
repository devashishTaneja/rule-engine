package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.ICondition;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.mvel2.MVEL;

@Getter
@Setter
@Slf4j
public class Condition implements ICondition {
    String conditionStatement;
    Object[] inputData;

    @Override
    public Boolean evaluate(Object... inputData) {
        log.info("Evaluating condition : " + conditionStatement);
        this.inputData = inputData;
        return MVEL.evalToBoolean(conditionStatement, this);
    }
}
