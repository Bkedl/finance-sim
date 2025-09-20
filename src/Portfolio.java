import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Transaction> transactions;

    public Portfolio() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // View transactions with updated prices
    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transactions:");
            for (Transaction t : transactions) {
                t.getInstrument().updatePrice(); // refresh price
                System.out.println(t);
            }
        }
    }

    // Compute total portfolio value
    public double getPortfolioValue() {
        double total = 0;
        for (Transaction t : transactions) {
            t.getInstrument().updatePrice(); // refresh price
            total += t.getAmount();
        }
        return total;
    }
}