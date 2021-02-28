package functions;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class SeleniumFunctions {

    static WebDriver driver;
    public static String GetFieldBy = "";
    public static String ValueToFind = "";

    public SeleniumFunctions(){
        driver = Hooks.driver;
    }

    public static Object readJSON(String fileNamePath) throws Exception {
        FileReader reader = new FileReader(fileNamePath);
        try {

            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (NullPointerException e) {
            throw new IllegalStateException("ReadEntity: No existe el archivo " + fileNamePath, e);

        }
    }

    public static JSONObject readPageElements(String elementName) throws Exception {
        JSONObject element = null;

        JSONObject jsonObject = (JSONObject) readJSON("src/test/resources/pages/searchElements.json");
        element = (JSONObject) jsonObject.get(elementName);
        return element;

    }

    public static By getElement(String element) throws Exception {
        By result = null;
        JSONObject Entity = readPageElements(element);

        GetFieldBy = (String) Entity.get("FindBy");
        ValueToFind = (String) Entity.get("Value");

        if ("className".equalsIgnoreCase(GetFieldBy)) {
            result = By.className(ValueToFind);
        } else if ("cssSelector".equalsIgnoreCase(GetFieldBy)) {
            result = By.cssSelector(ValueToFind);
        } else if ("id".equalsIgnoreCase(GetFieldBy)) {
            result = By.id(ValueToFind);
        } else if ("linkText".equalsIgnoreCase(GetFieldBy)) {
            result = By.linkText(ValueToFind);
        } else if ("name".equalsIgnoreCase(GetFieldBy)) {
            result = By.name(ValueToFind);
        } else if ("link".equalsIgnoreCase(GetFieldBy)) {
            result = By.partialLinkText(ValueToFind);
        } else if ("tagName".equalsIgnoreCase(GetFieldBy)) {
            result = By.tagName(ValueToFind);
        } else if ("xpath".equalsIgnoreCase(GetFieldBy)) {
            result = By.xpath(ValueToFind);
        }
        return result;
    }

    public void Click(String nameElement) throws Exception {
        By element = SeleniumFunctions.getElement(nameElement);
        driver.findElement(element).click();
    }

    public void Write(String nameElement, String text) throws Exception {
        By element = SeleniumFunctions.getElement(nameElement);
        driver.findElement(element).sendKeys(text);
    }

    public Boolean CheckElementsName(String elementName, String brand) throws Exception {
        By element = SeleniumFunctions.getElement(elementName);
        List<WebElement> elementsList = driver.findElements(element);
        for (WebElement elementText :
                elementsList) {
            if(!elementText.getText().contains(brand)){
                return false;
            }
        }
        return true;
    }
}
