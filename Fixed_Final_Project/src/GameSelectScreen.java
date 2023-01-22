/* 
 * @ author Christopher Evans, Anthony
 * This class is the menu screen of our game. It has 4 buttons that perform different actions (exiting, commencing gameplay, etc.).
 */
//import necessary packages
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameSelectScreen extends ScreenFrame implements ActionListener{
	//Instance variables
	private ImageIcon bg, bgGif; //background image of menu screen and the background gif that will be put on labelGif
	private JButton jbtInfanite ,jbtSuperjump, jbtMenu; //action buttons
	private PaintPanel canvas; //all components are put on a PaintPanel which holds the background image
	private JLabel heading, labelGif; //the heading label of the Main Menu and the label that will hold bgGif
	private final Color MENU_COLOR_FG = Color.black, MENU_COLOR_BG = Color.white; //constant colors of menu button foreground and background respectively
	private final Font MENU_FONT = new Font("Brush Script MT", Font.PLAIN, 25); //constant font of menu buttons
	
	//layout for MenuScreen
	GameSelectScreen(){
		super(); //calls ScreenFrame constructor to create a new ScreenFrame
		
		//set a background image
		bg = new ImageIcon("images/bgMenu.png");
		//instantiate canvas and set null layout manager of canvas so we can manually place components
		canvas = new PaintPanel();
		canvas.setLayout(null);
		this.add(canvas); //add canvas to frame
				
		//add a custom label for the heading
		canvas.add(heading = addCustomLabel("Select gamemode", Color.black, new Font("Brush Script MT", Font.BOLD, 60)));
		heading.setBounds(50, 25, 900, 150); //set bounds for the heading on the canvas
		
		//add a Play button
		jbtInfanite = addCustomButton("Infanite mode", 95, 540, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtInfanite.addActionListener(this); //register action listener
		canvas.add(jbtInfanite); //add to canvas
		
		//then add the Instructions button
		jbtSuperjump = addCustomButton("Superjump mode", 405, 540, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtSuperjump.addActionListener(this); //register action listener
		canvas.add(jbtSuperjump); //add to canvas

		//and finally adding the Exit button
		jbtMenu = addCustomButton("Menu", 725, 540, 200, 80, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		jbtMenu.addActionListener(this); //register action listener
		canvas.add(jbtMenu); //add to canvas
		
	}//end of MenuScreen layout 

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//adding different outcomes for each button to allow for multiple menu's to be accessed
		if(e.getSource() == jbtInfanite) {
			//create new instance of DifficultyScreen
			// new InfaniteGaeModeScreen(); 
			//this.dispose(); //get rid of current frame
		}
		else if(e.getSource() == jbtSuperjump) {
			//create new instance of InstructionsScreen
			//new MegaJumpGameScreen();
			//this.dispose(); //get rid of current frame
		}
		//exit button exits the program
		else if(e.getSource() == jbtMenu) {
			new MenuScreen();
			this.dispose();
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