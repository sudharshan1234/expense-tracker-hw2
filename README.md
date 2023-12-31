# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction.

## Compile

To compile the code from terminal, use the following command:

```
cd src
javac ExpenseTrackerApp.java
java ExpenseTracker
```

You should be able to view the GUI of the project upon successful compilation.

## Java Version

This code is compiled with `openjdk 17.0.7 2023-04-18`. Please update your JDK accordingly if you face any incompatibility issue.

- Encapsulation for the list of transactions
  - List of transaction is made private and final.
- Apply immutability on the list of transactions when the getter method is invoked
  - get transaction returns an unmodifiable list to uphold encapsulation
- Apply changes to the “‘Transaction“‘ class to prevent external data modification
  - Variables in the class are made private and final
  - All Setter methods are removed to prevent data modification

## Implemented Features

- Filter transactions by attribute (amount or category).
- Encapsulation of filter algorithms into reusable classes.
- Easily extensible for adding new filters using strategies.
- Users can filter by either amount or category at a time.
- Highlighting matched transactions in green (RGB code:[173, 255, 168]).

## Contributors

Sudharshan Govindan and Smruthi Sathyamoorthy
