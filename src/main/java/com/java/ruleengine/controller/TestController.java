package com.java.ruleengine.controller;

import com.java.ruleengine.model.implementation.SimpleRuleEngine;
import com.java.ruleengine.repository.MongoRuleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private SimpleRuleEngine simpleRuleEngine;
    private MongoRuleRepository mongoRuleRepository;

    public TestController(SimpleRuleEngine simpleRuleEngine, MongoRuleRepository mongoRuleRepository) {
        this.simpleRuleEngine = simpleRuleEngine;
        this.mongoRuleRepository = mongoRuleRepository;
    }

    @GetMapping("/test")
    private void test(@RequestParam Integer x1){
        simpleRuleEngine.setRules(mongoRuleRepository.findAll());
        simpleRuleEngine.executeRules(new Object[]{x1});
    }
}

