import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    String url = "http://www.99-bottles-of-beer.net/";

    @Test
    public void testConfirmHeader(){

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement header = driver.findElement(By.cssSelector("#header > h1"));

        Assert.assertEquals(header.getText(), "99 Bottles of Beer");

    }

    @Test
    public void testLanguageButton(){

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement languageButton = driver.findElement(By.cssSelector(" #menu > li:nth-child(6) > a"));

        Assert.assertEquals(languageButton.getText(), "Submit new Language".toUpperCase());
    }

    @Test
    public void testClickMenuButton(){

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.cssSelector(" #menu > li:nth-child(6) > a")).click();
        WebElement header2 = driver.findElement(By.cssSelector("#main > h2"));

        Assert.assertEquals(header2.getText(), "Submit New Language");
    }

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.99-bottles-of-beer.net/abc.html");


        Assert.assertEquals(driver.findElement(By.cssSelector("#submenu > li:nth-child(1) > a")).getText(), "0-9");

        driver.quit();
    }
}


