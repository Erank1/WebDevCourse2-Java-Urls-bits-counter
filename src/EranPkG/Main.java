/**
 * @author Eran Reuven 205410848
 */
package EranPkG;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class. will manage the program and catch the general exceptions.
 * We get to the arguments vector 2 values: input file name, output file name.
 * Then, we open the files with the right classes (inputFile, outputFile) by time.
 * The main is the program manager that call and pass values to the different classes by time.
 * The main catch the most of the exceptions and then we have "finally" to close the files
 * no matter if exception has been cached or not.
 */
public class Main {
    /**
     *
     * @param args gets two values: "input.txt" and "output.txt" for the files name we will work with.
     */
    public static void main(String[] args)  {
        if (args.length != 2) {     //if we dont get the args we need, program will terminate.
            System.out.println("wrong usage");
            System.exit(0);
        }
        /* Defining files classes types for each "input" and "output". */
        inputFile inf = null;
        outputFile outf = null;
        try { //try will scope the files that open, the reading, the writing and the collections exeptions.
            inf = new inputFile(args[0]);
            outf = new outputFile(args[1]);
            inf.ReadAllFromFile();
            URLCollection myCollection = new URLCollection((ArrayList<String>) inf.getFileContent());
            myCollection.SortMyCollection();
            outf.printToFileURLSandBytes((ArrayList<URLItem>) myCollection.GetMyCollection());

        } catch (FileNotFoundException e) {
            System.out.println("bad input");
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally{    //no matter if we catch exception or not, closing files will happen.
            try{
                inf.CloseFile();
            }
            catch (Exception e){}
            try{
                outf.CloseFile();
            }catch (Exception e){}

        }
    }
}
