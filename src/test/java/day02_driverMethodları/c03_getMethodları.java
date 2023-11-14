package day02_driverMethodları;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c03_getMethodları {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.testotomasyonu.com");
       // driver.getPageSource();
      //  System.out.println(driver.getPageSource());// sayfada var olan kodları getirdi
        driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());//F82762735E96E925ADAEB922CBC1F3F4
       // biz bu değeri birden fazla sayfa açılırsa sayfalar arasinda geçiş yapmak için
        // kullanıcaz.
        driver.getWindowHandles();// tek fark köşeli olarak set getirdi


        Thread.sleep(5000);
        driver.quit();
    }
}
