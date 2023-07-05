package com.java.ruleengine.model.interfaces;

public interface ICondition {
    Boolean evaluate(Object... inputData);
}
