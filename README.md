

# API Automation Project

Welcome to the Selenium Automation Framework repository! This guide will walk you through the process of setting up a new Selenium framework project from scratch using Maven, including dependency management, and project configuration.


## Table of content
- Description
- Prerequisites 
- Setting Up the Environment 
- Creating the Maven Project 
- Adding Maven Dependencies 
- Project Structure 
- Writing Test Case
  - API Test Case
- Creating TestNG XML File
- Running Tests
- Checking Test Reports
- Importing Postman Collection

## Description
Project Overview: This project focuses on automating API testing using RestAssured, a powerful Java library for RESTful API testing, Java for scripting, and TestNG for test management, this framework aims to provide a robust solution for validating API endpoints, ensuring they meet functional requirements. The project is designed to streamline the testing process and improve test coverage.

Tools and Technologies:

1. RestAssured: A Java library used for simplifying API testing. It provides a fluent interface for sending HTTP requests, validating responses, and handling various API scenarios.
2. Java: The programming language used to write the test scripts and integrate with RestAssured and TestNG.
3. TestNG: The testing framework used for managing, executing, and reporting test cases, providing support for test grouping and configuration.

## Prerequisites
Before you start, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Maven 3.6 or higher
- Eclipse IDE for Java Developers
## Setting Up the Environment

**1. Install Java 8**
Download and install the Java JDK 8 from the official Oracle website or use an OpenJDK version.

**2. Install Eclipse IDE**
Download and install Eclipse IDE from the official Eclipse website. Choose the "Eclipse IDE for Java Developers" package.
    
## Creating the Maven Project
  1. Open Eclipse IDE.

  2. Create a New Maven Project:

- Go to File > New > Other....
- Select Maven > Maven Project and click Next.
- Check Create a simple project (skip archetype selection) and click Next.
- Enter Group ID (e.g., com.Automation), Artifact ID (e.g., APIautomation), and Version (e.g., 1.0-SNAPSHOT).
- Click Finish.
## Adding Maven Dependencies
1. Open pom.xml located in the root directory of your Maven project.

2. Add the following dependencies inside the <dependencies> tag:
   
  <>
    
    <dependencies>
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.7.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>json-schema-validator</artifactId>
    <version>5.5.0</version>
    </dependency>
    <!-- Apache Commons IO -->
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.11.0</version>
    </dependency>

    <!-- Rest Assured for API Testing -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.1</version>
        <scope>test</scope>
    </dependency>

    <!-- Hamcrest for assertions in Rest Assured -->
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-library</artifactId>
        <version>2.2</version>
        <scope>test</scope>
    </dependency>
    </dependencies>
3. Save the pom.xml file and update the Maven project by right-clicking on the project in Eclipse and selecting Maven > Update Project.
## Project Structure
The Maven project structure will look like this:

    selenium-automation/
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── com/
    │   │           └── example/
    │   │               └── utils/
    │   ├── test/
    │   │   └── java/
    │   │       └── com/
    │   │           └── example/
    │   │               └── test/
    │   │              
    │   └── resources/
    ├── pom.xml
    └── .project

- com.automation.Tests: Contains API-related test classes.

## Writing Test Cases
## API Test Case
1. Create a Java class in the com.Automations.Tests package named Apiautomation.java.

2. Add the following code for API testing:
    package com.Automations.Tests;
    import static io.restassured.RestAssured.given;
    import java.io.File;
    import java.io.IOException;

    import org.apache.commons.io.FileUtils;
    import org.testng.annotations.Test;

    import io.restassured.RestAssured;
    import io.restassured.module.jsv.JsonSchemaValidator;

        public class APIautomation {

	    @Test
	    public void getMethod() throws IOException {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		// check for 200 Ok status code and json schema structure
		//to check json schema structure here I have used JsonschemaValidator maven dependency 
		given().log().all().when().get("posts").then().assertThat().statusCode(200)
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));

	    }
       }

## Creating TestNG XML File
1. Create a TestNG XML file named testng.xml in the root directory of your project.

