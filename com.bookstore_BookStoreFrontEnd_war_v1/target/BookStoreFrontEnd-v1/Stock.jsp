

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock Page</title>
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
            legend{
                color:purple;
            }
        </style>
    </head>
    <body>
        <h1>Welcome to the Stock Page</h1>
        <form action="StockController" method="post">
            <fieldset>
                <legend>Enter the Book ID and the quantity that you would like to add</legend>
                <div>
                    <label for="bookId">Book ID: <input type="text" name="bookId" id="bookId"></label>
                    <br>
                    <br>

                    <label for="quantity">Quantity: <input type="number" name = "quantity" id="quantity"></label>
                    <br>
                    <br>

                    <input type="submit" name="submit" value="ADD STOCK" style="font-size: 15px; display: inline-block; background: #49a6e8; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px; cursor: pointer;">
                </div>
            </fieldset>
        </form>
        <br>
        <form action="BookController" method="post">
            <fieldset>
                <legend>Click this button to view a list of all available books</legend>
                <input type="submit" name="submit" value="DISPLAY ALL BOOKS" style="display: inline-block; background: #ff99cc; color: #ffffff; font-family: Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif; font-size: 13px; font-weight: normal; line-height: 100%; margin: 0; text-decoration: none; text-transform: none; padding: 9px 26px 9px 26px; mso-padding-alt: 0px; border-radius: 24px;">
            </fieldset>
        </form>
        <br>
        <br>
        <a href='MainMenu.jsp'>Main Menu</a>
    </body>
</html>
