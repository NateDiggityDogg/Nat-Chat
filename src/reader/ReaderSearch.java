package reader;

import reader.Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ReaderSearch {
	static Boolean[] selectedFiles;
	public static void main() {
		String searchText = Reader.searchText.toLowerCase();
		File fileFolder = new File("").getAbsoluteFile();
		File[] files = fileFolder.listFiles();
		selectedFiles = new Boolean[files.length];
		System.out.println(files.length);
		System.out.println(searchText);
		for (int i = 0; i < files.length; i++) {
			try {
				Scanner scan = new Scanner(files[i]);
				Boolean bool = true;
				
				if(scan.hasNextLine()) {
					String comparison = scan.nextLine();
					if(comparison.contains(searchText)) {
						System.out.println("Found!!!");
						selectedFiles[i] = true;
					}else {
						System.out.println("Not found!!!" + comparison);
						selectedFiles[i] = false;
					}
				}
//				System.out.println(searchText);
				
				while (bool == true) {
					if (scan.hasNextLine()) {
						System.out.println(scan.nextLine());
					} else {
						System.out.println("");
						bool = false;
					}
				}
				scan.close();
				
				System.out.println(selectedFiles.length);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<selectedFiles.length;i++) {
			System.out.println(selectedFiles[i]);
		}
		
		ReaderReport.main();
		
	}

}
