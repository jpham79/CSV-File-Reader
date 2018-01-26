


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.*;
/**
 * Provides methods for loading and searching through a data file.
 */
public class Assignment1 {
    /**
     * The file name used by commands other than load. It is overwritten when load is called.
     */
    private String loadedFileName;

    /**
     * The character that is assumed to separate values in lines of files read by this class.
     */
    private final String SEPARATOR = "\\|";

    /**
     * load takes a fileName as an argument and reads in the CSV file at the given path. The data may
     * not all fit in memory.
     *
     * @param fileName The name of the file to be loaded.
     */
    public void naiveLoad(String fileName) {

        loadedFileName = fileName;
        System.out.println("naiveLoad " + fileName);

    }

    /**
     * searchEq takes a columnNumber and a value and prints tuples that match the given value on the
     * given column. More points will be given for faster return of this method.
     *
     * @param columnNumber The column of a row to be checked.
     * @param value The value which column values are checked against.
     * @throws IOException 
     */
    public void naiveSearchEq(int columnNumber, String value) throws IOException {
// code to be added when due date is over
    }
    import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.io.*;
/**
 * Provides methods for loading and searching through a data file.
 */
public class Assignment1 {
    /**
     * The file name used by commands other than load. It is overwritten when load is called.
     */
    private String loadedFileName;
    private String loadedBinaryFileName;

    /**
     * The character that is assumed to separate values in lines of files read by this class.
     */
    private final String SEPARATOR = "\\|";

    /**
     * load takes a fileName as an argument and reads in the CSV file at the given path. The data may
     * not all fit in memory.
     *
     * @param fileName The name of the file to be loaded.
     */
    public void naiveLoad(String fileName) {

        loadedFileName = fileName;
        System.out.println("naiveLoad " + fileName);

    }
    
    public void binaryLoad(String fileName) throws IOException {
    	BufferedReader input = new BufferedReader(new FileReader(fileName)); //reads given file
    	DeflaterOutputStream output = new DeflaterOutputStream(new FileOutputStream("data.bin")); //compresses given file into "data.bin"
    	
		int c;
		while ((c = input.read()) != -1) {  //does the actual writing/compressing
			output.write(c);
    	}
    	loadedBinaryFileName = "data.bin";
    	System.out.println("binaryLoad " + fileName);
    	input.close();
    	output.close();
    }

    /**
     * searchEq takes a columnNumber and a value and prints tuples that match the given value on the
     * given column. More points will be given for faster return of this method.
     *
     * @param columnNumber The column of a row to be checked.
     * @param value The value which column values are checked against.
     * @throws IOException 
     */
    public void naiveSearchEq(int columnNumber, String value) throws IOException {
    	int c;
    	int column = 0; 
    	String currentLine = "";
    	FileReader inputStream = null;
    	try {
			inputStream = new FileReader(loadedFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	while ((c = inputStream.read()) != -1) { // reads till the end of the file
        	char ch = (char)c;
        	
        	if(ch != '\n') { //does not add new line into the array holding the current line
    		currentLine += ch; //adds character by character to the current String[] till the next line
        	}
        	
            if (ch == '|') { //counts how many columns we've been through to find the next line
        		column++;
            }
            
    		if (column == 9) { // marks the end of each line
    			String[] check = currentLine.split(SEPARATOR); // splits each column into the array
    			if (check[columnNumber-1].contentEquals(value)) { //compares the value of the column to the given value
    				System.out.println(currentLine);
    			}
    			column = 0; //resets the counter
    			currentLine = ""; //resets the current line
    		}  	
    	}		
        System.out.println("naiveSearchEq col #" + columnNumber + "=" + value);
        inputStream.close();
    }
    
    public void naiveBufSearchEq(int columnNumber, String value) throws IOException {
    	String currentLine; 
    	BufferedReader inputStream = null; 
    	try {
			inputStream = new BufferedReader(new FileReader(loadedFileName)); //initializing bufferedReader
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	while ((currentLine = inputStream.readLine()) != null) { // reads till the end of the file line by line
    		String[] check = currentLine.split(SEPARATOR); // splits each column into the array
    		if (check[columnNumber-1].contentEquals(value)) { //compares the value of the column to the given value
    			System.out.println(currentLine);
    		}  	
    	}		     
    	System.out.println("naiveBufSearchEq col #" + columnNumber + "=" + value);
    	inputStream.close();
    }

    /**
     * searchGtr takes a columnNumber and a value and prints tuples where the given column is greater
     * than the given value. More points will be given for faster return of this method.
     *
     * @param columnNumber The column of a row to be checked.
     * @param value The value which column values are checked against.
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public void naiveSearchGtr(int columnNumber, float value) throws NumberFormatException, IOException {
    	int c;
    	int column = 0; 
    	String currentLine = "";
    	FileReader inputStream = null;
    	try {
			inputStream = new FileReader(loadedFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	while ((c = inputStream.read()) != -1) { // reads till the end of the file 
        	char ch = (char)c;
        	
        	if(ch != '\n') { //does not add new line into the array holding the current line
    		currentLine += ch; //adds character by character to the current String[] till the next line
        	}
        	
            if (ch == '|') {
        		column++;
            }
            
    		if (column == 9) { //checks if the current line is gtr than the given value, if it is it prints to console
    			String[] check = currentLine.split(SEPARATOR);
    			if (Float.parseFloat(check[columnNumber-1]) > (value)) {
    				System.out.println(currentLine);
    			}
    			column = 0;
    			currentLine = "";
    		}  	
    	}   
        System.out.println("naiveSearchGtr col #" + columnNumber + ">" + value);
        inputStream.close();
    }

	public void naiveBufSearchGtr(int columnNumber, float value) throws NumberFormatException, IOException {
    	String currentLine;
    	BufferedReader inputStream = null;

			inputStream = new BufferedReader(new FileReader(loadedFileName));   	
    	while ((currentLine = inputStream.readLine()) != null) { // reads till the end of the file line by line
    		String[] check = currentLine.split(SEPARATOR);
    		if (Float.parseFloat(check[columnNumber-1]) > value) { //prints current line if value is eq
    			System.out.println(currentLine);
    		}  	
    	}		     
    	System.out.println("naiveBufSearchGtr col #" + columnNumber + "=" + value);
    	inputStream.close();
    }


}

