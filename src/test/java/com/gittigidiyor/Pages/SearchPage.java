package com.gittigidiyor.Pages;

import com.gittigidiyor.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public WebElement pageNumber(int number){
String xpath = "//span[.='"+number+"']";
return Driver.get().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//h2[contains(.,'Lenovo IdeaCentre 3 Intel Core i3 10100 4GB 256GB SSD Freedos Masaüstü Bilgisaya')]")
    public WebElement computer;
}
