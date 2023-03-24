# kotak-test-framework

## Config Changes to Run Test?

- Run in firefox/edge instead of chrome? - update the application-qa.properties.
- Add more pages/tests? - just create the classes.
- Add more tests? - create more @Test methods in your test classes.
- Run multi tests/run tests in parallel? - configure in testng.xml
- Run via maven? - use maven commands from CLI
- Run via jenkins? - create a jenkins job, trigger via maven commands/auto-trigger based on GIT commits, its all possible.

## What are the components of the framework?
Below are the tech-stack used:

**Maven**
- manage dependencies and plugins, integrate with CI/CD tools

**TestNG**
- test configurations in testng.xml, annotations, data provider, listeners

**Properties file**
- maintain global properties

**POM**
- test pages, page objects, page factory

**Tests**
- separate driver config - uses SeleniumManager
- separate utilities class
- multi browser (using properties)

**GIT**
- integration options

**Reports**
- native testng report and surefire-reports included
- Extent Reports added


## How TDD Works?
- Calculator class has Add and Multiplication Feature. As per TDD the implementation of methods is commented out and test is expected to fail.
- To fix failing test cases, uncomment the implementation.
