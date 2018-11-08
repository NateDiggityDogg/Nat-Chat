package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class drawingComponent extends JComponent{

	public void paintComponent(Graphics g){
	int frameWidth = super.getWidth();
	int frameHeight = super.getHeight();
	Graphics2D g2d = (Graphics2D) g;

	System.out.println("tick!");
	
	Image image = loadImage("Resources/IMG_1749.JPG");

	g2d.drawImage(image, frameWidth/2, 0, frameWidth/2, frameHeight/2, null);
	
	
	}
	
	public BufferedImage loadImage(String imageName) {
		
		try {
			BufferedImage image = ImageIO.read(new File(imageName));
			return image;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}