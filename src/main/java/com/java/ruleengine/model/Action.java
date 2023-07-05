package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.IAction;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class Action implements IAction {
    String actionStatement;

    @Override
    public Boolean execute(Object... args) {
        System.out.println(Arrays.toString(args));
        return true;
    }

}
