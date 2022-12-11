package org.example.pages;


import io.cucumber.plugin.event.Node;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class P03_homePage {

    SoftAssert soft = new SoftAssert();

    public void check_products_price_symbol(String symbol) throws InterruptedException {
        int count = 0;
        int productWithEuroSign = 4;
        List<WebElement> listOfCategories = Hooks.driver.findElements(By.className("item-box"));


//        for (WebElement webElement: listOfCategories) {
//            if (webElement.getText().contains(symbol)) {
//            }
//        }
        for (int i = 0; i < listOfCategories.size(); i++) {
            if (listOfCategories.get(i).getText().contains(symbol)) {
                count++;
            }
        }
        soft.assertEquals(productWithEuroSign, count);
        soft.assertAll();
    }

    public WebElement getCurrencyList() {

        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    public void selectCurrency(String currencyName) throws InterruptedException {
        Select dropCurr = new Select(getCurrencyList());
        dropCurr.selectByVisibleText(currencyName);
        Thread.sleep(3000);

    }

    //////////////////////////////////////////////////search by name//////////////////
    public WebElement get_searchElement() {

        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public void setSearchWord(String word) {
        get_searchElement().sendKeys(word);
    }

    public WebElement getSearchBtn() {
        return Hooks.driver.findElement(By.cssSelector("form > button[type=\"submit\"]"));
    }

    public void clickSearch() {
        getSearchBtn().click();

    }

    public List<WebElement> getResult() {
        return Hooks.driver.findElements(By.className("product-title"));
    }

    public String getCurrentURL() {
        return Hooks.driver.getCurrentUrl();
    }

    public void resultSearch(String word) {

        int countResults = 0;
        for (int i = 0; i < getResult().size(); i++) {
            if (getResult().get(i).getText().toLowerCase().contains(word)) {
                countResults++;

            }
        }
        String acualURL = "https://demo.nopcommerce.com/search?q=";
        soft.assertTrue(getCurrentURL().contains(acualURL));
        soft.assertEquals(countResults, getResult().size());

        soft.assertAll();
    }

    //////////////////// search by sku/////////////////////////////

    public WebElement getImageLink() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"picture\"] > a"));
    }

    public void clickImageLink() {
        getImageLink().click();
    }

    public WebElement getResultSku() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"] > span[class=\"value\"]"));
    }

    public void checkResultSku(String Sku) {
        String acualSku = Sku;
        String expectedSku = getResultSku().getText();
        soft.assertTrue(expectedSku.contains(acualSku));
    }
///////////////////////////////////////////////////////follow us////////////////////////

    public WebElement getFacebook() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement getTwitter() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }

    public WebElement getRss() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }

    public WebElement getYoutube() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    public void clickOnFacebook() {
        getFacebook().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void clickOnTwitter() {
        getTwitter().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void clickOnRss() {
        getRss().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    }

    public void clickOnYoutube() {
        getYoutube().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void validateURL(String expectedURL) {
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));

        soft.assertTrue(getCurrentURL().contains(expectedURL));

    }

    ////////////////////////////////////////////////////wishlist/////////////////////////
    public List<WebElement> getwishlistbtns() {
        return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    public void clickOnWishlistBtn() {
        getwishlistbtns().get(2).click();
    }

    public WebElement get_addToWishlistBtn() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public void clickOnAddToWishListBtn() {
        get_addToWishlistBtn().click();

    }

    public WebElement getMsg() {

        return Hooks.driver.findElement(By.linkText("wishlist"));
    }

    public WebElement get_Msg() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public void validateAddToWishList() {
        boolean Msg = getMsg().isDisplayed();
        soft.assertTrue(Msg);
        String acualBackgroundColorMsg = "#4bb07a";
        String BackgroundColor = get_Msg().getCssValue("background-color");
        String expectedBackgroundColorMsg = Color.fromString(BackgroundColor).asHex();
        soft.assertEquals(expectedBackgroundColorMsg, acualBackgroundColorMsg);
        soft.assertAll();
    }

    public WebElement getWishListBtn() {
        return Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]"));
    }

    public WebElement closeWishListMsgBtn() {
        return Hooks.driver.findElement(By.cssSelector("span[class=\"close\"]"));
    }

    public void disappeardMsg() throws InterruptedException {

        //closeWishListMsgBtn().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(getWishListBtn()));
        wait.until(ExpectedConditions.invisibilityOf(get_Msg()));
        getWishListBtn().click();
    }

    public WebElement getQuantity() {
        return Hooks.driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
    }

    public void verifyQuatity() {
        int qty = Integer.parseInt(getQuantity().getAttribute("value"));

        soft.assertTrue(qty > 0);
    }

    ///////////////////////////////////////home slider//////////////////////////////////
    public WebElement getClickNokiaSlider() {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[1]"));
    }

    public void clickOnNokiaSlider() {
        getClickNokiaSlider().click();
    }

    public WebElement getClickIphoneSlider() {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[2]"));
    }

    public void clickOnIphoneSlider() {
        getClickIphoneSlider().click();
    }

    public void validateUrl(String url) {


        soft.assertTrue(getCurrentURL().contains(url));
        // soft.assertEquals(getCurrentURL(),url);
        soft.assertAll();
    }


    //////////////////////////////////////////////hover category///////////
    public List<WebElement>mainCategories(){
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }
    Actions actions = new Actions(Hooks.driver);
    int count = mainCategories().size();
    int min = 0;
    int max = count - 1;
    int selectedCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
    public void hoverRandomCategory() throws InterruptedException {
        actions.moveToElement(mainCategories().get(selectedCategory)).perform();
        String selectedCategoryText = mainCategories().get(selectedCategory).getText();
        System.out.println("to know which category is selected:   " + selectedCategoryText);
        Thread.sleep(2000);
    }
public WebElement getPgeTitle(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1"));
}
    public void findelements() throws InterruptedException {

        selectedCategory = selectedCategory + 1;
        String locator = "(//ul[@class=\"top-menu notmobile\"]//ul)[" + selectedCategory + "]/li";
        List<WebElement> subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String selectedSubCategoryText;
        if (!subCategoryLinks.isEmpty()) {
            int subCategoryCount = subCategoryLinks.size();
            int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();

            subCategoryLinks.get(selectedSubCategory).click();
            String acualtitle=subCategoryLinks.get(0).getText().toLowerCase().trim();
           soft.assertEquals(getPgeTitle().getText().toLowerCase().trim(),acualtitle);

           soft.assertAll();
            //System.out.println(getPgeTitle());
        } else {
            mainCategories().get(selectedCategory).click();

        }

        // reset it to the initial value
       Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}