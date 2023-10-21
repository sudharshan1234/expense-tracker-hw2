package filters;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

/**
 * The CategoryFilter class implements a TransactionFilter that filters
 * transactions based on their category.
 * It allows filtering transactions for a specific category or returning all
 * transactions if "all" is specified.
 */
public class CategoryFilter implements TransactionFilter {

    /**
     * The category to be considered for filtering. If set to "all", no filtering by
     * category will be applied.
     */
    private String category;

    /**
     * Constructs a CategoryFilter with the specified category.
     *
     * @param category The category to be considered for filtering. If set to "all",
     *                 no filtering by category will be applied.
     */
    public CategoryFilter(String category) {
        this.category = category;
    }

    /**
     * Filters a list of transactions based on their category.
     * If the specified category is "all", it returns the original list of
     * transactions without any filtering.
     *
     * @param transactions The list of transactions to be filtered.
     * @return A list of transactions that belong to the specified category, or the
     *         original list if "all" is specified.
     */
    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        if (category.equals("all")) {
            return transactions;
        }
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equals(category)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}
