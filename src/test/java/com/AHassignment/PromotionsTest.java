package com.AHassignment;

/* Importing the relevant libraries */
import AlbertLittleHelpers.InstantMethods;
import AlbertLittleHelpers.PageObjects;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import static org.junit.Assert.*;
import AlbertLittleHelpers.RunnerSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import org.openqa.selenium.By;

public class PromotionsTest extends RunnerSetup{

    private WebDriver driver;
    private String pageURL = "https://www.ah.nl/mijn/inloggen?ref=%2Facties%2Fkoopzegels";
    PageObjects pageObjects = new PageObjects();
    InstantMethods instantMethods = new InstantMethods();
    String testUserName = "adi.ben.arieh@gmail.com";
    String testUserPassword = "adi1976";


    @Test
    /* Our first test case checking what happens when there are stamps and cards. */
    public void promoInfo() {
    //opening the promotions  page//
        setupPage();
        InstantMethods.sleep(3);
        //dismissing the cookies popup//
        if (pageObjects.cookiesAcceptButton().isDisplayed()){
            pageObjects.cookiesAcceptButton().click();
        }

        //*solve the captcha or disable it on the test environment//*
       //making sure we are on the right page by checking the title of the form//
        assertEquals("Inloggen", pageObjects.loginFormTitle().getText());
        InstantMethods.sleep(1);
        //logging in with a user that has stamos and cards//
        PageObjects.login_logic(driver, testUserName, testUserPassword);
        InstantMethods.sleep(5);
        //*fill in the email code or disable it on test environment//*
        InstantMethods.sleep(5);
        //verifying the stamp number is not equal to 0, and full cards value not 0 as well//
        String stampsNumber = pageObjects.stamps().getText();
        String fullCardsNumber = pageObjects.fullCards().getText();
        assertNotEquals("0/490", stampsNumber);
        assertNotEquals("0", fullCardsNumber);
    }


    @Test
    /* Our second test case. checking what happens when there are no stamps and cards*/
    public void promoNoInfo() {
    //opening the promotions page//
        setupPage();
        InstantMethods.sleep(3);
        //dismissing the cookies popup//
        if (pageObjects.cookiesAcceptButton().isDisplayed()){
            pageObjects.cookiesAcceptButton().click();
        }

        //*solve the captcha or disable it on the test environment//*
        //making sure we are on the right page by checking the title of the form//
        assertEquals("Inloggen", pageObjects.loginFormTitle().getText());
        InstantMethods.sleep(1);
        //logging in with a user that has stamps and cards//
        PageObjects.login_logic(driver, testUserName, testUserPassword);
        InstantMethods.sleep(5);
        //*fill in the email code or disable it on test environment//*
        InstantMethods.sleep(5);
        //verifying the stamp number is  equal to 0, and full cards value is also 0//
        String stampsNumber = pageObjects.stamps().getText();
        String fullCardsNumber = pageObjects.fullCards().getText();
        assertEquals("0/490", stampsNumber);
        assertEquals("0", fullCardsNumber);

    }



        private void setupPage () {
            driver = getDriver();
            driver.get(pageURL);
        }

    }
