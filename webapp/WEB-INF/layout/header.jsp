<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
    <nav class="navbar navbar-inverse">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="active navbar-brand" href="<c:url value='/'/>">OrgManager</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="menu-item"><a href="<c:url value='/news'/>">Новости<span class="sr-only">(current)</span></a></li>
                    <sec:authorize access="hasAuthority('USER') ">
                        <li class="menu-item"><a href="<c:url value='/reference'/>">Справочник</a></li>
                        <li class="menu-item"><a href="<c:url value='/tasks'/>">Задачи</a></li>
                    </sec:authorize>
                    <li class="menu-item"><a href="<c:url value='/contacts'/>">Контакты</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="hasAuthority('ADMIN')">
                        <li class="menu-item"><a href="<c:url value='/admin/tasks'/>">Панель администратора</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                    <li class="menu-item"><a href="<c:url value='/login'/>">Войти</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="menu-item"><a href="<c:url value='/login'/>">Выйти</a></li>
                    </sec:authorize>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
    </nav>
</header>