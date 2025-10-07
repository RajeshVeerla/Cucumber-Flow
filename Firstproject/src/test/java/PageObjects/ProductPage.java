package PageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[text()='Products']")
    WebElement pageHeading;

    @FindBy(xpath = "(//button[text()='ADD TO CART'])[1]")
    WebElement firstAddToCartButton;

    @FindBy(xpath ="//div[@id='shopping_cart_container']")
    WebElement cartIcon;

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOnProductPage() {
        try {
            getWait().until(ExpectedConditions.visibilityOf(pageHeading));
            return pageHeading.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void addFirstProductToCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(firstAddToCartButton)).click();
    }
    public boolean isCartIconVisible() {
        try {
            return cartIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickCartIcon() {
        getWait().until(ExpectedConditions.elementToBeClickable(cartIcon));
                cartIcon.click();
    }
}




//    public boolean isOnProductPage() {
//        return pageHeading.isDisplayed();
//    }

//    public void addFirstProductToCart() {
//        firstAddToCartButton.click();
//    }

//    public void clickCartIcon() {
//        cartIcon.click();
//    }
//}

