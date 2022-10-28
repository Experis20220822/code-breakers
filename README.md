# HMRC [Code-Breakers](https://staging.tiered-planet.net/code-breakers) Salary Tax Calculator

This app allows the user to calculate their annual salary after tax and allows you to add you expediencies.


## Contributors 

* @Laura,
* @Lee,
* @Adil, 
* @German

## Design

### Frameworks
- PlayFramework - was used to build the web application with Scala
- HMRC.gov Framework - components were used to replicate the style and look of HMRC pages 

### Wireframes
Figma was used for the [planning](https://imgur.com/a/bOOCvcu) of our application and for the [wireframe](https://imgur.com/a/EPPuTaL)

-----
# Features

## Login 
- User can login to their account 
- User is shown an error if username doesn't match database
- User is shown an error if password doesn't match database
- After successful login user is directed to the Calculator page
## Register
- User can register their account
- User is shown warnings if form fields are incomplete
- After successful login user is directed to the Calculator page
## Salary Calculator
- User can calculate their take home salary after tax.

## Expense Form
- User can use the expense form to budget by deducting their annual expenses from their take home salary.

## Expense Table
- User can see all their expenses added in a table view.
-----
# Database Structure
**Mongodb** was used during development to store the following:
- Users - username, email, password
- Calculator - salary, tax code, pension, student loan
- Expenses - date, amount and category
-----
# Technologies Used

**Languages Used**
- [Scala](https://www.scala-lang.org/)

**Libraries & Frameworks**
- [Gov.uk Design](https://design-system.service.gov.uk/get-started/)
- [Play Framework](https://www.playframework.com/)
- [Docker](https://www.docker.com/)
- [MongoDB](https://www.mongodb.com/)

-----
# Testing
Manual testing was carried out locally each feature was tested to ensure it was fully 

Testing was carried out for the following:

**Controllers**
- ExpenseControllerSpec
- RegisterControllerSpec

**Models**
- ExpenseSpec
- UserSpec

**scala**
- NumberSpec
- StringSpec

**Services**
- StandardCalculatorServiceTest

ScalaCheck & Scoverage were implemented

------

# Deployment
- [Jenkins](https://www.jenkins.io/) was used for **CI** deployment
- [Spinnaker](https://spinnaker.io/) was used for **CD** deployment

-----

# Future Development
- The ability to calculate your monthly, weekly salary
- A budgeting tool for Holidays, or any other big expenditure
- Add a Savings Goal, so user knows how much they need to save per month to reach their savings target
- Allow users the ability to add a new expense category
- Sort and Filter the expense table
- Incorporate Mockito into the testing

# Credits
