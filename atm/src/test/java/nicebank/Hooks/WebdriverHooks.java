package nicebank.Hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.KnowsTheDomain;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class WebdriverHooks {

    private KnowsTheDomain helper;
    private static final String geckoProperty = "webdriver.gecko.driver";
    private static final String geckoPath = "src/test/resources/drivers/geckodriver";

    public WebdriverHooks(KnowsTheDomain helper){
        this.helper = helper;
    }

    @Before
    public void setGeckodriverPath(){
        System.setProperty(geckoProperty, geckoPath);
    }

    @After
    public void finish(Scenario scenario){
        try{
            byte[] screenshot =
                    helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDoNotSuppotScreens){
            System.err.println(somePlatformsDoNotSuppotScreens.getMessage());
        } finally {
            helper.getWebDriver().close();
        }
    }
}
