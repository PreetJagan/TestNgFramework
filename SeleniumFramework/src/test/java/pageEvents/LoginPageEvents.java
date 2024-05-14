package pageEvents;

import org.testng.Assert;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {

    ElementFetch ele = new ElementFetch();
    public void verifyLoginPageIsLoaded(){

        Assert.assertTrue(ele.getWebElements("XPATh", LoginPageElements.loginText).size()>0,"Elements not found");

    }
    public void enterCredentials(){
        ele.getWebElement("XPATH",LoginPageElements.emailAddress).sendKeys("prexitrataroi-7783@yopmail.com");
        ele.getWebElement("XPATH",LoginPageElements.passwordField).sendKeys("Test@123");

    }
}
