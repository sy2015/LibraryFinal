package presentation;

import Models.Book;
import Models.Author;
import Models.BookGenre;
import Models.Editor;
import Service.BookServiceImpl;
import Service.IBookService;
import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import java.util.ArrayList;
import java.util.List;

public class BooksAction extends ActionSupport {
  private InputStream stream;
  private int bookId;
  private String firstName;
  private String editor;
  private String genre;
  private String language;
  private String date;
  private double price;
  private String reference;
  private String summary;
  private List<Object> authorEditorInfo; 
  
  
  public String redirectBooks(){
    List<Book> bookList = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    bookList = bookService.selectListBook();
    
    ServletActionContext.getRequest().getSession().setAttribute("booksList", bookList);
    return "success";
  }
  
  public String bookDetails(){
    Book book = new Book();
    book.setBookID(bookId);
    IBookService bookService = new BookServiceImpl();
    book = bookService.selectBook(book);
    ServletActionContext.getRequest().getSession().setAttribute("detailedBook", book);
    return "success";
  }
  
  public String deleteBook(){
    String str;
    List<Book> bookList = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    Book book = new Book();
    book.setBookID(bookId);
    boolean deleted = bookService.deleteBook(book);
    if(deleted){
      bookList = bookService.selectListBook();
      ServletActionContext.getRequest().getSession().setAttribute("booksList", bookList);
      str = "success";
    }else{
      str = "failure";
    }
    
    stream = new ByteArrayInputStream(str.getBytes());
    return SUCCESS;
    
  }
  
  public String updateBook(){
    /*
    Author author = new Author(firstName,firstName,1);
    Editor editorN = new Editor(1,editor);
    BookGenre genreN = new BookGenre(1, genre);
    Book book1 = new Book(author, editorN, genreN, 1, language, "FRED The lonely monster", price, date);
    
    bookList.add(book1);
    */
    
    List<Book> bookList = new ArrayList<Book>();
    IBookService bookService = new BookServiceImpl();
    Book book = new Book();
    book.setBookID(bookId);
    book.setBookPrice(price);
    boolean updated = bookService.updateBook(book);
    ServletActionContext.getRequest().getSession().setAttribute("booksList", bookList);
    return "success";
  }
  
 public String authorEditorInfo(){
    authorEditorInfo = new ArrayList<Object>();
    //Author author = new Author("A","B",1);
    //authorEditorInfo.add(author);
    return "json";
  }
  
  public int getBookId() {
    return bookId;
  }
  
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }
  
  public InputStream getStream() {
    return stream;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getEditor() {
    return editor;
  }

  public void setEditor(String editor) {
    this.editor = editor;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public List<Object> getAuthorEditorInfo() {
    return authorEditorInfo;
  }

  public void setAuthorEditorInfo(List<Object> authorEditorInfo) {
    this.authorEditorInfo = authorEditorInfo;
  }
  
  
}
