package EranPkG;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * URLHandler an abstract class that implements of Comparable interface.
 * This class is the base class of URLItem. It has two methods.
 * URLContentInBytes is a public method that open the url and return the
 * answer from FileBytesCounter method (private method) that return the num of bytes in the
 * stream we opened by URL java class. URLItem call the URLContentInBytes method to gets the
 * number of bytes.
 */
public abstract class URLHandler implements Comparable<URLItem>  {
    /**
     * private method. it uses only for the constructor. private method for the class.
     * @param line the url that we pass from the constructor.
     * @return return an answer from a called function "FileBytesCounter" (long type)
     * @throws IOException throws when the url or the openStream has been failed.
     */
    public long URLContentInBytes(String line) throws IOException {
        URL url = new URL(line);
        return FileBytesCounter(url.openStream());
    }

    /**
     * private method. it uses only from the URLContentInBytes function.
     * @param bytesReader will get InputStream (the file that we open from the url)
     * @return it will return the counter typed "long" after finishing the loop.
     * the method has inside try - catch to handle the situation when a reading is failing.
     * so the counter will be 0 and return.
     */
    private long FileBytesCounter(InputStream bytesReader)  {
        long counter = 0;
        try {
            while (bytesReader.read() != -1)
                ++counter;
        }
        catch(IOException e){
            counter = 0;
        }
        return counter;
    }

}
