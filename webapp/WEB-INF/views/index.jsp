<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 11.04.2016
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Home Page</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
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
          <a class="navbar-brand" href="#">OrgManager</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="active menu-item"><a href="#">Новости<span class="sr-only">(current)</span></a></li>
            <li class="menu-item"><a href="#">Контакты</a></li>
            <li class="menu-item"><a href="#">Реквизиты</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="menu-item"><a href="#">Войти</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>
  </header>

  <div id="container" class="container">
    <div class="col col-lg-2 block"></div>
    <div class="col col-lg-8 news">
      <h4>Заголовок новости</h4>
      <p>Текст новости Текст новости< Текст новости< Текст новости< Текст новости< Текст новости< Текст новости< Текст новости<</p>
      <a href="#">Подробнее</a>
    </div>
    <div class="col col-lg-2"></div>

    <div class="col col-lg-2 block"></div>
    <div class="col col-lg-8 news">
      <h4>Заголовок новости</h4>
      <p>Текст новости Текст новости< Текст новости< Текст новости< Текст новости< Текст новости< Текст новости< Текст новости<</p>
      <a href="#">Подробнее</a>
    </div>
    <div class="col col-lg-2"></div>

    <div class="col col-lg-2 block"></div>
    <div class="col col-lg-8 news">
      <h4>Заголовок новости</h4>
      <p>Текст новости Текст новости< Текст новости< Текст новости< Текст новости< Текст новости< Текст новости< Текст новости<</p>
      <a href="#">Подробнее</a>
    </div>
    <div class="col col-lg-2"></div>

    <div class="col col-lg-2 block"></div>
    <div class="col col-lg-8 news">
      <h4>Заголовок новости</h4>
      <p>Текст новости Текст новости< Текст новости< Текст новости< Текст новости< Текст новости< Текст новости< Текст новости<</p>
      <a href="#">Подробнее</a>
    </div>
    <div class="col col-lg-2"></div>
  </div>

  <footer>
    <div class="container"><hr>
      <p class="pull-right">(c) OrgManager team 2016</p>
    </div>
  </footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
