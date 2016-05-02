<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="inner cover">
    <table class="table">
        <tr>
            <th>Имя задачи</th>
            <th>описание</th>
            <th>автор</th>
            <th>создана</th>
            <th>срок</th>
            <th></th>
        </tr>
        <c:url var="addUrl" value="/tasks/add" />
        <c:forEach items="${items}" var="item">
            <c:url var="editUrl" value="/tasks/change?id=${item.id}" />
            <c:url var="deleteUrl" value="/tasks/delete?id=${item.id}" />
            <tr>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="${item.creator.name}"/></td>
                <td><c:out value="${item.createDate}"/></td>
                <td><c:out value="${item.deadLine}"/></td>
                <td>
                    <button class="btn btn-default" onclick="window.location.href='${editUrl}'">Изменить</button>
                    <button class="btn btn-default" onclick="window.location.href='${deleteUrl}'">Удалить</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button class="btn btn-default" onclick="window.location.href='${addUrl}'">Добавить задачу</button>
</div>