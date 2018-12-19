package pages.web;

import framework.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.ProfilePageInterface;

import static framework.Utilities.getLogger;

public class ProfilePageWeb extends BasePage implements ProfilePageInterface {

    @FindBy(xpath = "//a[@data-tab-key='friends']")
    private WebElement friends;

    @Override
    public FriendsPageWeb goToFriends() {
        Utilities.isDisplayed(friends);
        friends.click();
        getLogger().info("Friends tab was clicked");
        return new FriendsPageWeb();
    }

    @Override
    public int getFriendsCount() {
        Utilities.isDisplayed(friends);
        String count = friends.findElement(By.xpath("./span[1]")).getText();
        getLogger().info("Friends count was taken");
        return Integer.valueOf(count);
    }
}
