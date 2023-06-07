# Java-Selenium-Task
This project contains an Automated Test Suite for testing an e-commerce website using Selenium WebDriver and Java. The test cases are implemented using the Page Object Model (POM) design pattern.

# Tasks Implemented
## Test Cases  
Verify user registration and login.  
Verify product search functionality.  
Verify add-to-cart functionality.  
Verify the checkout process.  
# POM Classes 
The following POM classes have been created:  

- **BaseTest** - Contains common setup and teardown methods for test cases.
- **BasePage** - Contains common methods and elements for all page classes.
- **HomePage** - Contains common methods and elements for Home page classes.
- **CartPage** - Contains common methods and elements for Cart page classes.
- **CheckoutPage** - Contains common methods and elements for Checkout page classes.
- **ProductPage** - Contains common methods and elements for Product page classes.
- **SignUpPage** - Contains common methods and elements for Sign Up page classes.

# Running the Tests  
To run the tests, follow these steps:  

- Make sure you have Java and Selenium WebDriver set up on your machine.  
- Clone this repository to your local machine.  
- Open the project in your preferred Java IDE.  
- Find the file testNg.xml in the shared folder.   
- Run the testNG.xml file using your IDE or the command line.
- The testNG.xml file is used to configure and execute the test suite. It specifies the test classes and test methods to run, as well as any test parameters.  

# Test Results
After running the tests, you will see the test results in the console output of your IDE. In addition, screenshots of the test results are shown below.  

![Image alt](https://github.com/bproskura/Java-Selenium-Task/raw/main/Testresult.png)


# Repository Structure
**'src'** folder: Contains the source code for the test suite.    
**'README.md'** file: Provides an overview of the tasks implemented, description of the POM classes, and instructions on how to run the tests. 
