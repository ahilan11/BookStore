

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Employee Page</title>
        <style>
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
            legend{
                color:purple;
            }
        </style>
    </head>
    <body>
        <h1>Welcome to the Register Employee Page</h1>
        <form action ="EmployeeController" method="post">
            <fieldset>
                <legend>Enter the details of the employee to register them to use the Book Shop:</legend>
                <label for="name">Name: <input type = "text" name="name" id="name"></label>
                <br>
                <br>

                <label for="surname">Surname: <input type="text" name="surname" id="surname"></label>
                <br>
                <br>

                <label for="password">Password: <input type="password" name ="password" id="password"></label>
                <br>
                <br>

                <label for="confirmPassword">Confirm Password: <input type="password" id="confirmPassword" name ="confirmPassword"></label>
                <br>
                <br>

                <input type="submit" name="submit" value="REGISTER EMPLOYEE" style="font-size: 15px; display: inline-block; background: #49a6e8; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px; cursor: pointer;">
            </fieldset>
        </form>
        <%if(request.getAttribute("id") != null){%>
        <p>Your employee account was created successfully.</p>
        <%= "Your new employee ID is: " + (String)request.getAttribute("id")%>
        <%}%>
        <br>
        <br>
        <a href="MainMenu.jsp">Click here to go back to the main menu</a>
    </body>
</html>
