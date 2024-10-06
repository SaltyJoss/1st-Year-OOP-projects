import uk.ac.leedsbeckett.oop.OOPGraphics;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GraphicsSystem extends OOPGraphics {
	
	public int value = 0;

	File textFile = new File("log.txt"); // creates a new text file called "log.txt"
	BufferedImage savedIMG = getBufferedImage(); // creates a new BufferedImage called "savedIMG"
	JFileChooser fileChoose = new JFileChooser();
	
	ArrayList<String> lineArry = new ArrayList<>(); // makes a arrayList called lineArry
	
	JFrame frame = new JFrame("Joss Salton - Turtle Graphics");
	Button commdBtn = new Button("COMMANDS"); // makes a new button called "COMMANDS"
	Button colorBtn = new Button("COLOURS"); // makes a new button called "COLOURS"
	JPanel panel = new JPanel(); // new JPanel

	String [] listOfCommands = {"penup", "about", "pendown", "forward", "backward", "turnleft", "turnright", "red",
								"blue", "green", "black", "clear", "reset", "save", "load", "square", "triangle", "hexagon",
								"pentagon", "cube", "octagon", "rgb", "close", "penwidth", "execute", "pyramid", "circle"};
	
	String [] commandList = {"command + <parameter(s)>\n where <parameter> = integer value\n ", "penup", "about", "pendown", "forward <parameter>", "backward <parameter>", "turnleft <parameter>", "turnright <parameter>", "red",
								"blue", "green", "black", "clear", "reset", "save", "load", "square <parameter>", "triangle <parameter> / <parameter>,<parameter>,<parameter>", "hexagon <parameter>",
								"pentagon <parameter>", "cube <parameter>", "octagon <parameter>", "rgb <parameter>,<parameter>,<parameter>", "close", "penwidth <parameter>", "execute", "pyramid <parameter>", "circle <parameter>"};
	
	public GraphicsSystem() {
		Container toplevel = frame.getContentPane();
		frame.getContentPane().setBackground(new Color(66,179,252)); // sets frame background colour
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes sure application is closed fully
		frame.setLayout(new FlowLayout());
		
		panel.add(commdBtn); // adds button to panel
		panel.add(colorBtn); // adds button to panel
		panel.setBackground(new Color(66,179,252)); // sets background colour panel
		panel.setLocation(100, 100); // sets location of panel (doesnt work though)
		
		frame.add(panel); // adds panel to the actual frame
		
		toplevel.add(this);
		frame.pack();
		frame.setVisible(true);
		displayMessage("JOSS SALTON"); // displays message
		
		setTurtleImage("yoshi.png"); // changes turtle image
		setBackground_Col(new Color(127,205,255)); // changes background colour of application
		clear(); // clears previous
	
		
		
		commdBtn.addActionListener(new ActionListener(){ // if button is clicked method
			@Override
			public void actionPerformed(ActionEvent e) { // checks for action performed
				JOptionPane.showMessageDialog(null, commandList, "COMMAND LIST", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		colorBtn.addActionListener(new ActionListener() { // if button is clicked method
			@Override
			public void actionPerformed(ActionEvent e) {// checks for action performed
				Color newColor = JColorChooser.showDialog(null, "Color Chooser", new Color(127,205,255)); // creates new Colour Chooser
					
				setPenColour(newColor); // also sets pen to colour of said COLORCHOOSER	
			}
		});
		
		about();
	}
	
	@Override
	public void about() { // OVERRIDES current about() method
		super.about();
		
		String msg = "Created by: Joss Salton"; // new String
		Icon face = new ImageIcon("C:\\Users\\Joss\\TURTLE GRAPHICS ASSIGNMENT\\dance.gif"); // URL based icon, takes the image from URL
		JOptionPane.showMessageDialog(null, "CREATED BY JOSS SALTON", "IMPORTANT", JOptionPane.INFORMATION_MESSAGE, face);
		displayMessage(msg);
	}
	
	public String listOfCommands(String inpCommands) { // method creates a list of ALL commands
		
		for (String command:listOfCommands) { // checks if command in the list
			if(command.equals(inpCommands))
				return command;
			
		}
		return ""; // returns nothing
	}
	
	//requirments 1/2/3/4
	
	@Override
	public void processCommand(String outputCommand) { // OVERRIDES the processCommand() method from turtle graphics
		
		String [] cmdSplit = outputCommand.split(" "); // splits the commands whitespace, adds them to array
		String inputCommands = listOfCommands(cmdSplit[0]); //puts the initial split[0] into a string
		
		int posParameter = 0; // setting position parameter integer to 0
		int val1 = 0, val2 = 0, val3 = 0; // setting 3 values to 0, values used for triangle and RGB
		
		if (cmdSplit.length > 1) { // checks the length of cmdSplit
			posParameter = -1;
			String[] valArry = cmdSplit[1].split(","); // splits the parameter if there's "," involved
			try {
				if(cmdSplit[1].contains(",")) { // if parameter contains ","
					val1 = Integer.parseInt(valArry[0]); // string to integer conversion for index 0 of parameter
					val2 = Integer.parseInt(valArry[1]); // string to integer conversion for index 1 of parameter
					val3 = Integer.parseInt(valArry[2]); // string to integer conversion for index 2 of parameter
				}
				else{
					posParameter = Integer.parseInt(cmdSplit[1]); // string to integer conversion
				}
				
			}
			catch (Exception Errors) { // check for errors
				JOptionPane.showMessageDialog(null, "ERROR: non-numeric value", "ERROR", JOptionPane.ERROR_MESSAGE);
				posParameter = -2;
			}
		}
		
		for (String command : listOfCommands) { // for loop checking if command is in listOfCommands
			if (cmdSplit[0].equals(command)) { // if index 0 equals command
				try {
					FileWriter fileWrite = new FileWriter(textFile, true); // creates a filewriter into existing log.txt file
					fileWrite.write(outputCommand + "\n"); // writes the typed command with parameter
					fileWrite.close(); // closes text file
					
					lineArry.add(outputCommand); // adds typed command with parameter to array list
					
					if (outputCommand.equals("save")) { // if typed command equals "save" 
						FileNameExtensionFilter text = new FileNameExtensionFilter("Text files (*.txt)", "txt"); // sets a filter option for txt files
						fileChoose.setFileFilter(text); // puts the filter option to the file explorer
						int dialog = fileChoose.showSaveDialog(null); // opens the save file "dialog" that opens the file explorer to save file
						
						if(dialog == JFileChooser.APPROVE_OPTION) { // if they press save 
							File file = fileChoose.getSelectedFile(); // saves as typed file
							
							try{
								ArrayList<String> txtArry = new ArrayList<>(); // creates a new array list (string)
								txtArry.addAll(lineArry); // adds all the content from existing array list (lineArry) to new array list (txtArry)
								
								BufferedWriter writeTxt = new BufferedWriter(new FileWriter(file)); // creates a new bufferedWriter based on file just saved file
								for(String lines : txtArry) { // checks for lines in txtArry
									writeTxt.write(lines); // writes all the content from txtArry to the file
									writeTxt.newLine(); // adds a new line to text file
								}
								writeTxt.close(); // closes the text file
								
								JOptionPane.showMessageDialog(null, "text file saved", "IMPORTANT", JOptionPane.INFORMATION_MESSAGE); // says file is saved after click save
							}
							catch(IOException e) { // checks for exceptions
							}
						}
						else if (dialog == JFileChooser.CANCEL_OPTION) { // if cancelled button pressed
							JOptionPane.showMessageDialog(null, "ERROR: user cancelled", "ERROR", JOptionPane.ERROR_MESSAGE); // shows user cancelled
						}
					}
					
				}
				catch(IOException ioe) {
				}

			}
			
		}
		System.out.println(outputCommand); // outputs all commands typed within current session into console
		// System.out.println(lineArry);
		
		switch(inputCommands) { // switch command to do all the heavy lifting of setting the movement / shape / colour etc. work
		case "penup": // case for penUp() command
			penUp();
			value = 0;
			break;
			
		case "pendown": // case for penDown() command
			penDown();
			value = 0;
			break;
			
		case "about": // case for about() command
			about();
			value = 0;
			break;
		
		case "close": // case for close command
			if (JOptionPane.showConfirmDialog(frame, "YOU ARE ABOUT TO CLOSE WITHOUT SAVING", "ARE YOU SURE", 
		            JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION){
				
				System.exit(0);				
		        value = 0;
			}
			break;
			
		case "forward": // case for forward() command
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 200) { // if position parameter is above 200
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				forward(posParameter);
				value = 0;
			}
			break;
			
		case "backward": // case for backward command
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 200) { // if position parameter is above 200
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				forward(posParameter * -1); // then moves forward based on value inputted
				value = 0;
			}
			break;
		
		case "turnleft": // case for turnLeft() command
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 360) { // if position parameter is above 360
				JOptionPane.showMessageDialog(null, "ERROR: Turtle cannot rotate over 360 degrees", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				turnLeft(posParameter); // turns user around the parameter typed
				value = 0;
			}
			break;
				
		case "turnright": // case for turnRight() command
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 360) { // if position parameter is above 360
				JOptionPane.showMessageDialog(null, "ERROR: Turtle cannot rotate over 360 degrees", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				turnRight(posParameter); // turns user around the parameter typed
				value = 0;
			}
			break;
			
		case "red": // case for setPenColour() command
			if (posParameter != 0) { // if position parameter isn't 0
				JOptionPane.showMessageDialog(null, "ERROR: parameter not needed for colours", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				setPenColour(Color.RED); // sets the pen colour as red
				value = 0;
			}
			break;
			
		case "black": // case for setPenColour() command
			if (posParameter != 0) { // if position parameter isn't 0
				JOptionPane.showMessageDialog(null, "ERROR: parameter not needed for colours", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				setPenColour(Color.BLACK); // sets the pen colour as black
				value = 0;
			}
			break;
			
		case "blue": // case for setPenColour() command
			if (posParameter != 0) { // if position parameter isn't 0
				JOptionPane.showMessageDialog(null, "ERROR: parameter not needed for colours", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				setPenColour(Color.BLUE); // sets the pen colour as blue
				value = 0;
			}
			break;
			
		case "green": // case for setPenColour() command
			if (posParameter != 0) { // if position parameter isn't 0
				JOptionPane.showMessageDialog(null, "ERROR: parameter not needed for colours", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				setPenColour(Color.GREEN); // sets the pen colour as green
				value = 0;
			}
			break;
			
		case "clear": // case for clear() command
			if(JOptionPane.showConfirmDialog(frame, "YOU ARE ABOUT TO CLEAR THE CANVAS", "ARE YOU SURE", 
		            JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
				clear();
				lineArry.clear(); // clears lineArrys' contents
				value = 0;
			}
			break;
			
		case "reset": // case for reset() command
			reset();
			
			value = 0;
			break;
			
		case "save": // case for save command
			if (posParameter != 0) { // if position parameter isn't 0
				JOptionPane.showMessageDialog(null, "ERROR: save parameter not needed", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				FileNameExtensionFilter jpeg = new FileNameExtensionFilter("jpeg file(*.jpg)", "jpg");
				FileNameExtensionFilter png = new FileNameExtensionFilter("png file(*.png)", "png");
				fileChoose.setFileFilter(jpeg);
				fileChoose.setFileFilter(png);
				
				int dialog = fileChoose.showSaveDialog(null);
					
				if(dialog == JFileChooser.APPROVE_OPTION) {
					File file = fileChoose.getSelectedFile();
					
					try {
						ImageIO.write(savedIMG, "jpg", file); //writes the image taken from JFrame into the files just created
						value = 0;
						JOptionPane.showMessageDialog(null, "Image saved", "IMPORTANT", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(IOException exception) {
						JOptionPane.showMessageDialog(null, "ERROR: saving image error", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (dialog == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "ERROR: no image to save", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			break;
			
		case "load": // case for laod command
			if (posParameter != 0) { // if position parameter isn't 0
				JOptionPane.showMessageDialog(null, "ERROR: load parameter not needed", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				FileNameExtensionFilter image = new FileNameExtensionFilter("image files", "jpg", "png");
				fileChoose.setFileFilter(image);
				int dialog = fileChoose.showOpenDialog(null);
					
				if(dialog == JFileChooser.APPROVE_OPTION) {
					File file = fileChoose.getSelectedFile();
					
					try {
						BufferedImage imageFile = ImageIO.read(file); // reads the image from file selected, images allowed to be loaded are set in filter
						setBufferedImage(imageFile); // prints the image
						value = 0;
						JOptionPane.showMessageDialog(null, "Image loaded", "IMPORTANT", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(IOException exception) {
						JOptionPane.showMessageDialog(null, "ERROR: loading image error", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (dialog == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "ERROR: no image to load", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			break;
			
		case "execute": // case for execute command
			if (posParameter != 0) { // if position parameter isn't 0
				JOptionPane.showMessageDialog(null, "ERROR: execute parameter not needed", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				FileNameExtensionFilter text = new FileNameExtensionFilter("Text files (*.txt)", "txt");
				fileChoose.setFileFilter(text);
				int dialog = fileChoose.showOpenDialog(null);
				
				if(dialog == JFileChooser.APPROVE_OPTION) {
					File file = fileChoose.getSelectedFile();
					
					try(BufferedReader fileRead = new BufferedReader(new FileReader(file))){ // bufferedReader file initiated based on files chosen
						String line; // sets a string as a line

						while((line = fileRead.readLine()) != null) { // while there's lines to read, read them
							if (line.contains("close") || line.contains("save") || line.contains("load") || line.contains("execute")) { // if lines contains those words dont do
							}
							else {
								processCommand(line); // otherwise process the commands
								
							}

						}
					}
					catch(IOException e) {
						JOptionPane.showMessageDialog(null, "ERROR: text error loading", "ERROR", JOptionPane.ERROR_MESSAGE); // checks errors and produces message
					}
					
				}
				else if (dialog == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "ERROR: user cancelled", "ERROR", JOptionPane.ERROR_MESSAGE); // checks errors and produces message
				}
			}
			break;
		
		case "square": // case for square command
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 200) { // if position parameter is above 200
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				for (int i = 0; i < 4; i++) { // for loop, index = 0, if index is less than 4, index + 1 until index is above 4
					forward(posParameter);
					turnRight(90);
				}
			}
			break;
			
		case "triangle": // case for triangle command
			if(cmdSplit[1].contains(",")) {
				if (val1 < 1 || val2 < 1 || val3 < 1) { // if val1,2,3 are below 1
					JOptionPane.showMessageDialog(null, "ERROR: parameters too low", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if (val1 > 150 || val2 > 150 || val3 > 150) {// if val1,2,3 are above 150
					JOptionPane.showMessageDialog(null, "ERROR: parameters too high", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if ((val1 + val2) > val3 || (val2 + val3) > val1 || (val3 + val1) > val2) { // triangle valid checker
					if (val1 == val2 && val2 == val3) { // checks if all values are the same
						forward(val1);
						turnRight(120);
						forward(val2);
						turnRight(120);
						forward(val3);
					}
					else {
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR: Triangle not valid", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				if (posParameter < 1) { // if position parameter is below 1
					JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if (posParameter > 200) {
					JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					for (int i = 0; i < 3; i++) { // for loop, index = 0, if index is less than 3, index + 1 until index is above 3
						forward(posParameter);
						turnRight(120);
					}
				}
			}
			break;
		
		case "pentagon": // case for pentagon command
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 200) {
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				for (int i = 0; i < 5; i++) { // for loop, index = 0, if index is less than 5, index + 1 until index is above 5
					forward(posParameter);
					turnRight(72);
				}
			}
			break;
			
		case "hexagon": // case for hexagon command
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 200) {
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				for (int i = 0; i < 6; i++) { // for loop, index = 0, if index is less than 6, index + 1 until index is above 6
					forward(posParameter);
					turnRight(60);
				}
			}
			break;
			
		case "octagon": // case for octagon command
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 200) {
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				for (int i = 0; i < 8; i++) { // for loop, index = 0, if index is less than 8, index + 1 until index is above 8
					forward(posParameter);
					turnRight(45);
				}
			}
			break;
			
		case "cube": // case for cube command
			if(posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 125) {
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				for (int i = 0; i < 4; i++) { // for loop, index = 0, if index is less than 4, index + 1 until index is above 4
					forward(posParameter);
					turnRight(90);
				}
				
				turnRight(45);
				forward(posParameter / 2); // for the sides to connect the two squares
				turnLeft(45);
				
				for (int i = 0; i < 4; i++) { // for loop, index = 0, if index is less than 4, index + 1 until index is above 4
					forward(posParameter);
					turnRight(90);
				}
				forward(posParameter);
				turnLeft(135);
				forward(posParameter / 2);
				turnLeft(45);
				forward(posParameter);
				turnLeft(90);
				forward(posParameter);
				turnLeft(45);
				forward(posParameter / 2);
				turnLeft(45);
				forward(posParameter);
				turnLeft(135);
				forward(posParameter / 2);
				reset();
			}
			break;
			
		case "rgb": // case for rgb command
			if (val1 < 0 || val2 < 0 || val2 < 0) { // if val1,2,3 are below 0
				JOptionPane.showMessageDialog(null, "ERROR: parameters too low for RGB", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (val1 > 255 || val2 > 255 || val3 > 255) { // if val1,2,3 are above 255
				JOptionPane.showMessageDialog(null, "ERROR: parameters too high for RGB", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				setPenColour(new Color(val1, val2, val3)); // sets the colour to each 3 values added
				value = 0;
			}
			break;
			
		case "penwidth": // case for 
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 25) { // if position parameter is above 25
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				setStroke(posParameter); //sets the stroke to parameter set
				value = 0;
			}
			break;
			
		case "pyramid":
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 200) {
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				turnLeft(30);
				for (int i = 0; i < 3; i++) { // for loop, index = 0, if index is less than 3, index + 1 until index is above 3
					forward(posParameter);
					turnRight(120);
				}
				
				forward(posParameter);
				turnRight(135);
				forward(posParameter / 2);
				turnLeft(30);
				forward(posParameter / 2);
				turnRight(180);
				forward(posParameter / 2);
				turnLeft(75);
				forward((int) (posParameter * .6666666));
			}
			break;
			
		case "circle":
			if (posParameter < 1) { // if position parameter is below 1
				JOptionPane.showMessageDialog(null, "ERROR: Non-existent parameter", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (posParameter > 200) {
				JOptionPane.showMessageDialog(null, "ERROR: Out of bounds", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				circle(posParameter);
			}
			break;
			
		default: // default case if nothing is typed, or something is typed wrong
			JOptionPane.showMessageDialog(null, "ERROR: invalid command", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		}	
	}
}
