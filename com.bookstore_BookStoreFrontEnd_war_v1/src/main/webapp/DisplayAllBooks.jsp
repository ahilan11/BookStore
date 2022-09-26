

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display All Books Page</title>
        <style>
             label{
                color:purple;
            }
            h1{
                color: green;
                text-align: center;
                font-family: serif;
                font-weight: normal;
                text-transform: uppercase;
                border-bottom: 1px solid #57b1dc;
                margin-top: 30px;
            }
            body{
                background-color: lightyellow;
            }
            a:link, a:visited {
                background-color: #f44336;
                color: white;
                padding: 14px 25px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
            }

            a:hover, a:active {
                background-color: red;
            }
        </style>
    </head>
    <body>
        <%@page import="com.bookstore.bookstorefrontend.book.Book"%>
        <%@page import="java.util.List"%>

        <h1>Welcome to the Display all Books Page</h1>
        <br>
        <label>Below you will find a list of all the books in the shop</label>
        <br>
        <%List<Book> books = (List<Book>) request.getAttribute("books");%>
        <%if(books!= null){%>
        <%for(Book book : books){ %>
        <p>Book ID: <%=book.getBookId()%></p>
        <p>Title: <%=book.getTitle()%></p>
        <p>Description: <%=book.getDescription()%></p>
        <p>Author: <%=book.getAuthor()%></p>       
        <p>Price:  <%=book.getPrice()%> </p>
        <br>
        <%}%>
        <%} else {%>
        <p>The books cannot be found at this time</p>
        <%}%>
        <br>
        <table>
            <tr>
                <td>
                    <%if(request.getSession(false).getAttribute("client")!= null){%>
        <a href="NewPurchase.jsp">Purchase PDF</a>
        </td>
        <td>
        <a href="NewSale.jsp">Purchase Physical Book</a>
        </td>
        <%}%>
         <td>
        <a href="Stock.jsp">Stock Page</a>
        </td>
        <td>
        <a href="MainMenu.jsp">Main Menu</a>
        </td>
    </body>
</html>
