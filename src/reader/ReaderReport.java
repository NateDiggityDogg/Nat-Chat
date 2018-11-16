package reader;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class ReaderReport {
	static String[][] data;
	static Boolean[] selectedFiles;

	public static void main() {
		
		data = ReaderSearch.data;
		selectedFiles = ReaderSearch.selectedFiles;

		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		JFrame readerFrame = new JFrame();
		readerFrame.setSize(screenWidth/2,screenHeight/2);
		readerFrame.setLocation(screenWidth/4, screenHeight/4);
		readerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		readerFrame.setVisible(true);
		System.out.println("");
		System.out.println(data[1][11]);
		
//		for(int i = 0; i<selectedFiles.length;i++) {
//			if(selectedFiles[i]) {
//			for(int k = 0; k<12; k++) {
//				System.out.println(data[i][k]);
//			}
//			}
//		}

	}

}
