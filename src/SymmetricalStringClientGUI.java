

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SymmetricalStringClientGUI extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public  static JTextArea textArea;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SymmetricalStringClientGUI frame = new SymmetricalStringClientGUI();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SymmetricalStringClientGUI() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    textArea = new JTextArea();
		textArea.setBounds(10, 10, 449, 207);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Nhập số:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 239, 85, 19);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(98, 239, 266, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Gửi");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(374, 239, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.append("Da nhap:"+textField.getText()+"\n");
				SymmetricalStringClient.Send();
				
			}
		});
		contentPane.add(btnNewButton);
		contentPane.setVisible(true);

	}
	
}
