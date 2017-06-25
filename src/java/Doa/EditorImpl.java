/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doa;

import Models.Book;
import Models.Editor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YS
 */
public class EditorImpl implements IEditor
{
    Select sb=new Select();

    @Override
    public boolean addEditor(Editor e) {
        Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="insert into editor (EditorID,EditorName,EditorAddress) values("+e.getEditorID()+",'"+e.getEditorName()+"','"+e.getEditorAddress()+"')";
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
    public boolean deleteEditor(Editor e) {
           Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        String req1="delete from book WHERE  EditorID = "+e.getEditorID()+"";
			String req="delete from editor WHERE EditorID = "+e.getEditorID()+"";
			Statement st=c.createStatement();
                        st.execute(req1);
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
    public boolean updateEditor(Editor e) {
         Connection c=null;
		boolean bool=false;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
			String req="UPDATE editor SET EditorName = '"+e.getEditorName()+"',EditorAddress = '"+e.getEditorAddress()+"' WHERE EditorID = "+e.getEditorID()+"";
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
    public Editor selectEditor(Editor e) {
       
        List<Book> listbook=null;
                Connection c=null;
		Editor e1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from editor where EditorID="+e.getEditorID()+"";
                      
                        Statement st=c.createStatement();
                      
                           listbook = sb.selectBooks(e);
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{
			     e1=new Editor();
                             e1.setEditorID(Integer.parseInt(s.getString("EditorID")));
                             e1.setEditorName(s.getString("EditorName"));
                             e1.setEditorAddress(s.getString("EditorAddress"));
                             e1.setBookList(listbook);
                             
                             

			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return e1;
    }
    
    @Override
    public List<Editor> selectListEditor() {
       List<Editor> listEditor=new ArrayList<Editor>();
        List<Book> listbook=null;
                Connection c=null;
		Editor e1=null;
                ResultSet s;
		try
		{
			c=ConnectionManager.getInstance().etablirconnection();
                        
			String req="select * from editor";
                      
                        Statement st=c.createStatement();
                      
                          
                      
                             s=st.executeQuery(req);
                        
			
			
			while(s.next())
			{    listbook = new ArrayList<Book>();
			     e1=new Editor();
                             e1.setEditorID(Integer.parseInt(s.getString("EditorID")));
                             e1.setEditorName(s.getString("EditorName"));
                             e1.setEditorAddress(s.getString("EditorAddress"));
                             listbook=sb.selectBooks(e1);
                             e1.setBookList(listbook);
                             listEditor.add(e1);

			}
                        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.getInstance().fermerConnection(c);
		}
		
		return listEditor;
    }
    
}
