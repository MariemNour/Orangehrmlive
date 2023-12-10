package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeLoginPage extends BasePage {

    private static String LOGIN_PATH = "/auth/login";

    private By emailField = By.xpath("//input[@placeholder='Username']");
    private By passwordField = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.cssSelector("button[type=\"submit\"]");

    public OrangeLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillInEmailField(String email) {
        fillInElement(emailField, email);
    }

    public void fillInPasswordField(String email) {
        fillInElement(passwordField, email);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void login(String email, String password) {
        // Dotenv dotenv = Dotenv.load();
        // String orangeURL = dotenv.get("ORANGE_URL");
        visitPageURL(ORANGE_URL);
        fillInEmailField(email);
        fillInPasswordField(password);
        clickLoginButton();
    }
}
