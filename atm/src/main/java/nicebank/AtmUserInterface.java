package nicebank;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AtmUserInterface implements Teller {

    private EventFiringWebDriver webDriver;

    public AtmUserInterface(){
        this.webDriver = new EventFiringWebDriver(new FirefoxDriver());

    }

    public void withdrawFrom(Account account, int dollars) {

        try {
            webDriver.get("http://localhost:9988");
            webDriver.findElement(By.id("Amount"))
                    .sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("withdraw")).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            webDriver.close();
        }

    }
}
