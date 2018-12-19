package pages.mobile;

import framework.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.ProfilePageInterface;

import static framework.Utilities.getLogger;

public class ProfilePageMobile extends BasePage implements ProfilePageInterface {

    @FindBy(xpath = "//a[contains(@href, 'friends')]/div[@class='_52jd _52ja _52jh _1hc']")
    private WebElement friends;

    @FindBy(xpath = "//div[@class='_4mp']/span")
    private WebElement friendsCount;

    @Override
    public FriendsPageMobile goToFriends() {
        Utilities.scrollToElement(friends);
        Utilities.isDisplayed(friends);
        friends.click();
        getLogger().info("Friends tab was clicked");
        return new FriendsPageMobile();
    }

    @Override
    public int getFriendsCount() {
        Utilities.isDisplayed(friendsCount);
        String count = friendsCount.getText().split(" ")[0];
        getLogger().info("Friends count was taken");
        return Integer.valueOf(count);
    }
}
