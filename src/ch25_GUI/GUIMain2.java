package ch25_GUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIMain2 extends JFrame {

	private JPanel mainCardPane;
	private CardLayout mainCardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain2 frame = new GUIMain2();
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
	public GUIMain2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		/* << mainCardPane >> */
		mainCardPane = new JPanel();
		mainCardLayout = new CardLayout(0, 0);

		mainCardPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainCardPane.setLayout(mainCardLayout);

		setContentPane(mainCardPane);

		/* << sub panel 1 >> */
		JPanel subPanel1 = new JPanel();
		mainCardPane.add(subPanel1, "subPanel1");
		subPanel1.setLayout(null);

		JButton subPanel2ShowBtn = new JButton("2번 페이지");
		subPanel2ShowBtn.setBounds(149, 110, 100, 23);
		subPanel1.add(subPanel2ShowBtn);

		subPanel2ShowBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});

		/* << sub panel 2 >> */
		JPanel subPanel2 = new JPanel();
		mainCardPane.add(subPanel2, "subPanel2");
		subPanel2.setLayout(null);

		/* << mainCardPane >> */
		JButton subPanel1showBtn = new JButton("1번 페이지");
		subPanel1showBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel1");
			}
		});
		subPanel1showBtn.setBounds(37, 58, 126, 23);
		subPanel2.add(subPanel1showBtn);

		JButton subPanel3showBtn = new JButton("3번페이지");
		subPanel3showBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel3");
			}
		});
		subPanel3showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		subPanel3showBtn.setBounds(250, 58, 126, 23);
		subPanel2.add(subPanel3showBtn);

		/* << sub panel 3 >> */
		JPanel subPanel3 = new JPanel();
		mainCardPane.add(subPanel3, "subPanel3");
		subPanel3.setLayout(null);

		JButton subPanel2ShowBtn2 = new JButton("2번 페이지");
		subPanel2ShowBtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCardLayout.show(mainCardPane, "subPanel2");
			}
		});
		subPanel2ShowBtn2.setBounds(166, 104, 91, 23);
		subPanel3.add(subPanel2ShowBtn2);
	}

}