2. Add the following configuration:
    
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
        <suite name="Suite">
        <test thread-count="5" name="Test">
        <classes>
        <class name="com.APIAutomation.Tests.APIautomation"/>
        </classes>
        </test> <!-- Test -->
        </suite> <!-- Suite -->


## Running Tests
1. Right-click on the testng.xml file in Eclipse.

2. Select Run As > TestNG Suite.

   This will execute all the tests defined in the testng.xml file
## Checking Test Reports
1. Navigate to the test-output directory in your project.

2. Open the index.html file in a web browser.

   This will display a detailed report of your test execution, including passed, failed, and skipped tests.
## Run Locally
Go to the desired directory

```bash
  cd my-project
```

Clone the project

```bash
  git clone https://github.com/tejashwaree/WysaAPIAutomation
```

Steps to Add a Cloned Project into Eclipse
1. Open Eclipse IDE
Launch your Eclipse IDE. If you don't have Eclipse installed, you can download it from the Eclipse website.

2. Import the Maven Project
    1. Go to the Import Wizard:
    - Click on File in the top menu.
    - Select Import
    2. Select Maven Project:
    - In the import wizard, expand the Maven folder.
    - Choose Existing Maven Projects and click Next.

3. Select the Root Directory:

- Click on Browse... next to the Root Directory field.
- Navigate to the directory where you cloned the project using Git Bash.
- Select the root directory of the project (the directory containing the pom.xml file).
- Click OK.
4. Finish the Import:
- Eclipse will scan the directory and list the projects found.
- Ensure the correct project is checked.
- Click Finish.
Eclipse will import the project, read the pom.xml file, and set up the project according to the Maven configuration.

5. Update Maven Project:
- Right-click on the project in the Project Explorer view.
- Select Maven > Update Project.
- In the dialog that appears, ensure that your project is checked.
- Click OK.
This action updates the Maven dependencies and configurations in Eclipse.

6. Run Tests
    1. Locate Test Classes:
        - Navigate to the src/test/java directory within the Project Explorer view.
    2. Run Tests:
        - Right-click on the test class or test suite you want to run.
        - Select Run As > TestNG Test (or JUnit Test if using JUnit).

## Importing Postman Collection(API testing using Postman tool)
**1. Install Postman**

If you haven’t already, download and install Postman from Postman’s website. It’s available for Windows, macOS, and Linux.

**2. Open Postman**
Launch the Postman application on your computer.

**3. Import a Collection**
1. Click on the “Import” Button:
- On the left sidebar, click on the "Import" button. This opens the import modal.
2. Choose Import Method:
- You can import a collection by dragging and dropping a file into the modal, pasting a URL, or uploading a file directly.
To upload a file:
- Download the collection file from [URL](https://drive.google.com/file/d/1bxJE1Xyh69Z8suH9kZTXHlY19kcmuDsN/view).
- Click “Upload Files” and select the Postman collection file (usually a .json file) from download directory of your computer.

3. Import the Collection:

- After selecting the file or pasting the URL, click the “Import” button in the modal to start the import process.

**4. View the Imported Collection**
1. Navigate to Collections:

- On the left sidebar, click on “Collections” to see the imported 
collection listed.

2. Expand the Collection:

- Click on the collection name to expand it and view the available requests, folders, and other details.
**5. Run the Collection**
1. Open Collection Runner:

- Click on the “Runner” button in the top left corner of Postman (it looks like a play icon) to open the Collection Runner.
2. Select the Collection:

- In the Collection Runner window, select the collection you want to run from the dropdown menu.

3. Start the Run:

- Click the “Run” button to start executing the collection.
4. Monitor the Run:

- The Collection Runner will display the progress and results of the requests. You can see details about each request, including status codes, response times, and any test results.

**6. Analyze Results**
1. Review Results:

- After the run is complete, you can review the results directly in the Collection Runner window. You’ll see a summary of successes, failures, and other relevant metrics.
2. Check Logs and Tests:

- Click on individual requests to view detailed logs, responses, and any test results that were part of the collection. 
