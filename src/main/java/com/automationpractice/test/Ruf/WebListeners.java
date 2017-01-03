package com.automationpractice.test.Ruf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Created by neeraj.bhatnagar on 1/3/2017.
 */
public class WebListeners extends AbstractWebDriverEventListener {

    public void afterClickOn(WebElement element, WebDriver driver){
        System.out.println("Object clicked");
    }


}
