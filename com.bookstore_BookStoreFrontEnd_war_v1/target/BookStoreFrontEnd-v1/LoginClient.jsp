<%-- 
    Document   : LoginClient
    Created on : 20 Jul 2022, 09:49:52
    Author     : Vijay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Login Page</title>
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
            legend{
                color:purple;
            }
        </style>
    </head>
    <body>
        <h1>Welcome to the Client Login Page</h1>
        <form action ="ClientController" method="post">
            <fieldset>
                <legend>Enter the details of the client to log them in to use the Book Shop:</legend>
                <label for="email">Email: <input type = "text" name="email"></label>
                <br>
                <br>

                <label for="password">Password: <input type="password" name ="password"></label>
                <br>
                <br>

                <input type="submit" name="submit" value="LOG IN CLIENT" style="font-size: 15px; display: inline-block; background: #49a6e8; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px; cursor: pointer;">
            </fieldset>
        </form>
        <%if(request.getAttribute("failure") != null){%>
        <%=(String)request.getAttribute("failure")%>
        <%}%>
        <br>
        <br>

        <a href="RegisterClient.jsp">Click here to go back to the client register page</a>
    </body>
</html>
