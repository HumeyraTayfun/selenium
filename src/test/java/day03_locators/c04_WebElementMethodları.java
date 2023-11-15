package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class c04_WebElementMethodları {
    public static void main(String[] args) throws InterruptedException {
        //1. ilgili ayarları yapın

        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3. sayfada 147 adet link bulunduğunu test edin
        List<WebElement> LinkEelementleriList=driver.findElements(By.tagName("a"));
        int expectedLinkSayısı=147;
        int actualLinkSayısı= LinkEelementleriList.size();
        if (expectedLinkSayısı==actualLinkSayısı) {
            System.out.println("Link sayısı testi passed");
        }else{
            System.out.println("Link sayısı testi failed");
        }

        //4.sonra products linkini tıklayın
        driver.findElement(By.partialLinkText("Products")).click();
        //5. special offer yazısının göründüğünü test edin
        WebElement specialOfferElementi=driver.findElement(By.id("sale_image"));
        Thread.sleep(2000);
        if (specialOfferElementi.isDisplayed()) {
            System.out.println("special offer testi passed");
        }else{
            System.out.println("special offer testi failed");//Link sayısı testi passed
                                                            //special offer testi passed
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
