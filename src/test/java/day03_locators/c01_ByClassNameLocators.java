package day03_locators;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class c01_ByClassNameLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.crome.driver", "kurulumDosyaları/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        int expectedKategoriSayısı = 8;
        List<WebElement> kategoriElementlerıList = driver.findElements(By.className("acc_head"));
        int actualKategoriSayısı = kategoriElementlerıList.size();

        if (expectedKategoriSayısı == actualKategoriSayısı) {
            System.out.println("kategori sayısı testi passed");
        } else {
            System.out.println("kategori sayısı testi passed");
            System.out.println("actual kategori sayısı:" + actualKategoriSayısı);
        }

        // katwgorileri yazdırın
        // for (WebElement each:kategoriElementlerıList){
        // System.out.println(each.getText());
        System.out.println(ReusableMethods.stringlisteDönüştür(kategoriElementlerıList));
       //[Grocery, Kids Wear, Travel, Shoes, Furniture, Men Fashion, Women Fashion, Electronics]

        Thread.sleep(3000);

        driver.quit();


    }

}