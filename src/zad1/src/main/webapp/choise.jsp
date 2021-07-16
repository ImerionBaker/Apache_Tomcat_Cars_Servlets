<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Choice</title>
</head>
<body>
    <h1>Cars</h1>
    <br>
    <p>
    <form action="choice-servlet" method="get">
        Car type: <select name="car_type">
        <option value="F1">F1</option>
        <option value="Osobowy">Osobowy</option>
        <option value="Cienzarowy">Cienzarowy</option>
    </select>
        <br><br>
        <input type="submit" value="Search" >
    </form>

    </p>

</body>
</html>
