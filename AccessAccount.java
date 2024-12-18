import javax.swing.*;

public class AccessAccount extends Account {

    private final Account linkedAccount;

    public AccessAccount(String accountNumber, String pin, Account account) {
        super(accountNumber, pin);
        this.linkedAccount = account;
    }

    public void accessMenu() {
        String[] options = {"Inquiry", "Deposit", "Withdraw", "Exit"};
        boolean running = true;

        while (running) {
            int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Transaction Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> JOptionPane.showMessageDialog(null, "Current Balance: ₱" + linkedAccount.getBalance(), "Balance Inquiry", JOptionPane.INFORMATION_MESSAGE);
                case 1 -> {
                    String depositStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                    try {
                        double deposit = Double.parseDouble(depositStr);
                        linkedAccount.deposit(deposit);
                        JOptionPane.showMessageDialog(null, "Deposit successful! New Balance: ₱" + linkedAccount.getBalance(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 2 -> {
                    String withdrawStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                    try {
                        double withdraw = Double.parseDouble(withdrawStr);
                        if (linkedAccount.withdraw(withdraw)) {
                            JOptionPane.showMessageDialog(null, "Withdrawal successful! New Balance: ₱" + linkedAccount.getBalance(), "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient balance or invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 3 -> running = false;
                default -> running = false;
            }
        }
    }
}
