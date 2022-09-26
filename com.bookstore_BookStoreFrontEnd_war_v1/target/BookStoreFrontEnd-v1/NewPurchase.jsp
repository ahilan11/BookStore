<%-- 
    Document   : NewPurchase
    Created on : 20 Jul 2022, 13:27:37
    Author     : Vijay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Purchase Page</title>
        <style>
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
            legend{
                color:purple;
            }
        </style>
    </head>
    <body>
        <%@page import="com.bookstore.bookstorefrontend.book.Book" %>
        <%@page  import ="java.util.List" %>

        <h1>Welcome to the new purchase page!</h1>
        <%Double total = 0.0;%>
        <%List<Book> list = (List<Book>)request.getSession(false).getAttribute("salelineitemList");%>
        <%if(list != null){%>
        <%for(Book book : list){%>
        <p>Book ID: <%=book.getBookId()%></p>
        <p>Title: <%=book.getTitle()%></p>
        <p>Author: <%=book.getAuthor()%></p>
        <%total = total + book.getPrice();%>
        <%if(book.getPrice() == 0){%>
        <p>Price: Free</p>
        <%}else{%>
        <p>Price:  <%=book.getPrice()%> </p>
        <%}%>
        <br>
        <%}%>
        <br>
        <p>Total: <%=total%></p>
        <%}%>

        <form action="SaleController" method="post">         
            <fieldset>
                <legend>Enter the Book ID and the location, on your computer, you want the new book to go to then proceed to: </legend>
                <br><!-- comment -->
                <legend style = "text-align: centre">ADD PDF TO CART, which will add your book to your cart</legend>
                <legend style = "text-align: centre">REMOVE PDF/S, which will remove the book with the book ID you enter, from your cart</legend>
                <legend style = "text-align: centre">PURCHASE PDF, which will confirm your sale</legend>

                <div style="margin:0px auto;max-width:600px;">

                    <table align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="width:100%;">
                        <tbody>
                            <tr>
                                <td style="direction:ltr;font-size:0px;padding:9px 0px 9px 0px;text-align:center;">


                                    <div class="mj-column-per-50 outlook-group-fix" style="font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:50%;">

                                        <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%">

                                            <tr>
                                                <td align="left" style="font-size:0px;padding:15px 15px 15px 15px;word-break:break-word;">
                                                    <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:14px;line-height:1.5;text-align:left;color:#000000;"><p style="font-size: 11px; font-family: Ubuntu, Helvetica, Arial; text-align: center;"><span style="font-size: 14px;">
                                                                <label for='bookId'>Book ID: </label>
                                                                <input type='text' name='bookId' id='bookId'></span></p></div>       

                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="left" style="font-size:0px;padding:15px 15px 15px 15px;word-break:break-word;">
                                                    <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:14px;line-height:1.5;text-align:left;color:#000000;"><p style="font-size: 11px; font-family: Ubuntu, Helvetica, Arial; text-align: center;"><span style="font-size: 14px;">

                                                                <label for='location'>Location on PC: </label>
                                                                <input type='text' name='location' id='location'>
                                                                </td>

                                                                </tr>
                                                                </table>

                                                                </div>
                                                                </td>
                                                                </tr>
                                                                </tbody>
                                                                </table>

                                                                </div>
                                                                <input style="font-size: 15px; display: inline-block; background: #e85034; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px; cursor: pointer;" type="submit" name="submit" value="ADD PDF TO CART">
                                                                <input style="font-size: 15px; display: inline-block; background: #e85034; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px; cursor: pointer;" type="submit" name="submit" value="PURCHASE PDF/S">
                                                                <input style="font-size: 15px; display: inline-block; background: #e85034; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px; cursor: pointer;" type="submit" name="submit" value="REMOVE PDF/S">

                                                                </fieldset>
                                                                </form>
                                                                <form action="BookController" method="post">
                                                                    <fieldset>
                                                                        <legend>Click this button to view a list of all available books</legend>
                                                                        <input type="submit" name="submit" value="DISPLAY ALL BOOKS" style="display: inline-block; background: #ff99cc; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px;">
                                                                    </fieldset>
                                                                </form>

                                                                <br><!-- comment -->
                                                                <%String fail = (String) request.getAttribute("failure");%>
                                                                <%if(fail!= null){ %>
                                                                <p><%=fail%></p>
                                                                <%}%>
                                                                <br><!-- comment -->

                                                                </body>
                                                                </html>
