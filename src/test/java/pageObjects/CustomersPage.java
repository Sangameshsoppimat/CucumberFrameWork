package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage 
{
	public WebDriver driver;	
	public CustomersPage(WebDriver sdriver)
	{
		this.driver=sdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement cutomersMenuItem;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	private WebElement cutomersOption;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
	private WebElement addNewButton;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement pass;
	
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement fname;
	
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement lname;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	private WebElement malegender;
	
	@FindBy(xpath="//input[@id='Gender_Female']")
	private WebElement Femalegender;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	private WebElement dob;
	
	@FindBy(xpath="//input[@id='Company']")
	private WebElement compName;
	
	@FindBy(xpath="//button[@name='save']")
	private WebElement saveButton;
	
	
	@FindBy(xpath="//input[@aria-controls='select2-SelectedCustomerRoleIds-results']")
	private WebElement roles;
	
	@FindBy(xpath="//li[@title='Administrators']")
	private WebElement Adminstratorrole;
	@FindBy(xpath="//li[@title='Registered']")
	private WebElement Registeredrole;
	@FindBy(xpath="//li[@title='Guests']")
	private WebElement Guestsrole;
	@FindBy(xpath="//li[@title='Forum Moderators']")
	private WebElement ForumModeratorsrole;
	@FindBy(xpath="//li[@title='Vendors']")
	private WebElement Vendorsrole;
	
	
	public void roles(String custroles)
	{
		if(custroles.equalsIgnoreCase("Administrators"))
		{
			Adminstratorrole.click();
		}
		else if(custroles.equalsIgnoreCase("Registered"))
		{
			Registeredrole.click();
		}
		else if(custroles.equalsIgnoreCase("Guests"))
		{
			Guestsrole.click();
		}
		else if(custroles.equalsIgnoreCase("Forum Moderators"))
		{
			ForumModeratorsrole.click();
		}
		else
		{
			Vendorsrole.click();
		}
		
	}
	
	public String getaddcustomerpagetitle()
	{
		return driver.getTitle();
	}
	
	public void clickcutomersMenuItem (){
		cutomersMenuItem.click();
	}
public void cutomersOption(){
	cutomersOption.click();
	}
public void clickaddNewButton(){
	addNewButton.click();
}
public void enteremail(String customermail){
	email.sendKeys(customermail);;
}
public void enterpass(String customerpass){
	pass.sendKeys(customerpass);
}
public void enterfname(String customername){
	fname.sendKeys(customername);
}
public void enterlname(String customerlname) {
	lname.sendKeys(customerlname);
}
public void clickgender(String gender){
	if(gender.equals("Male"))
	{
		malegender.click();
	}
	else if(gender.equals("Female"))
	{
		Femalegender.click();
	}
	else
	{
		malegender.click();
	}
}
public void enterdob(String dateofbirth){
	dob.sendKeys(dateofbirth);
}
public void entercompName(String companyname) {
	compName.sendKeys(companyname);
}
public void clicksaveButton()
{
	saveButton.click();
}
}
