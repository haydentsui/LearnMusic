/*--------------------------------------------------------------------------------------*/
/*  main.java  -  LearnMusic! teachers users about the basics of music. (Ex. notes, clefs, symbols)                                                */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author: Hayden Tsui                                                                             */
/*  Date: June 4th 2013                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input: User can select from the menu bar what lesson they want to do, and also select to do a lesson
 * from the start or a quiz                                                                          */
/*  Output: Outputs a main menu screen, and depending what user chooses it redirects them to a lesson/quiz                                                                     *
/*--------------------------------------------------------------------------------------*/
package hayden;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class menu extends JFrame implements ActionListener {

	// calls local variables needed for program
	private JPanel contentPane;
	private JButton btnNewButton = new JButton("");
	private JButton btnNewButton_1 = new JButton("New button");
	private lesson lesson = new lesson();

	/**
	 * Launch the application.
	 */

	/**
	 * Creates the frame, and assigns the co-ordinates for objects
	 */
	public menu() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				menu.class.getResource("/hayden/music.png")));
		setTitle("Main Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ActionListener action;
		action = new ActionListener() {

			@Override
			// based on what the user has clicked in the menu bar, it directs it
			// to the lesson the user wants
			public void actionPerformed(ActionEvent e) {
				// sees what user clicked
				int temp = Integer.parseInt(e.getActionCommand());
				lesson.setVisible(true);
				lesson.intit();

				// directs it to specified lesson
				switch (temp) {
				case 1:
					lesson.lesson1();
					break;
				case 2:
					lesson.lesson2();
					break;
				case 3:
					lesson.lesson3();
					break;
				case 4:
					lesson.lesson4();
					break;
				case 5:
					lesson.lesson5();
					break;
				case 6:
					lesson.lesson6();
					break;

				}

			}

		};

		// creates a menu bar for lessons
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);

		JMenu mnLesson = new JMenu("Lesson");
		menuBar.add(mnLesson);

		// creates menu items for lessons
		JMenuItem mntmLesson[] = new JMenuItem[6];
		for (int i = 0; i < 6; i++) {
			mntmLesson[i] = new JMenuItem("Lesson " + i);
			mnLesson.add(mntmLesson[i]);
			mntmLesson[i].addActionListener(action);
			mntmLesson[i].setActionCommand(String.valueOf(i + 1));
		}
		
		//creates a button for lesson
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(menu.class
				.getResource("/hayden/music.png")));
		btnNewButton.setBounds(89, 112, 101, 89);
		contentPane.add(btnNewButton);
		
		//creates text for lesson button
		JLabel lblLesson = new JLabel("LESSON");
		lblLesson.setForeground(Color.WHITE);
		lblLesson.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblLesson.setHorizontalAlignment(SwingConstants.CENTER);
		lblLesson.setBounds(89, 212, 101, 20);
		contentPane.add(lblLesson);
		
		//creates text for test button
		JLabel lblTest = new JLabel("TEST");
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
		lblTest.setForeground(Color.WHITE);
		lblTest.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblTest.setBounds(294, 212, 101, 20);
		contentPane.add(lblTest);
		
		//creates a button for test
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setIcon(new ImageIcon(menu.class
				.getResource("/hayden/Untitled-2.png")));
		btnNewButton_1.setBounds(294, 112, 100, 89);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(menu.class
				.getResource("/hayden/background.jpg")));
		lblNewLabel.setBounds(-66, -14, 609, 481);
		contentPane.add(lblNewLabel);

	}

	//waits for the user to click a button
	public void actionPerformed(ActionEvent e) {
		
		//if user clicks , it goes to lesson
		if (e.getSource() == btnNewButton) {
			lesson.setVisible(true);
			lesson.lessonmenu();
		}
		
		//if user clicks , it goes to quiz
		if (e.getSource() == btnNewButton_1) {
			quiz quiz = new quiz();
			quiz.setVisible(true);
		}
	}
}
