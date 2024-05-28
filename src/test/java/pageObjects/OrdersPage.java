package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage 
{
	public WebDriver driver;	
	public OrdersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[normalize-space()='Sales']")
	 WebElement salesMenu;
	
	@FindBy(xpath="//p[normalize-space()='Orders']")
	 WebElement Orders;
	
	@FindBy(xpath="//div[@class='col-md-12']//table")
	WebElement table;
	
	@FindBy(xpath="//div[@class='col-md-12']//table//tbody//tr//td[3]")
	List<WebElement> orderStatus;
	
	
	
	public void clickOnsalesMenu()
	{
		salesMenu.click();
	}
	public void clickOnOrders()
	{
		Orders.click();
	}
	
	public void clickOnview(String orderstatuspass )
	{
		driver.findElement(By.xpath("//td[text()='"+orderstatuspass+"']//following-sibling::td//a")).click();
		
	}

}




//p[normalize-space()='Sales']
//p[normalize-space()='Orders']