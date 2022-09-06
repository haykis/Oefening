package Dersler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Klas1 {
    WebDriver driver;
    public void bekleme(WebElement element, int timeout){

        for(int i=0;i<timeout;i++){
            try{
                element.click();
                return;
            }catch (WebDriverException e){
                try {
                    wait(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
    @Test
    public void elementler(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gcreddy.com/project/admin/login.php");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("gcreddy");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Temp@2020");

        WebElement kayit=driver.findElement(By.xpath("//span[@class='ui-button-text']"));
        bekleme(kayit,5);

    }
}
