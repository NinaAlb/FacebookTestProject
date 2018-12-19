package pages.web;

import framework.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.FriendsPageInterface;

import java.util.List;

import static framework.Utilities.getLogger;

public class FriendsPageWeb extends BasePage implements FriendsPageInterface {

    @FindBy(xpath = "//div[@id='pagelet_timeline_medley_friends']//ul[contains(@class,'_262m')]/li")
    private List<WebElement> allFriends;

    @FindBy(xpath = "//div[contains(@class,'sectionHeader')]")
    private WebElement sectionHeader;

    @Override
    public void scroll() {
        Utilities.isListDisplayed(allFriends);
        do {
            List<WebElement> list = allFriends;
            Utilities.scrollToElement(list.get(list.size()-1));
        } while (!Utilities.isDisplayed(sectionHeader, 1));
        getLogger().info("Scroll to the last friend and new section header was performed");

    }

    @Override
    public int getFriendsCountActual() {
        Utilities.isListDisplayed(allFriends);
        return allFriends.size();
    }
}
