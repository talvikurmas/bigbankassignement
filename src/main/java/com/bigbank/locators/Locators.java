package com.bigbank.locators;

public class Locators {

    // Create book fields
    public static String BookName = "#title";
    public static String Author = "#author";
    public static String Summary = "#summary";
    public static String ISBN = "#isbn";

    // Check Box
    public static String FictionCB = "//label[contains(text(),'Fiction')]";

    // Buttons
    public static String Submit = "//button[@class='btn btn-primary']";

    // Menu buttons
    public static String CreateNewBook = "Create new book";
    public static String AllBooks = "All books";

    // Assertion texts
    public static String CreateBook = "//h1[contains(text(),'Create Book')]";
    public static String BookTitle = "/html[1]/body[1]/div[1]/div[1]/div[2]/h1[1]";

    // Test Data
    public static String BookNameInput = "Cucumber";
    public static String AuthorInput = "Bot, Test";
    public static String SummaryInput = "Test";
    public static String ISBNInput = "123456";

}
