package view;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.InputValidation;

import java.awt.*;
import java.text.NumberFormat;

import model.Transaction;
import java.util.List;

public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JFormattedTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private JComboBox<String> categoryDropdown;

  public ExpenseTrackerView() {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger

    String[] columnNames = { "serial", "Amount", "Category", "Date" };
    this.model = new DefaultTableModel(columnNames, 0);

    addTransactionBtn = new JButton("Add Transaction");

    String[] categories = { "all", "food", "travel", "bills", "entertainment", "other" }; // Replace with your actual
    // categories
    categoryDropdown = new JComboBox<>(categories);

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    NumberFormat format = NumberFormat.getNumberInstance();

    amountField = new JFormattedTextField(format);
    amountField.setColumns(10);

    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);

    // Create table
    transactionsTable = new JTable(model);

    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel);
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);

    JPanel categoryFilterPanel = new JPanel();
    categoryFilterPanel.add(new JLabel("Category:"));
    categoryFilterPanel.add(categoryDropdown);

    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    JPanel combinedPanel = new JPanel(new GridLayout(2, 1));
    combinedPanel.add(categoryFilterPanel);

    add(combinedPanel, BorderLayout.WEST);

    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }

  public void applyFilterHighlighting(List<Transaction> filteredTransactions, List<Transaction> originalTransactions) {
    transactionsTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
      @Override
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
          boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row >= 0 && row < originalTransactions.size()) {
          Transaction currentTransaction = originalTransactions.get(row);

          if (filteredTransactions.contains(currentTransaction)) {
            c.setBackground(new Color(173, 255, 168)); // Set background color to green
          } else {
            c.setBackground(Color.white); // Set background color to default
          }
        } else {
          c.setBackground(Color.white);
        }

        return c;
      }
    });

    transactionsTable.repaint(); // Repaint the table to apply the highlighting
  }

  public void refreshTable(List<Transaction> transactions) {
    // Clear existing rows
    model.setRowCount(0);
    // Get row count
    int rowNum = model.getRowCount();
    double totalCost = 0;
    // Calculate total cost
    for (Transaction t : transactions) {
      totalCost += t.getAmount();
    }
    // Add rows from transactions list
    for (Transaction t : transactions) {
      model.addRow(new Object[] { rowNum += 1, t.getAmount(), t.getCategory(), t.getTimestamp() });
    }
    // Add total row
    Object[] totalRow = { "Total", null, null, totalCost };
    model.addRow(totalRow);

    // Fire table update
    transactionsTable.updateUI();

  }

  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  public JComboBox<String> getCategoryDropdown() {
    return categoryDropdown;
  }

  public DefaultTableModel getTableModel() {
    return model;
  }

  // Other view methods
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  public double getAmountField() {
    if (amountField.getText().isEmpty()) {
      return 0;
    } else {
      double amount = Double.parseDouble(amountField.getText());
      return amount;
    }
  }

  public void setAmountField(JFormattedTextField amountField) {
    this.amountField = amountField;
  }

  public String getCategoryField() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  public String getSelectedCategory() {
    return (String) categoryDropdown.getSelectedItem();
  }
}
