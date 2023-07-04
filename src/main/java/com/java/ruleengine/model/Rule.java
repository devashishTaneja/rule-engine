package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.IAction;
import com.java.ruleengine.model.interfaces.IRule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Rule implements IRule {
    private List<Condition> conditions;
    private List<Action> actions;
    private Integer order;

    @Override
    public void execute(Object... inputData) {
        ActionChain actionChain = new ActionChain(actions);
        actionChain.execute();
    }
}
