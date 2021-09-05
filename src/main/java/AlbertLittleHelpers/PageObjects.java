package AlbertLittleHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObjects extends RunnerSetup {

    //Data//
    //Login page elements//

    //Login form title//
    public static WebElement loginFormTitle() {
        return getDriver().findElement(By.xpath("/html/body/div[3]/div/main/div/div/div/div[1]/h1"));
    }

    //Email field//
    public static WebElement email_Field() {
        return getDriver().findElement(By.id("username"));
    }
    //Password field//
    public  static WebElement password_Field() {
        return getDriver().findElement(By.id("password"));
    }
    //Login button//
    public  static WebElement login_Button() {
        return getDriver().findElement(By.xpath("/html/body/div[3]/div/main/div/div/div/form/div[3]/button"));
    }
    public static WebElement cookiesAcceptButton() {
        return getDriver().findElement(By.id("accept-cookies"));
    }

    public static WebElement stamps() {
        return getDriver().findElement(By.id("I dont have that element"));
    }

    public static WebElement fullCards() {
        return getDriver().findElement(By.linkText("I dont have that element"));
    }



    //reusable methods//
    public static void login_logic(WebDriver driver, String user, String password){
        InstantMethods instantMethods = new InstantMethods() ;
        PageObjects.email_Field().sendKeys(user);
        PageObjects.password_Field().sendKeys(password);
        InstantMethods.sleep(3);
        PageObjects.login_Button ().submit();
        InstantMethods.sleep(5);

    }


}







