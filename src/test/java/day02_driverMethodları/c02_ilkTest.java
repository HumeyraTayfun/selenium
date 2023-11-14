package day02_driverMethodları;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c02_ilkTest {

    public static void main(String[] args) throws InterruptedException {

        // test otomasyonu ana sayfaya gidin.url nın test otomasyonu.com oldugunu ve tıtlenın
        // test kelimesi içerdiğini kontrol edin

        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        // testotomasyonu anasayfasına gidin

        driver.get("https://www.testotomasyonu.com");

        // url nın testotomasyonu.com olduğunu
        String expectedUrl="https://www.testotomasyonu.com";
        String actualUrl= driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("url testi passed");
        }else {
            System.out.println("url testi failed");
            System.out.println("actualurl:" +actualUrl);

        }


        // titlenin test kelimesi içerdiğini test edin

        String expectedTitleİçeriği= "test";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expectedTitleİçeriği)) {
            System.out.println("title testi passed");
        }else{
            System.out.println("title testi failed");
            System.out.println("actual tıtle:"+ actualTitle);
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
