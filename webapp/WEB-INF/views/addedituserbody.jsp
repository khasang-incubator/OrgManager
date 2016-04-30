<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form>
    <input type="text" value="${item.name}" class="form-control"/>
    <input type="text" value="${item.role.name}" class="form-control"/>
    <button type="submit" class="btn">Сохранить</button>
</form>