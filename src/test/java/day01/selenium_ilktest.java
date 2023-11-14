package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_ilktest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.crome.driver","kurulumDosyaları/chromedriver.exe");
        // bu satır oluşturacağımız webdriverin özellıklerını set ediyor
        WebDriver driver = new ChromeDriver();
   driver.get("https://www.testotomasyonu.com");
        Thread.sleep(5000);
   driver.manage().window().maximize();

    Thread.sleep(5000);

    driver.quit();

    }
}
