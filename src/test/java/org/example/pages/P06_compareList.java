package org.example.pages;

import org.example.stepDefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P06_compareList {
    public WebElement get_addToComparelistBtn(){
         return Hooks.driver.findElement(By.xpath("//div[@class=\"compare-products\"]//button[@type=\"button\"]"));
    }
    public void clickOnAddToComparelist(){
        get_addToComparelistBtn().click();
    }
   public List<WebElement> rowElements(){
       return  Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr"));
    }
    public  List<WebElement> colElements(){
        return Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td"));
    }
    public void validateProductAddedToComparelist(String Name) throws InterruptedException {
        Assert.assertTrue(Hooks.driver.findElement(By.xpath("//p//a[@href=\"/compareproducts\"]")).getText().contains("product comparison"));
        Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[2]/ul/li[5]/a")).click();
        Thread.sleep(3000);
        int rowsCount=rowElements().size();
        int colCount=colElements().size();

for(int i=1; i<=colCount; i++){
            String productName=Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td["+i+"]")).getText();
            if(productName.contains(Name)){
                Assert.assertTrue(productName.contains(Name));
                System.out.println(productName);
            }
        }
    }
}
