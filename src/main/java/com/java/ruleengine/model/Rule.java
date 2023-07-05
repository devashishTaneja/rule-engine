package com.java.ruleengine.model;

import com.java.ruleengine.model.interfaces.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@AllArgsConstructor
@Document(collection = "rules")
public class Rule {
    @Field(name = "conditions")
    private List<ICondition> conditions;
    @Field(name = "actions")
    private List<IAction> actions;
    @Field(name = "order")
    private Integer order;

}
