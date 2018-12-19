package com.facebook.tests;

import framework.BrowserFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {

        BrowserFactory.initDriver();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {

        BrowserFactory.closeDriver();
    }
}
