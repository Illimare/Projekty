<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           String liczba1 = request.getParameter("liczba1");
           String liczba2 = request.getParameter("liczba2");
           int liczba11 = Integer.parseInt(liczba1);
           int liczba22 = Integer.parseInt(liczba2);
        %>    
        
        <p>Liczba1: <%= liczba1 %></p>
        <p>Liczba2: <%= liczba2 %></p>
        <p>Suma liczb: <%= liczba11+liczba22 %></p>
    </body>
</html>
