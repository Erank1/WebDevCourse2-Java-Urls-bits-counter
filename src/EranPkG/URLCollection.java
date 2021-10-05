package EranPkG;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * URLCollection class. will contain Collection of URLItem (a class of url object)
 * This is the data structure i created to keep all of the urls by the object class.
 * The data structure filled by the constructor that gets ArrayList of String. each line is
 * a URLItem object. we can get the collection by call "GetMyCollection" method.
 * We can use "sort" because we  have override on Comparable in URLItem so the comparation
 * for the sort is by the bytes we keep as a member in URLItem. we call the method SortMyCollection
 * for that.
 */
public class URLCollection {
    private List m_urls; //member that will be the collection by

    /**
     * Second Constructor will get ArrayList of strings and will convert and add all the URLs
     * into the URLItem collection.
     * @param urlarray the ArrayList of String that contain all the input file (urls)
     * @throws IOException throws when adding item to the collection has been failed.
     */
    public URLCollection(ArrayList<String> urlarray) throws IOException {
        m_urls = new ArrayList<URLItem>();
        for (int i = 0; i < urlarray.size(); i++) {
            try {
                AddItem(urlarray.get(i));
            }
            catch(IOException e){}
        }
    }

    /**
     * private function that only use in the class. it called by the constructor in the loop to create the objects.
     * @param url is a string that contain a valid url (we checked before) and will add it as URLItem
     * @throws IOException throws when Adding to the collection has been failed.
     */
    private void AddItem(String url) throws IOException {
            m_urls.add(new URLItem(url));
    }

    /**
     * SortMyCollection method will sort all of the collection by bytes.
     * Comparable implements in URLItem to override the compare method so it will sort
     * by the size of the bytes.
     */
    public void SortMyCollection(){
        Collections.sort(m_urls);
    }

    /**
     *
     * @return returns the Collection of the URLItem.
     */
    public List GetMyCollection(){
        return m_urls;
    }
}

