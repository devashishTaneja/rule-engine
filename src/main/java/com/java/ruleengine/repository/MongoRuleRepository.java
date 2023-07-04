package com.java.ruleengine.repository;

import com.java.ruleengine.model.MongoRule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRuleRepository extends MongoRepository<MongoRule, Long> {
}
