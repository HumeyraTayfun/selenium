package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class c05_findElements {
    public static void main(String[] args) throws InterruptedException {
        //1. gerekli ayarları yapın
        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.testotomasyonu sayfasına gidin
        driver.get("https://www.testotomasyonu.com");
        //3.shoes linkine tıklayın
        driver.findElement(By.partialLinkText("hoes")).click();

        //4.cıkan ürünlerden 3.süne tıklayın
        List<WebElement> ürünElementleriListesi=driver.findElements(By.className("prod-img"));
        ürünElementleriListesi.get(2).click();

        WebElement ürünDetaylarıElementi=driver.findElement(By.className("prod-detail"));
        System.out.println(ürünDetaylarıElementi.getText());

        //5.ürün kısa açıklamalarında case sensitive olmadan shoe geçtiğini test edin
        String expectedİçerik="shoe";
        String actualİçerik=ürünDetaylarıElementi.getText().toLowerCase();
        if (actualİçerik.contains(expectedİçerik)) {
            System.out.println("ürün detay testi passed");//ürün detay testi passed

        }else{
            System.out.println("ürün detay testi failed");
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
