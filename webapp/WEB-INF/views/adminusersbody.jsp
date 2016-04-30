<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="inner cover">
    <table class="table">
        <tr>
            <th>Имя пользователя</th>
            <th>Роль</th>
            <th></th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.role.name}"/></td>
                <td></td>

            </tr>
        </c:forEach>
    </table>
</div>