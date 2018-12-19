package pages.mobile;

import framework.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.HomePageInterface;

import static framework.Utilities.getLogger;

public class HomePageMobile extends BasePage implements HomePageInterface {

    @FindBy(xpath = "//div[@class='_5s61 _5i2i _52we']")
    private WebElement profileLink;

    @Override
    public boolean isHomePageDisplayed() {
        return Utilities.isDisplayed(profileLink);
    }

    @Override
    public ProfilePageMobile goToProfile() {
        Utilities.isDisplayed(profileLink);
        profileLink.click();
        getLogger().info("Profile link was clicked");
        return new ProfilePageMobile();
    }
}
