

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book Page</title>
        <style>
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

        </style>
    </head>
    <body>
        <h1>Welcome to the Add Book Page</h1>
        <form action ="BookController" method="post">
            <fieldset>
                <legend>Enter the details of the book to add to the shop:</legend>
                <label for="title">Title: <input type = "text" name="title"></label>
                <br>
                <br>

                <label for="author">Author:  <input type="text" name="author"></label>
                <br>
                <br>

                <label for="description">Description: <textarea id="description" name="description" rows="4" cols="50">
                    </textarea></label><br>                                <br>

                <label for="price">Price:  <input type="text" name ="price"></label>
                <br>
                <br>

                <label for="stock">Stock:  <input type="number" name ="quantity"></label>
                <br>
                <br>

                <label for="location">Location on PC: <textarea id="location" name="location" rows="4" cols="50">
                    </textarea></label>
                <br>
                <br>


                <input type="submit" name="submit" value="ADD BOOK" style="font-size: 15px; display: inline-block; background: #49a6e8; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px; cursor: pointer;">
            </fieldset>
        </form>
        <br>
        <br>
        <a href="MainMenu.jsp">Main Menu</a>
    </body>
</html>
