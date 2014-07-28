/*--------------------------------------------------------------------------------------*/
/*  quiz.java  -  LearnMusic! teachers users about the basics of music. (Ex. notes, clefs, symbols)                                                    */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author: Hayden Tsui                                                                             */
/*  Date: June 4th 2013                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input: User selects answers for the questions they are asked							*/
/*  Output: Displays questions to ask user, and in the end displays their current score and high score                                                          *
 /*--------------------------------------------------------------------------------------*/
package hayden;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class quiz extends JFrame implements ActionListener {

	// declares local variables needed for class
	private JPanel contentPane;
	private JButton btnBegin = new JButton("BEGIN!!");
	private JButton btnMainMenu = new JButton("Main Menu");
	private JButton submit = new JButton("Submit");
	private int temp = 1, score = 0;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private int[] answers = new int[10];
	private JRadioButton radiobutton[][] = new JRadioButton[10][10];
	private jFrame jframe = new jFrame();
	private JLabel label[] = new JLabel[10];
	private JButton btnLogOut = new JButton("LOG OUT");

	/**
	 * Creates the frame, and assigns the co-ordinates for objects
	 */
	public quiz() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				lesson.class.getResource("/hayden/music.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Quiz!");
		contentPane.setLayout(null);

		btnBegin.setBounds(342, 397, 91, 23);

		contentPane.add(btnBegin);
		submit.setBounds(326, 425, 131, 23);
		btnMainMenu.setBounds(326, 449, 131, 23);
		contentPane.add(btnMainMenu);

		btnLogOut.setBounds(689, 11, 89, 23);
		contentPane.add(btnLogOut);

		btnLogOut.addActionListener(this);
		submit.addActionListener(this);
		btnBegin.addActionListener(this);
		btnMainMenu.addActionListener(this);
	}

	public void intit() {
		btnBegin.setVisible(false);
	}

	// shows quizmenu
	public void quizmenu() throws IOException {
		setTitle("TEST");
		temp = 1;
	}

	// shows quiz 1
	public void quiz1() throws IOException {
		displayQuestions("quiz1.txt");
		setTitle("QUIZ 1");
		temp = 2;
	}

	// shows quiz 2
	public void quiz2() throws IOException {
		displayQuestions("quiz2.txt");
		setTitle("QUIZ 2");
		temp = 3;
		repaint();
	}

	// shows quiz 3
	public void quiz3() throws IOException {
		displayQuestions("quiz3.txt");
		setTitle("QUIZ 3");
		temp = 4;
	}

	// shows quiz 4
	public void quiz4() throws IOException {
		displayQuestions("quiz4.txt");
		setTitle("QUIZ 4");
		temp = 5;
	}

	// quiz 5
	public void quiz5() throws IOException {
		displayQuestions("quiz5.txt");
		setTitle("QUIZ 5");
		temp = 6;
	}

	// shows quiz 6
	public void quiz6() throws IOException {
		displayQuestions("quiz6.txt");
		setTitle("QUIZ 6");
		temp = 7;
	}

	// show final screen with scores and high scores
	public void quiz7() {

		// display your score
		JLabel lblYourScore = new JLabel("YOUR SCORE : ");
		lblYourScore.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblYourScore.setForeground(Color.WHITE);
		lblYourScore.setBounds(40, 81, 268, 112);
		contentPane.add(lblYourScore);

		JLabel lblNewLabel_1 = new JLabel(String.valueOf(score));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(451, 81, 305, 130);
		contentPane.add(lblNewLabel_1);

		// display username
		JLabel label_1 = new JLabel(login.username());
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		label_1.setBounds(40, 11, 298, 112);
		contentPane.add(label_1);

		// display high score
		JLabel lblHighScore = new JLabel("HIGH SCORE : ");
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblHighScore.setBounds(40, 247, 268, 112);
		contentPane.add(lblHighScore);

		JLabel label_2 = new JLabel(login.returnscores());
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 37));
		label_2.setBounds(451, 231, 305, 130);
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(label_2);
		
		//set background image
		lblNewLabel.setIcon(new ImageIcon(quiz.class
				.getResource("/hayden/48076.jpg")));
		lblNewLabel.setBounds(-17, -31, 830, 538);
		contentPane.add(lblNewLabel);
		btnMainMenu.setVisible(true);
		btnLogOut.setVisible(true);
	}

	// display the multiple choice questions
	public void displayQuestions(String urls) throws IOException {
		URL url = getClass().getResource(urls);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				url.openStream()));
		contentPane.removeAll();
		for (int i = 0; i < 4; i++) {
			label[i] = new JLabel(reader.readLine());
			
			//display first set of questions
			if (i == 0) {
				label[i].setBounds(10, 26, 500, 32);
				for (int j = 0; j < 4; j++) {
					radiobutton[i][j] = new JRadioButton(reader.readLine());
					radiobutton[i][j].setBounds(10, 65 + (j * 36), 257, 23);
					buttonGroup.add(radiobutton[i][j]);
					contentPane.add(radiobutton[i][j]);
				}
				answers[i] = Integer.parseInt(reader.readLine());
			}
			//display second set of questions
			if (i == 1) {
				label[i].setBounds(10, 233, 500, 33);
				for (int j = 0; j < 4; j++) {
					radiobutton[i][j] = new JRadioButton(reader.readLine());
					radiobutton[i][j].setBounds(10, 288 + (j * 36), 257, 23);
					buttonGroup_1.add(radiobutton[i][j]);
					contentPane.add(radiobutton[i][j]);
				}
				answers[i] = Integer.parseInt(reader.readLine());
			}
			//display third set of questions
			if (i == 2) {
				label[i].setBounds(450, 26, 500, 33);
				for (int j = 0; j < 4; j++) {
					radiobutton[i][j] = new JRadioButton(reader.readLine());
					radiobutton[i][j].setBounds(450, 65 + (j * 36), 257, 23);
					buttonGroup_2.add(radiobutton[i][j]);
					contentPane.add(radiobutton[i][j]);
				}
				answers[i] = Integer.parseInt(reader.readLine());
			}
			//display fourth set of questions
			if (i == 3) {
				label[i].setBounds(450, 233, 500, 33);
				for (int j = 0; j < 4; j++) {
					radiobutton[i][j] = new JRadioButton(reader.readLine());
					radiobutton[i][j].setBounds(450, 288 + (j * 36), 257, 23);
					buttonGroup_3.add(radiobutton[i][j]);
					contentPane.add(radiobutton[i][j]);
				}
				answers[i] = Integer.parseInt(reader.readLine());
			}
			contentPane.add(label[i]);
			label[i].setVisible(true);
		}
		contentPane.add(btnMainMenu);
		contentPane.add(submit);
		validate();
		repaint();
	}

	// waits for the user to press a button
	public void actionPerformed(ActionEvent e) {

		// goes to main menu if main menu button is closed
		if (e.getSource() == btnMainMenu) {
			dispose();
		}

		// goes to first frame if user clicks begin
		if (e.getSource() == btnBegin) {
			btnBegin.setVisible(false);
			try {
				quiz1();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		// if user press submits, it shows another set of questions
		if (e.getSource() == submit) {
			for (int i = 0; i < 4; i++) {
				int correct = answers[i] - 1;
				if (radiobutton[i][correct].isSelected() == true) {
					score++;
				}
			}
			// checks which frame user on is on, and goes to next one
			switch (temp) {
			case 2:
				try {
					quiz2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					quiz3();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 4:
				try {
					quiz4();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 5:
				try {
					quiz5();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case 6:
				try {
					quiz6();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			// saves user scores and displays final frame
			case 7:
				contentPane.removeAll();
				try {
					login.saveScores(score);
					quiz7();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnMainMenu.setVisible(true);
				submit.setVisible(false);
				JOptionPane.showMessageDialog(null, score + "/24 CORRECT",
						"YOUR SCORE", JOptionPane.PLAIN_MESSAGE);
			}
			repaint();
		}

		// if user press logouts, it closes the whole program
		if (e.getSource() == btnLogOut) {
			System.exit(0);
		}
	}
}
