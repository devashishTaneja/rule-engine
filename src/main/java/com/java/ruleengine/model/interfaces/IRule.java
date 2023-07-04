package com.java.ruleengine.model.interfaces;

import com.java.ruleengine.model.Action;
import com.java.ruleengine.model.Condition;


import java.util.List;

public interface IRule {
    List<Condition> getConditions();
    List<Action> getActions();
    void execute(Object... inputData);
}
