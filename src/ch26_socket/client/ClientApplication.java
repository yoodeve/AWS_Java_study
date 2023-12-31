package ch26_socket.client;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientApplication extends JFrame {

	private Socket socket;

	private JPanel mainPanel;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JTextField messageTextField;
	private JButton messageSendButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApplication frame = new ClientApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 540);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);

		/* << 채 팅 내 용 부 >> */
		JScrollPane chatTextAreaScrollPane = new JScrollPane();
		chatTextAreaScrollPane.setBounds(28, 28, 403, 427);
		mainPanel.add(chatTextAreaScrollPane);

		JTextArea chatTextArea = new JTextArea();
		// textArea edit mode false
		chatTextArea.setEditable(false);
		chatTextAreaScrollPane.setViewportView(chatTextArea);

		/* << 채 팅 연 결 부 >> */
		ipTextField = new JTextField();
		ipTextField.setBounds(443, 31, 196, 38);
		mainPanel.add(ipTextField);
		ipTextField.setColumns(10);

		portTextField = new JTextField();
		portTextField.setBounds(443, 79, 196, 38);
		mainPanel.add(portTextField);
		portTextField.setColumns(10);

		JButton connectionButton = new JButton("접속");
		connectionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String serverIp = ipTextField.getText();
				String serverPort = portTextField.getText();

				if (serverIp.isBlank() || serverPort.isBlank()) {
					JOptionPane.showMessageDialog(mainPanel, "IP와 포트번호를 입력해주세요", "접속오류", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					// new Socket(ip, port): 이 프로그램은 이 ip/port로 찾아갈 것이다.(소켓객체 생성)
					// 소켓 연결되면 비활성화 해제 => 버튼 전역으로 뺐음
					socket = new Socket(serverIp, Integer.parseInt(serverPort));
					JOptionPane.showMessageDialog(mainPanel, "서버와의 연결에 성공하였습니다", "접속 완료", JOptionPane.PLAIN_MESSAGE);
					messageTextField.setEditable(true);
					messageSendButton.setEnabled(true);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		connectionButton.setBounds(443, 127, 196, 30);
		mainPanel.add(connectionButton);

		/* << 접 속 자 >> */
		JScrollPane connectedUserListScrollPane = new JScrollPane();
		connectedUserListScrollPane.setBounds(443, 167, 196, 288);
		mainPanel.add(connectedUserListScrollPane);

		JList connectedUserList = new JList();
		connectedUserListScrollPane.setViewportView(connectedUserList);

		/* << 메 세 지 입 력 및 전 송 >> */
		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { // key 손 뗄때
				// 이미 키코드가 상수화 되어있음
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("전송");

				}
			}
		});
		messageTextField.setBounds(28, 465, 403, 28);
		// 접속 후 입력가능하게 처리
		messageTextField.setEditable(false);
		mainPanel.add(messageTextField);
		messageTextField.setColumns(10);

		messageSendButton = new JButton("전송");
		messageSendButton.setBounds(443, 465, 112, 28);
		messageSendButton.setEnabled(false);

		mainPanel.add(messageSendButton);
	}
}
