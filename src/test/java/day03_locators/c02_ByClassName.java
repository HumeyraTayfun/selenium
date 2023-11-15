package day03_locators;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class c02_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        //1.bir test classı oluşturun ilgili ayarları yapın

        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2
        driver.get("https://www.automationexercise.com");
        //3. categorı bölümündeki elementleri locate edin
        List<WebElement> kategoriElementleriList=driver.findElements(By.className("panel-title"));

        //4.category bölümünde 3 element oldugunu test edin
         int expectedKategoriSayısı=3;
         int actualKategoriSayısı=kategoriElementleriList.size();
         if (expectedKategoriSayısı==actualKategoriSayısı) {
             System.out.println("kategori sayısı testı passed");
         }else{
             System.out.println("kategori sayısı testi failed");
         }

        //5.kategori isimlerini yazdırın
        System.out.println(ReusableMethods.stringlisteDönüştür(kategoriElementleriList));
          //[WOMEN, MEN, KIDS]

        //6. sayfayı kapatın
        Thread.sleep(3000);
        driver.quit();

    }
}
