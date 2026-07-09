package utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import FirstContacts.FirstContacts.BaseTest;
import pages.SplashPage;

public class TestData extends BaseTest
{
    @Test
    public void verifySplashScreen()
    {

        SplashPage splash = new SplashPage(driver);
        Assert.assertTrue(splash.isAppTitleDisplayed(),"App title 'My First App' is NOT displayed.");
        Assert.assertTrue(splash.isContactsDisplayed(),"'CONTACTS' title is NOT displayed.");
        Assert.assertTrue(splash.isAuthorDisplayed(),"Author name is NOT displayed.");
        Assert.assertEquals(splash.getAppTitle(),"My First App","Incorrect App Title displayed.");
        Assert.assertEquals(splash.getContactsTitle(),"CONTACTS","Incorrect CONTACTS title displayed.");
        Assert.assertEquals(splash.getAuthor(),"Author: Chinmay Agrawal","Incorrect author displayed.");
    }

}