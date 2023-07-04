# rule-engine


rules =
[
    {
        "conditions": [
            {
                "bean": "testService",
                "method": "divisionPossible",
                "expected": true
            }
        ],
        "actions":  [
            {
                "bean": "testService",
                "method": "testActionIfPositive",
                "params": null
            }
        ],
        "order": 1
    },
    {
        "conditions": [
            {
                "bean": "testService",
                "method": "divisionPossible",
                "expected": false
            }
        ],
        "actions":  [
            {
                "bean": "testService",
                "method": "testActionIfZero",
                "params": null
            }
        ],
        "order": 2
    },
}
