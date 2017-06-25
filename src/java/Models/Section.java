package Models;

import java.util.List;


/**
 * @author YS
 * @version 1.0
 * @created 09-juin-2017 22:24:31
 */
public class Section {

	private int NomberBook;
	private BookGenre Genre;
	private int SectionID;

   

    /**
     * @return the Genre
     */
    public BookGenre getGenre() {
        return Genre;
    }

    /**
     * @param Genre the Genre to set
     */
    public void setGenre(BookGenre Genre) {
        this.Genre = Genre;
    }

    /**
     * @return the SectionID
     */
    public int getSectionID() {
        return SectionID;
    }

    /**
     * @param SectionID the SectionID to set
     */
    public void setSectionID(int SectionID) {
        this.SectionID = SectionID;
    }

    /**
     * @return the NomberBook
     */
    public int getNomberBook() {
        return NomberBook;
    }

    /**
     * @param NomberBook the NomberBook to set
     */
    public void setNomberBook(int NomberBook) {
        this.NomberBook = NomberBook;
    }

	
}