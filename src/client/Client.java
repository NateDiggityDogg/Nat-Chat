package client;

import java.awt.Color;
import java.awt.FlowLayout;
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
	
	static int frameWidth = screenWidth/2;
	static int frameHeight = screenHeight/2;
	
	static JLabel label1;
	static JLabel label2;
	static JLabel label3;
	
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
		container.setLayout(null);
		
		label1 = new JLabel("Dank");
		label2 = new JLabel("Memes");
		label3 = new JLabel("Kiddos");
		
		textbox1 = new JTextField();
		textbox2 = new JTextField();
		textbox3 = new JTextField();
		checkbox1 = new JCheckBox("E-Z Dubs");
		checkbox2 = new JCheckBox("Not so E-Z Dubs");
		checkbox3 = new JCheckBox("Super E-Z Dubs");
		saveButton = new JButton("Save");
		
//		container.add(checkbox1);
//		container.add(checkbox2);
//		container.add(checkbox3);
//		container.add(label1);
//		container.add(label2);
//		container.add(label3);
//		container.add(textbox1);
//		container.add(textbox2);
//		container.add(textbox3);
//		container.add(saveButton);
		System.out.println("made it!");
		container.add(paint);
		
		clientFrame.add(container);
		
		while (true) {
			frameWidth = clientFrame.getWidth();
			frameHeight = clientFrame.getHeight();
			
			textbox1.setBounds(0, 0, frameWidth/2, frameHeight/2);
			paint.setBounds(frameWidth/2, 0, frameWidth/2, frameHeight/2);
			clientFrame.add(container);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
}
}