<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--параметры адресной строки: parentID (null, если нет)--%>

<div class="container">
    <form action="<c:url value="/tasks/save"/>" method="post" class="form-signin" accept-charset="UTF-8">
        <input  name="id" type="text" value="${item.id}" hidden/>
        <input  name="parentid" type="text" value="${parentid}" hidden/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <h2 class="form-signin-heading">${title}</h2>
        <label for="title">Задача:</label>
        <input name="name" type="text" id="title" value="${item.name}" class="form-control" placeholder="Название" required autofocus>

        <label for="description">Описание:</label>
        <textarea name="description" id="description" class="form-control" placeholder="Описание">${item.description}</textarea>

        <label>Сделано:</label>
        <input name="done" type="checkbox"
        <c:if test="${item.done}">checked</c:if>
        >
        <br/> <br/>

        <label for="prioritySlider">Приоритет:</label>
        <p>
            <input name="priority" id="prioritySlider" data-slider-id='prioritySlider'  type="text"
                   data-provide="slider"
                   data-slider-ticks="[0, 3, 6]"
                   data-slider-ticks-labels='["Низкий", "Средний", "Высокий"]'
                   data-slider-min="0"
                   data-slider-max="6"
                   data-slider-step="1"
                   data-slider-value="${item.priority}"/>
        </p>
        <div>
            <SCRIPT LANGUAGE="JavaScript">
                $(function () {
                    $('#startDate').datetimepicker({
                        language: 'ru',
                        minuteStepping: 10,
                        defaultDate: "09.01.2015",
                        daysOfWeekDisabled: [0, 6]
                    });
                });
            </SCRIPT>

            <label for="startDate">Поставлена:</label>
            <div class="input-group date" id="startDate">
                <input name="startdate" data-format="dd/MM/yyyy hh:mm:ss" type="text" value="${item.createDate}" class="form-control"/>
                <span class="input-group-addon">
                    <span class="glyphicon-calendar glyphicon"></span>
                </span>
            </div>
        </div>

        <div>
            <SCRIPT LANGUAGE="JavaScript">
                $(function () {
                    $('#endDate').datetimepicker({
                        language: 'ru',
                        minuteStepping: 10,
                        defaultDate: "09.01.2015",
                        daysOfWeekDisabled: [0, 6]
                    });
                });
            </SCRIPT>

            <label for="endDate">Срок:</label>
            <div class="input-group date" id="endDate">
                <input name="deadline" data-format="dd/MM/yyyy hh:mm:ss" type="text" value="${item.deadLine}" class="form-control"/>
                <span class="input-group-addon">
                    <span class="glyphicon-calendar glyphicon"></span>
                </span>
            </div>
        </div>

        <label for="selectUser">Ответственный:</label>
        <select name="executor" id="selectUser" class="form-control">
            <c:forEach items="${users}" var="user">
                <option><c:out value="${user.name}"/></option>
            </c:forEach>
        </select>

        <button class="btn btn-md btn-success btn-block" type="submit">Сохранить</button>
    </form>
</div>
<script>
    document.querySelector('#selectUser').value='${item.executor.name}';
</script>
<SCRIPT LANGUAGE="JavaScript">
    $(function () {
        $('#startDate').datetimepicker({
            language: 'ru',
            minuteStepping: 10,
            defaultDate: "09.01.2015",
            daysOfWeekDisabled: [0, 6]
        });
        $('#endDate').datetimepicker({
            language: 'ru',
            minuteStepping: 10,
            defaultDate: "09.01.2015",
            daysOfWeekDisabled: [0, 6]
        });
    });

    $('#prioritySlider').slider({
        formatter: function (value) {
            return 'Текущий приоритет: ' + value;
        }
    });
</SCRIPT>