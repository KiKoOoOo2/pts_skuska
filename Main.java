package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://ais2.ukf.sk/ais/start.do");

        try {
            Thread.sleep(500);
            driver.manage().window().setSize(new Dimension(945, 1030));
            Thread.sleep(500);
            WebElement cookiesButton = driver.findElement(By.id("accept-cookies")); // nájdenie "OK" cookies button
            cookiesButton.click();  // kliknutie naň
            Thread.sleep(200);
            driver.findElement(By.id("login")).click();
            Thread.sleep(200);
            driver.findElement(By.id("login")).sendKeys("182310"); //zadanie loginu
            Thread.sleep(200);
            driver.findElement(By.id("heslo")).sendKeys("9702022737"); //zadanie hesla
            Thread.sleep(200);
            driver.findElement(By.id("login-form-submit-btn")).click(); //kliknutie na prihlásenie
            Thread.sleep(1500);
            driver.findElement(By.cssSelector("div > a")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".card-header > .ais-color")).click(); //otvorenie rozvrhu
            Thread.sleep(1500);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Uloženie súboru
            FileUtils.copyFile(screenshot, new File("screenshot.png"));

            Thread.sleep(1500);

            driver.findElement(By.cssSelector(".d-none > .app-logo")).click(); //ísť späť
            Thread.sleep(500);
            driver.findElement(By.cssSelector(".d-none > .app-logo")).click(); //ísť späť
            Thread.sleep(500);
            driver.findElement(By.cssSelector(".button")).click(); //odhlásenie
            Thread.sleep(500);

            driver.close();

        }  catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        driver.quit(); //zatvorenie prehliadača
    }
}