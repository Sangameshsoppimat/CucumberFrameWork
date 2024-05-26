Feature: Login

Scenario: Succesfull Login with valid credentials
Given User succesfully lounch browser
When user open URL "https://demo.opencart.com/admin/"
And User enters valid username as "demo" and password as "demo"
And click on login button
Then user should be landed on dashboard page and page tiltle should be "Dashboard"
And user click on logout button
Then page title should be "OpenCart"


Scenario Outline: Succesfull Login with multiple credentials

Given User succesfully lounch browser
When user open URL "https://demo.opencart.com/admin/"
And User enters valid username as "<emails>" and password as "<passwords>"
And click on login button
Then user should be landed on dashboard page and page tiltle should be "Dashboard"
And user click on logout button
Then page title should be "OpenCart"

Examples:
					| emails  |  passwords|
					|demo			|demo|
					|demo@gmail.com	|demo@123|