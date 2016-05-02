<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="container" class="container">
  <nav class="block">
    <ul class="pagination">
      <li><a href="<c:url value='/news?pageNumber=0'/>" aria-label="First"><span aria-hidden="true">&laquo;</span></a></li>
      <c:forEach items="${pagination}" var="page">
        <c:choose>
        <c:when test="${page == currentPage}"><li class="active"><a href="http://localhost:8080/news?pageNumber=<c:out value="${page} "></c:out>"> <c:out value="${page} "></c:out><span class="sr-only">(current)</span></a></li></c:when>
        <c:when test="${page != currentPage}"><li><a href="http://localhost:8080/news?pageNumber=<c:out value="${page} "></c:out>"> <c:out value="${page} "></c:out><span class="sr-only">(current)</span></a></li></c:when>
        </c:choose>
      </c:forEach>
      <li><a href="http://localhost:8080/news?pageNumber=<c:out value="${countOFPages} "></c:out>" aria-label="Last"><span aria-hidden="true">&raquo;</span></a></li>
    </ul>
  </nav>
  <c:forEach items="${news}" var="wholenews">
    <div class="col col-lg-2 block"></div>
    <div class="col col-lg-8 news">
      <h4><c:out value="${wholenews.name} "></c:out></h4>

      <p><c:out value="${wholenews.description} "></c:out></p>
      <a href="#">Подробнее</a>
    </div>
    <div class="col col-lg-2"></div>
  </c:forEach>
  <nav class="block">
    <ul class="pagination">
      <li><a href="<c:url value='/news?pageNumber=0'/>" aria-label="First"><span aria-hidden="true">&laquo;</span></a></li>
      <c:forEach items="${pagination}" var="page">
        <c:choose>
          <c:when test="${page == currentPage}"><li class="active"><a href="http://localhost:8080/news?pageNumber=<c:out value="${page} "></c:out>"> <c:out value="${page} "></c:out><span class="sr-only">(current)</span></a></li></c:when>
          <c:when test="${page != currentPage}"><li><a href="http://localhost:8080/news?pageNumber=<c:out value="${page} "></c:out>"> <c:out value="${page} "></c:out><span class="sr-only">(current)</span></a></li></c:when>
        </c:choose>
      </c:forEach>
      <li><a href="http://localhost:8080/news?pageNumber=<c:out value="${countOFPages} "></c:out>" aria-label="Last"><span aria-hidden="true">&raquo;</span></a></li>
    </ul>
  </nav>
</div>

