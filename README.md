## CIS18B-S25-33479 Assignment 3

### Overview
This repository contains Java source code for Assignment 3 of the CIS18B (Spring 2025) course. The project demonstrates various object-oriented programming principles, including:
- **Decorator Pattern** (enhancing existing classes without modifying them directly)
- **Observer Pattern** (notifying observers of state changes)
- **Custom Exceptions** (handling invalid operations with descriptive errors)

The application simulates a basic bank system, where users can create accounts, deposit, withdraw, and observe transactions via a logger.

### Cloning the Repository
To copy this project, use the following command:

```bash
git clone https://github.com/Drake-Programming/CIS18B-S25-33479-Assignment3.git
```

### Running the Project
After cloning the repository, navigate to the `src` directory:

```bash
cd CIS18B-S25-33479-Assignment3/src
```

All main project files are located in this directory.

To compile and run the code from the terminal, use the following commands:

```bash
javac BankAccountTest.java
java BankAccountTest
```

### Important Notes
- The project includes files generated by IntelliJ IDE which are unnecessary if you're compiling and running via terminal.
- Ensure you are in the `src` directory when compiling and running the Java files.

### Project Structure
```
src/
│
├── BankAccount.java
├── BankAccountDecorator.java
├── BankAccountTest.java
├── IAccount.java
├── IObserver.java
├── ISubject.java
├── InvalidAccountOperationException.java
├── NegativeDepositException.java
├── OverdrawException.java
├── SecureBankAccount.java
└── TransactionLogger.java


```

### Main Execution
The entry point of the application is the BankAccountTest.java file.

### Expected Output
Account Creation: Prompts for account number and initial balance.
Menu:
Deposit: Prompts for deposit amount and updates balance.
Withdraw: Prompts for withdrawal amount, checks limits, and updates balance if valid.
Exit: Terminates the application.
Transaction Logging: Every valid deposit or withdrawal is logged via the TransactionLogger (observer).

---

*Author:* Drake Programming


