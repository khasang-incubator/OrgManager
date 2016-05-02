<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="inner cover">
    <table class="table">
        <tr>
            <th>Имя пользователя</th>
            <th>Начальник</th>
            <th>Роль</th>
            <th></th>
        </tr>
        <c:forEach items="${items}" var="item">
            <c:url var="addUrl" value="/admin/user/add" />
            <c:url var="editUrl" value="/admin/user/change?id=${item.id}" />
            <c:url var="deleteUrl" value="/admin/user/delete?id=${item.id}" />
            <tr>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.manager.name}"/></td>
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