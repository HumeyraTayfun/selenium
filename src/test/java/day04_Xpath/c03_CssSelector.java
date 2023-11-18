package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c03_CssSelector {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // elektronıcs linkine tıklayın
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        //kenarda bulunan fiyat filtresinde min 10,max 200 yazarak
        WebElement minKutusu= driver.findElement(By.cssSelector("input[class='form-control minPrice']"));
        WebElement maxKutusu= driver.findElement(By.cssSelector("input[class='form-control maxPrice']"));
        minKutusu.clear();
        minKutusu.sendKeys("10");
        maxKutusu.clear();
        maxKutusu.sendKeys("200");
        //filtreleme yapın
        driver.findElement(By.cssSelector("button[class='price-range-button']")).click();

        //arama sonucunda ürün bulunabildiğini test edin
           WebElement aramaSonucuElementi= driver.findElement(By.cssSelector(".product-count-text"));
        System.out.println(aramaSonucuElementi.getText());
        String aramasonucuStr=aramaSonucuElementi.getText().replaceAll("\\D","");
        int actualSonucSayısı=Integer.parseInt(aramasonucuStr);
        if (actualSonucSayısı>0){
            System.out.println("filtreleme testi passed");
        }else{
            System.out.println("filtreleme testi passed");
        }
        // sayfayı kapatın
        Thread.sleep(3000);
        driver.quit();
    }
}
