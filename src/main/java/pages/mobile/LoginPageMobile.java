package pages.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.LoginPageInterface;

import static framework.Utilities.getLogger;

public class LoginPageMobile extends BasePage implements LoginPageInterface {

    @FindBy(id = "m_login_email")
    private WebElement email;

    @FindBy(id = "m_login_password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement logInButton;

    @FindBy(xpath = "//a[@class='_54k8 _56bs _26vk _56b_ _56bw _56bt _52jg']")
    private WebElement notNowButton;

    @Override
    public HomePageMobile login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        logInButton.click();
        notNowButton.click();
        getLogger().info("Log in performed");
        return new HomePageMobile();
    }
}
