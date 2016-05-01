<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
  <form class="form-signin" action="/news/save">
    <h2 class="form-signin-heading">Add news:</h2>
    <label for="title">Title:</label>
    <input type="text" id="title" value="${item.title}" class="form-control" placeholder="Title" required autofocus>
    <label for="description">Content:</label>
    <textarea class="form-control" id="description" value="${item.description}" placeholder="Content"></textarea>
    <label for="message-text">Content:</label>
    <textarea class="form-control" id="message-text" value="${item.fullText}" placeholder="Content"></textarea>
    <button class="btn btn-md btn-success btn-block" type="submit">Add</button>
  </form>
</div>
