1. Java - Programming Language for the testing framework
2. Maven - Build and Dependency Management tool
    - Cucumber: Testing tool to create and implement a test framework that supports Behavioral Driven Development
      with the help of Gherkin language which is easy to be understood by ordinary users, customers etc.
      Gherkin is used in Feature files.
    - Selenium Library: This Library contains Selenium WebDriver and methods and waits in Web UI automation
    - WebDriverManager: This allows compatible webdrivers to be setup in the local machine easier
    - Junit: Normally a unit test framework but it allows us to create various test methods and write assertions
      in our framework
3. Plugins in pom.xml:
    - Maven Surefire: This plugin helps us to build and run our test suites/cases via Maven lifecycle
    - Maven Cucumber Reporting: This plugin helps us to create fancy reports for our test suites/cases as well.
4. Page Object Model (POM):
    - Design pattern for Ui Testing that aims to group web elements and methods for each page in separate Java classes.
    - PageFactory.initElements method is used in class constructor to initialize all web elements once they are invoked.
5. Runners package:
    - CukesRunner class: In this class, I use some Cucumber tools to define this class as a test runner with some
      configurations like which tags in feature files to be run, dryRun or not. Also, I make a connection between
      feature files and step definitions (test scripts) in separate java classes belongs to that feature files
      in accordance with Page Object Model.
    - FailedTestRunner class: This class is structured similar to CukesRunner class and it runs only test
      scenarios failed after CukesRunner class is run.
6. StepDefinitions package:
    - The classes in this package is run by classes in runners package
    - Hooks class : This class contains Before and After methods that will be run before and after all test methods such
      as when maximizing browser window, defining implicit wait, taking screen shot if scenario is failed and its timeout or quitting webdriver after all tests are done.
7. Utilities package:
    - ConfigurationReader: With help of the get method in this class, for example we get the browser type
      from one center and use it in our Driver class to create an instance of Selenium WebDriver.
    - Driver: I create a Singleton WebDriver by using get method in this class.
8. Parallel Execution:
    - To run the scenarios parallel, switch branch master to "parallel".
    - How many browsers will be opened? It depends based on number of feature file.
   
Filtering The Test From The Maven cmd:   
mvn verify -Dcucumber.filter.tags=@yourTagHere

Next Possible Steps For Improvements:   
We can add browser actions based on needs such as scroll down, hover over etc.