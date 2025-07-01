# ATM Interface

A console-based ATM Interface built with Java that simulates basic banking operations.

## Features

- User authentication with User ID and PIN
- View transaction history
- Withdraw money
- Deposit money
- Transfer money to other accounts
- Clean console-based interface

## Sample Accounts

For testing purposes, the following accounts are pre-loaded:
- User ID: `user1`, PIN: `1234`, Balance: $1000.00
- User ID: `user2`, PIN: `5678`, Balance: $2000.00

## How to Run

1. Make sure you have Java Development Kit (JDK) installed on your system
2. Navigate to the `src/main/java` directory
3. Compile all Java files:
   ```bash
   javac *.java
   ```
4. Run the ATM application:
   ```bash
   java ATM
   ```

## Usage

1. Launch the application
2. Enter your User ID and PIN when prompted
3. Select an option from the menu:
   - 1: View transaction history
   - 2: Withdraw money
   - 3: Deposit money
   - 4: Transfer money to another account
   - 5: Quit the application

## Project Structure

- `ATM.java`: Main class that runs the ATM interface
- `Account.java`: Represents a bank account with user information and balance
- `Transaction.java`: Manages transaction history for each account
- `BankDatabase.java`: Simulates a database of bank accounts
- `Keypad.java`: Handles user input with validation

## Notes

- This is a console-based application with no persistent storage (all data is lost when the program exits)
- For demonstration purposes only - not suitable for production use
- No actual money is involved in this simulation
