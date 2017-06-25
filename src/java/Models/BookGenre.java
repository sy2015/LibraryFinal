package Models;

import java.io.Serializable;
import java.util.List;


/**
 * @author Not-Aimane
 * @version 1.0
 * @created 09-juin-2017 22:24:30
 */
public class BookGenre implements Serializable {

	private List<Book> bookList;
	private int genreID;
	private String genreName;

    /**
     * @return the bookList
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * @param bookList the bookList to set
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * @return the genreID
     */
    public int getGenreID() {
        return genreID;
    }

    /**
     * @param genreID the genreID to set
     */
    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    /**
     * @return the genreName
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * @param genreName the genreName to set
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

	

}