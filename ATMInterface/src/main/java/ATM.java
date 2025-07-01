public class ATM {
    private BankDatabase bankDatabase;
    private Keypad keypad;
    private Account currentAccount;

    public ATM() {
        bankDatabase = new BankDatabase();
        keypad = new Keypad();
    }

    public void run() {
        System.out.println("\n=== Welcome to ATM Interface ===");
        System.out.println("Sample accounts available for testing:");
        System.out.println("1. User ID: user1, PIN: 1234, Balance: $1000.00");
        System.out.println("2. User ID: user2, PIN: 5678, Balance: $2000.00\n");
        
        // Login
        if (!login()) {
            System.out.println("\nInvalid credentials. Exiting...");
            return;
        }
        
        // Main menu
        boolean quit = false;
        while (!quit) {
            displayMenu();
            int choice = keypad.getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private boolean login() {
        System.out.println("\n=== Login ===");
        String userId = keypad.getInput("Enter user ID: ");
        String pin = keypad.getInput("Enter PIN: ");
        
        if (bankDatabase.authenticateUser(userId, pin)) {
            currentAccount = bankDatabase.getAccount(userId);
            System.out.println("\nLogin successful!");
            System.out.println("Welcome, " + userId + "!");
            return true;
        }
        return false;
    }

    private void displayMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    private void viewTransactionHistory() {
        System.out.println("\n=== Transaction History ===");
        System.out.println(currentAccount.getTransactionHistory());
        System.out.println("Current Balance: $" + String.format("%.2f", currentAccount.getBalance()));
    }

    private void withdraw() {
        double amount = keypad.getDoubleInput("Enter amount to withdraw: ");
        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + 
                String.format("%.2f", currentAccount.getBalance()));
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }

    private void deposit() {
        double amount = keypad.getDoubleInput("Enter amount to deposit: ");
        currentAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + 
            String.format("%.2f", currentAccount.getBalance()));
    }

    private void transfer() {
        String recipientId = keypad.getInput("Enter recipient's user ID: ");
        Account recipient = bankDatabase.getAccount(recipientId);
        
        if (recipient == null) {
            System.out.println("Recipient not found.");
            return;
        }
        
        if (recipient == currentAccount) {
            System.out.println("Cannot transfer to yourself.");
            return;
        }
        
        double amount = keypad.getDoubleInput("Enter amount to transfer: ");
        if (currentAccount.transfer(recipient, amount)) {
            System.out.println("Transfer successful. New balance: $" + 
                String.format("%.2f", currentAccount.getBalance()));
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
