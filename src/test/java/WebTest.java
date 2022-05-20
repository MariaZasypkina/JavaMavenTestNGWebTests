import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

public class WebTest {

    String url = "http://www.99-bottles-of-beer.net/";

    @Test //1
    public void testConfirmHeader() {

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement header = driver.findElement(By.cssSelector("#header > h1"));

        Assert.assertEquals(header.getText(), "99 Bottles of Beer");
        driver.quit();
    }

    @Test //2
    public void testLanguageButton() {

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement languageButton = driver.findElement(By.cssSelector(" #menu > li:nth-child(6) > a"));

        Assert.assertEquals(languageButton.getText(), "Submit new Language".toUpperCase());
        driver.quit();
    }

    @Test //3
    public void testClickMenuButton() {

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.cssSelector(" #menu > li:nth-child(6) > a")).click();
        WebElement header2 = driver.findElement(By.cssSelector("#main > h2"));

        Assert.assertEquals(header2.getText(), "Submit New Language");
        driver.quit();
    }

    @Test //4
    public void testButton09() {
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.99-bottles-of-beer.net/abc.html");


        Assert.assertEquals(driver.findElement(By.cssSelector("#submenu > li:nth-child(1) > a")).getText(), "0-9");
        driver.quit();
    }

    @Test //6
    public void testTeamContent() {
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.99-bottles-of-beer.net/team.html");
//        Object [] expectedResult = {"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};
        Object[] expectedResult = {"Gregor Scheithauer", "Stefan Scheler", "Oliver Schade"};
        Arrays.sort(expectedResult);

        Object team1 = driver.findElements(By.cssSelector("#main > h3")).get(0).getText();
        Object team2 = driver.findElements(By.cssSelector("#main > h3")).get(1).getText();
        Object team3 = driver.findElements(By.cssSelector("#main > h3")).get(2).getText();


        Object[] actualResult = {team1, team2, team3};
        Arrays.sort(actualResult);

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    @Test //7
    public void testSearchLanguagesAPlus() {
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.linkText("SEARCH LANGUAGES")).click();
        driver.findElement(By.name("search")).sendKeys("A+");

        driver.findElement(By.name("submitsearch")).click();

        boolean langTable = driver.findElement(By.cssSelector(
                "#category > tbody > tr:nth-child(2)")).getText().contains("A+");

        Assert.assertTrue(langTable);
        driver.quit();
    }

    @Test //11
    public void testSubmitLanguageError() {
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        driver.findElement(By.name("submitlanguage")).click();
        WebElement errorField = driver.findElement(By.cssSelector("#main > p"));

        Assert.assertTrue(errorField.getText().contains("Error"));

        Assert.assertEquals(errorField.getText(), "Error: Precondition failed - Incomplete Input.");
        driver.quit();
    }

    @Test //12
    public void testErrorMassage() {
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        driver.findElement(By.name("submitlanguage")).click();
        WebElement errorField = driver.findElement(By.cssSelector("#main > p"));
        String[] error = errorField.getText().split(" ");

        Assert.assertTrue(
                error[0].startsWith("E") && error[1].startsWith("P") && error[2].startsWith("f") &&
                        error[4].startsWith("I") && error[5].startsWith("I"));
        Assert.assertTrue(
                errorField.getText().contains(":") && errorField.getText().contains(".") &&
                        errorField.getText().contains("-"));
        driver.quit();
    }

    @Test //13
    public void testConfirmText() {
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        boolean test = driver.findElement(By.cssSelector("#main > ul")).getText().contains(
        "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and " +
        "description), the easier it will be for us and the faster your language will show up on this page. We don't " +
        "have the time to mess around with fixing your descriptions etc. Thanks for your understanding.");

        Assert.assertTrue(test);
        driver.quit();
    }

    @Test //14
    public void testBrowseLanguages() {
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.linkText("BROWSE LANGUAGES")).click();
        WebElement tableHeader = driver.findElement(By.cssSelector("#category > tbody > tr:nth-child(1)"));

        Assert.assertEquals(tableHeader.getText().split(" ")[0], "Language");
        Assert.assertEquals(tableHeader.getText().split(" ")[1], "Author");

        driver.quit();
}

@Test //15
    public void testConfirmNoComments(){
    System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get(url);

    driver.findElement(By.linkText("TOP LISTS")).click();
    driver.findElement(By.linkText("New Comments")).click();
    Object [] list = driver.findElements((By.xpath("/html/body/div/div[3]/text()/outerText"))).toArray();

    Assert.assertEquals(list.length, 0);
    driver.quit();
}

@Test //21
    public void testImportantWordLayout(){
    System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

    WebElement importantWord = driver.findElement(By.cssSelector("#main > ul > li:nth-child(1) > span"));

//    System.out.println(importantWord.get);

    Assert.assertTrue(importantWord.getCssValue("color").contains("255, 255, 255") &&
            importantWord.getCssValue("background-color").contains(("255, 0, 0")) &&
            importantWord.getText().equals(importantWord.getText().toUpperCase()));

    driver.quit();
}
}






