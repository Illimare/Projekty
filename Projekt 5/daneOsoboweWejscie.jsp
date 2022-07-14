<%-- 
    Document   : daneOsoboweWejscie
    Created on : 2022-05-25, 12:50:13
    Author     : Roberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formularz Osobowy</title>
    </head>
    <body>
        <h1 style="color:red">Formularz Zgłoszeniowy</h1>

        <form action="daneOsoboweWyjscie.jsp" method="post">
            <p><b><label style="color:blue">Imię:</label><input type="text" name="imie"/></p>
            
            <p><label style="color:blue">Nazwisko:</label><input type="text" name="nazwisko"/></p>
            
            <p style="color:blue"><label>Płeć:</label>
                <input type="radio" checked="checked" name="plec" value="kobieta" /> K
                <input type="radio" name="plec" value="mezczyzna" /> M</p>
            
            <p  style="color:blue"><label>Kurs:</label>
            <input type="checkbox" name="kurs" value="PHP" /> PHP
            <input type="checkbox" name="kurs" value="JAVA" /> JAVA
            <input type="checkbox" name="kurs" value="C++" /> C++</p>
            
            <p><label style="color:blue">Region:</label>
                <select name="region">
                <option>Dolnośląskie</option>
                <option>Kujawsko - pomorskie</option>
                <option>Lubelskie</option>
                <option>Lubuskie</option>
                <option>Łódzkie</option>
                <option>Małopolskie</option>
                <option>Mazowieckie</option>
                <option>Opolskie</option>
                <option>Podkarpackie</option>
                <option>Podlaskie</option>
                <option>Pomorskie</option>
                <option>Śląskie</option>
                <option>Świętokrzyskie</option>
                <option>Warmińsko - mazurskie</option>
                <option>Wielkopolskie</option>
                <option>Zachodniopomorskie</option>
                </select></p>
                
            <p><label style ="color:blue">Uwagi:</label><textarea name="uwagi" rows="5"></textarea></p>
            
            <p><button type="submit">Wyślij</button>
                <button type="reset">Resetuj</button></p>
        </form>
    </body>
</html>
