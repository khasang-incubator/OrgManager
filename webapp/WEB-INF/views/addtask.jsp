<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--параметры адресной строки: parentID (null, если нет)--%>

<div class="container">
    <form class="form-signin">
        <h2 class="form-signin-heading">Add task</h2>
        <label for="title">Title:</label>
        <input type="text" id="title" value="${item.name}" class="form-control" placeholder="Title" required autofocus>
        <label for="prioritySlider">Priority:</label>
        <p>
        <input id="prioritySlider" data-slider-id='prioritySlider' value="${item.priority}" type="text"
               data-provide="slider"
               data-slider-ticks="[0, 3, 5]"
               data-slider-ticks-labels='["Low", "Medium", "High"]'
               data-slider-min="0"
               data-slider-max="5"
               data-slider-step="1"
               data-slider-value="1"/>
        </p>
        <div>
            <SCRIPT LANGUAGE="JavaScript">
                $(function () {
                    $('#startDate').datetimepicker({language: 'ru',minuteStepping:10,defaultDate:"09.01.2015",daysOfWeekDisabled:[0,6]});
                });
            </SCRIPT>

            <label for="startDate">Start Date:</label>
            <div class="input-group date" id="startDate">
                <input data-format="dd/MM/yyyy hh:mm:ss" type="text" value="${item.createDate}" class="form-control"/>
                <span class="input-group-addon">
                    <span class="glyphicon-calendar glyphicon"></span>
                </span>
            </div>
        </div>
        <div>
            <SCRIPT LANGUAGE="JavaScript">
                $(function () {
                    $('#endDate').datetimepicker({language: 'ru',minuteStepping:10,defaultDate:"09.01.2015",daysOfWeekDisabled:[0,6]});
                });
            </SCRIPT>

            <label for="endDate">End Date:</label>
            <div class="input-group date" id="endDate">
                <input data-format="dd/MM/yyyy hh:mm:ss" type="text" value="${item.deadLine}" class="form-control"/>
                <span class="input-group-addon">
                    <span class="glyphicon-calendar glyphicon"></span>
                </span>
            </div>
        </div>
        <label for="dropdownUsers">Assign users:</label>
        <div id="dropdownUsers" class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenuRoles" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Users
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuRoles">
                <li><a href="#">UserName</a></li>
            </ul>
        </div>
        <table class="table table-bordered">
            <caption>Assigned users</caption>
            <tr>
                <th>Index</th>
                <th>User name</th>
                <th>Actions</th>
            </tr>
            <tr>
                <td>${item.executor.id}</td>
                <td>${item.executor.name}</td>
                <td>${item.executor.role.name}</td>
            </tr>
        </table>
        <button class="btn btn-md btn-success btn-block" type="submit">Add</button>
    </form>
</div>

<SCRIPT LANGUAGE="JavaScript">
    $(function () {
        $('#startDate').datetimepicker({language: 'ru',minuteStepping:10,defaultDate:"09.01.2015",daysOfWeekDisabled:[0,6]});
        $('#endDate').datetimepicker({language: 'ru',minuteStepping:10,defaultDate:"09.01.2015",daysOfWeekDisabled:[0,6]});
    });

    $('#prioritySlider').slider({
        formatter: function(value) {
            return 'Current value: ' + value;
        }
    });
</SCRIPT>
