package com.java.ruleengine.controller;

import com.java.ruleengine.model.MongoRule;
import com.java.ruleengine.model.SimpleRuleEngine;
import com.java.ruleengine.repository.MongoRuleRepository;
import org.springframework.data.domain.Sort;
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
        List<MongoRule> rules = mongoRuleRepository.findAll(Sort.by(Sort.Direction.DESC, "order"));
        simpleRuleEngine.setRules(rules);
        simpleRuleEngine.executeRules(new Object[]{x1, x2});
    }
}

