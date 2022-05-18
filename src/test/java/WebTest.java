import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    String url = "http://www.99-bottles-of-beer.net/";

    @Test
    private void testConfirmHeader(){

        System.setProperty("webdriver.chrome.driver", "//Applications/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement header = driver.findElement(By.cssSelector("#header > h1"));

        Assert.assertEquals(header.getText(), "99 Bottles of Beer");

        driver.quit();
    }
}

//TC_11_01 Подтвердите, что на странице по базовой ссылке в правом верхнем углу пользователь видит заголовок
// 99 Bottles of Beer
//
//Шаги:
//1. Открыть вебсайт на базовой странице
//2. Считать заголовок в правом верхнем углу
//3. Подтвердить, что текст заголовка соответствует ожидаемому
//4. Закрыть браузер


