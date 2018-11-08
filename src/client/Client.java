package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	
	static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	static int frameWidth = screenWidth/2;
	static int frameHeight = screenHeight/2;
	
	static JTextField textbox1;
	static JTextField textbox2;
	static JTextField textbox3;
	
	static JCheckBox checkbox1;
	static JCheckBox checkbox2;
	static JCheckBox checkbox3;
	
	static JButton saveButton;
	
	static JLayer layout;

	

	public static void main(String[] args) {
		JFrame clientFrame = new JFrame();
		clientFrame.setTitle("Nat-Chat");
		clientFrame.setSize(frameWidth, frameHeight);
		clientFrame.setLocation(screenWidth/4,screenHeight/4);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.setVisible(true);
		
		drawingComponent paint = new drawingComponent();
		
		JPanel container = new JPanel();
		
		textbox1 = new JTextField(20);
		textbox2 = new JTextField(20);
		textbox3 = new JTextField(20);
		checkbox1 = new JCheckBox("E-Z Dubs");
		checkbox2 = new JCheckBox("Not so E-Z Dubs");
		checkbox3 = new JCheckBox("Super E-Z Dubs");
		saveButton = new JButton();
		
	//	clientFrame.add(textbox1);
//		clientFrame.add(textbox2);
//		clientFrame.add(textbox3);
		container.add(checkbox1);
		container.add(checkbox2);
		container.add(checkbox3);
		container.add(textbox1);
		container.add(textbox2);
		container.add(textbox3);
		clientFrame.add(saveButton);
		container.add(paint);
		
		clientFrame.add(container);
		clientFrame.repaint();

	}
	
}
