package reader;

import java.awt.Color;
import java.awt.Font;
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

public class drawingComponent extends JComponent {

	static Font font;

	public void paintComponent(Graphics g) {
		int frameWidth = super.getWidth();
		int frameHeight = super.getHeight();

		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gradPaint = new GradientPaint(0, 0, Color.BLUE, frameWidth, frameHeight, Color.ORANGE);

		System.out.println("draw!");

//		Image image = loadImage("Resources/IMG_1749.JPG");

		font = new Font("sdf", frameWidth/16, frameHeight/16);

		g2d.setPaint(gradPaint);
		g2d.setFont(font);
		g2d.drawString(Double.toString(Math.round(100 * ReaderReport.average(ReaderReport.data, ReaderReport.selectedFiles, 9))/100.00), frameWidth/4, frameHeight/12);
		g2d.drawString(Double.toString(Math.round(100 * ReaderReport.average(ReaderReport.data, ReaderReport.selectedFiles, 10))/100.00), frameWidth/2, frameHeight/12);
		g2d.drawString(Double.toString(Math.round(100 * ReaderReport.average(ReaderReport.data, ReaderReport.selectedFiles, 11))/100.00), frameWidth*3/4, frameHeight/12);

	}

	public BufferedImage loadImage(String imageName) {

		try {
			BufferedImage image = ImageIO.read(new File(imageName));
			return image;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}