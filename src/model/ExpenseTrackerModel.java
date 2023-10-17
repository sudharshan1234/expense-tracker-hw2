// To apply immutablility and encapsulation for transaction List, it is made both private and final.

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.binding.When;


public class ExpenseTrackerModel {

  private final List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  public List<Transaction> getTransactions() {
    return Collections.unmodifiableList(transactions);
  }

}