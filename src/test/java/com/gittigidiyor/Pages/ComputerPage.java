package com.gittigidiyor.Pages;

import com.gittigidiyor.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage extends BasePage{
    public ComputerPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//div[@class='gg-w-24 gg-t-24 gg-m-24 product-price-info-con']//div[@id='sp-price-lowPrice']")
    public WebElement price;

    @FindBy(xpath = "//button[@id='add-to-basket']")
    public WebElement basket;

    @FindBy(xpath = "//strong[.='3.599,00 TL']")
    public WebElement basketPrice;

    @FindBy(xpath = "//a[.='Sepete Git']")
    public WebElement goToBasket;

    @FindBy(xpath = "//select[@class='amount']")
    public WebElement amount;

    @FindBy(xpath = "//div[@class='gg-d-24 hidden-m update-buttons-container']//i[@class='gg-icon gg-icon-bin-medium']")
    public WebElement deleteIcon;

    @FindBy(xpath = "//h2[.='Sepetinizde ürün bulunmamaktadır.']")
    public WebElement noItem;
}
