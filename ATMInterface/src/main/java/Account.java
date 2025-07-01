public class Account {
    private String userId;
    private String userPin;
    private double balance;
    private Transaction transactionHistory;

    public Account(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = initialBalance;
        this.transactionHistory = new Transaction();
    }

    public boolean validatePin(String pin) {
        return this.userPin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.addTransaction("Deposit: +$" + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.addTransaction("Withdraw: -$" + amount);
            return true;
        }
        return false;
    }

    public boolean transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.addTransaction("Transfer to " + recipient.userId + ": -$" + amount);
            recipient.transactionHistory.addTransaction("Transfer from " + this.userId + ": +$" + amount);
            return true;
        }
        return false;
    }

    public String getTransactionHistory() {
        return transactionHistory.toString();
    }
    
    public String getUserId() {
        return userId;
    }
}
