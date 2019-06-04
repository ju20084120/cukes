package nicebank.Hooks;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SomeTestHooks {

    @Before
    public void beforeCallingScenario(){
        System.out.println("********** About to start the scenario **********");
    }

    @After
    public void afterRunningScenario(Scenario scenario){
        System.out.println("********** Finished running the scenario **********" +
                scenario.getStatus());
    }

}
