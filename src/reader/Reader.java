package reader;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Reader {
	
	static JFrame clientFrame;
	static JPanel container;
	
	static JTextField searchBox;
	static JButton searchButton;
	
	static int screenWidth;
	static int screenHeight;

	public static void main(String[] args) {
		
		screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		clientFrame = new JFrame("Nat-Chat Viewer");
		clientFrame.setSize(screenWidth/2, screenHeight/2);
		clientFrame.setLocation(screenWidth/4, screenHeight/4);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.setVisible(true);
		
		container = new JPanel();
		container.setLayout(null);
		
		searchBox = new JTextField();

	}

}
