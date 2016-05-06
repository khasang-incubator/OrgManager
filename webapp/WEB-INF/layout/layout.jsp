<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/css/bootstrap.min.css" var="bootstrap"/>
<spring:url value="/css/index.css" var="indexcss"/>
<spring:url value="/css/style.css" var="stylecss"/>
<spring:url value="/css/signin.css" var="signincss"/>
<spring:url value="/css/bootstrap-slider.min.css" var="bootstrapmin"/>
<spring:url value="/css/bootstrap-datetimepicker.min.css" var="bootstrapdatepicker"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><tiles:insertAttribute name="title" /></title>
    <link href="${bootstrap}" rel="stylesheet">
    <link href="${indexcss}" rel="stylesheet">
    <link href="${stylecss}" rel="stylesheet">
    <link href="${signincss}" rel="stylesheet">
    <link href="${bootstrapmin}" rel="stylesheet">
    <link href="${bootstrapdatepicker}" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <spring:url value="/js/jquery-1.12.3.min.js" var="jquery"/>
    <script src="${jquery}"></script>

    <spring:url value="/js/moment-with-locales.min.js" var="jquerylocjs"/>
    <script src="${jquerylocjs}"></script>

    <spring:url value="/js/bootstrap-datetimepicker.min.js" var="bootstrapdatejs"/>
    <script src="${bootstrapdatejs}"></script>

    <spring:url value="/js/bootstrap.min.js" var="bootstrapjs"/>
    <script src="${bootstrapjs}"></script>

    <spring:url value="/js/bootstrap-slider.min.js" var="bootstrapsliderjs"/>
    <script src="${bootstrapsliderjs}"></script>
</head>
<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
</body>
</html>
