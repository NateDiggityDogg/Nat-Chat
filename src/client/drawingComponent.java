package client;

import java.awt.Color;
import java.awt.GradientPaint;
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
	
	GradientPaint gradPaint = new GradientPaint(0, 0, Color.BLUE, frameWidth, frameHeight, Color.ORANGE);

	System.out.println("tick!");
	
	Image image = loadImage("Resources/IMG_1749.JPG");
	
	g2d.setPaint(gradPaint);
	
	g2d.fillRect(0, 0, frameWidth, frameHeight);

//	g2d.drawImage(image, 0, 0, frameWidth, frameHeight, null);
	
	
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