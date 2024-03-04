# Alas

## Project Overview

The following instructions will guide you through the setup and execution of tests using Java, IntelliJ.

## Prerequisites

Before you begin, ensure that you have the following prerequisites installed on your machine:

- Java Development Kit (JDK): [Installation Guide](https://www.oracle.com/java/technologies/javase-downloads.html)
- IntelliJ IDEA: [Installation Guide](https://www.jetbrains.com/idea/download/)
- Git: [Installation Guide](https://git-scm.com/downloads)

## Clone the Project

## Running Tests Separately from IntelliJ UI

1. Open IntelliJ IDEA.
2. Open the project by selecting `File` > `Open` and choosing the project folder.
3. Navigate to the test class containing the test you want to run.
4. Right-click on the test method or class and select `Run` from the context menu.

## Running Test Group from IntelliJ UI

1. Open IntelliJ IDEA.
2. Open the project by selecting `File` > `Open` and choosing the project folder.
3. Navigate to the test class containing the test group you want to run.
4. Right-click on the test class or group and select `Run` from the context menu.

## Browser selection
* In "globalData.properties" edit browser name

## Running Test Suite

1. Open IntelliJ IDEA.
2. Open the project by selecting `File` > `Open` and choosing the project folder.
3. Navigate to the test suite class.
4. Right-click on the test suite class and select `Run` from the context menu.

## Running from command line
*Use the cd command to change the current directory to the location where your pom.xml file 
mvn test - To run all tests
mvn test -Dbrowser=chrome - to chose browser
mvn test -Dtest=uiTests -Dbrowser=chrome
mvn clean test -PuiTests - to run one Profile

## Non implemented features
1. I had Jenkins setup through desktop rancher to hit remote machine on moon ui

