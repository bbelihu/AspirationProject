package PageObject;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//This class is used to group the identifiers for the Cookie button.
public class Cookie {
    public WebDriver driver;
    By link = By.id("onetrust-accept-btn-handler");
    //Post: This driver intialized to argument driver
    public Cookie(WebDriver driver){
        this.driver = driver;
    }

    public void getCookie(){
        driver.findElement(link).click();
    }
}
