package com.facebook.tests;

import framework.Browser;
import framework.BrowserAction;
import framework.Config;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.interfaces.FriendsPageInterface;
import pages.interfaces.HomePageInterface;
import pages.interfaces.LoginPageInterface;
import pages.interfaces.ProfilePageInterface;
import pages.mobile.LoginPageMobile;
import pages.web.LoginPageWeb;

public class FacebookTest extends BaseTest {

    private LoginPageInterface loginPage;
    private ProfilePageInterface profilePage;
    private HomePageInterface homePage;
    private FriendsPageInterface friendsPage;

    @BeforeClass
    public void setupClass() {
        BrowserAction.open("https://www.facebook.com/");
        if (Config.browser == Browser.ANDROID || Config.browser == Browser.iOS) {
            loginPage = new LoginPageMobile();
        } else {
            loginPage = new LoginPageWeb();
        }
        homePage = loginPage.login(Config.facebookLogin, Config.facebookPassword);
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @Test
    public void checkFriendsNumberTest() {

        profilePage = homePage.goToProfile();

        friendsPage = profilePage.goToFriends();

        friendsPage.scroll();

        Assert.assertEquals(profilePage.getFriendsCount(), friendsPage.getFriendsCountActual());
    }
}
