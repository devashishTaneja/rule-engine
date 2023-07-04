package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.IAction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@AllArgsConstructor
public class Action implements IAction {
    Object[] params;

    @Override
    public void execute(Object... params) {
        // do something
    }
}
