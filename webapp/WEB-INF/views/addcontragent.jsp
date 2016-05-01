<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
    <form action="/contragent/save" class="form-signin">
        <h2 class="form-signin-heading">Add —щтек‘путе:</h2>
        <label for="name">Name:</label>
        <input type="text" id="name"  value="${item.name}" class="form-control" placeholder="Name" required autofocus>
        <label for="address">Address:</label>
        <input type="text" id="address"  value="${item.address}" class="form-control" placeholder="Address" required autofocus>
        <label for="email">Address:</label>
        <input type="email" id="email"  value="${item.email}" class="form-control" placeholder="E-Mail" required autofocus>
        <button class="btn btn-md btn-success btn-block" type="submit">Add</button>
    </form>
</div>

