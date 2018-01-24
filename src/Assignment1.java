


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
    
    public void naiveBufSearchEq(int columnNumber, String value) throws IOException {
//code to be added when due date is over
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
//code to be added when due date is over
    }

	public void naiveBufSearchGtr(int columnNumber, float value) throws NumberFormatException, IOException {
//code to be added when due date is over
}
