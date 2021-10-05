package EranPkG;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * InputFile class for the Input file read.
 * The class gets from the arguments vector the file name as string to the constructor.
 * It open the files, and reads all its content to a database that we will work with in the URLHandler class.
 */
public class inputFile {
    private String line; //line to hold a line when reads.
    private BufferedReader m_reader; //will be the reader
    private List fileContent = new ArrayList<String>(); //will contain all the file content.

    /**
     * InputFile the constructor: will open the input file to read.
     * @param infile is the input file name from the arguments vector.(args[0])
     * @throws FileNotFoundException throws if the file does not exsist.
     */
    public inputFile(String infile) throws FileNotFoundException {
        m_reader = new BufferedReader(new FileReader(infile));

    }

    /**
     * ReadAllFromFile method is to read all the content of the file into "fileContent" collection
     * @throws IOException throws when reading from the file is failed.
     */
    public void ReadAllFromFile() throws IOException {
        while((line = m_reader.readLine())!=null) {
            fileContent.add(line);
        }
    }

    /**
     *
     * @return the fileContent that hold all the input file content.
     */
    public List getFileContent(){
        return fileContent;
    }

    /**
     * Forced function by implements from FileManager.
     * @throws IOException throws when file close is failed.
     */
    public void CloseFile() throws IOException {
        m_reader.close();
    }
}

