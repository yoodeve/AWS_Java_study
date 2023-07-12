package ch26_socket.simpleGUI.client;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import ch26_socket.simpleGUI.client.dto.SendMessage;
import lombok.Getter;

@Getter
public class SimpleGUIClient extends JFrame {

	private static SimpleGUIClient instance;

	public static SimpleGUIClient getInstance() {
		if (instance == null) {
			instance = new SimpleGUIClient();
		}
		return instance;
	}

	/* << 멤 버 변 수 >> */
	private Socket socket;

	private CardLayout mainCardLayout;
	private JPanel mainCardPanel;

	private JPanel chattingRoomListPanel;
	private JScrollPane roomListScrollPanel;
	private DefaultListModel<String> roomListModel;
	private JList roomList;

	private JPanel chattingRoomPanel;
	private JScrollPane userListScrollPane;
	private String username;
	private JTextField messageTextField;
	private JTextArea chattingTextArea;

	private DefaultListModel<String> userListModel;
	private JList userList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// singletone 사용
					SimpleGUIClient frame = SimpleGUIClient.getInstance(); // 생성
					frame.setVisible(true);

					ClientReceiver clientReceiver = new ClientReceiver();
					clientReceiver.start();

					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("connection", frame.username);
					ClientSender.getInstance().send(requestBodyDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimpleGUIClient() {
		username = JOptionPane.showInputDialog(chattingRoomPanel, "아이디를 입력하세요.");

		if (Objects.isNull(username)) {
			System.exit(0);
		}
		if (username.isBlank()) {
			System.exit(0);
		}
		try {
			socket = new Socket("127.0.0.1", 8000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 528);

		mainCardLayout = new CardLayout();
		mainCardPanel = new JPanel();
		mainCardPanel.setLayout(mainCardLayout);
		setContentPane(mainCardPanel);

		chattingRoomListPanel = new JPanel();
		mainCardPanel.add(chattingRoomListPanel, "chattingRoomListPanel");
		JButton createRoomButton = new JButton("방만들기");
		createRoomButton.setBounds(10, 10, 120, 40);
		createRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String roomName = JOptionPane.showInputDialog(chattingRoomListPanel, "방제목을 입력하세요!");
				if (Objects.isNull(roomName)) {
					// 취소버튼 누른 경우
					return;
				}
				if (roomName.isBlank()) {
					JOptionPane.showMessageDialog(chattingRoomListPanel, "방제목을 입력하셔야 합니다", "오류",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				for (int i = 0; i < roomListModel.size(); i++) {
					if (roomListModel.get(i).equals(roomName)) {
						JOptionPane.showMessageDialog(chattingRoomListPanel, "중복된 방제목입니다.", "오류",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				RequestBodyDto<String> requestBodyDto = new RequestBodyDto<String>("createRoom", roomName);
				ClientSender.getInstance().send(requestBodyDto);
				mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
				requestBodyDto = new RequestBodyDto<String>("join", roomName);
				ClientSender.getInstance().send(requestBodyDto);
			}
		});
		chattingRoomListPanel.add(createRoomButton);

		chattingRoomListPanel.setLayout(null);
		chattingRoomListPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		roomListScrollPanel = new JScrollPane();
		roomListScrollPanel.setBounds(10, 119, 641, 360);
		chattingRoomListPanel.add(roomListScrollPanel);

		roomListModel = new DefaultListModel<String>();
		roomList = new JList(roomListModel);
		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 더블클릭인지 체크
				if (e.getClickCount() == 2) {
					// 화면 넘어가고 join 함께 실행
					String roomName = roomListModel.get(roomList.getSelectedIndex());
					mainCardLayout.show(mainCardPanel, "chattingRoomPanel");
					RequestBodyDto<String> requestBodyDto = new RequestBodyDto<>("join", roomName);
					ClientSender.getInstance().send(requestBodyDto);
				}
			}
		});
		roomListScrollPanel.setViewportView(roomList);

		chattingRoomPanel = new JPanel();
		chattingRoomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chattingRoomPanel.setLayout(null);
		mainCardPanel.add(chattingRoomPanel, "chattingRoomPanel");

		JScrollPane chattingTextAreaScrollPanel = new JScrollPane();
		chattingTextAreaScrollPanel.setBounds(12, 24, 525, 350);
		chattingRoomPanel.add(chattingTextAreaScrollPanel);

		chattingTextArea = new JTextArea();
		chattingTextAreaScrollPanel.setViewportView(chattingTextArea);

		messageTextField = new JTextField();
		messageTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendMessage sendMessage = SendMessage.builder().fromUsername(username)
							.messageBody(messageTextField.getText()).build();
					RequestBodyDto<SendMessage> requestBodyDto = new RequestBodyDto<>("sendMessage", sendMessage);
					ClientSender.getInstance().send(requestBodyDto);
					messageTextField.setText("");
				}
			}
		});
		messageTextField.setBounds(12, 384, 639, 69);
		chattingRoomPanel.add(messageTextField);
		messageTextField.setColumns(10);

		/* << 유저 리스트 >> */
		userListScrollPane = new JScrollPane();
		userListScrollPane.setBounds(549, 24, 100, 350);
		chattingRoomPanel.add(userListScrollPane);

		userListModel = new DefaultListModel<>();
		userList = new JList<>(userListModel);
		userListScrollPane.setViewportView(userList);

	}
}
