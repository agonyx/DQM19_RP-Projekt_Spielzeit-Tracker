package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Jann-Leon Winkler
 *
 */
public class FileManager {

	private void create(String filename) throws IOException, FileCreationError{
		File file = new File(filename);
		if (file.createNewFile()) {
            System.out.println("File created" + file.getAbsolutePath());
        } else {
        	throw new FileCreationError();
        }
	}
	private void write (String filename,String message) throws IOException {
        FileWriter fw = new FileWriter(filename);
        fw.write(message);
        fw.close();
    }
	private boolean doesExist(String filename) {
		File f= new File(filename);
		return f.exists();
	}
	private void delete(String filename) {
		File f = new File(filename);
		if(f.delete()) {
			System.out.println("sucessfully deleted");
		} else {
			System.out.println("failed to delete");
		}
	}
}
