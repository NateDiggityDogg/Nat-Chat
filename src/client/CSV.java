package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CSV {
	
		File csvFile;
		PrintWriter writer;
	
	public static void write(Boolean[] booleans, String[] strings) {
		
		for(int i=0;i<6;i++) {
			System.out.println(booleans[i]);
		}
		
		for(int i=0;i<3;i++) {
			System.out.println(strings[i]);
		}
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(strings[0] + strings[1] + ".txt", "UTF-8");
			
			for(int i=0;i<6;i++) {
				writer.println(booleans[i]);
			}
			
			for(int i=0;i<3;i++) {
				writer.println(strings[i]);
			}
				
			writer.close();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Success!");
		
		
	}
}
