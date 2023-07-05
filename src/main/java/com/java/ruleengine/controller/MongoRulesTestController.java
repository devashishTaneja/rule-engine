package com.java.ruleengine.controller;

import com.java.ruleengine.model.Action;
import com.java.ruleengine.model.Condition;
import com.java.ruleengine.model.implementation.ActionNode;
import com.java.ruleengine.model.implementation.ConditionNode;
import com.java.ruleengine.model.implementation.Rule;
import com.java.ruleengine.model.implementation.SimpleRuleEngine;
import com.java.ruleengine.repository.MongoRuleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongoRulesTestController {

    private SimpleRuleEngine simpleRuleEngine;
    private MongoRuleRepository mongoRuleRepository;

    public MongoRulesTestController(SimpleRuleEngine simpleRuleEngine, MongoRuleRepository mongoRuleRepository) {
        this.simpleRuleEngine = simpleRuleEngine;
        this.mongoRuleRepository = mongoRuleRepository;
    }

    @GetMapping("/div")
    private void test(@RequestParam Integer x1, @RequestParam Integer x2){
        Action action1 = new Action();
        action1.setActionStatement("System.out.println(\"Input greater than 10!!!\")");
        ActionNode actionNode1 = new ActionNode(List.of(action1));
        Condition condition1 = new Condition();
        condition1.setConditionStatement("(Integer) inputData[0] > 10");
        ConditionNode conditionNode1 = new ConditionNode(List.of(condition1));
        Rule rule = new Rule(conditionNode1, actionNode1, 1, "Check input greater than 0");

        Action action2 = new Action();
        action2.setActionStatement("System.out.println(\"Input less than 10!!!\")");
        ActionNode actionNode2 = new ActionNode(List.of(action2));
        Condition condition2 = new Condition();
        condition2.setConditionStatement("(Integer) inputData[0] < 10");
        ConditionNode conditionNode2 = new ConditionNode(List.of(condition2));
        Rule rule2 = new Rule(conditionNode2, actionNode2, 2, "Check input less than 0");

        Action action3 = new Action();
        action3.setActionStatement("System.out.println(\"Input equal to 10!!!\")");
        ActionNode actionNode3 = new ActionNode(List.of(action3));
        Condition condition3 = new Condition();
        condition3.setConditionStatement("(Integer) inputData[0] == 10");
        ConditionNode conditionNode3 = new ConditionNode(List.of(condition3));
        Rule rule3 = new Rule(conditionNode3, actionNode3, 3, "Check input equal to 0");

        simpleRuleEngine.setRules(List.of(rule, rule2, rule3));
        simpleRuleEngine.executeRules(new Object[]{x1, x2});
    }
}

