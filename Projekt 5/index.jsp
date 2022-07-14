<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kalkulator</h1>
        
        <form action="wynik.jsp" method="post">
            <label>Podaj pierwszą liczbę:</label><input type="text" name="liczba1"/><br>
            <label>Podaj drugą liczbę:</label><input type="text" name="liczba2"/><br>
            <button type="submit">Dodaj liczby</button>
            <button type="reset">Wyczyść pola</button>
        </form>
        
        
        
        
    </body>
</html>
