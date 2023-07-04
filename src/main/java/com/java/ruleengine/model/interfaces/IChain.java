package com.java.ruleengine.model.interfaces;

public interface IChain {

    void execute(Object... args);
    void setNext(IChain chain);
}
