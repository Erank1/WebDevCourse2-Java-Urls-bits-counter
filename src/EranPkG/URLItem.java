package EranPkG;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * URLItem class extends URLHandler. URLHandler is abstract class.
 * will create an object of url with various methods by the task.
 * This is the URLItem object class. it gets to the constructor String of url.
 * it will keep the number of bytes that we got from the url and also we keep the
 * url (in private members). URLContentInBytes is a class from URLHandler that handle the
 * URL and returns the number of bytes.
 * This class override "toString" (of System) and "compareTo" of Comparable that implements in the base class.
 */
public class URLItem extends URLHandler {
    private String m_url; //member String to hold the url itself as string
    private long m_bytes; //member long to hold the number of bytes from the url page.

    /**
     * Constructor will get url as string and call the right functions.
     * @param url will contain the line (could be valid or invalid url)
     * @throws IOException throws when the url is invalid.
     */
    public URLItem(String url) throws IOException {
        m_bytes = URLContentInBytes(url);
        m_url = url;
    }

    /**
     * Override method "toString".
     * @return returns the string as we want to print to the output file.
     */
    @Override
    public String toString(){
        return m_url + ' ' + m_bytes + '\n';
    }

    /**
     * Override method "compareTo" from implements "Comparable" to make our own compare by bytes.
     * @param urlItem will get URLitem object to compare to the object that called the function (this)
     * @return returns the answer by int. if they equal it returns 0. if the other object
     * is bigger of "this" object, return -1. if "this" bigger than than the other object,
     * return 1.
     */
    @Override
    public int compareTo(URLItem urlItem) {
        return (this.m_bytes < urlItem.m_bytes ? -1 :
                (this.m_bytes == urlItem.m_bytes ? 0 : 1));
    }
}
