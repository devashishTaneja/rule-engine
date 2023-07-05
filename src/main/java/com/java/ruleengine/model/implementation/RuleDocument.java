package com.java.ruleengine.model.implementation;

import com.java.ruleengine.model.Action;
import com.java.ruleengine.model.Condition;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "rules")
@Getter
public class RuleDocument {
    List<Action> actions;
    List<Condition> conditions;
    Integer order;
    String description;
}
