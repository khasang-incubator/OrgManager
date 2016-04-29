<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="inner cover">
    <h1 class="cover-heading">Добро пожаловать!</h1>

    <sec:authorize access="isAuthenticated()">
        <p class="lead">Вы авторизованы как пользователь <sec:authentication property="principal.username" /></p>
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
    <p class="lead">Войдите, для того, чтобы управлять задачами. Без регистрации доступны публичные страницы (Новости, Контакты, Реквизиты)</p>
    <p class="lead">
        <a href="#" class="btn btn-lg btn-default">Узнать больше</a>
    </p>
    </sec:authorize>
</div>