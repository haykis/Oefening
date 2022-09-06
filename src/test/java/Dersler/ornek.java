package Dersler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ornek {
    WebDriver driver;
    Klas1 klas1=new Klas1();
    @BeforeClass
    public void beforeKlas(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get("https:google.com");
        try{
            WebElement guvenlik=driver.findElement(By.cssSelector("button[id='L2AGLb']"));
            klas1.bekleme(guvenlik,5);
        }
        catch (Exception a){
            System.out.println("\"guvenlik duvari yok\" = " + "guvenlik duvari yok");
        }


    }
    @Test
    public void IkinciArama() throws InterruptedException{

        WebElement arama=driver.findElement(By.cssSelector("input[name='q']"));
        klas1.bekleme(arama,5);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys("e").keyUp(Keys.LEFT_SHIFT).sendKeys("lma"+Keys.ENTER).perform();
        Thread.sleep(3*1000);
    }
    @Test
    public void BirinciArama(){

        System.out.println("\"ikinci method\" = " + "ikinci method");
        WebElement arama=driver.findElement(By.cssSelector("input[name='q']"));
        klas1.bekleme(arama,5);
        arama.sendKeys("Bisiklet"+Keys.ENTER);
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("arama sonuclari= " + driver.findElement(By.xpath("//div[@id='result-stats']")).getText());

    }
    @AfterClass
    public void afterKlas(){
        driver.close();
    }
}
