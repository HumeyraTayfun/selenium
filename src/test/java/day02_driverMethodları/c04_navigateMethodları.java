package day02_driverMethodları;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c04_navigateMethodları {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // testotomasyonu anasayfasına gidin.titlenin otomasyon içerdiğini test edin
        // sonra wisequarter anasayfaya gidin urlnın wisequarter içerdiğini test edin.
        // tekrar test otomasyonu anasayfasına dönün.urlnınotomasyon içerdiğini test edin ve sayfayi kapatın

          // 1.testotomasyonu anasayfasına gidin.
          driver.get("https://www.testotomasyonu.com");

          //2.titlenin otomasyon içerdiğini test edin
            String expectedTitleİçerik="otomasyon";
            String actualTitle= driver.getTitle();
            if (actualTitle.contains(expectedTitleİçerik)) {
                System.out.println("title testi passed");
            }else {
                System.out.println("title testi failed");
                System.out.println("title test:"+actualTitle);//title testi failed
                //title test:Test Otomasyonu - Test Otomasyonu
                //eger Otomasyonu şeklinde yazarsam passed

              //3.  wisequarter anasayfaya gidin
                driver.navigate().to("https://www.wisequarter.com");

             //4.   urlnın wisequarter içerdiğini test edin.
                String expectedUrlİçerik="wisequarter";
                String actualUrl=driver.getCurrentUrl();
                if (actualUrl.contains(expectedUrlİçerik)) {
                    System.out.println("test passed");
                }else{
                    System.out.println("test failed");
                    System.out.println("url içerik:"+actualUrl);// test passed
                }
             //5.   tekrar test otomasyonu anasayfasına dönün
                driver.navigate().back();
             //6.   urlnınotomasyon içerdiğini test edin ve sayfayi kapatın
                 expectedUrlİçerik="otomasyon";
                 actualUrl=driver.getCurrentUrl();
                 if (actualUrl.contains(expectedUrlİçerik)) {
                     System.out.println("test passed");
                 }else{
                     System.out.println("test failed");//test passed
                 }


            }




            Thread.sleep(3000);
            driver.quit();

    }
}
