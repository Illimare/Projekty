
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wynik</title>
    </head>
    <body>
        
        <%
           String imie = request.getParameter("imie");
           String nazwisko = request.getParameter("nazwisko");
           String uwagi = request.getParameter("uwagi");
           String plec = request.getParameter("plec");
           String region = request.getParameter("region");
           
        %>
        <p>Imię: <%= imie%></p>
        <p>Nazwisko: <%= nazwisko%></p>  
        <p>Płeć: <%= plec%></p>
        <p>Region: <%= region%></p>
        <p>Kurs: </p>
            
      <%
           
           String kurs[] = request.getParameterValues("kurs");
           for(String tempKurs : kurs)
           {
               out.println(" <li>" + tempKurs + "</li>");
           }
        %> 
      
        
        <p>Uwagi: </p>
        <%= uwagi%>
    </body>
</html>
