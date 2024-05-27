package stepDefintions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps 
{
	public WebDriver driver;
	public LoginPage lp;
	public CustomersPage cp;
	public SearchCustomerPage sc;
	public Properties conprop;
	
	@Before
	public void setup() throws IOException
	{
		conprop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\sande\\eclipse-workspace\\CucumberPracticeYTpavan\\Config.proprties");
		conprop.load(fis);
		
		String desireBrowser = conprop.getProperty("browser");
		if(desireBrowser.equalsIgnoreCase("Chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			    driver=new ChromeDriver();
		}
		else if(desireBrowser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.chromedriver().setup();
		    driver=new FirefoxDriver();
		}
		 	driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Given("user lounch chrome browser")
	public void user_lounch_chrome_browser() {
	   System.out.println("browser Loaunched");
	}

	@Then("user open URL {string}")
	public void user_open_url(String URL) 
	{
		driver.get(URL);
	 
	}

	@Then("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		lp=new LoginPage(driver);
		lp.enterUname(username);
		lp.enterPassword(password);
	}
	
	@When("User enters valid username as {string} and password as {string}")
	public void user_enters_valid_username_as_and_password_as(String emails, String passwords) {
		lp=new LoginPage(driver);
		lp.enterUname(emails);
		lp.enterPassword(passwords);
	}
	@When("click on login button")
	public void click_on_login_button() {
		lp.clickLoginbutton();
	}

	@Then("user click on Customer menu item")
	public void user_click_on_customer_menu_item() 
	{
		cp=new CustomersPage(driver);
		cp.clickcutomersMenuItem();
	  
	}

	@Then("user click on customer menu")
	public void user_click_on_customer_menu() 
	{
		cp=new CustomersPage(driver);
		cp.cutomersOption();
	   
	}

	@Then("user click on Add new button")
	public void user_click_on_add_new_button() 
	{
		cp=new CustomersPage(driver);
		cp.clickaddNewButton();
	    
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() 
	{
		Assert.assertEquals("Add a new customer / nopCommerce administration", cp.getaddcustomerpagetitle());
	   
	}

	@Then("user enters customer info")
	public void user_enters_customer_info() throws InterruptedException 
	{
		cp=new CustomersPage(driver);
		String custemail = RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
		cp.enteremail(custemail);
		cp.enterpass("San@123");
		cp.enterfname("Sanman");
		cp.enterlname("panman");
		cp.clickgender("Mail");
		cp.enterdob("1/08/1998");
		cp.entercompName("Qatesting");
		cp.roles("Registered");
		Thread.sleep(3000);
		
		
	}

	@Then("user click on save button")
	public void user_click_on_save_button() 
	{
		cp=new CustomersPage(driver);
		cp.clicksaveButton();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg)
	{
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	  
	}
	
	//Search customer by Email
	@When("user enter customerEmail")
	public void user_enter_customer_email() 
	{
		sc=new SearchCustomerPage(driver);
		sc.setsearchemail("james_pan@nopCommerce.com");
	    
	}
	@When("user click on Search button")
	public void user_click_on_search_button() throws InterruptedException 
	{
	   sc.clicsearchButton();
	   Thread.sleep(3000);
	}
	@Then("user should find customer info in search list")
	public void user_should_find_customer_info_in_search_list() 
	{
	    boolean emailstatus = sc.seacrchCustomerList("james_pan@nopCommerce.com");
	    Assert.assertEquals(true, emailstatus);
	}
	
	@When("user enter Firstname")
	public void user_enter_firstname() {
		sc=new SearchCustomerPage(driver);
	    sc.setsearchfname("James");
	}
	@When("user enter Lastname")
	public void user_enter_lastname() {
		
	  sc.setsearchLname("Pan");
	}
	@Then("user should find customer name info in search list")
	public void user_should_find_customer_name_info_in_search_list() {
	    boolean fnamelnamestatu = sc.SerchcustomerListfnamelname("JamesPan");
	    Assert.assertEquals(true, fnamelnamestatu);
	}

	@Then("close browser")
	public void close_browser() 
	{
		driver.close();
	   
	}
	
	
}
