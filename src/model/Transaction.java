package model;

import java.text.SimpleDateFormat;
import java.util.Date;

// To make the class immutable,
// All the variables are made private final - to prevent modification
// Setter methods are removed.

public class Transaction {

  private final double amount;
  private final String category;
  private final String timestamp;

  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  public double getAmount() {
    return amount;
  }

  public String getCategory() {
    return category;
  }

  public String getTimestamp() {
    return timestamp;
  }

  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    return sdf.format(new Date());
  }

}