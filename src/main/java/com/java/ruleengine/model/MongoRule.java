package com.java.ruleengine.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "rules")
public class MongoRule extends Rule {
    @Field(name = "conditions")
    private List<Condition> conditions;
    @Field(name = "actions")
    private List<Action> actions;
    @Field(name = "order")
    private Integer order;

    public MongoRule(List<Condition> conditions, List<Action> actions, Integer order) {
        super(conditions, actions, order);
    }
}
