package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //locators
    @FindBy(xpath = "//input[@name='user-name']" )
    WebElement txt_username;

    @FindBy(name="password")
    WebElement txt_password;

    @FindBy(id="login-button")
    WebElement loginButton;

    public void enterUsername(String Username){
        txt_username.sendKeys(Username);
    }
    public void enterPassword(String pass){
        txt_password.sendKeys(pass);
    }
    public void clickLogin() {
        loginButton.click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
