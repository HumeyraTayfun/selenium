package day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c02_XPath_textKullanımı {

        // xpath link olmasa bile yazısı olan webelementleri yazı ile locate etmemize imkan tanır

    public static void main(String[] args) {


            System.setProperty("Webdriver.chrome.driver","kurulumDosyaları/chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //1.https://www.testotomasyonu.com/addremove/ adresine gidin
            driver.get("https://www.testotomasyonu.com/addremove/");
            //2.add element butonuna basın
            driver.findElement(By.xpath("//button[text()='Add']")).click();
            //3.remove butonunun görünür oldugunu test edin
            WebElement removeButon= driver.findElement(By.xpath("//button[text()='Remove']"));
            if (removeButon.isDisplayed()){
                System.out.println("remove butonu görünme testi passed");
            }else{
                System.out.println("remove butonu görünme testi failed");
            }
            //4. remove tuşuna basın
            driver.findElement(By.className("remove-btn")).click();
            //5."Add/Remove Elements" yazısının görünür olduğunu test edin
            WebElement addRemoveYazıElementi=driver.findElement(By.xpath("//*[text()='Add/Remove']"));
            if (addRemoveYazıElementi.isDisplayed()){
                System.out.println( "add remove yazısı görünme testi passed");
            }else{
                System.out.println("add remove yazısı görünme testi failed");
            }

            //6.remove butonunun görünur olmadıgını teste edin


        try {
            removeButon= driver.findElement(By.className("remove-btn"));
            System.out.println("remove butonu görünmeme testi failed");
        } catch (NoSuchElementException e) {
            System.out.println("remove butonu görünmeme testi passed");
        }

            driver.quit();

            }


        }




