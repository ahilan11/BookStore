

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Client Page</title>
        <style>
            p{
                color:blue;
            }
            legend{
                color:purple;
            }
            body{
                background-color: lightyellow;
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
        <h1>Welcome to the Register Client Page</h1>
        <form action ="ClientController" method="post">
            <fieldset>
                <legend>Enter the details of the client to save them to our records:</legend>
                <label for="name">Name: <input type = "text" name="name" id="name"></label>
                <br>
                <br>

                <label for="surname">Surname: <input type="text" name="surname" id="surname"></label>
                <br>
                <br>

                <label for="email">Email: <input type="email" name ="email" id="email"></label>
                <br>
                <br>

                <label for="password">Password: <input type="password" name ="password" id="password"></label>
                <br>
                <br>

                <label for="confirmPassword">Confirm Password: <input type="password" id="confirmPassword" name ="confirmPassword"></label>
                <br>
                <br>

                <input type="submit" name="submit" value="ADD CLIENT" style="font-size: 15px; display: inline-block; background: #49a6e8; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px; cursor: pointer;">
            </fieldset>
        </form>
        <%if(request.getAttribute("id") != null){%>
        <%=(String)request.getAttribute("id")%>
        <%}%>
        <br>
        <p>Already have an account? Click below to log in</p><!-- comment -->
        <a href="LoginClient.jsp">Log In</a>  <a href="MainMenu.jsp">Main Menu</a>
    </body>
</html>
