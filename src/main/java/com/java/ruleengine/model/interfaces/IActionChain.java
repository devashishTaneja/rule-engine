package com.java.ruleengine.model.interfaces;

public interface IActionChain {
    void execute(Object... params);
    void setNext(IActionChain chain);
}
