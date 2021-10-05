package EranPkG;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * outputFile class for the output file print.
 * after having the complete database, we pass it to printToFileURLandBytes method
 * that will print all of the data structure to the output file.
 */
public class outputFile {
    private BufferedWriter m_writer; //will be the writer to the output file

    /**
     * The constructor, will open the file to write.
     * @param outfile is the name of the output file (args[1])
     * @throws IOException throws when the file opening is failed.
     */
    public outputFile(String outfile) throws IOException {
        m_writer = new BufferedWriter(new FileWriter(outfile));
    }

    /**
     * printToFileUFLSandBytes is for run over the Collection and print to the file the items.
     * @param finalDetailedURLs is the final Collection that hold sorted urls by bytes.
     * @throws IOException throws when the writing to the output file has been failed, in any section of the loop.
     */
    public void printToFileURLSandBytes(ArrayList<URLItem> finalDetailedURLs) throws IOException {
        for (URLItem i :finalDetailedURLs) {
            m_writer.write(i.toString());
        }
    }

    /**
     * CloseFile function forced by implements from FileManager to handle closing the file.
     * @throws IOException throws when close method failed
     */
    public void CloseFile() throws IOException { m_writer.close(); }
}