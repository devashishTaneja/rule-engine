package com.java.ruleengine.repository;

import com.java.ruleengine.model.implementation.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRuleRepository extends MongoRepository<Rule, Long> {

}
