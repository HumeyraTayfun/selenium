package day02_driverMethodları;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c06_byIdLocator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdirever.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.testotomasyonu.com");
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
       aramaKutusu.sendKeys("phone");
       aramaKutusu.submit();
      WebElement sonuçYazElementi=driver.findElement(By.className("product-count-text"));
      System.out.println(sonuçYazElementi);//[[ChromeDriver: chrome on windows
        // (3e4d087c2752655d7d66d0a3f2a4b80f)] -> class name: product-count-text]

        // web elementler direk yazdırılmaz.eger webelement üzerindeki yazıyı elde etmek ıstersek
       System.out.println(sonuçYazElementi.getText());//4 Products Found

        // arama sonucunda ürün bulunabildigini test edin
       String sonuçSayısıStr=sonuçYazElementi.getText().replaceAll("\\D","");
        int sonuçSayısıInt=Integer.parseInt(sonuçSayısıStr);
       if (sonuçSayısıInt>0) {
            System.out.println("arama testi passed");
       }else{
           System.out.println("arama testi failed");
        }


     Thread.sleep(2000);
        driver.quit();
    }
}
