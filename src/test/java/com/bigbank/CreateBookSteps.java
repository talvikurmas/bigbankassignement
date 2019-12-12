package com.bigbank;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.bigbank.locators.Locators;
import com.bigbank.browserhandler.BrowserHandler;

public class CreateBookSteps {

    public static WebDriver driver;

    @Given("^I open library webApp$")
    public void I_open_library_webApp() {
        BrowserHandler bh;
        bh = new BrowserHandler();
        driver = bh.getBrowser();
    }

    @And("^I navigate to create new book page$")
    public void I_navigate_to_create_new_book_page() {
        driver.findElement(By.linkText(Locators.CreateNewBook)).click();
    }

    @And("^I navigate to all books page$")
    public void I_navigate_to_all_books_page() {
        driver.findElement(By.linkText(Locators.AllBooks)).click();
    }

    @Then("^I can see input field to create book$")
    public void I_can_see_input_fields_to_create_book() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String exp_message = "Create Book";
        String actual = driver.findElement(By.xpath(Locators.CreateBook)).getText();
        Assert.assertEquals(exp_message, actual);
    }

    @And("^I input book name$")
    public void I_input_book_name() {
        WaitSteps.safeWait(2000);
        driver.findElement(By.cssSelector(Locators.BookName)).sendKeys(Locators.BookNameInput);
    }

    @And("^I select author$")
    public void I_select_author()  {
        driver.findElement(By.cssSelector(Locators.Author)).click();
        driver.findElement(By.cssSelector(Locators.Author)).sendKeys(Locators.AuthorInput);
    }

    @And("^I input summary$")
    public void I_input_summary()  {
        driver.findElement(By.cssSelector(Locators.Summary)).sendKeys(Locators.SummaryInput);
    }

    @And("^I input ISBN$")
    public void I_input_ISBN()  {
        driver.findElement(By.cssSelector(Locators.ISBN)).sendKeys(Locators.ISBNInput);
    }

    @And("^I check genre as fiction")
    public void I_check_genre_as_fiction()  {
        driver.findElement(By.xpath(Locators.FictionCB)).click();
    }

    @When("^I press submit$")
    public void I_press_submit()  {
        driver.findElement(By.xpath(Locators.Submit)).click();
    }

    @Then("^I can see book is saved$")
    public void I_can_see_book_is_saved()  {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String createdBook = driver.findElement(By.xpath(Locators.BookTitle)).getText();
        Assert.assertTrue("Wrong Title!", createdBook.contains(Locators.BookNameInput));
        Assert.assertTrue(driver.getPageSource().contains(Locators.AuthorInput));
        Assert.assertTrue(driver.getPageSource().contains(Locators.SummaryInput));
        Assert.assertTrue(driver.getPageSource().contains(Locators.ISBNInput));
        Assert.assertTrue(driver.getPageSource().contains(Locators.SummaryInput));
    }

    @Then("^I can find created book$")
    public void I_can_find_created_book() {
        WaitSteps.safeWait(1000);
        driver.findElement(By.partialLinkText(Locators.BookNameInput)).click();
        String foundBook = driver.findElement(By.xpath(Locators.BookTitle)).getText();
        Assert.assertTrue(foundBook.contains(Locators.BookNameInput));

            if(driver.getPageSource().contains(Locators.BookNameInput))
        {
            System.out.print("Book found, verifying details");
            Assert.assertTrue(driver.getPageSource().contains(Locators.AuthorInput));
            Assert.assertTrue(driver.getPageSource().contains(Locators.SummaryInput));
            Assert.assertTrue(driver.getPageSource().contains(Locators.ISBNInput));
            Assert.assertTrue(driver.getPageSource().contains(Locators.SummaryInput));
        }

        else

        {
            System.out.print("Book NOT found, something went worng");
            Assert.assertTrue(driver.getPageSource().contains(Locators.SummaryInput));
            {

            }
        }
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}