package reader;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class ReaderReport {
	static String[][] data;
	static int[][] averageData;
	static Boolean[] selectedFiles;

	public static void main() {
		
		data = ReaderSearch.data;
		selectedFiles = ReaderSearch.selectedFiles;
		averageData = new int[data.length][data[0].length];

		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		JFrame readerFrame = new JFrame(Reader.searchText);
		readerFrame.setSize(screenWidth/2, screenHeight/2);
		readerFrame.setLocation(screenWidth/4,screenHeight/4);
		readerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		readerFrame.add(new drawingComponent());
		readerFrame.setVisible(true);

	}
	
	public static double average(String[][] field, Boolean[] selectedFiles, int row) {
		String[] nextArray = reverseView(field, row);
		int[] values = new int[field.length];
		
		double runningTotal = 0;
		double numbersUsed = 0;
		
		for(int i=0;i<field.length;i++) {
			if(selectedFiles[i]) {
				values[i] = Integer.parseInt(nextArray[i]);
				numbersUsed++;
			}
		}
		
		for(int i=0;i<values.length;i++) {
			runningTotal+=values[i];	
			
		}
		
		System.out.println(runningTotal);
		System.out.println(numbersUsed);
		
		return runningTotal/numbersUsed;
		
		
		}
	
	public static String[] reverseView(String[][] field, int row) {
		String[] returnArray = new String[field.length];
		for(int i=0;i<field.length;i++) {
			returnArray[i] = field[i][row];
		}
		return returnArray;
	}
	}
