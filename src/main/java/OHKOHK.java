import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OHKOHK {

    public static class DropDownHandleConceptsPart2 {

        private WebDriver driver;

        @BeforeSuite
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public  void testdata() throws InterruptedException {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://www.facebook.com");
            driver.findElement(By.linkText("Create a Page")).click();

            driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 signup_btn _4jy4 _4jy2 selected _51sy\"]")).click();



            WebElement month = driver.findElement(By.id("month"));
            WebElement day = driver.findElement(By.id("day"));
            WebElement year = driver.findElement(By.id("year"));

            // Sometimes there are some value which need to be change every time , this is called Hard- coded value.
            // for that we are using Array with string split method.

            String dob = "Jul-12-2020";// when we want to change the value of dob here, we can change it here only ,
            //for eg. " change only to Mar-10-1991 something anything.
            // we don't need to chang the code in selectvaluefromdropdown method  and it will be very to easy and fast to wotk with it.

            // This is the Generic method we have created

            String dobArr[] = dob.split("-");

            selectValueFromDropDown(month, dobArr[0]);
            selectValueFromDropDown(day,dobArr[1]);
            selectValueFromDropDown(year,dobArr[2]);


        }
        public static  void selectValueFromDropDown(WebElement element, String value){
            Select select = new Select(element);
            select.selectByVisibleText(value);

        }


        @AfterMethod
        public void tearDown() {
            //   driver.quit();
        }
    }

}
