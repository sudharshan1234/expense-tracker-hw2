package filters;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class CategoryFilter implements TransactionFilter {
    private String category;

    public CategoryFilter(String category) {
        this.category = category;
    }

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
