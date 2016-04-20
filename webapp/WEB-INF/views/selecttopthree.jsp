<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
SelectTopThree

<table>
    <c:forEach var="person" items="${name}">
        <tr>
            <td>${person}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
