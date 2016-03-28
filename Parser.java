package twitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Parser {
	private ArrayList<String> strs;
	public ArrayList<String> getStrs() {
        return strs;
     }
	public ArrayList<String> StringsReader(String filename, int wread, int scount) {
		int number = 0;
		String s;
		BufferedReader reader = null;
		File f;
		strs = new ArrayList<String>();
		f = new File(filename);
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.out.println("File '" + f.getAbsolutePath() + "' - not found!");
		}
		try {
			while ((reader.readLine()) != null) {
				number++;
				if (number == wread) {
					for (int i = 0; i < scount; i++)
						if ((s = reader.readLine()) != null)
							strs.add(s);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading file: " + f.getAbsolutePath() + "!");
		}
		return strs;
	}
	public void ShowStrings(String s) {
		System.out.println(s);
		}
}
