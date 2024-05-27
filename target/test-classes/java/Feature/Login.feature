Feature: Login

Background: These are common methods for each scenario
Given user lounch chrome browser
Then user open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"

Scenario: Succesfull Login with valid credentials
And user enters username as "admin@yourstore.com" and password as "admin"
And click on login button
And close browser



Scenario Outline: Succesfull Login with multiple credentials
And User enters valid username as "<emails>" and password as "<passwords>"
And click on login button
And close browser


Examples:
					| emails  |  passwords|
					|demo			|demo|
					|admin@yourstore.com|admin|
					
					
					
			