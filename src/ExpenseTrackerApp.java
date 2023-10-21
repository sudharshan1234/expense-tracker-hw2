import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;
import controller.InputValidation;
import filters.AmountFilter;
import filters.CategoryFilter;

public class ExpenseTrackerApp {

  public static void main(String[] args) {

    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();

      // Call controller to add transaction
      boolean added = controller.addTransaction(amount, category);

      if (!added) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });

    view.getFilterAmountBtn().addActionListener(e -> {
      // Get transaction data from view
      double maxAmount = view.getMaxAmountField();
      double minAmount = view.getMinAmountField();
      if (!InputValidation.isValidAmount(maxAmount) || !InputValidation.isValidAmount(minAmount)) {
        JOptionPane.showMessageDialog(view, "Invalid amount entered in the filter");
        view.toFront();
      } else {
        controller.applyFilter(new AmountFilter(minAmount, maxAmount));
      }
    });

    view.getCategoryDropdown().addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          controller.applyFilter(new CategoryFilter((String) view.getCategoryDropdown().getSelectedItem()));
        }
      }
    });

  }

}