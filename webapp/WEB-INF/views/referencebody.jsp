<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="container" class="container">
  <c:forEach items="${references}" var="wholeitems">
    <div class="col col-lg-2 block"></div>
    <div class="col col-lg-8 news">
      <h4><c:out value="${wholeitems.name} " ></c:out></h4>
      <p><c:out value="${wholeitems.address} " ></c:out></p>
      <a href="#">Подробнее</a>
    </div>
    <div class="col col-lg-2"></div>
  </c:forEach>
</div>



