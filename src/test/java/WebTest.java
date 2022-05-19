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

    @Test
    public void testConfirmHeader() {

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement header = driver.findElement(By.cssSelector("#header > h1"));

        Assert.assertEquals(header.getText(), "99 Bottles of Beer");

    }

    @Test
    public void testLanguageButton() {

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement languageButton = driver.findElement(By.cssSelector(" #menu > li:nth-child(6) > a"));

        Assert.assertEquals(languageButton.getText(), "Submit new Language".toUpperCase());
    }

    @Test
    public void testClickMenuButton() {

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.cssSelector(" #menu > li:nth-child(6) > a")).click();
        WebElement header2 = driver.findElement(By.cssSelector("#main > h2"));

        Assert.assertEquals(header2.getText(), "Submit New Language");
    }

    @Test
    public void testButton09() {
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.99-bottles-of-beer.net/abc.html");


        Assert.assertEquals(driver.findElement(By.cssSelector("#submenu > li:nth-child(1) > a")).getText(), "0-9");
    }

    @Test
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

    @Test
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
    }

    @Test
}
//TC_11_11 Подтвердите, что если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,  пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка
//
//Error: Precondition failed - Incomplete Input.
//
//Шаги:
//1. Открыть вебсайт на странице
//2. Нажать на кнопку Submit Language
//3. Подтвердить, что на странице показана ошибка
//4. Подтвердить, что текст ошибки соответствует ожидаемому
//5. Закрыть браузер


