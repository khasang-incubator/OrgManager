<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <form action="/admin/user/save" method="post" class="form-signin">
        <input  name="id" type="text" value="${item.id}" hidden/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <h2 class="form-signin-heading">${title}</h2>
        <label for="inputLogin">Login:</label>
        <input name="name" value="${item.name}" type="text" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword">Password</label>
        <input name="password"  value="${item.password}"  type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <label for="inputRole">Role</label>
        <select  name="role" id="inputRole" class="form-control">
            <option>USER</option>
            <option>ADMIN</option>
        </select>

        <label for="manager">Начальник</label>
        <select  name="manager" id="manager" class="form-control">
            <option></option>
            <c:forEach items="${users}" var="user">
                <option><c:out value="${user.name}"/></option>
            </c:forEach>
        </select>
        <br/>
        <button class="btn btn-md btn-success btn-block" type="submit">Сохранить</button>
    </form>
</div>
<script>
    document.querySelector('#inputRole').value='${item.role.name}';
    document.querySelector('#manager').value='${item.manager.name}';
</script>
