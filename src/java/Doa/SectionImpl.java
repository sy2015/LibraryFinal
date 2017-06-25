/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;


import Models.BookGenre;
import Models.Section;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YS
 */
public class SectionImpl implements ISection {
Select select=new Select();
    @Override
    public boolean addSection(Section s) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into section (SectionID,GenreID,NomberBook) values("+s.getSectionID()+","+s.getGenre().getGenreID()+","+s.getNomberBook()+")";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public boolean deleteSection(Section s) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="delete from section WHERE SectionID = "+s.getSectionID()+"";
			Statement st=c.createStatement();
                       
			st.execute(req);
			bool=true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public boolean updateSection(Section s) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="UPDATE section SET GenreID = "+s.getGenre().getGenreID()+",NomberBook  = "+s.getNomberBook()+" WHERE SectionID = "+s.getSectionID()+"";
			Statement st=c.createStatement();
			st.execute(req);
			bool=true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		return bool;
    }

    @Override
    public List<Section> selectListSection() {
        List<Section> listsection=new ArrayList<Section>();
        BookGenre bg=null;
                Connection c=null;
		Section s1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from section";
                      
                        Statement st=c.createStatement();
                      
                           
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
                             bg=new BookGenre();
			     s1=new Section();
                             s1.setSectionID(Integer.parseInt(s.getString("SectionID")));
                             s1.setNomberBook(Integer.parseInt(s.getString("NomberBook")));
                             bg.setGenreID(Integer.parseInt(s.getString("GenreID")));
                             s1.setGenre(select.selectBookGenre(bg));
                             listsection.add(s1);

			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listsection;
    }

    @Override
    public Section selectSection(Section s) {
        BookGenre bg=null;
        Connection c=null;
	Section s1=null;
        ResultSet rs;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from section where SectionID ="+s.getSectionID()+"";
                      
                        Statement st=c.createStatement();
                      
                           
                      
                             rs=st.executeQuery(req);
                        
			
			
			while(rs.next())
			{
                             bg=new BookGenre();
			     s1=new Section();
                             s1.setSectionID(Integer.parseInt(rs.getString("SectionID")));
                             s1.setNomberBook(Integer.parseInt(rs.getString("NomberBook")));
                             bg.setGenreID(Integer.parseInt(rs.getString("GenreID")));
                             s1.setGenre(select.selectBookGenre(bg));
                             

			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return s1;
    }
    
}
