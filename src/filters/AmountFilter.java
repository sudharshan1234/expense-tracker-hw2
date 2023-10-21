package filters;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

/**
 * The AmountFilter class implements a TransactionFilter that filters
 * transactions based on their amount.
 * It includes a range of minimum and maximum amounts to be considered for
 * filtering.
 */
public class AmountFilter implements TransactionFilter {

    /**
     * The minimum amount to be considered for filtering.
     */
    private double minAmount;

    /**
     * The maximum amount to be considered for filtering.
     */
    private double maxAmount;

    /**
     * Constructs an AmountFilter with the specified minimum and maximum amounts.
     *
     * @param minAmount The minimum amount to be considered for filtering.
     * @param maxAmount The maximum amount to be considered for filtering.
     */
    public AmountFilter(double minAmount, double maxAmount) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    /**
     * Filters a list of transactions based on their amount.
     *
     * @param transactions The list of transactions to be filtered.
     * @return A list of transactions that fall within the specified amount range.
     */
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
