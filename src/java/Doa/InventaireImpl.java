/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Book;
import Models.BookGenre;
import Models.Inventaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YS
 */
public class InventaireImpl implements IInventaire {

    @Override
    public boolean addInventaire(Inventaire i) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into inventaire (UserID,BookID,DateSortie,DateEntree) values("+i.getUser().getUserID()+","+i.getBook().getBookID()+",'"+i.getDateSortie()+"','"+i.getDateEntree()+"')";
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
    public List<Inventaire> selectInventaire(Inventaire i) {
       /* List<BookGenre> listbookgenre=new ArrayList<BookGenre>();
        List<Book> listbook=null;
                Connection c=null;
		BookGenre b1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();              
			String req="select * from bookgenre where GenreID="+bg.getGenreID()+"";
                      
                        Statement st=c.createStatement();
                      
                     listbook = selectBooks(bg);
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     b1=new BookGenre();
                             b1.setGenreID(Integer.parseInt(s.getString("GenreID")));
                             b1.setGenreName(s.getString("GenreName"));
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
		
		return listbookgenre;*/
       return null;
    }

    @Override
    public boolean updateInventaire(Inventaire i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
