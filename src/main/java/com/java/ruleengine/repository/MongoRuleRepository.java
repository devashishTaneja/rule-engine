package com.java.ruleengine.repository;

import com.java.ruleengine.model.implementation.Rule;
import com.java.ruleengine.model.implementation.RuleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRuleRepository extends MongoRepository<RuleDocument, Long> {

}
