package ch25_GUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUIMain1 extends JFrame {
	private final String ADMIN_USERNAME = "admin";
	private final String ADMIN_PASSWORD = "1234";

	private JPanel contentPane;
	private CardLayout mainCardLayout;
//	private JTextField userNameTextField;
//	private JPasswordField passwordTextField;
	private JPanel loginLayout;
	private JPanel nextLayout;
	private JTextField idTextField;
	private JButton loginBtn;
	private JPasswordField pwField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain1 frame = new GUIMain1();
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
	public GUIMain1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 띄울 좌표(x,x) : 왼쪽 위가 0,0 but y좌표는 -가 생략되어있음 화면사이즈(x,y)
		setBounds(1090, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		loginLayout = new JPanel();
		contentPane.add(loginLayout, "loginLayout");
		loginLayout.setLayout(null);
		
		idTextField = new JTextField();
		idTextField.setBounds(75, 30, 199, 37);
		loginLayout.add(idTextField);
		idTextField.setColumns(10);

		loginBtn = new JButton("loginBtn");

		mainCardLayout = new CardLayout(0, 0);

		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = idTextField.getText();
				String password = pwField.getText();
				// 틀렸을 경우에 if를 걸고, 성공로직은 디폴트
				if (!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
					// 첫번째 인자: 어떤 것을 부모요소로 삼을건지?(부모요소의 가운데에 모달이 뜸)
					JOptionPane.showMessageDialog(contentPane, "사용자 정보가 일치하지 않습니다", "로그인 실패",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				System.out.println("asdf");
//				JOptionPane.showMessageDialog(contentPane, "환영합니다!", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				mainCardLayout.show(contentPane, "nextLayout");

			}
		});
		loginBtn.setBounds(75, 124, 199, 43);
		loginLayout.add(loginBtn);

		pwField = new JPasswordField();
		pwField.setBounds(75, 77, 199, 37);
		loginLayout.add(pwField);

	}
}
