package pages.web;

import framework.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.HomePageInterface;

import static framework.Utilities.getLogger;

public class HomePageWeb extends BasePage implements HomePageInterface {

    @FindBy(xpath = "//div[@data-click='profile_icon']")
    private WebElement profileLink;

    @Override
    public boolean isHomePageDisplayed() {
        return Utilities.isDisplayed(profileLink);
    }

    @Override
    public ProfilePageWeb goToProfile() {
        profileLink.click();
        getLogger().info("Profile link was clicked");
        return new ProfilePageWeb();
    }
}
