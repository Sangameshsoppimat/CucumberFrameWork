package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage 
{
	WebDriver driver;
	
	public SearchCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement searchemail;
	
	@FindBy(xpath="//input[@id='SearchFirstName']")
	WebElement searchfname;
	
	@FindBy(xpath="//input[@id='SearchLastName']")
	WebElement searchLname;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='dataTables_scroll']")
	WebElement table;
	
	@FindBy(xpath="//div[@class='dataTables_scroll']//tbody//tr")
	List<WebElement> tablerow;
	
	@FindBy(xpath="//div[@class='dataTables_scroll']//tbody//td")
	List<WebElement>  tablecolumn;
	
	public void setsearchemail(String email)
	{
		searchemail.sendKeys(email);
	}
	public void setsearchfname(String fistnme)
	{
		searchfname.sendKeys(fistnme);
	}
	public void setsearchLname(String lastnme)
	{
		searchLname.sendKeys(lastnme);
	}
	public void clicsearchButton()
	{
		searchButton.click();
	}
	
	public int getrownum()
	{
		return tablerow.size();
	}
	
	public int getcolnum()
	{
		return tablecolumn.size();
	}
	
	public boolean seacrchCustomerList(String email)
	{
		boolean flag=false;
		
		for(int i=1;i<=getrownum();i++)
		{
			String emailid = driver.findElement(By.xpath("//div[@class='dataTables_scroll']//tbody//tr["+i+"]//td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equalsIgnoreCase(email))
			{
				flag=true;
			}
		}
		return flag;
		
	}
	
	public boolean SerchcustomerListfnamelname(String custname)
	{
		boolean flag = false;
		for(int i=1;i<getrownum();i++)
		{
			String name = driver.findElement(By.xpath("//div[@class='dataTables_scroll']//tbody//tr["+i+"]//td[3]")).getText();
			String[] names = name.split("");
			if(names[0].equalsIgnoreCase("James")&&names[1].equalsIgnoreCase("Pan"))
			{
				flag=true;
			}
		}
		return flag;
		
	}
	
	
	
}
