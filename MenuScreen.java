/* 
 * @ author Christopher Evans, Anthony
 * This class is the menu screen of our game. It has 4 buttons that perform different actions (exiting, commencing gameplay, etc.).
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuScreen extends ScreenFrame implements ActionListener{
	//Instance variables
	private ImageIcon bg, bgGif; //background image of menu screen and the background gif that will be put on labelGif
	private JButton jbtPlay ,jbtInstructions, jbtScores, jbtExit; //action buttons
	private PaintPanel canvas; //all components are put on a PaintPanel which holds the background image
	private JLabel heading, labelGif; //the heading label of the Main Menu and the label that will hold bgGif
	private final Color MENU_COLOR_FG = Color.black, MENU_COLOR_BG = Color.white; //constant colors of menu button foreground and background respectively
	private final Font MENU_FONT = new Font("Brush Script MT", Font.PLAIN, 25); //constant font of menu buttons
	
	//layout for MenuScreen
	MenuScreen(){
		super(); //calls ScreenFrame constructor to create a new ScreenFrame
		
		//set a background image
		bg = new ImageIcon("images/bgMenu.png");
		//instantiate canvas and set null layout manager of canvas so we can manually place components
		canvas = new PaintPanel();
		canvas.setLayout(null);
		this.add(canvas); //add canvas to frame
				
		//add a custom label for the heading
		canvas.add(heading = addCustomLabel("Welcome to Hill Adventure", Color.black, new Font("Brush Script MT", Font.BOLD, 60)));
		heading.setBounds(50, 25, 900, 150); //set bounds for the heading on the canvas
		
		//add a Play button
		jbtPlay = addCustomButton("Play", 95, 540, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtPlay.addActionListener(this); //register action listener
		canvas.add(jbtPlay); //add to canvas
		
		//then add the Instructions button
		jbtInstructions = addCustomButton("Instructions", 305, 540, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtInstructions.addActionListener(this); //register action listener
		canvas.add(jbtInstructions); //add to canvas

		//plus add the Scores button
		jbtScores = addCustomButton("Scores", 515, 540, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtScores.addActionListener(this); //register action listener
		canvas.add(jbtScores); //add to canvas

		//and finally adding the Exit button
		jbtExit = addCustomButton("Exit", 725, 540, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtExit.addActionListener(this); //register action listener
		canvas.add(jbtExit); //add to canvas
		
	}//end of MenuScreen layout 

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//adding different outcomes for each button to allow for multiple menu's to be accessed
		if(e.getSource() == jbtPlay) {
			//create new instance of DifficultyScreen
			// new GameSelectScreen(); Will connect once game is finished being made
			//this.dispose(); //get rid of current frame
		}
		else if(e.getSource() == jbtInstructions) {
			//create new instance of InstructionsScreen
			new InstructionsScreen();
			this.dispose(); //get rid of current frame
		}
		else if(e.getSource() == jbtScores) {
			//create new instance of ScoreScreen
			//new ScoreScreen();
			//this.dispose(); //get rid of current frame
		}
		//exit button exits the program
		else if(e.getSource() == jbtExit) {
			//exit the program
			System.exit(0);
		}
	}//end of actionPerformed method
	
	/*
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g); //override the paintComponent method
			//draw the background image to fill the entire panel
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}//end of paintComponent method
	}

}