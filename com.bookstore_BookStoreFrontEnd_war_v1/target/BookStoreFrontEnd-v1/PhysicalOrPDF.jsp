<%-- 
    Document   : PhysicalOrPDF
    Created on : 20 Jul 2022, 13:52:10
    Author     : Vijay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Physical or PDF Page</title>
        <style>
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
            h1{
                color: green;
                text-align: center;
                font-family: serif;
                font-weight: normal;
                text-transform: uppercase;
                border-bottom: 1px solid #57b1dc;
                margin-top: 30px;
            }
        </style>
    </head>
    <body>
        <h1>Welcome to the Physical or PDF Page</h1>
        <p>Choose whether you want to buy a physical book or a pdf</p>
        <a href ="NewSale.jsp">Click here to purchase a physical book</a>
        <br><!-- comment -->
        <br>

        <a href="NewPurchase.jsp">Click here to purchase a pdf</a>
        <br><!-- comment -->
        <br>
        <a href="MainMenu.jsp">Main Menu</a>
    </body>
</html>
