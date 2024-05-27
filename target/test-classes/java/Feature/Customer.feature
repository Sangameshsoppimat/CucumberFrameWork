Feature: Customer

Background: These are common methods for each scenario
Given user lounch chrome browser
Then user open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enters username as "admin@yourstore.com" and password as "admin"
And click on login button
And user click on Customer menu item
And user click on customer menu


Scenario: Add a new customer
And user click on Add new button
Then user can view add new customer page
And user enters customer info
And user click on save button
Then user can view confirmation message "The new customer has been added successfully."
And close browser


Scenario: Search customer by Email
When user enter customerEmail
And user click on Search button
Then user should find customer info in search list
And close browser


Scenario: Search customer by Firstname and Lastname
When user enter Firstname
When user enter Lastname
And user click on Search button
Then user should find customer name info in search list
And close browser