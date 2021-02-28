package stepsDefinitions;

import functions.Hooks;
import functions.SeleniumFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class searchSteps {
    static WebDriver driver;
    SeleniumFunctions functions = new SeleniumFunctions();

    public searchSteps(){
        driver = Hooks.driver;
    }

    @When("^The user perform a search (.*)")
    public void performSearch(String text) throws Exception {
        functions.Write("searchBox", text);
        functions.Click("searchButton");
    }

    @Then("^All product contains the (.*) name")
    public void checkProductNames(String productBrand) throws Exception {
        Assert.assertTrue("There are wrong product names", functions.CheckElementsName("productNames", productBrand));
    }
}
