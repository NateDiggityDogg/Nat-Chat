package reader;

import reader.Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ReaderSearch {
	static Boolean[] selectedFiles;
	static String[][] data;
	public static void main() {
		String searchText = Reader.searchText.toLowerCase();
		File fileFolder = new File("").getAbsoluteFile();
		File[] files = fileFolder.listFiles();
		selectedFiles = new Boolean[files.length];
		data = new String[files.length][12];
//		System.out.println(files.length);
//		System.out.println(searchText);
		for (int i = 0; i < files.length; i++) {
			try {
				Scanner scan = new Scanner(files[i]);
				Boolean bool = true;
				
				if(scan.hasNextLine()) {
					String comparison = scan.nextLine();
					if(comparison.equals(searchText)) {
//						System.out.println("Found!!!");
						selectedFiles[i] = true;
						data[i][0] = comparison;
						
						for(int k=0;k<11;k++) {
							String line = scan.nextLine();
//							System.out.println(line);
							data[i][k+1] = line;
						}
						
					}else {
						System.out.println("Not found!!!" + comparison);
						selectedFiles[i] = false;
					}
				}else {
					selectedFiles[i] = false;
				}
				
				scan.close();
				
//				System.out.println(selectedFiles.length);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		ReaderReport.main();
		
	}

}
