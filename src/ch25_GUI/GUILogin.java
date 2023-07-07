package ch25_GUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUILogin extends JFrame {

	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";

	private JPanel contentPane;
	private CardLayout mainCardLayout;

	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton backBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin frame = new GUILogin();
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
	public GUILogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		mainCardLayout = new CardLayout(0, 0);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(mainCardLayout);
		setContentPane(contentPane);

		JPanel loginLayout = new JPanel();
		contentPane.add(loginLayout, "loginLayout");
		loginLayout.setLayout(null);

		usernameField = new JTextField();
		usernameField.setBounds(53, 28, 330, 43);
		loginLayout.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(53, 88, 330, 43);
		loginLayout.add(passwordField);

		JButton loginBtn = new JButton("log in");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				if (!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
					JOptionPane.showMessageDialog(contentPane, "사용자 정보가 일치하지 않습니다", "로그인 실패",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				System.out.println("asdf");
				mainCardLayout.show(contentPane, "nextLayout");
			}
		});
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				if (!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
					JOptionPane.showMessageDialog(contentPane, "사용자 정보가 일치하지 않습니다", "로그인 실패",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				System.out.println("asdf");
				JOptionPane.showMessageDialog(contentPane, "환영합니다!", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				mainCardLayout.show(contentPane, "nextLayout");
			}
		});
		loginBtn.setBounds(53, 141, 330, 43);
		loginLayout.add(loginBtn);

		JPanel nextLayout = new JPanel();
		contentPane.add(nextLayout, "nextLayout");
		nextLayout.setLayout(null);

		backBtn = new JButton("뒤로가기");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(contentPane, "loginLayout");
			}
		});
		backBtn.setBounds(109, 70, 278, 65);
		nextLayout.add(backBtn);
	}
}
