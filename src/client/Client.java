package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client {
	
	static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	static int frameWidth = screenWidth/2;
	static int frameHeight = screenHeight/2;

	public static void main(String[] args) {
		JFrame clientFrame = new JFrame();
		clientFrame.setTitle("Nat-Chat");
		clientFrame.setSize(frameWidth, frameHeight);
		clientFrame.setLocation(screenWidth/4,screenHeight/4);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.setVisible(true);
		
		drawingComponent paint = new drawingComponent();
		clientFrame.add(paint);

	}
	
}
