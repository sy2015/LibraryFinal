package Models;

import java.util.List;


/**
 * @author YS
 * @version 1.0
 * @created 09-juin-2017 22:24:31
 */
public class Inventaire {

        private String DateSortie;
        private String DateEntree;
	private Book Book;
	private User User;

    /**
     * @return the Book
     */
    public Book getBook() {
        return Book;
    }

    /**
     * @param Book the Book to set
     */
    public void setBook(Book Book) {
        this.Book = Book;
    }

    /**
     * @return the User
     */
    public User getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(User User) {
        this.User = User;
    }

    /**
     * @return the DateSortie
     */
    public String getDateSortie() {
        return DateSortie;
    }

    /**
     * @param DateSortie the DateSortie to set
     */
    public void setDateSortie(String DateSortie) {
        this.DateSortie = DateSortie;
    }

    /**
     * @return the DateEntree
     */
    public String getDateEntree() {
        return DateEntree;
    }

    /**
     * @param DateEntree the DateEntree to set
     */
    public void setDateEntree(String DateEntree) {
        this.DateEntree = DateEntree;
    }

	

}