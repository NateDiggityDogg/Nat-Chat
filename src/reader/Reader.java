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
	
	static int frameWidth;
	static int frameHeight;
	
	static int newFrameWidth;
	static int newFrameHeight;
	
	static String searchText;

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
		searchButton = new JButton("Search!");
		
		container.add(searchBox);
		container.add(searchButton);
		
		clientFrame.add(container);
		clientFrame.revalidate();
		
		//tick...
		while(true) {
			
			frameWidth = clientFrame.getWidth();
			frameHeight = clientFrame.getHeight();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			newFrameWidth = clientFrame.getWidth();
			newFrameWidth = clientFrame.getHeight();
			
			if(searchButton.getModel().isPressed()) {
				searchText = searchBox.getText();
				clientFrame.remove(container);
				resize();
				clientFrame.dispose();
				ReaderSearch.main();
			}
			
			if(frameWidth != newFrameWidth || frameHeight != newFrameHeight) {
				resize();
			}
			
		}

	}
	public static void resize() {
		
		frameWidth = clientFrame.getWidth();
		frameHeight = clientFrame.getHeight();
		
		searchBox.setBounds(frameWidth/4, frameHeight/2, frameWidth/2, frameWidth/16);
		searchButton.setBounds(frameWidth*3/4, frameHeight/2, frameHeight/8, frameWidth/16);
		
		clientFrame.repaint();

	}

}
