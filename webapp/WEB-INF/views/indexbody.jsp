<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="inner cover">
    <h1 class="cover-heading">Добро пожаловать!</h1>

    <sec:authorize access="isAuthenticated()">
        <p class="lead">Вы авторизованы как пользователь <sec:authentication property="principal.username" /></p>
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
    <p class="lead">Войдите, для того, чтобы управлять задачами. Без регистрации доступны публичные страницы (Новости, Контакты)</p>
    <p class="lead">
        <a href="<c:url value='/login'/>" class="btn btn-lg btn-default">Войти</a>
    </p>
    </sec:authorize>
</div>