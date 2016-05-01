<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/user/save" method="post">
    <input  name="id" type="text" value="${item.id}" hidden/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input name="name" type="text" value="${item.name}" class="form-control"/>
    <input name="role" type="text" value="${item.role.name}" class="form-control"/>
    <button type="submit" class="btn">Сохранить</button>
</form>