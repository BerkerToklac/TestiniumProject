package com.gittigidiyor.Pages;

import com.gittigidiyor.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@name='k']")
    public WebElement searchBox;

    @FindBy(xpath = "//span[.='BUL']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[.='Kapat']")
    public WebElement cookies;
}
