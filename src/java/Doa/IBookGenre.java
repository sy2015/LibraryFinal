/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.BookGenre;
import java.util.List;

/**
 *
 * @author YS
 */
public interface IBookGenre {
    boolean addBookGenre(BookGenre bg);
    boolean deleteBookGenre(BookGenre bg);
    boolean updateBookGenre(BookGenre bg);
    BookGenre selectBookGenre(BookGenre bg);
    List<BookGenre> selectListBookGenre();
}
