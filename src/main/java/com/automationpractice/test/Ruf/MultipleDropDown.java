package com.automationpractice.test.Ruf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by neeraj.bhatnagar on 12/30/2016.
 */
public class MultipleDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\GecoDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.wikipedia.org");

        Select select = new Select(driver.findElement(By.xpath(".//*[@id='searchLanguage']")));
        System.out.println("************************Printing All Dropdown values****************************************");
          /*List<WebElement> options = driver.findElements(By.tagName("option"));
        System.out.println("Size of list is" + "" + options.size()+ "" + "Elements");
        for(int i = 0; i<options.size(); i++) {
            System.out.println(options.get(i).getText());
            System.out.println(options.get(i).getAttribute("value"));
        }*/

            System.out.println("****************************Print All links on page*************************************");

            List<WebElement> links = driver.findElements(By.tagName("a"));

            for (int j=0;j<links.size();j++){
                System.out.println(links.get(j).getAttribute("href"));
                System.out.println(links.get(j).getText());
            }
        System.out.println("*********************Total Links are**************** " + "" + links.size());

        /*System.out.println("*********************************Print links from a block on webpage****************************");
        List<WebElement> block = driver.findElements(By.xpath("./*//*[@class='footer-sidebar-text']/ul"));
        System.out.println(block.size());
        for (int k=0; k<block.size();k++){
            System.out.println(block.get(k).getAttribute("href"));
            System.out.println(block.get(k).getText());
        }
        System.out.println("Total Links in block :" + "" + block.size());
*/
        //driver.quit();
    }
    }

