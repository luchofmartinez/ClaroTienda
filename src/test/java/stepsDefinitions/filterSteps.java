package stepsDefinitions;

import functions.Hooks;
import functions.SeleniumFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class filterSteps {

    static WebDriver driver;
    SeleniumFunctions functions = new SeleniumFunctions();

    public filterSteps(){
        driver = Hooks.driver;
    }

    @When("^The user perform a filter for (.*) brand")
    public void performSearch(String brand) throws Exception {
        functions.Filter("filterBrand", brand);
        Thread.sleep(5000);
    }
}
