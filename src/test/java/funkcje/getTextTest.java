package funkcje;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class getTextTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TestGetTagNameFunction() {
//        driver.get("https://pl.wikipedia.org/");
//        WebElement element = driver.findElement(By.id("main-page-column1"));
//        System.out.println(element.getText());

//        driver.get("https://pl.wikipedia.org/");
//        String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
//        System.out.println(atrybut);

        driver.get("https://pl.wikipedia.org/");
        String tag = driver.findElement(By.id("main-page-content")).getTagName();
        System.out.println(tag);
    }

    @After
    public void tearDown() {
        //        driver.quit();
    }
}
