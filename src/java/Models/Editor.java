package Models;

import java.io.Serializable;
import java.util.List;


/**
 * @author Not-Aimane
 * @version 1.0
 * @created 09-juin-2017 22:24:31
 */
public class Editor implements Serializable {

	private List<Book> bookList;
	private String editorAddress;
	private int editorID;
	private String editorName;

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
     * @return the editorAddress
     */
    public String getEditorAddress() {
        return editorAddress;
    }

    /**
     * @param editorAddress the editorAddress to set
     */
    public void setEditorAddress(String editorAddress) {
        this.editorAddress = editorAddress;
    }

    /**
     * @return the editorID
     */
    public int getEditorID() {
        return editorID;
    }

    /**
     * @param editorID the editorID to set
     */
    public void setEditorID(int editorID) {
        this.editorID = editorID;
    }

    /**
     * @return the editorName
     */
    public String getEditorName() {
        return editorName;
    }

    /**
     * @param editorName the editorName to set
     */
    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

	

}