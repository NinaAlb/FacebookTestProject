package pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.LoginPageInterface;

import static framework.Utilities.getLogger;

public class LoginPageWeb extends BasePage implements LoginPageInterface {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "loginbutton")
    private WebElement logInButton;

    @Override
    public HomePageWeb login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        logInButton.click();
        getLogger().info("Log in performed");
        return new HomePageWeb();
    }
}
