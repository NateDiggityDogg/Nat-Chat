package reader;

import reader.Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ReaderSearch {
	static Boolean[] selectedFiles;
	public static void main() {
		String searchText = Reader.searchText;
		File fileFolder = new File("").getAbsoluteFile();
		File[] files = fileFolder.listFiles();
		selectedFiles = new Boolean[files.length];
		System.out.println(files.length);
		for (int i = 0; i < files.length; i++) {
			try {
				Scanner scan = new Scanner(files[i]);
				Boolean bool = true;
				
				if(scan.hasNextLine() && scan.nextLine() == searchText) {
					selectedFiles[i] = true;
					System.out.println("Found!!!");
				}
				System.out.println(searchText);
				
				while (bool == true) {
					if (scan.hasNextLine()) {
						System.out.println(i);
						System.out.println(scan.nextLine());
					} else {
						System.out.println("");
						bool = false;
					}
				}
				scan.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
