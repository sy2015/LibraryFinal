<%@page import="java.util.List"%>
<%@page import="Models.Book"%>
<%@page import="com.google.gson.Gson"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Books List</title>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
        <script src="<%=application.getContextPath() %>/vues/js/jquery-3.2.1.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/script.js"></script>
    </head>
    <body>
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <strong>Email: </strong>support@onlinelibrary.com
                        &nbsp;&nbsp;
                        <strong>Support: </strong>+212 5 00 00 00
                    </div>
                </div>
            </div>
        </header>
        <!-- HEADER END-->
       <div class="navbar navbar-inverse set-radius-zero">
            <div class="container">
                <div class="navbar-header">
                    <div class="welcome-div col-md-7">
                        <img src="<%=application.getContextPath() %>/vues/img/logo.png" style="height:100px;"/>
                    </div>
                    <div class="welcome-div col-md-4">
                        <h2 class="page-head-welcome"><%=session.getAttribute("userSession")%></h2>
                    </div>
                </div>
            </div>
        </div>
        <!-- LOGO HEADER END-->
        <section class="menu-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="navbar-collapse collapse ">
                            <ul id="menu-top" class="nav navbar-nav navbar-right">
                                <li><a  href="index.jsp">Dashboard</a></li>   
                                <li><a class="menu-top-active" href="booksList.jsp">Books</a></li>
                                <li><a href="borrowsList.jsp">Borrows</a></li>
                                <li><a href="usersList.jsp">Users</a></li>
                                <li><a href="forms.html">Shelfs</a></li>
                                <li><a href="login.html">Log Out</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- MENU SECTION END-->
        <div id="container" class="content-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="page-head-line">Books List</h4>
                    </div>
                </div>
                <div class="row" style="margin-bottom: 10px;">
                    <div class="col-md-3 col-md-offset-9">
                        <a class="btn btn-default btn-md pull-right" href="createBook.jsp">
                            <span class="glyphicon glyphicon-plus"></span> Add a new Book
                        </a>
                    </div>
                </div>
                 <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Books currently in library 
                                <input type="text" id="bookSearchInput" onkeyup="filterBooks()" placeholder="Search by" class="filterButton">
                                 <select id="bookFilter" class="filterSelect" onchange="clearFilterInput()">
                                    <option value="1">Book's Name</option>
                                    <option value="2">Author's Name</option>
                                    <option value="3">Book's Editor</option>
                                    <option value="4">Book's Genre</option>
                                    <option value="5">Book's Language</option>
                                    <option value="6">Book's Publication</option>
                                    <option value="7">Books in Library</option>
                                </select>   
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table id="booksTable" class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th class="pointer" onclick="sortTable(0)">#</th>
                                                <th class="pointer" onclick="sortTable(1)">Book's name</th>
                                                <th class="pointer" onclick="sortTable(2)">Book's Author</th>
                                                <th class="pointer" onclick="sortTable(3)">Book's Editor</th>
                                                <th class="pointer" onclick="sortTable(4)">Book's Genre</th>
                                                <th class="pointer" onclick="sortTable(5)">Book's Language</th>
                                                <th class="pointer" onclick="sortTable(6)">Book's Publication</th>
                                                <th class="pointer" onclick="sortTable(7)">Books in Library</th>
                                                <th>Details</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% 
                                                List<Book> booksList = (List<Book>)session.getAttribute("booksList");
                                                for(int i=0;i<booksList.size();i++){
                                                Book book = (Book)booksList.get(i);
                                            %>
                                            <tr>
                                                <td><%=book.getBookID()%></td>
                                                <td><%=book.getBookName()%></td>
                                                <td><%=book.getBookAuthor().getAuthorFirstName() + " " + book.getBookAuthor().getAuthorLastName()%></td>
                                                <td><%=book.getBookEditor().getEditorName()%></td>
                                                <td><%=book.getBookGenre().getGenreName()%></td>
                                                <td><%=book.getBookLanguage()%></td>
                                                <td><%=book.getBookPublicationDate()%></td>
                                                <td><%=book.getBooksInStore()%></td>
                                                <td class="text-center"><a href="<s:url action="bookDetails" namespace="/vues" />?bookId=<%=book.getBookID()%>" data-toggle="modal" data-target="#bookDetailsModal<%=book.getBookID()%>"><img src="/Library_Final/vues/img/bookDetail.png" width="25" height="25"></img></a></td>
                                            </tr>
                                            
                                            <div class="container">
                                                <div id="bookDetailsModal<%=book.getBookID()%>" class="modal fade" role="dialog">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <%}
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                                <div id="pagination"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- CONTENT-WRAPPER SECTION END-->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        &copy; 2017 The OnlineLibrary | 62 Street 2 Maarif Casablanca Morocco</a>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
