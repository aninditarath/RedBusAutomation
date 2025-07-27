package org.redbus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Hello world!
 *
 */
public class redbusautomation
{
    public static void main( String[] args ) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver(options);

        wd.get("https://www.redbus.in/");

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));

        // Click on 'From' field
        By source = By.xpath("(//div[contains(@class,'srcDestWrapper') and @role='button'])[1]");
        WebElement sourceButton = wait.until(ExpectedConditions.elementToBeClickable(source));
        sourceButton.click();

        // Enter city name in input field
        By inputField = By.xpath("//input[contains(@class,'inputField')]");
        WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(inputField));
        fromInput.sendKeys("Mumbai");

//        // Wait for suggestions and click the first one
//        By suggestion = By.xpath("//li[contains(@class,'sc-iwsKbI')]");
//        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(suggestion));
//        firstSuggestion.click();


        By Fromserachcatagorylist = By.xpath("//div[contains(@class,'searchCategory')]");
        List<WebElement> Fromsearchlist= wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(Fromserachcatagorylist,1));

        System.out.println(Fromsearchlist.size());

        WebElement serachtext= Fromsearchlist.get(0);

        By webelementtobeclicked=By.xpath("//div[contains(@class,'listHeader')]");
        List<WebElement> locations= serachtext.findElements(webelementtobeclicked);
        System.out.println(locations.size());

        for(WebElement location: locations){
            if(location.getText().equalsIgnoreCase("Mumbai")){
                location.click();
                break;
            }
        }


        WebElement Toinputbox= wd.switchTo().activeElement();
        Toinputbox.sendKeys("Pune");


        By Toserachcatagorylist = By.xpath("//div[contains(@class,'searchCategory')]");
        List<WebElement> Tosearchlist= wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(Toserachcatagorylist,1));

        System.out.println(Tosearchlist.size());

        WebElement Toserachtext= Tosearchlist.get(0);

        By TOwebelementtobeclicked=By.xpath("//div[contains(@class,'listHeader')]");
        List<WebElement> TOlocations= Toserachtext.findElements(TOwebelementtobeclicked);
        System.out.println(TOlocations.size());
        for(WebElement location: TOlocations){
            if(location.getText().equalsIgnoreCase("Pune")){
                location.click();
                break;
            }
        }

        WebElement clicksearch= wd.findElement(By.xpath("//button[contains(@class,'searchButtonWrapper')]"));
        clicksearch.click();
        Thread.sleep(2000); // Just for demo pause
        //wd.quit();
        System.out.println("Test Completed Successfully");
    }
}
