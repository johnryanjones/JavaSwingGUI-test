import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankGUI {

	private JFrame frmBankGui;
	private JTextField balanceText;
	private JTextField withdrawText;
	private JTextField depositText;
	private double balance;
	private JTextField textField;
	
	public double getBalance() {
		return balance;
	}
	public double setBalance(double balance) {
		return this.balance = balance;
	}
	public double withdrawFunds(double amt) {
		return balance -= amt;
	}
	public void depositFunds(double amt) {
		balance += amt;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankGUI window = new BankGUI();
					window.frmBankGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankGui = new JFrame();
		frmBankGui.setTitle("Bank GUI");
		frmBankGui.setBounds(100, 100, 450, 300);
		frmBankGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankGui.getContentPane().setLayout(null);
		
		JLabel balanceLabel = new JLabel("Enter Initial Balance:");
		balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		balanceLabel.setBounds(10, 14, 126, 17);
		frmBankGui.getContentPane().add(balanceLabel);
		
		balanceText = new JTextField();
		balanceText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = balanceText.getText();
				BankGUI.this.setBalance(Double.parseDouble(userInput));
				textField.setText("Your new balance is: $" + String.format("%.2f", BankGUI.this.balance));
				balanceText.setText("");
			}
		});
		balanceText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		balanceText.setBounds(146, 11, 126, 23);
		frmBankGui.getContentPane().add(balanceText);
		balanceText.setColumns(10);
		
		JLabel withdrawLabel = new JLabel("Withdraw Amount:");
		withdrawLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawLabel.setBounds(20, 45, 117, 17);
		frmBankGui.getContentPane().add(withdrawLabel);
		
		withdrawText = new JTextField();
		withdrawText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = withdrawText.getText();
				BankGUI.this.withdrawFunds(Double.parseDouble(userInput));
				textField.setText("Your new balance is: $" + String.format("%.2f", BankGUI.this.balance));
				withdrawText.setText("");
			}
		});
		withdrawText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawText.setBounds(146, 42, 126, 23);
		frmBankGui.getContentPane().add(withdrawText);
		withdrawText.setColumns(10);
		
		JLabel depositLabel = new JLabel("Deposit Amount:");
		depositLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositLabel.setBounds(31, 73, 105, 17);
		frmBankGui.getContentPane().add(depositLabel);
		
		depositText = new JTextField();
		depositText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = depositText.getText();
				BankGUI.this.depositFunds(Double.parseDouble(userInput));
				textField.setText("Your new balance is: $" + String.format("%.2f", BankGUI.this.balance));
				depositText.setText("");
			}
		});
		depositText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositText.setBounds(146, 70, 126, 23);
		frmBankGui.getContentPane().add(depositText);
		depositText.setColumns(10);
		
		JButton balanceButton = new JButton("Display Balance");
		balanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("Your new balance is: $" + String.format("%.2f", BankGUI.this.balance));
			}
		});
		balanceButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		balanceButton.setBounds(273, 128, 151, 25);
		frmBankGui.getContentPane().add(balanceButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 164, 404, 86);
		frmBankGui.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 384, 64);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(19, 128, 152, 25);
		frmBankGui.getContentPane().add(btnClear);
	}
}
