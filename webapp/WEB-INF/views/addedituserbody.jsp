<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <form action="/user/save" method="post" class="form-signin">
        <input  name="id" type="text" value="${item.id}" hidden/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <h2 class="form-signin-heading">Add user</h2>
        <label for="inputLogin">Login:</label>
        <input name="name" type="text" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword">Password</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <select  name="role" value="${item.role.name}" class="form-control">
            <option>USER</option>
            <option>MANAGER</option>
            <option>ADMIN</option>
        </select>


      <!--  <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenuRoles" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Roles:
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuRoles">
                <li><a href="#">USER</a></li>
                <li><a href="#">MANAGER</a></li>
                <li><a href="#">ADMIN</a></li>
            </ul>
        </div>-->
        <button class="btn btn-md btn-success btn-block" type="submit">Сохранить</button>
    </form>
</div>
