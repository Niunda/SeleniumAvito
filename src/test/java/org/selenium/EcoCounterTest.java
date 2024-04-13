package org.selenium;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;


public class EcoCounterTest {
    public static File captureEcoCounterElementScreen(WebDriver driver) {
        WebElement element = driver.findElement(By.className("desktop-wrapper-OutiE"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element.getScreenshotAs(OutputType.FILE);
    }
    @Test
    public void ecoCounterChrome1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/avito-care/eco-impact");
        driver.manage().window().maximize();
        try {
            FileUtils.copyFile(captureEcoCounterElementScreen(driver), new File("output\\EcoCounterChrome1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void ecoCounterChrome2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/avito-care/eco-impact");
        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.className("desktop-value-Nd1tR"));
        List<WebElement> styleElements = driver.findElements(By.cssSelector(".desktop-disabled-kdOve"));
        for (int i = 0; i < 3; i ++) {
            Integer num = (int) (10 + Math.random() * 90);
            ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = " + num, elements.get(i));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.opacity = 'unset'", styleElements.get(i));
        }
        try {
            FileUtils.copyFile(captureEcoCounterElementScreen(driver), new File("output\\EcoCounterChrome2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void ecoCounterChrome3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/avito-care/eco-impact");
        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.className("desktop-value-Nd1tR"));
        List<WebElement> styleElements = driver.findElements(By.cssSelector(".desktop-disabled-kdOve"));
        for (int i = 0; i < 3; i ++) {
            Integer num = (int) (100 + Math.random() * 900);
            ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = " + num, elements.get(i));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.opacity = 'unset'", styleElements.get(i));
        }
        elements = driver.findElements(By.className("desktop-unit-puWVS"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = 'тонн CO₂'", elements.get(0));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = 'м³ воды'", elements.get(1));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = 'МВт⋅ч энергии'", elements.get(2));
        try {
            FileUtils.copyFile(captureEcoCounterElementScreen(driver), new File("output\\EcoCounterChrome3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
