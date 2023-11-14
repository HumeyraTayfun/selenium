package day02_driverMethodları;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c05_manageMethodları {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "kurulumDosyaları/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // implicitlywait sayfanın yuklenmesi ve veya arayacağımız web elementleri bulmak için
        // dinamik olarak tanımlanmıs maksımum bekleme süresidir.asıl amaç bekleme değil görevi yapmaktır
        //burada tanımlanan süre görevi yapmaya çabalayacagı maksimum süredir bu süre içerisinde görevi
        // yapamazsa exception fırlatır

        System.out.println("ilk baştaki konum" + driver.manage().window().getPosition());
        System.out.println("ilk baştaki size" + driver.manage().window().getSize());
        //ilk baştaki konum(-8, -8)
        //ilk baştaki size(1382, 744)


        Thread.sleep(3000);
        driver.quit();
    }
}

