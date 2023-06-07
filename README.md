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
- **HomePage** - Represents the home page of the e-commerce website.
- **CartPage** - Represents the cart page of the e-commerce website.
- **CheckoutPage** - Represents the checkout page of the e-commerce website.
- **ProductPage** - Represents a product page of the e-commerce website.
- **SignUpPage** - Represents the sign-up page of the e-commerce website.
# Running the Tests  
To run the tests, follow these steps:  

- Make sure you have Java and Selenium WebDriver set up on your machine.  
- Clone this repository to your local machine.  
- Open the project in your preferred Java IDE.  
- Find the file testNg.xml in the shared folder.   
- Run the testNG.xml file using your IDE or the command line.
- The testNG.xml file is used to configure and execute the test suite. It specifies the test classes and test methods to run, as well as any test parameters.  

# Test Results
After running the tests, you will see the test results in the console output of your IDE. Additionally, screenshots of the test results can be found in the screenshots directory.
![Image alt](https://github.com/bproskura/Java-Selenium-Task/main/Testresult.png)
![Image alt](https://github.com/{username}/{repository}/raw/{branch}/{path}/image.png)

# Repository Structure
**'src'** folder: Contains the source code for the test suite.  
**'screenshots'** folder: Contains screenshots of the test results.  
**'README.md'** file: Provides an overview of the tasks implemented, description of the POM classes, and instructions on how to run the tests.  
If you have any questions or issues, please feel free to open an issue in the GitHub repository.
