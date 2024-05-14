package utils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifiervalue) {

        switch (identifierType) {
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(identifiervalue));

            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifiervalue));

            case "ID":
                return BaseTest.driver.findElement(By.id(identifiervalue));

            case "NAME":
                return BaseTest.driver.findElement(By.name(identifiervalue));

            default:
                return null;

        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifiervalue) {

        switch (identifierType){
            case "XPATH":
                return BaseTest.driver.findElements(By.xpath(identifiervalue));

            case "CSS":
                return BaseTest.driver.findElements(By.cssSelector(identifiervalue));

            case "ID":
                return BaseTest.driver.findElements(By.id(identifiervalue));

            case "NAME":
                return BaseTest.driver.findElements(By.name(identifiervalue));

            default:
                return null;

    }
}
}
