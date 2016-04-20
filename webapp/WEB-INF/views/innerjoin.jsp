<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework: Inner Join</title>
</head>
<body>
    $[for(String[] tableRow : tableResult){]
      <div>$[tableRow[0]</div>|<div>$[tableRow[1]</div><br>
    $[}]
</body>
</html>
