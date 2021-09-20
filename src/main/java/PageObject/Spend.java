package PageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//This class is used to group the identifiers for the Spend and Save Link


public class Spend {

    public WebDriverWait wait;
    public WebDriver driver;
    By link = By.linkText("SPEND & SAVE");

    public Spend(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30);
    }
    public WebElement link(){

        WebElement links = this.wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        WebElement linked = driver.findElement(link);
        return linked;
    }

}
