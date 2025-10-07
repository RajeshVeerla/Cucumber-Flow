package StepDefinitions;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Steps {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
//        Alert alert = driver.switchTo().alert();
//        System.out.println("Alert says: " + alert.getText());
//        alert.accept();


    }
    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }
    @When("clicks the login button")
    public void clicks_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLogin();
    }
    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
//        Alert alert = driver.switchTo().alert();
//        System.out.println("Alert says: " + alert.getText());
//        alert.accept();
        Assert.assertTrue("User is not on the Products page.", productPage.isOnProductPage());
    }
    @Then("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        productPage.addFirstProductToCart();
    }
    @Then("the cart should show the product")
    public void the_cart_should_show_the_product() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Cart icon is not visible", productPage.isCartIconVisible());
        productPage.clickCartIcon();
    }
}

