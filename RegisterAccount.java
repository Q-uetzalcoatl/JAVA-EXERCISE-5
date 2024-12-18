import javax.swing.*;

public class RegisterAccount extends Account {

    public RegisterAccount(String accountNumber, String pin) {
        super(accountNumber, pin);
    }

    public static RegisterAccount createAccount() {
        String accountNumber = JOptionPane.showInputDialog("Enter a unique account number:");
        String pin = JOptionPane.showInputDialog("Set your PIN:");
        JOptionPane.showMessageDialog(null, "Account successfully registered!", "Success", JOptionPane.INFORMATION_MESSAGE);
        return new RegisterAccount(accountNumber, pin);
    }
}
