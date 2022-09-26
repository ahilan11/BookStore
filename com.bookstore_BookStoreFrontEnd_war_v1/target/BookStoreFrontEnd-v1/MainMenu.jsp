

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.bookstore.bookstorefrontend.employee.Employee"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Menu Page</title>
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


        <%Employee emp = (Employee)request.getSession(false).getAttribute("employee");%>
        <h1>Welcome to the Guy's Books Online Main Menu <%=emp.getName()%></h1>
        
        <label>Click on one of the buttons below to go to the indicated page</label>
        <br>
        <br>
        <table>
            <tr>
                <td>    <a href="index.html"><i class="fa fa-search" aria-hidden="true" style="color:#ff99cc"></i>LOGIN</a>

                </td>
                <td>
                    <a href="RegisterClient.jsp"><i class="fa fa-shopping-basket" aria-hidden="true" style="color:#ff99cc"></i>NEW SALE</a>
                </td>
                <td>
                    <a href="Stock.jsp"><i class="fa fa-cubes" aria-hidden="true" style="color:#ff99cc"></i>STOCK</a>
                </td>
                <td>
                    <a href="RegisterEmployee.jsp"><i class="fa fa-cubes" aria-hidden="true" style="color:#ff99cc"></i>REGISTER EMPLOYEE</a>
                </td>
                <td>
                    <a href="AddBook.jsp"><i class="fa fa-cubes" aria-hidden="true" style="color:#ff99cc"></i>ADD BOOK</a>
                </td>
                <td>
                    <a href="Help.jsp"><i class="fa fa-cubes" aria-hidden="true" style="color:#ff99cc"></i>HELP</a>
                </td>
            </tr>
        </table>
    </body>
    <footer>
        <br>
        <br> 
        <br>
        <h2>About us: </h2>
        <p>Guy's Books Online started as an actual, physical bookstore and was situated in Rosebank.</p>
        <p>The owner Mr Gregory Guy decided to close this bookshop and create an online bookshop.</p>
        <p>The bookshop still kept it's inventory of books and thus the online bookshop provides books in online pdf format as well as an option to buy the physical book.</p>
        <p>We hope you enjoy using the Guy's Books Online web application, and enjoy our books.</p>
        <p>Contact the developer of this web application if you have any questions:</p>
        <p>Developer: Ahilan Naidoo</p>                                    
        <p>Phone:XXX XXX XXXX</p>
    </footer>
</html>
