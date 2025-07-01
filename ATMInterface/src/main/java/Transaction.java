import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<String> transactions;

    public Transaction() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        if (transactions.isEmpty()) {
            return "No transactions yet.";
        }
        
        StringBuilder sb = new StringBuilder("Transaction History:\n");
        for (int i = 0; i < transactions.size(); i++) {
            sb.append((i + 1)).append(". ").append(transactions.get(i)).append("\n");
        }
        return sb.toString();
    }
}
