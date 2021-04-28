$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Sorting.feature");
formatter.feature({
  "line": 3,
  "name": "Sort Items",
  "description": "",
  "id": "sort-items",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Sort"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Sort scenarios",
  "description": "",
  "id": "sort-items;sort-scenarios",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "user logs in to application with user \"\u003cUserName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user sort items in \"\u003cOrder\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user verifies items sorted in \"\u003cOrder\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "sort-items;sort-scenarios;",
  "rows": [
    {
      "cells": [
        "UserName",
        "Order"
      ],
      "line": 12,
      "id": "sort-items;sort-scenarios;;1"
    },
    {
      "cells": [
        "standard_user",
        "az"
      ],
      "line": 13,
      "id": "sort-items;sort-scenarios;;2"
    },
    {
      "cells": [
        "standard_user",
        "za"
      ],
      "line": 14,
      "id": "sort-items;sort-scenarios;;3"
    },
    {
      "cells": [
        "standard_user",
        "hilo"
      ],
      "line": 15,
      "id": "sort-items;sort-scenarios;;4"
    },
    {
      "cells": [
        "standard_user",
        "lohi"
      ],
      "line": 16,
      "id": "sort-items;sort-scenarios;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6308046,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Sort scenarios",
  "description": "",
  "id": "sort-items;sort-scenarios;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Sort"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user logs in to application with user \"standard_user\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user sort items in \"az\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user verifies items sorted in \"az\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 39
    }
  ],
  "location": "steps.userLogsIn(String)"
});
formatter.write("Logged in as user: standard_user");
formatter.result({
  "duration": 3168324290,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "az",
      "offset": 20
    }
  ],
  "location": "steps.userSortItems(String)"
});
formatter.write("Order selected: az");
formatter.result({
  "duration": 10078765154,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "az",
      "offset": 31
    }
  ],
  "location": "steps.userVerifiesSort(String)"
});
formatter.write("Expected order: Name (A to Z) -- Actual order: NAME (Z TO A)");
formatter.result({
  "duration": 28782407,
  "error_message": "java.lang.AssertionError: Failed in sorting products\n\tat org.junit.Assert.fail(Assert.java:89)\n\tat stepDefs.steps.userVerifiesSort(steps.java:282)\n\tat ✽.Then user verifies items sorted in \"az\"(Sorting.feature:9)\n",
  "status": "failed"
});
formatter.before({
  "duration": 37998,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Sort scenarios",
  "description": "",
  "id": "sort-items;sort-scenarios;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Sort"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user logs in to application with user \"standard_user\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user sort items in \"za\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user verifies items sorted in \"za\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 39
    }
  ],
  "location": "steps.userLogsIn(String)"
});
formatter.write("Logged in as user: standard_user");
formatter.result({
  "duration": 1985805614,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "za",
      "offset": 20
    }
  ],
  "location": "steps.userSortItems(String)"
});
formatter.write("Order selected: za");
formatter.result({
  "duration": 5079444625,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "za",
      "offset": 31
    }
  ],
  "location": "steps.userVerifiesSort(String)"
});
formatter.write("Expected order: Name (Z to A) -- Actual order: NAME (Z TO A)");
formatter.result({
  "duration": 25019299,
  "status": "passed"
});
formatter.before({
  "duration": 76980,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Sort scenarios",
  "description": "",
  "id": "sort-items;sort-scenarios;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Sort"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user logs in to application with user \"standard_user\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user sort items in \"hilo\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user verifies items sorted in \"hilo\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 39
    }
  ],
  "location": "steps.userLogsIn(String)"
});
formatter.write("Logged in as user: standard_user");
formatter.result({
  "duration": 1924978744,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hilo",
      "offset": 20
    }
  ],
  "location": "steps.userSortItems(String)"
});
formatter.write("Order selected: hilo");
formatter.result({
  "duration": 10076382696,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hilo",
      "offset": 31
    }
  ],
  "location": "steps.userVerifiesSort(String)"
});
formatter.write("Expected order: Price (high to low) -- Actual order: PRICE (LOW TO HIGH)");
formatter.result({
  "duration": 24677200,
  "error_message": "java.lang.AssertionError: Failed in sorting products\n\tat org.junit.Assert.fail(Assert.java:89)\n\tat stepDefs.steps.userVerifiesSort(steps.java:282)\n\tat ✽.Then user verifies items sorted in \"hilo\"(Sorting.feature:9)\n",
  "status": "failed"
});
formatter.before({
  "duration": 28036,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Sort scenarios",
  "description": "",
  "id": "sort-items;sort-scenarios;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Sort"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user logs in to application with user \"standard_user\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user sort items in \"lohi\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user verifies items sorted in \"lohi\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 39
    }
  ],
  "location": "steps.userLogsIn(String)"
});
formatter.write("Logged in as user: standard_user");
formatter.result({
  "duration": 1910355127,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lohi",
      "offset": 20
    }
  ],
  "location": "steps.userSortItems(String)"
});
formatter.write("Order selected: lohi");
formatter.result({
  "duration": 5072988149,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lohi",
      "offset": 31
    }
  ],
  "location": "steps.userVerifiesSort(String)"
});
formatter.write("Expected order: Price (low to high) -- Actual order: PRICE (LOW TO HIGH)");
formatter.result({
  "duration": 24476327,
  "status": "passed"
});
});