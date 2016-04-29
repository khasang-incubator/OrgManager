<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <div class="container">

        <c:choose>
        <c:when test="${not empty error}">
            <div class="error">${error}</div>
        </c:when>
        <c:otherwise>
            <h2 class="form-signin-heading">Добро пожаловать!</h2>
        </c:otherwise>
        </c:choose>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <sec:authorize access="isAnonymous()">
       <form class="form-signin"  name='f' action="<c:url value='/j_spring_security_check'/>" method='POST'>
            <label for="login" class="sr-only">Login:</label>
            <input type="text" id="login" name="username" class="form-control" placeholder="Login" required autofocus>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password"  name="password" class="form-control" placeholder="Password" required>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="btn btn-md btn-success btn-block" type="submit">Войти</button>
        </form>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                <button class="btn btn-md btn-success btn-block" type="submit">Выйти</button>
            </form:form>
        </sec:authorize>
    </div>
<!-- /container -->
