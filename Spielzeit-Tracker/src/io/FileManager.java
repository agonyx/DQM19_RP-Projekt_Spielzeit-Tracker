package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Jann-Leon Winkler
 *
 */
public class FileManager {

	public boolean create(String filename) throws IOException, FileCreationError{
		File file = new File(filename);
		if (file.createNewFile()) {
            System.out.println("File created" + file.getAbsolutePath());
            return true;
        } else {
        	return false;
        }
	}
	public void write (String filename,String message) throws IOException {
        FileWriter fw = new FileWriter(filename);
        fw.write(message);
        fw.close();
    }
	public boolean doesExist(String filename) {
		File f= new File(filename);
		return f.exists();
	}
	public void delete(String filename) {
		File f = new File(filename);
		if(f.delete()) {
			System.out.println("sucessfully deleted");
		} else {
			System.out.println("failed to delete");
		}
	}
	public String read(String filename) throws FileNotFoundException {
		File f = new File(filename);
		String data = "";
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			data += sc.nextLine();
		}
		sc.close();
		return data;
	}
}
