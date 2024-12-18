import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UIManager.put("OptionPane.background", new java.awt.Color(240, 240, 250));
        UIManager.put("Panel.background", new java.awt.Color(240, 240, 250));
        UIManager.put("Button.background", new java.awt.Color(180, 200, 230));
        UIManager.put("Button.foreground", java.awt.Color.BLACK);

        JOptionPane.showMessageDialog(null, "Welcome to the Mojas ATM!", "Mojas ATM", JOptionPane.INFORMATION_MESSAGE);

        // Login or Signup
        RegisterAccount account1 = null;
        RegisterAccount account2 = null;

        while (account1 == null || account2 == null) {
            String[] options = {"Login", "Sign Up", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Login or Sign Up",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 1) { // Sign Up
                if (account1 == null) {
                    account1 = RegisterAccount.createAccount();
                } else if (account2 == null) {
                    account2 = RegisterAccount.createAccount();
                } else {
                    JOptionPane.showMessageDialog(null, "Maximum accounts created.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (choice == 0) { // Login
                String enteredPin = JOptionPane.showInputDialog("Enter your pin number:");
                if (account1 != null && account1.verifyPin(enteredPin)) {
                    AccessAccount userAccount = new AccessAccount(account1.getAccountNumber(), enteredPin, account1);
                    userAccount.accessMenu();
                } else if (account2 != null && account2.verifyPin(enteredPin)) {
                    AccessAccount userAccount = new AccessAccount(account2.getAccountNumber(), enteredPin, account2);
                    userAccount.accessMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid PIN or no accounts registered.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else { // Exit
                JOptionPane.showMessageDialog(null, "Thank you for using the Mojas ATM!", "Mojas ATM", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }
}
