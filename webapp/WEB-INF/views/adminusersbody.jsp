<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="inner cover">
    <table class="table">
        <tr>
            <th>Имя пользователя</th>
            <th>Роль</th>
            <th></th>
        </tr>
        <c:forEach items="${items}" var="item">
            <c:url var="addUrl" value="/user/change" />
            <c:url var="editUrl" value="/user/change?id=${item.id}" />
            <c:url var="deleteUrl" value="/user/delete?id=${item.id}" />
            <tr>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.role.name}"/></td>
                <td>
                    <button class="btn btn-default" onclick="window.location.href='${editUrl}'">Изменить</button>
                    <button class="btn btn-default" onclick="window.location.href='${deleteUrl}'">Удалить</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button class="btn btn-default" onclick="window.location.href='${addUrl}'">Добавить пользователя</button>
</div>