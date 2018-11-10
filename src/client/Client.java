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

	// JComponent variable declarations
	static JLabel[] labels;

	static JTextField[] textboxes;

	static JCheckBox[] checkboxes;

	// Counter buttons
	static JButton saveButton;
	static JButton resetButton;
	static JButton adderButtons[];
	static JButton subtracterButtons[];

	// Counter numbers

	static int numbers[];

	static drawingComponent paint;

	public static void main(String[] args) {

		// Defining JFrame properties
		JFrame clientFrame = new JFrame();
		clientFrame.setTitle("Nat-Chat");
		clientFrame.setSize(frameWidth, frameHeight);
		clientFrame.setLocation(screenWidth / 4, screenHeight / 4);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.setVisible(true);

		paint = new drawingComponent();

		JPanel container = new JPanel();

		container.setLayout(null);

		numbers = new int[3];

		numbers[0] = 0;
		numbers[1] = 0;
		numbers[2] = 0;

		// Component Declarations!

		labels = new JLabel[6];

		labels[0] = new JLabel("Team name(all lower case, no spaces)");
		labels[1] = new JLabel("Match #");
		labels[2] = new JLabel("Scout's name");
		labels[3] = new JLabel("Vault cubes");
		labels[4] = new JLabel("Switch cubes");
		labels[5] = new JLabel("Scale cubes");

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

		adderButtons = new JButton[3];
		subtracterButtons = new JButton[3];

		adderButtons[0] = new JButton("+");
		adderButtons[1] = new JButton("+");
		adderButtons[2] = new JButton("+");

		subtracterButtons[0] = new JButton("-");
		subtracterButtons[1] = new JButton("-");
		subtracterButtons[2] = new JButton("-");

		// Adding components to JPanel
		container.add(paint);
		container.add(checkboxes[0]);
		container.add(checkboxes[1]);
		container.add(checkboxes[2]);
		container.add(checkboxes[3]);
		container.add(checkboxes[4]);
		container.add(checkboxes[5]);
		container.add(labels[0]);
		container.add(labels[1]);
		container.add(labels[2]);
		container.add(labels[3]);
		container.add(labels[4]);
		container.add(labels[5]);
		container.add(textboxes[0]);
		container.add(textboxes[1]);
		container.add(textboxes[2]);
		container.add(saveButton);
		container.add(resetButton);
		container.add(adderButtons[0]);
		container.add(adderButtons[1]);
		container.add(adderButtons[2]);
		container.add(subtracterButtons[0]);
		container.add(subtracterButtons[1]);
		container.add(subtracterButtons[2]);
		// Adding panel to frame
		clientFrame.add(container);

		// Tick...
		while (true) {
			frameWidth = clientFrame.getWidth();
			frameHeight = clientFrame.getHeight();

			// On button press
			if (saveButton.getModel().isPressed()) {

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
				
				if(strings[0].length() != 0 && strings[1].length() != 0 && strings[2].length() != 0) {
				saveButton.setVisible(false);
				CSV.write(booleans, strings, numbers);
				}

			}

			// On reset button press
			if (resetButton.getModel().isPressed()) {
				checkboxes[0].setSelected(false);
				checkboxes[1].setSelected(false);
				checkboxes[2].setSelected(false);
				checkboxes[3].setSelected(false);
				checkboxes[4].setSelected(false);
				checkboxes[5].setSelected(false);

				textboxes[0].setText(null);
				textboxes[1].setText(null);

				numbers[0] = 0;
				numbers[1] = 0;
				numbers[2] = 0;

				repaint(clientFrame);

				saveButton.setVisible(true);
			}

			// On counter button press

			for (int i = 0; i < 3; i++) {
				if (adderButtons[i].getModel().isPressed()) {
					numbers[i]++;
					cooldown(adderButtons[i], clientFrame);
					System.out.println(i);
				}
				if (subtracterButtons[i].getModel().isPressed()) {
					numbers[i]--;
					cooldown(subtracterButtons[i], clientFrame);
				}
			}

			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}

			int newFrameWidth = clientFrame.getWidth();
			int newFrameHeight = clientFrame.getHeight();

			if (newFrameWidth != frameWidth || newFrameHeight != frameHeight) {
				reformat(clientFrame);
				repaint(clientFrame);
			}
		}
	}

	// Reformat Components to new frame size
	public static void reformat(JFrame clientFrame) {
		frameWidth = clientFrame.getWidth();
		frameHeight = clientFrame.getHeight();

		labels[0].setBounds(0, 0, frameWidth / 4, frameHeight / 16);
		labels[1].setBounds(0, frameHeight * 2 / 16, frameWidth / 4, frameHeight / 16);
		labels[2].setBounds(0, frameHeight * 4 / 16, frameWidth / 4, frameHeight / 16);
		labels[3].setBounds(frameWidth / 2, frameHeight / 8, frameWidth / 4, frameHeight / 16);
		labels[4].setBounds(frameWidth * 5 / 8, frameHeight / 8, frameWidth / 4, frameHeight / 16);
		labels[5].setBounds(frameWidth * 6 / 8, frameHeight / 8, frameWidth / 4, frameHeight / 16);

		textboxes[0].setBounds(0, frameHeight / 16, frameWidth / 4, frameHeight / 16);
		textboxes[1].setBounds(0, frameHeight * 3 / 16, frameWidth / 4, frameHeight / 16);
		textboxes[2].setBounds(0, frameHeight * 5 / 16, frameWidth / 4, frameHeight / 16);

		checkboxes[0].setBounds(frameWidth / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkboxes[1].setBounds(frameWidth * 5 / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkboxes[2].setBounds(frameWidth * 9 / 16, frameHeight * 5 / 8, frameWidth / 4, frameHeight / 32);
		checkboxes[3].setBounds(frameWidth / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);
		checkboxes[4].setBounds(frameWidth * 5 / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);
		checkboxes[5].setBounds(frameWidth * 9 / 16, frameHeight * 21 / 32, frameWidth / 4, frameHeight / 32);

		adderButtons[0].setBounds(frameWidth / 2, 0, frameWidth / 32, frameWidth / 32);
		subtracterButtons[0].setBounds(frameWidth * 9 / 16, 0, frameWidth / 32, frameWidth / 32);

		adderButtons[1].setBounds(frameWidth * 10 / 16, 0, frameWidth / 32, frameWidth / 32);
		subtracterButtons[1].setBounds(frameWidth * 11 / 16, 0, frameWidth / 32, frameWidth / 32);

		adderButtons[2].setBounds(frameWidth * 12 / 16, 0, frameWidth / 32, frameWidth / 32);
		subtracterButtons[2].setBounds(frameWidth * 13 / 16, 0, frameWidth / 32, frameWidth / 32);

		saveButton.setBounds(frameWidth / 2, frameHeight * 17 / 32, frameWidth / 12, frameHeight / 16);
		resetButton.setBounds(frameWidth / 2, frameHeight * 13 / 32, frameWidth / 12, frameHeight / 16);

	}

	public static void repaint(JFrame clientFrame) {
		frameWidth = clientFrame.getWidth();
		frameHeight = clientFrame.getHeight();
		paint.setBounds(0, 0, frameWidth, frameHeight);
		clientFrame.repaint();
	}

	public static void cooldown(JButton button, JFrame clientFrame) {
		repaint(clientFrame);
		button.setEnabled(false);
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		button.setEnabled(true);
	}
}