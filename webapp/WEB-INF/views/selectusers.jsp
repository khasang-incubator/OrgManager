<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users</title>
</head>
<body>


<c:forEach items="${users}" var="allnames">
    <c:out value="${allnames} " ></c:out>
</c:forEach>

</body>
</html>
