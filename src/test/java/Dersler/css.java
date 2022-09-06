package Dersler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class css {
    Klas1 klas1=new Klas1();

WebDriver driver;
    @Test
    public void elementler() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https:facebook.com");
        WebElement guvduv=driver.findElement(By.xpath("(//button)[7]"));
        klas1.bekleme(guvduv,5);
        Actions actions = new Actions(driver);
      WebElement isim=driver.findElement(By.cssSelector("input#email"));

      klas1.bekleme(isim,5);
        actions.moveToElement(isim).click().keyDown(Keys.LEFT_SHIFT).sendKeys("h").keyUp(Keys.LEFT_SHIFT).sendKeys("useyin").perform();

        driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("kahraman");




    }
}
