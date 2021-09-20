package com.techbee;
import PageObject.*;
import Resources.Base;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends Base
{
    public WebDriver driver;
    private static Logger logger;



    @BeforeTest
    public void initialize(){
        this.driver = init();
        this.driver.get(pro.getProperty("url"));
        logger= Logger.getLogger(AppTest.class);

    }

    @Test
    public void launchPage()
    {
        Cookie cook = new Cookie(driver);
        cook.getCookie();
        logger.info("cookie accepted");
        Spend s = new Spend(driver);
        s.link().click();
        logger.info("cookie accepted");
        Products pro = new Products(driver);
        List<WebElement> elements=pro.getProducts();
        String element1 = "Aspiration";
        String element2 = "Aspiration Plus";
        logger.info("Text when Aspiration Button is clicked is: "+elements.get(0).getText());
        logger.info("Text when Aspiration Plus Button is clicked is: "+elements.get(1).getText());
        Assert.assertEquals(element1,elements.get(0).getText());
        Assert.assertEquals(element2,elements.get(1).getText());
        logger.info("Assertion of Text Buttons complete.....");
        AspirationSignUp sign = new AspirationSignUp(driver);
        sign.signUpButton();
        logger.info("Get Aspiration Clicked!");
        WebElement wElement=sign.input();
        String tag= wElement.getTagName();
        if(tag!= "input"){
            logger.info("Modal doesn't have an input tag");
        }
        else{
            logger.info("Modal contains an input that requests user to input an email...");
        }
        sign.close();
        logger.info("Modal from the aspiration closed");
        AspirationPlusInfo plus = new AspirationPlusInfo(driver);
        plus.signUpButton();
        logger.info("Aspiration Plus button clicked!");
        List<WebElement> list=plus.info();
        String monthly = "$71.88 paid once yearly";
        String yearly = "$7.99 paid monthly";
        String outCome1 = list.get(1).getText().toString().trim();
        String outCome2 = list.get(2).getText().toString().trim();
        if(monthly.equals(outCome1)){
            logger.info("yearly shows $71.88 paid once yearly ");
        }
        if(yearly.equals(outCome2)){
            logger.info("Monthly shows:$7.99 paid monthly ");
        }
        Assert.assertEquals(monthly,outCome1);
        Assert.assertEquals(yearly,outCome2);
    }
    @AfterTest
    public void close(){
        this.driver.close();
        this.driver.quit();
        logger.info("driver closed");
    }
}
