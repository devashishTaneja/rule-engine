package com.java.ruleengine.controller;

import com.java.ruleengine.model.Rule;
import com.java.ruleengine.model.TaskAction;
import com.java.ruleengine.model.TaskCondition;
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
        TaskAction action = new TaskAction();
        TaskCondition condition = new TaskCondition();
        Rule rule = new Rule(List.of(condition), List.of(action), 1);
        simpleRuleEngine.setRules(List.of(rule));
        simpleRuleEngine.executeRules(new Object[]{"as", 1, 2});
    }
}

