package com.gittigidiyor.test;

import com.gittigidiyor.Pages.ComputerPage;
import com.gittigidiyor.Pages.HomePage;
import com.gittigidiyor.Pages.SearchPage;
import com.gittigidiyor.utilities.BrowserUtils;
import com.gittigidiyor.utilities.ConfigurationReader;
import com.gittigidiyor.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestClass {

   @Test
    public void test1() throws InterruptedException {

       Driver.get().manage().window().maximize();
       Driver.get().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       Driver.get().get(ConfigurationReader.get("url"));

       HomePage homePage = new HomePage();

       homePage.searchBox.sendKeys("Bilgisayar");
       homePage.searchButton.click();

       SearchPage searchPage = new SearchPage();
       BrowserUtils.scrollToElement(searchPage.pageNumber(2));
       Thread.sleep(2000);
       searchPage.pageNumber(2).click();
       String expectedPageNumber = "https://www.gittigidiyor.com/arama?k=Bilgisayar&sf=2";
       String actualPageNumber = Driver.get().getCurrentUrl();
       Assert.assertEquals(expectedPageNumber,actualPageNumber);

       BrowserUtils.scrollToElement(searchPage.computer);
       searchPage.computer.click();
       ComputerPage computerPage = new ComputerPage();
       String actualPrice = computerPage.price.getText();
       BrowserUtils.clickWithJS(computerPage.basket);

       computerPage.goToBasket.click();
       String expectedPrice = computerPage.basketPrice.getText();
       Assert.assertEquals(actualPrice,expectedPrice);

      Select select = new Select(computerPage.amount);

      select.selectByIndex(1);

      String actualOption = select.getFirstSelectedOption().getText();
      String expectedOption= "2";

      Assert.assertEquals(actualOption,expectedOption);

      Thread.sleep(3000);

      computerPage.deleteIcon.click();

      BrowserUtils.waitForVisibility(computerPage.noItem,10);

      String expectedText = "Sepetinizde ürün bulunmamaktadır.";
      String actualText = computerPage.noItem.getText();

      Assert.assertEquals(expectedText,actualText);



   }
}
