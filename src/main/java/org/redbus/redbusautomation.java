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

/**
 * Hello world!
 *
 */
public class redbusautomation
{
    public static void main( String[] args ) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

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

        // Wait for suggestions and click the first one
        By suggestion = By.xpath("//li[contains(@class,'sc-iwsKbI')]");
        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(suggestion));
        firstSuggestion.click();

        Thread.sleep(2000); // Just for demo pause
        wd.quit();
        System.out.println("Test Completed Successfully");
    }
}
