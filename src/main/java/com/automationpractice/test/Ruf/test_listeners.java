package com.automationpractice.test.Ruf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by neeraj.bhatnagar on 1/3/2017.
 */
public class test_listeners {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\GecoDriver\\geckodriver.exe");
        WebDriver webdriver = new FirefoxDriver();
        webdriver.manage().window().maximize();

        EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
        WebListeners listeners = new WebListeners();
        driver.register(listeners);

    }
}
