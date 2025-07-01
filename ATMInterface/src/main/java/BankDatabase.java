import java.util.HashMap;
import java.util.Map;

public class BankDatabase {
    private Map<String, Account> accounts;

    public BankDatabase() {
        accounts = new HashMap<>();
        // Initialize with some sample accounts
        addAccount(new Account("user1", "1234", 1000.0));
        addAccount(new Account("user2", "5678", 2000.0));
    }

    private void addAccount(Account account) {
        accounts.put(account.getUserId(), account);
    }

    public Account getAccount(String userId) {
        return accounts.get(userId);
    }

    public boolean authenticateUser(String userId, String pin) {
        Account account = getAccount(userId);
        return account != null && account.validatePin(pin);
    }
}
