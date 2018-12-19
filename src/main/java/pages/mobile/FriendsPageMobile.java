package pages.mobile;

import framework.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.FriendsPageInterface;

import java.util.List;

import static framework.Utilities.getLogger;

public class FriendsPageMobile extends BasePage implements FriendsPageInterface {

    @FindBy(xpath = "//div[@class='_55wp _4g33 _5pxa']")
    private List<WebElement> allFriends;

    @Override
    public void scroll() {
        Utilities.isListDisplayed(allFriends);
        int count;
        do {
            List<WebElement> list = allFriends;
            count = list.size();
            Utilities.scrollToElement(list.get(count-1));
            Utilities.isListDisplayed(allFriends);

        } while (allFriends.size() > count);
        getLogger().info("Scroll to the last friend was performed");
    }

    @Override
    public int getFriendsCountActual() {
        Utilities.isListDisplayed(allFriends);
        return allFriends.size();
    }
}
