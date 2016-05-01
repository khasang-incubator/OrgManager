<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
    <form action="/user/save" method="post" class="form-signin">
        <input name="id" type="text" value="${item.id}" hidden/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label>Login:</label>
        <input name="name" type="text" value="${item.name}" class="form-control"/>
        <c:choose>
            <c:when test="${not empty item.id}">
                <label>Role:</label>
                <input name="role" type="text" value="${item.role.name}" class="form-control"/>
                <button type="submit" class="btn  btn-md btn-success btn-block">Сохранить</button>
            </c:when>
            <c:otherwise>
                <div class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenuRoles"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        Roles:
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuRoles">
                        <li><a href="#">User</a></li>
                        <li><a href="#">Manager</a></li>
                        <li><a href="#">Admin</a></li>
                    </ul>
                </div>
                <button type="submit" class="btn  btn-md btn-success btn-block">Добавить</button>
            </c:otherwise>
        </c:choose>
    </form>
</div>