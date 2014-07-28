/*--------------------------------------------------------------------------------------*/
/*  lesson.java  -  LearnMusic! teachers users about the basics of music. (Ex. notes, clefs, symbols)                                                       */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author: Hayden Tsui                                                                             */
/*  Date: June 4th 2013                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input: User can press buttons to browse through lessons                                                                          */
/*  Output: Shows numerous lessons about music.                                                                        *
/*--------------------------------------------------------------------------------------*/
package hayden;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
import java.io.IOException;

import javax.swing.ImageIcon;

public class lesson extends JFrame implements ActionListener {

	//declare all variables needed for class 
	private JPanel contentPane;
	private JButton btnNext = new JButton("Next");
	private JButton btnQuiz = new JButton("QUIZ");
	private int temp = 1;
	private JButton btnPrevious = new JButton("Previous");
	private JButton btnBegin = new JButton("BEGIN!!");
	private JButton btnMainMenu = new JButton("Main Menu");
	private JButton btnLogOut = new JButton("LOG OUT");
	public static String [] notes = new String [19];
	private final JLabel[] label = new JLabel[20];

	/**
	 * Creates the frame, and assigns the co-ordinates for objects
	 */
	public lesson() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(lesson.class.getResource("/hayden/music.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnNext.setBounds(594, 453, 83, 23);
		btnNext.addActionListener(this);
		contentPane.add(btnNext);
		
		btnQuiz.setBounds(594, 453, 83, 23);
		contentPane.add(btnQuiz);
		btnQuiz.addActionListener(this);
		btnQuiz.setVisible(false);
		
		btnPrevious.setBounds(45, 453, 91, 23);
		contentPane.add(btnPrevious);
		btnBegin.setBounds(313, 396, 91, 23);
		
		contentPane.add(btnBegin);
		btnMainMenu.setBounds(295, 453, 131, 23);
		
		contentPane.add(btnMainMenu);
		btnLogOut.setBounds(630, 11, 89, 23);
		contentPane.add(btnLogOut);

		btnLogOut.addActionListener(this);
		btnBegin.addActionListener(this);
		btnPrevious.addActionListener(this);
		btnMainMenu.addActionListener(this);
		
		//gets music files
		for(int i =0; i < 19; i++)
		{
			notes[i]= (String.valueOf(i+1) + ".wav"); 
			label[i] = new JLabel("");
		}
		label[19] = new JLabel("");
		contentPane.add(label[0]);
	}
	
	//plays the sound clip given the file path
	public static void sound(String path){
		try{
			AudioInputStream audio = AudioSystem.getAudioInputStream(lesson.class.getResource(path));
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
			
		}catch(Exception e){
			System.out.println("Check " + path + "\n");
			e.printStackTrace();
		}
	}
	
	//sets begin button visible
	public void intit ()
	{
	btnBegin.setVisible(false);
	}
	
	//main menu for lesson
	public void lessonmenu(){
		setTitle("LESSON");
		label[0].setVisible(false);
		btnBegin.setVisible(true);
		btnNext.setVisible(false);
		btnPrevious.setVisible(false);
		temp = 1;
	}
	
	//shows lesson 1
	public void lesson1 (){
		label[0].setVisible(true);
		btnPrevious.setVisible(false);
		setTitle("LESSON 1");
		label[0].setIcon(new ImageIcon(lesson.class.getResource("/hayden/lesson1.jpg")));
		label[0].setBounds(0,-28,730,520);
		temp = 2;
	}
	
	//shows lesson 2
	public void lesson2 (){
		shownotes();
		label[0].setIcon(new ImageIcon(lesson.class.getResource("/hayden/lesson2.jpg")));
		label[0].setBounds(0,-28,730,520);
		setTitle("LESSON 2");
		
		//plays the specified music note when mouse enters the area
		label[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[0]);
			}
		});
		label[1].setBounds(99, 271, 46, 67);
		
		contentPane.add(label[1]);
		label[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[1]);
			}
		});
		label[2].setBounds(159, 271, 38, 58);
		
		contentPane.add(label[2]);
		label[3].setBounds(207, 259, 46, 67);
		label[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[2]);
			}
		});
		contentPane.add(label[3]);
		label[4].setBounds(264, 247, 46, 67);
		
		label[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[3]);
			}
		});
		contentPane.add(label[4]);
		label[5].setBounds(319, 236, 46, 67);
		
		label[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[4]);
			}
		});
		contentPane.add(label[5]);
		label[6].setBounds(369, 236, 46, 67);
		
		label[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[5]);
			}
		});
		contentPane.add(label[6]);
		label[7].setBounds(420, 262, 46, 67);
		
		label[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[6]);
			}
		});
		contentPane.add(label[7]);
		label[8].setBounds(476, 259, 46, 67);
		
		label[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[7]);
			}
		});
		contentPane.add(label[8]);
		label[9].setBounds(532, 247, 46, 67);
		
		label[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[8]);
			}
		});
		contentPane.add(label[9]);
		label[10].setBounds(584, 236, 46, 67);
		
		label[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[9]);
			}
		});
		contentPane.add(label[10]);
		label[11].setBounds(641, 225, 46, 67);
		
		label[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[10]);
			}
		});
		contentPane.add(label[11]);
		temp = 3;
	}
	
	//show lesson 3
	public void lesson3 (){
		shownotes1();
		label[0].setIcon(new ImageIcon(lesson.class.getResource("/hayden/lesson3.jpg")));
		label[0].setBounds(0,-28,730,520);
		setTitle("LESSON 3");
		label[12].setBounds(90, 244, 38, 91);
		
		//plays specified music note when mouse enters the area
		label[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[11]);
			}
		});
		contentPane.add(label[12]);
		label[13].setBounds(169, 225, 38, 91);
		
		label[13].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[12]);
			}
		});
		contentPane.add(label[13]);
		label[14].setBounds(239, 225, 38, 91);
		
		label[14].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[13]);
			}
		});
		contentPane.add(label[14]);
		label[15].setBounds(313, 281, 38, 91);
		
		label[15].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[14]);
			}
		});
		contentPane.add(label[15]);
		label[16].setBounds(388, 266, 38, 91);
		
		label[16].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[15]);
			}
		});
		contentPane.add(label[16]);
		label[17].setBounds(462, 266, 38, 91);
		
		label[17].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[16]);
			}
		});
		contentPane.add(label[17]);
		label[18].setBounds(537, 254, 38, 91);
		
		label[18].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[17]);
			}
		});
		contentPane.add(label[18]);
		label[19].setBounds(615, 244, 38, 91);
		
		label[19].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sound(notes[18]);
			}
		});
		contentPane.add(label[19]);
		temp = 4;
	}
	
	//show lesson 4
	public void lesson4 (){
		label[0].setIcon(new ImageIcon(lesson.class.getResource("/hayden/lesson4.jpg")));
		label[0].setBounds(0,-28,730,520);
		setTitle("LESSON 4");
		temp = 5;
	}
	
	//show lesson 5
	public void lesson5 (){
		label[0].setIcon(new ImageIcon(lesson.class.getResource("/hayden/lesson5.jpg")));
		label[0].setBounds(0,-28,730,520);
		setTitle("LESSON 5");
		temp = 6;
	}
	
	//show lesson 6
	public void lesson6 (){
		label[0].setIcon(new ImageIcon(lesson.class.getResource("/hayden/lesson6.jpg")));
		label[0].setBounds(0,-28,730,520);

		btnNext.setVisible(false);
		setTitle("LESSON 6");
		temp = 7;
	}

	//make notes for lesson 2 visible
	public void shownotes(){
		for(int i = 1;i<12;i++){
			label[i].setVisible(true);
		}
	}
	
	//make notes for lesson 3 visible
	public void shownotes1(){
		for(int i = 12;i<20;i++){
			label[i].setVisible(true);
		}
	}

	//performs action when user clicks a specified button
	public void actionPerformed(ActionEvent e) {
		btnNext.setVisible(true);
		btnPrevious.setVisible(true);
		for(int i =1;i<20;i++){
			label[i].setVisible(false);
		}
		
		//if user clicks next or begin it shows the next frame
		if(e.getSource() ==  btnNext || e.getSource() == btnBegin)
		{
			switch (temp)
			{
			case 1 : 
				sound(notes[0]);
				btnBegin.setVisible(false);
				btnPrevious.setVisible(false);
				lesson1();
				break;
			case 2 : 
				lesson2();
				break;
			case 3 : 
				lesson3();
				break;
			case 4 : 
				lesson4();
				break;
			case 5 : 
				lesson5();
				break;
			case 6 :
				btnQuiz.setVisible(true);
				lesson6();
				break;
			case 7:		
				btnQuiz.setVisible(true);
				break;
			}
		}
		
		//if user clicks the begin button it goes back to the previous frame
		if(e.getSource() ==  btnPrevious)
		{
			switch (temp-1)
			{
			case 1 : 
				break;
			case 2 :
				
				btnPrevious.setVisible(false);
				lesson1();
				break;
			case 3 : 
				lesson2();
				break;
			case 4 : 

				lesson3();
				break;
			case 5 : 
				lesson4();
				break;
			case 6 : 
				lesson5();
				break;
			case 7:
				lesson6();		
				break;
			}
		}
		
		//if user clicks main menu it goes back to the main menu
		if(e.getSource() == btnMainMenu)
		{
			dispose();
		}
		
		//if user clicks the quiz button it calls the quiz frame
		if(e.getSource() == btnQuiz)
		{
			quiz quiz = new quiz();
			quiz.setVisible(true);
			dispose();
		}
		
		//if user clicks logout, it closes the entire program 
		if(e.getSource() ==btnLogOut){
			System.exit(0);
		}
	}

	}

