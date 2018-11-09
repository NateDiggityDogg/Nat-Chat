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

	static JLabel label1;
	static JLabel label2;
	static JLabel label3;

	static JTextField textbox1;
	static JTextField textbox2;
	static JTextField textbox3;

	static JCheckBox checkbox1;
	static JCheckBox checkbox2;
	static JCheckBox checkbox3;
	static JCheckBox checkbox4;
	static JCheckBox checkbox5;
	static JCheckBox checkbox6;
	
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
		label1 = new JLabel("First Name");
		label2 = new JLabel("Last Name");
		label3 = new JLabel("Social Security #(We're all friends here!)");

		textbox1 = new JTextField();
		textbox2 = new JTextField();
		textbox3 = new JTextField();

		checkbox1 = new JCheckBox("Nate for Overlord!");
		checkbox2 = new JCheckBox("I Support Nat-Chat");
		checkbox3 = new JCheckBox("This is Getting Ridiculous");
		checkbox4 = new JCheckBox("I wanna kashoot myself");
		checkbox5 = new JCheckBox("Lowell for Freshman pres 2018");
		checkbox6 = new JCheckBox("Luigi says yeet with the heat");
		
		checkboxes[0] = new JCheckBox("Baske");

		saveButton = new JButton("Save");
		resetButton = new JButton("Reset");

		// Adding components to JPanel
//		container.add(paint);
		container.add(checkbox1);
		container.add(checkbox2);
		container.add(checkbox3);
		container.add(checkbox4);
		container.add(checkbox5);
		container.add(checkbox6);
		container.add(label1);
		container.add(label2);
		container.add(label3);
		container.add(textbox1);
		container.add(textbox2);
		container.add(textbox3);
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

				booleans[0] = checkbox1.isSelected();
				booleans[1] = checkbox2.isSelected();
				booleans[2] = checkbox3.isSelected();
				booleans[3] = checkbox4.isSelected();
				booleans[4] = checkbox5.isSelected();
				booleans[5] = checkbox6.isSelected();

				String[] strings = new String[3];
				strings[0] = textbox1.getText();
				strings[1] = textbox2.getText();
				strings[2] = textbox3.getText();

				CSV.write(booleans, strings);

			}
			
			//On reset button press
			if(resetButton.getModel().isPressed()) {
			System.out.println("Fetus repeatus");
			checkbox1.setSelected(false);
			checkbox2.setSelected(false);
			checkbox3.setSelected(false);
			checkbox4.setSelected(false);
			checkbox5.setSelected(false);
			checkbox6.setSelected(false);
			
			textbox1.setText(null);
			textbox2.setText(null);
			textbox3.setText(null);
			
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

		label1.setBounds(0, 0, frameWidth / 4, frameHeight / 16);
		label2.setBounds(0, frameHeight * 2 / 16, frameWidth / 4, frameHeight / 16);
		label3.setBounds(0, frameHeight * 4 / 16, frameWidth / 4, frameHeight / 16);

		textbox1.setBounds(0, frameHeight / 16, frameWidth / 4, frameHeight / 16);
		textbox2.setBounds(0, frameHeight * 3 / 16, frameWidth / 4, frameHeight / 16);
		textbox3.setBounds(0, frameHeight * 5 / 16, frameWidth / 4, frameHeight / 16);

		checkbox1.setBounds(frameWidth / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkbox2.setBounds(frameWidth * 5 / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkbox3.setBounds(frameWidth * 9 / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkbox4.setBounds(frameWidth / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);
		checkbox5.setBounds(frameWidth * 5 / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);
		checkbox6.setBounds(frameWidth * 9 / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);

		saveButton.setBounds(frameWidth / 2, frameHeight * 17 / 32, frameWidth / 12, frameHeight / 16);
		resetButton.setBounds(frameWidth/2, frameHeight*13/32, frameWidth/12, frameHeight/16);
		
	}

}