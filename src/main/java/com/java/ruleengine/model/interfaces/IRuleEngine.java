package com.java.ruleengine.model.interfaces;


import com.java.ruleengine.model.implementation.RuleDocument;

import java.util.List;

/**
 *
 * Interface for RuleEngine
 * @author Devashish Taneja
 *
 */
public interface IRuleEngine {

    /**
     * <p> Set rules for Engine
     * </p>
     * @param rules Rules
     */
    void setRules(List<? extends RuleDocument> rules);

    /**
     * <p> Evaluate through the rules and execute actions
     * if condition satisifed based on inputData
     * </p>
     * @param inputData Input Data
     */
    void executeRules(Object... inputData);

}
