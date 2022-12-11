package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class p04_SelectTag {
    public WebElement get_niceTag(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/div[3]/div[2]/div[1]/ul/li[13]/a"));
    }

    public WebElement get_awesomeTag(){
        return  Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/div[3]/div[2]/div[1]/ul/li[2]/a"));
    }

    public void clickOnTag(String tagName){
        if(tagName.contains("nice")){
            get_niceTag().click();
        }else{
            get_awesomeTag().click();
        }
    }
}
