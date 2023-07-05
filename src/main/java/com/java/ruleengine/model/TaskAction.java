package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.IAction;
import com.java.ruleengine.model.interfaces.INode;

import java.util.Arrays;

public class TaskAction implements IAction {

    @Override
    public Boolean execute(Object... args) {
        System.out.println(Arrays.toString(args));
        return true;
    }

}
