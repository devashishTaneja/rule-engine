package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.IAction;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.mvel2.MVEL;

@Setter
@Slf4j
public class Action implements IAction {
    String actionStatement;
    Object[] args;

    @Override
    public Boolean execute(Object... args) {
        log.info("Executing action : " + actionStatement);
        this.args = args;
        MVEL.eval(actionStatement, this);
        return true;
    }

}
