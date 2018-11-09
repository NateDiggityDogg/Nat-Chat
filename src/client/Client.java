package client;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {

	static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

	static int frameWidth = screenWidth / 2;
	static int frameHeight = screenHeight / 2;
	
	//JComponent variable declarations
	static JLabel[] labels;
	
	static JTextField[] textboxes;
	
	static JCheckBox[] checkboxes;

	static JButton saveButton;
	static JButton resetButton;

	drawingComponent paint;

	public static void main(String[] args) {

		// Defining JFrame properties
		JFrame clientFrame = new JFrame();
		clientFrame.setTitle("Nat-Chat");
		clientFrame.setSize(frameWidth, frameHeight);
		clientFrame.setLocation(screenWidth / 4, screenHeight / 4);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.setVisible(true);

		// Instancing object to draw image
//		drawingComponent paint = new drawingComponent();

		JPanel container = new JPanel();

		container.setLayout(null);

		// Component Declarations!
		
		labels = new JLabel[3];
		
		labels[0] = new JLabel("First Name");
		labels[1] = new JLabel("Last Name");
		labels[2] = new JLabel("Social Security #(We're all friends here!)");
		
		textboxes = new JTextField[3];
		
		textboxes[0] = new JTextField();
		textboxes[1] = new JTextField();
		textboxes[2] = new JTextField();
		
		checkboxes = new JCheckBox[6];
		
		checkboxes[0] = new JCheckBox("Nate for Overlord!");
		checkboxes[1] = new JCheckBox("I Support Nat-Chat");
		checkboxes[2] = new JCheckBox("LUIGI says yeEt with the heat");
		checkboxes[3] = new JCheckBox("I Wanna Kashoot myself");
		checkboxes[4] = new JCheckBox("Lowell for Freshman pres 2018");
		checkboxes[5] = new JCheckBox("I really hate the capitalization scheme");


		saveButton = new JButton("Save");
		resetButton = new JButton("Reset");

		// Adding components to JPanel
//		container.add(paint);
		container.add(checkboxes[0]);
		container.add(checkboxes[1]);
		container.add(checkboxes[2]);
		container.add(checkboxes[3]);
		container.add(checkboxes[4]);
		container.add(checkboxes[5]);
		container.add(labels[0]);
		container.add(labels[1]);
		container.add(labels[2]);
		container.add(textboxes[0]);
		container.add(textboxes[1]);
		container.add(textboxes[2]);
		container.add(saveButton);
		container.add(resetButton);

		// Adding panel to frame
		clientFrame.add(container);

		// Tick...
		while (true) {
			frameWidth = clientFrame.getWidth();
			frameHeight = clientFrame.getHeight();

			// On button press
			if (saveButton.getModel().isPressed()) {
				System.out.println("Yeetus that fucking fetus");
				saveButton.setVisible(false);

				Boolean[] booleans = new Boolean[6];

				booleans[0] = checkboxes[0].isSelected();
				booleans[1] = checkboxes[1].isSelected();
				booleans[2] = checkboxes[2].isSelected();
				booleans[3] = checkboxes[3].isSelected();
				booleans[4] = checkboxes[4].isSelected();
				booleans[5] = checkboxes[5].isSelected();

				String[] strings = new String[3];
				strings[0] = textboxes[0].getText();
				strings[1] = textboxes[1].getText();
				strings[2] = textboxes[2].getText();

				CSV.write(booleans, strings);

			}
			
			//On reset button press
			if(resetButton.getModel().isPressed()) {
			System.out.println("Fetus repeatus");
			checkboxes[0].setSelected(false);
			checkboxes[1].setSelected(false);
			checkboxes[2].setSelected(false);
			checkboxes[3].setSelected(false);
			checkboxes[4].setSelected(false);
			checkboxes[5].setSelected(false);
			
			textboxes[0].setText(null);
			textboxes[1].setText(null);
			textboxes[2].setText(null);
			
			saveButton.setVisible(true);
			}

			try {
				Thread.sleep(250);
			} catch (Exception e) {
				e.printStackTrace();
			}

			int newFrameWidth = clientFrame.getWidth();
			int newFrameHeight = clientFrame.getHeight();

			if (newFrameWidth != frameWidth || newFrameHeight != frameHeight) {
//				reformat(paint, clientFrame);
				reformat(clientFrame);
			}
		}
	}

	// Reformat Components to new frame size
//		public static void reformat(drawingComponent paint, JFrame clientFrame) {
	public static void reformat(JFrame clientFrame) {
		frameWidth = clientFrame.getWidth();
		frameHeight = clientFrame.getHeight();

//			paint.setBounds(0, 0, frameWidth, frameHeight);

		labels[0].setBounds(0, 0, frameWidth / 4, frameHeight / 16);
		labels[1].setBounds(0, frameHeight * 2 / 16, frameWidth / 4, frameHeight / 16);
		labels[2].setBounds(0, frameHeight * 4 / 16, frameWidth / 4, frameHeight / 16);

		textboxes[0].setBounds(0, frameHeight / 16, frameWidth / 4, frameHeight / 16);
		textboxes[1].setBounds(0, frameHeight * 3 / 16, frameWidth / 4, frameHeight / 16);
		textboxes[2].setBounds(0, frameHeight * 5 / 16, frameWidth / 4, frameHeight / 16);

		checkboxes[0].setBounds(frameWidth / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkboxes[1].setBounds(frameWidth * 5 / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkboxes[2].setBounds(frameWidth * 9 / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkboxes[3].setBounds(frameWidth / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);
		checkboxes[4].setBounds(frameWidth * 5 / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);
		checkboxes[5].setBounds(frameWidth * 9 / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);

		saveButton.setBounds(frameWidth / 2, frameHeight * 17 / 32, frameWidth / 12, frameHeight / 16);
		resetButton.setBounds(frameWidth/2, frameHeight*13/32, frameWidth/12, frameHeight/16);
		
	}

}