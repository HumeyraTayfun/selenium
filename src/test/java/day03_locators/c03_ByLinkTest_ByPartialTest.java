package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c03_ByLinkTest_ByPartialTest {
    public static void main(String[] args) throws InterruptedException {

        //1.gerekli ayarlamaları yapın
        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.testotomasyonu sayfasına gidin
          driver.get("https://www.testotomasyonu.com");
        //3.shoes linkine tıklayın
        WebElement shoesLinki = driver.findElement(By.linkText("Shoes"));
        shoesLinki.click();
        //4.açılan sayfada titlenin shoes içerdiğini test edin
           String expectedTitleİçerik="Shoes";
           String actualTitleİçerik=driver.getTitle();
           if (actualTitleİçerik.contains(expectedTitleİçerik)) {
               System.out.println("shoes testi passed");
           }else{
               System.out.println("shoes testi failed");
           }

        //driver.findElement(By.partialLinkText("hoes")).click();

        //5. shoes linkinin bu sayfada da erişilebilir olduğunu test edin

        if (shoesLinki.isEnabled()) {
            System.out.println("shoes linki erişim testi passed");
        }else{
            System.out.println("shoes linki erişim testi failed");//StaleElementReferenceException
        }
        Thread.sleep(3000);
           driver.quit();




    }
}
