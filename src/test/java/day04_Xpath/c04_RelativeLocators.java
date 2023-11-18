package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class c04_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        //gerekli ayarları yapın
        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //https://testotomasyonu.com/relativeLocators sayfasına gidin
        driver.get("https://testotomasyonu.com/relativeLocators");
        // DSLRcamera elementini locate edin
        WebElement dslrCameraElementi=driver.findElement(By.id("pic7_thumb"));

        // webelementin HTML kodunda src tagının "testotomasyonu.com/uploads/product"içerdiğini test edin
        String srcAttributeValue=dslrCameraElementi.getAttribute("src");
        String expectedHtmlİçerik="testotomasyonu.com/uploads/product";
        if (srcAttributeValue.contains(expectedHtmlİçerik)){
            System.out.println("DSLR camera testi passed");
        }else{
            System.out.println("DSLR camera testi failed");
        }
      // bir web sayfasında bir webelementi görebiliyor,html kodlarına ulaşabiliyor
        // ama locate edemiyorsanız etrafındakı webelementlerı kullanarak locate işlemini
        // yapabilmeniz için Selenium4 ile birlikte relative locator özelliği gelmiştir
        // relative locator için hedef elementin en az bir özelliği hedef element etrafında locate edip
        // kullanabildigimiz en az bir baska web element olmalıdır
        /*
        dslr camera webelementi ve relative locator kullanarak motor E13 telefonu locate edin

        motor E13  src tagında 16882639136208024 numarasının bulundugunu test edin
        */
         WebElement motorE13Elementi= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(dslrCameraElementi));
      expectedHtmlİçerik="16882639136208024";
      String actualSrcAttributeValue=motorE13Elementi.getAttribute("src");
       if (actualSrcAttributeValue.contains(expectedHtmlİçerik)){
           System.out.println("motorola E13 testi passed");
       }else{
           System.out.println("motorola E13 testi failed");
       }
       Thread.sleep(3000);

        driver.quit();
    }
}
