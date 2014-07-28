/*--------------------------------------------------------------------------------------*/
/*  jFrame.java  -  LearnMusic! teachers users about the basics of music. (Ex. notes, clefs, symbols)                                                         */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author: Hayden Tsui                                                                             */
/*  Date: June 4th 2013                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input: User can login using their login info or create a new account                                                                             */
/*  Output: Once the user has entered their proper login info or has created their new account 
 * the program will display the main menu in which the user can select to do a lesson or quiz                                                                            *
/*--------------------------------------------------------------------------------------*/
package hayden;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JTextPane;

public class jFrame extends JFrame implements ActionListener {

	//declares local variables 
	private JPanel contentPane;
	private JTextField txtUsername = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JButton btnLogin = new JButton("LOGIN");
	private login logininfo = new login();
	private JButton btnNewUser = new JButton("NEW USER");
	private String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrame frame = new jFrame();
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
	public jFrame() {
		//assigns all coordinates of objects and adds them to frame
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				this.getClass().getResource("music.png")));
		setTitle("Learn Music");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtUsername.setToolTipText("");

		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setBounds(145, 119, 163, 29);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		password.setToolTipText("");

		password.setBounds(145, 157, 163, 29);
		contentPane.add(password);

		btnLogin.addActionListener(this);
		btnLogin.setBounds(116, 197, 104, 23);
		contentPane.add(btnLogin);

		btnNewUser.addActionListener(this);
		btnNewUser.setBounds(230, 197, 104, 23);
		contentPane.add(btnNewUser);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-161, -38, 644, 522);
		lblNewLabel.setIcon(new ImageIcon(jFrame.class
				.getResource("/hayden/background1.jpg")));
		contentPane.add(lblNewLabel);
	}

	//waits until user clicks a button
	public void actionPerformed(ActionEvent e) {
		
		//perform login function if users clicks logins
		if (e.getSource() == btnLogin) {
			String user = txtUsername.getText();
			char[] pass = password.getPassword();
			String p = new String(pass);
			int i = 0;
			logininfo.setInfo(user, p);
			username = user;
			try {
				i = logininfo.getInfo();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//validates if info user entered is correct
			if (i == 0)
				JOptionPane.showMessageDialog(null, "USERNAME NOT FOUND",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			if (i == 1) {
				menu menu = new menu();
				menu.setVisible(true);
				dispose();
			}
			if (i == 2)
				JOptionPane.showMessageDialog(null, "PASSWORD INCORRECT",
						"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		//performs new user function if user clicks on new user
		if (e.getSource() == btnNewUser) {
			
			//pops up a menu for user to put info
			JPanel newpanel = new JPanel();
			JTextField newuser = new JTextField(10);
			JPasswordField newpass = new JPasswordField(10);
			JPasswordField newpass1 = new JPasswordField(10);
			JLabel usernameLbl = new JLabel("Username:");
			JLabel passwordLbl = new JLabel("Password:");
			JLabel password1Lbl = new JLabel("Confirm Password:");

			newpanel.add(usernameLbl);
			newpanel.add(newuser);
			newpanel.add(passwordLbl);
			newpanel.add(newpass);
			newpanel.add(password1Lbl);
			newpanel.add(newpass1);

			int result = JOptionPane.showConfirmDialog(null, newpanel,
					"Make a new Account", JOptionPane.OK_CANCEL_OPTION);

			if (result == JOptionPane.OK_OPTION) {
				char[] pass = newpass.getPassword();
				char[] pass1 = newpass1.getPassword();

				String p = String.valueOf(pass);
				String p1 = String.valueOf(pass1);

				try {
					if (p.equals(p1)) {
						//writes login info
						logininfo.writeInfo(newuser.getText(), p);
					} else {
						//show error message if the two passwords dont match
						JOptionPane.showMessageDialog(null,
								"PASSWORDS DONT MATCH", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

}
