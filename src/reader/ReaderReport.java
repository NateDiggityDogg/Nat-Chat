package reader;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class ReaderReport {
	static String[][] data;

	public static void main() {

		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		JFrame readerFrame = new JFrame();
		readerFrame.setSize(screenWidth/2,screenHeight/2);
		readerFrame.setLocation(screenWidth/4, screenHeight/4);
		readerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		readerFrame.setVisible(true);

	}

}
