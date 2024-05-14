package qa.tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class Testcase1 extends BaseTest {

    ElementFetch ele = new ElementFetch();
    HomePageEvents homepage = new HomePageEvents();
    LoginPageEvents loginPage = new LoginPageEvents();

    @Test
    public void sampleMethodForEnteringCredentials () {

        homepage.signInButton();
        loginPage.verifyLoginPageIsLoaded();
        loginPage.enterCredentials();

    }

}

