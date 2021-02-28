package functions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void initDriver(){
        driver = CreateWebDriver.initConfig();
    }

    @Given("^The user enter the web (.*)")
    public void openUrl(String url){
        driver.get(url);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
