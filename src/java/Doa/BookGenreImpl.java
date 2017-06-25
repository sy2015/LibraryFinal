/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Book;
import Models.BookGenre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YS
 */
public class BookGenreImpl implements IBookGenre {

    Select sb=new Select();
    @Override
    public boolean addBookGenre(BookGenre bg) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into bookgenre (GenreID,GenreName) values("+bg.getGenreID()+",'"+bg.getGenreName()+"')";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public boolean deleteBookGenre(BookGenre bg) {
                Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        String req2="delete from section WHERE  GenreID = "+bg.getGenreID()+"";
                        String req1="delete from book WHERE  GenreID = "+bg.getGenreID()+"";
			String req="delete from bookgenre WHERE GenreID = "+bg.getGenreID()+"";
			Statement st=c.createStatement();
                        st.execute(req2);
                        st.execute(req1);
			st.execute(req);
			bool=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public boolean updateBookGenre(BookGenre bg) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="UPDATE bookgenre SET GenreName = '"+bg.getGenreName()+"' WHERE GenreID = "+bg.getGenreID()+"";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public BookGenre selectBookGenre(BookGenre bg) {
        List<Book> listbook=null;
                Connection c=null;
		BookGenre b1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();              
			String req="select * from bookgenre where GenreID="+bg.getGenreID()+"";
                      
                        Statement st=c.createStatement();
                      
                     listbook = sb.selectBooks(bg);
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     b1=new BookGenre();
                             b1.setGenreID(Integer.parseInt(s.getString("GenreID")));
                             b1.setGenreName(s.getString("GenreName"));
                             b1.setBookList(listbook);
                             
                              
                                
                              

			}
                        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return b1;
    }
    
     public List<BookGenre> selectListBookGenre() {
        List<BookGenre> listbookgenre=new ArrayList<BookGenre>();
        List<Book> listbook=null;
                Connection c=null;
		BookGenre b1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();              
			String req="select * from bookgenre";
                      
                        Statement st=c.createStatement();
                      
                   
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
                             listbook = new ArrayList<Book>();
			     b1=new BookGenre();
                             b1.setGenreID(Integer.parseInt(s.getString("GenreID")));
                             b1.setGenreName(s.getString("GenreName"));
                             listbook=sb.selectBooks(b1);
                             b1.setBookList(listbook);
                             listbookgenre.add(b1);

			}
                        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listbookgenre;
    }
    
}
