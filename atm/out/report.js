$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("nicebank/cash_withdrawal.feature");
formatter.feature({
  "line": 1,
  "name": "Cash Withdrawal",
  "description": "",
  "id": "cash-withdrawal",
  "keyword": "Feature"
});
formatter.before({
  "duration": 653426,
  "status": "passed"
});
formatter.before({
  "duration": 664193,
  "status": "passed"
});
formatter.before({
  "duration": 5227866064,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "Successful withdrawal for an account in credit",
  "description": "",
  "id": "cash-withdrawal;successful-withdrawal-for-an-account-in-credit",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I have deposited $100.00 in my account",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I withdraw $20",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "$20 should be dispensed",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "the balance of my account should be $80.00",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "$100.00",
      "offset": 17
    }
  ],
  "location": "AccountSteps.i_have_deposited_$_in_my_account(Money)"
});
formatter.result({
  "duration": 176487251,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 12
    }
  ],
  "location": "TellerSteps.i_withdraw_$(int)"
});
formatter.result({
  "duration": 6064675819,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 1
    }
  ],
  "location": "CashSlotSteps.$_should_be_dispensed(int)"
});
formatter.result({
  "duration": 2026407,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "$80.00",
      "offset": 36
    }
  ],
  "location": "AccountSteps.the_balance_of_my_account_should_be_$(Money)"
});
formatter.result({
  "duration": 141593,
  "status": "passed"
});
formatter.after({
  "duration": 563534,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 2689336472,
  "status": "passed"
});
formatter.after({
  "duration": 13814268,
  "status": "passed"
});
});