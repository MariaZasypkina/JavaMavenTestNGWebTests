import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

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
        ;
        driver.findElement(By.name("submitsearch")).click();

        Boolean langTable = driver.findElement(By.cssSelector(
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

        Boolean test = driver.findElement(By.cssSelector("#main > ul")).getText().contains(
        "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and " +
        "description), the easier it will be for us and the faster your language will show up on this page. We don't " +
        "have the time to mess around with fixing your descriptions etc. Thanks for your understanding.");

        Assert.assertTrue(test);
        driver.quit();
    }

    @Test //14
    public void test(){

    }
}
//TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь увидит таблицу со следующими названиями для первого и второго столбцов:
//Language
//Author
//
//Шаги:
//1. Открыть вебсайт на базовой странице
//2. Нажать на пункт меню Browse Languages
//3. Считать названия первого и второго столбцов таблицы
//3. Подтвердить, что названия соответствует ожидаемым
//4. Закрыть браузер




