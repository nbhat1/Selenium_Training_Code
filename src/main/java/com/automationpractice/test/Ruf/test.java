package com.automationpractice.test.Ruf;

import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

/**
 * Created by neeraj.bhatnagar on 11/28/2016.
 */
public class test {

    static WebDriver driver;

@Test

    public static void mouseHover() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\GecoDriver\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.get( "http://automationpractice.com/index.php" );
        WebElement element = driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a"));
        System.out.println("Tool tip text on Women is " + element.getText());
        Thread.sleep( 5000 );
        Actions actions = new Actions( driver );
        Thread.sleep(5000);
        actions.moveToElement(element).perform();
        WebElement toolTipText = driver.findElement(By.xpath( ".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a" ));
        System.out.println(toolTipText);

    }

    @Test
    public static void selectItem() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\GecoDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get( "http://automationpractice.com/index.php" );
         driver.findElement( By.xpath( ".//*[@id='block_top_menu']/ul/li[1]/a" ) ).click();
        Thread.sleep( 10000 );
        driver.findElement(By.xpath( ".//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[2]/span" ) ).click();
        driver.findElement( By.xpath( ".//*[@id='wishlist_button']" ) ).click();
        Thread.sleep( 2000 );
        String text = driver.findElement( By.xpath( ".//*[@id='product']/div[3]/div/div/div/div/p" ) ).getText();
        driver.findElement( By.xpath( ".//*[@id='product']/div[3]/div/div/a" ) );





    }

}
