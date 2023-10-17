package filters;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class AmountFilter implements TransactionFilter {
    private double minAmount;
    private double maxAmount;

    public AmountFilter(double minAmount, double maxAmount) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            double amount = transaction.getAmount();
            if (amount >= minAmount && amount <= maxAmount) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}
