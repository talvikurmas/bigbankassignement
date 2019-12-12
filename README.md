Test assignement exercise

Requirements – Java 1.8 and Maven 3.5.0 installed and configured (paths set under variables),
compatible browser Google Chrome, used Java and Selenium with JUnit and Cucumber framework.

To start project:
Copy and extract project to desired location.
To run tests Cmd into the project dir and run command mvn clean install
To run single test use
mvn clean test -Dcucumber.options="--tags @add_new_book" or
mvn clean test -Dcucumber.options="--tags @search_book"


