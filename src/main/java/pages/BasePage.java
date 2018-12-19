package pages;

import framework.BrowserFactory;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(BrowserFactory.driver, this);
    }

}
