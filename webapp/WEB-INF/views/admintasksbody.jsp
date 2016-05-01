<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="backupURL" value="/backup" />
<button class="btn btn-default" onclick="window.location.href='${backupURL}'">Сделать резевную копию базы</button>