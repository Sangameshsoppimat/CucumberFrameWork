Feature: Orders

Background: These are common methods for each scenario
Given user lounch chrome browser
Then user open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enters username as "admin@yourstore.com" and password as "admin"
And click on login button

Scenario: click on view button based on order status
And user click on sales menu item 
And user click on orders menu 
Then user be navigated orders page and verify orders page
And user click on view button based on order status 