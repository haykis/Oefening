package Ders4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestAnnotations {
    WebDriver driver;
    @BeforeClass
    public void beforeKlas(){
        System.out.println("\"beforeKlas\" = " + "beforeKlas");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\"beforeMethod\" = " + "beforeMethod");
    }
    @Test
    public void tanimlama1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("\"Test01\" = " + "Test01");
    }
    @Test
    public void tanimlama2(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("\"Test02\" = " + "Test02");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("\"afterMethod\" = " + "afterMethod");
    }
    @AfterClass
    public void afterKlas(){
        System.out.println("\"afterKlas\" = " + "afterKlas");
    }

}
