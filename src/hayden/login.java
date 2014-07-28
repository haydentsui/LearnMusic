/*--------------------------------------------------------------------------------------*/
/*  login.java  -  LearnMusic! teachers users about the basics of music. (Ex. notes, clefs, symbols)                                                         */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author: Hayden Tsui                                                                             */
/*  Date: June 4th 2013                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input: User enters their username and password  							*/
/*  Output:Returns whether or not the information is valid, and also returns their high score                                                                   *
/*--------------------------------------------------------------------------------------*/
package hayden;

import java.io.*;
import java.net.URL;

public class login {

	//declares local variables needed for class
	private static String username;
	private String password;
	private static String highscore;
	
	//setter for variables username and password
	public void setInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//reads the info from text and validates if the user has properly entered the info
	public int getInfo() throws IOException {
		boolean condition = false;
		boolean condition1 = false;
		URL url = getClass().getResource("loginInfo.txt");
		
		// String absPath = url.toString().replace("file:/", "");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				url.openStream()));
		String temp = "";
		do {
			if (this.username.equals(reader.readLine())) {
				condition = true;

				if (this.password.equals(reader.readLine())) {
					condition1 = true;
				}
			} else {
				temp = reader.readLine();
			}
		} while (temp != null);

		//returns 0 if username doesnt match
		if (condition == false) {
			return 0;		
		} 
		//returns 1 if username and passwords match
		else if (condition == true && condition1 == true) {
			return 1;
		}
		//returns 2 if username matches but not password
		else {
			return 2;
		}
	}

	//writes the new info that user entered onto the txt file
	public int writeInfo(String username, String password) throws IOException {
		URL url = getClass().getResource("loginInfo.txt");
		String absPath = url.toString().replace("file:/", "");
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(absPath, true));
		writer.newLine();
		writer.write(username);
		writer.newLine();
		writer.write(password);
		writer.close();
		return 1;
	}

	//saves the score of user, and finds the high score
	public static void saveScores(int score) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(
				"F:/LearnMusic!/bin/hayden/scores.txt"));
		int counter = 0;
		boolean condition = false;
		String scores[] = new String[100];
		String temp = "";
		while (temp != null) {
			scores[counter] = reader.readLine();
			temp = scores[counter];
			counter++;
		}
		
		//checks if the user scores beats their highscire
		for (int i = 0; i < counter-1; i = i + 3) {
			
			//if score is greater, it replaces high score
			if (scores[i].equals(username) && Integer.parseInt(scores[i+2]) < score){
				scores[i + 1] = String.valueOf(score);
				scores[i + 2] = String.valueOf(score);
				highscore = scores[i+2];
				condition = true;
			}
			else if (scores[i].equals(username) && Integer.parseInt(scores[i+2]) > score){
				scores[i+1] = String.valueOf(score);
				highscore = scores[i+2];
				condition = true;
			}
		}
		
		//writes the existing user scores onto the text file
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				"F:/LearnMusic!/bin/hayden/scores.txt"));
		for(int j = 0; j < counter-1; j++){
			writer.write(scores[j]);
			writer.newLine();
		}
		//writes a new user's score onto the text file
		if(condition == false){
			scores[counter+1] = username;
			scores[counter+2] = String.valueOf(score);
			scores[counter+3] = String.valueOf(score);
			for(int i = 1; i < 4 ; i++)
			{
				writer.write(scores[counter + i]);
				writer.newLine();
			}
		}
		writer.close();
	}
	
	public static String returnscores(){
		return highscore;
	}
	public static String username(){
		return username;
	}

}