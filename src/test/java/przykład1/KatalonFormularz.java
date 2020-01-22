package przykład1;

import java.util.List;
//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class KatalonFormularz {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFormularz() throws Exception {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
            WebElement firstName = driver.findElement(By.id("first-name"));
            if (firstName.isEnabled()){
                firstName.clear();
                firstName.sendKeys("Jan");
            System.out.println(firstName.getTagName() + " wpisujemy w element " + "Karol");
        } else {
                fail();
        }

            WebElement lastName = driver.findElement(By.id("last-name"));
            if (lastName.isEnabled()){
                lastName.clear();
                lastName.sendKeys("Kowalski");
            System.out.println(lastName.getTagName() + " wpisujemy w element " + "Kowalski");
        } else {
                fail();
        }
// Lista elementów: 0 - Male, 1 - Female, 2 - In Between
            List<WebElement> gender =driver.findElements(By.name("gender"));
   //     if (gender.isEmpty()){
  //          gender.clear();
            gender.get(0).click();
//            System.out.println(gender.get() + " zaznaczamy " + "Male");
 //       } else {
//            fail();
 //       }

            //wybierz male
            gender.get(0).click();

            WebElement dateOfBirth = driver.findElement(By.id("dob"));
            if (dateOfBirth.isEnabled()){
                dateOfBirth.clear();
                dateOfBirth.sendKeys("05/22/2010");
                System.out.println(dateOfBirth.getTagName() + " wpisujemy w element " + "05/22//20210");
        } else {
                fail();
        }

            WebElement address = driver.findElement(By.id("address"));
            if (address.isEnabled()){
                address.clear();
                address.sendKeys("Prosta 51");
            System.out.println(address.getTagName() + " wpisujemy w element " + "Prosta 51");
        } else {
                fail();
        }

            WebElement email = driver.findElement(By.name("email"));
            if (email.isEnabled()){
                email.clear();
                email.sendKeys("karol.kowalski@mailinator.com");
            System.out.println(email.getTagName() + " wpisujemy w element " + "karol.kowalski@mailinator.com");
        } else {
                fail();
        }

            WebElement password = driver.findElement(By.id("password"));
            if (password.isEnabled()){
                password.clear();
                password.sendKeys("Pass123");
            System.out.println(password.getTagName() + " wpisujemy w element " + "Pass123");
        } else {
                fail();
        }

            WebElement company = driver.findElement(By.id("company"));
            if (company.isEnabled()){
                company.clear();
                company.sendKeys("CodersLab");
            System.out.println(company.getTagName() + " wpisujemy w element " + "CodersLab");
        } else {
                fail();
        }

            WebElement comment = driver.findElement(By.id("comment"));
            if (comment.isEnabled()){
                comment.clear();
                comment.sendKeys("To jest mój pierwszy autmoat testów");
                System.out.println(comment.getTagName() + " wpisujemy w element " + "To jest mój pierwszy automat testów");
        } else {
                fail();
        }

            WebElement SubmitButton =driver.findElement(By.id("submit"));
            SubmitButton.click();
   }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
