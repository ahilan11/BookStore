<%-- 
    Document   : Help
    Created on : 22 Jul 2022, 10:56:43
    Author     : Vijay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Help Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            h2{
                color: purple;
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
            label{
                color:blue;
            }
        </style>
    </head>
    <body>
        <h1>Welcome to the Help Page of Guy's Books Online</h1>
        <br>
        <label>This page services as a manual on how to use the Guy's Books Online application</label>
        <br>
        <br>
        <label>Add Book Page</label>
        <p>Add books to the database so that they can be used in the store</p>
        <p>The Location on PC parameter is not visible to clients and serves as the location to the book on the pc as a part of the Bookstores collection</p>
        <p>The Stock parameter can be set to 0 (Zero) if the book is only available as a pdf</p>

        <label>Purchase PDF Page</label>
        <p>To get a book ID to enter into the Book ID parameter, click the DISPLAY ALL BOOKS button and copy the book ID of a selected book</p>
        <p>You must add a book to cart before you can click PURCHASE PDF/S</p>
        <p>Enter the book ID into the Book ID parameter and click REMOVE PDF to remove a pdf from your cart</p>
        <p>The Location on PC parameter is where the client would like to send their pdf to on the pc</p>
        <br>

        <label>New Sale Page</label>
        <p>To get a book ID to enter into the Book ID parameter, click the DISPLAY ALL BOOKS button and copy the book ID of a selected book</p>
        <p>You must add a book to cart before you can click MAKE SALE</p>
        <p>Enter the book ID into the Book ID parameter and the quantity into the Quantity parameter and click REMOVE BOOK/S to remove a book of a selected quantity from your cart</p>

        <table>
            <tr>
                <td>
                    <a href='index.html'>Login Page</a>   

                </td>
                <%if(request.getSession(false).getAttribute("employee")!= null){%>
                <td>
                    <a href='MainMenu.jsp'>Main Menu Page</a>   

                </td>
                <%}%>
            </tr>
        </table>
    </body>
</html>

