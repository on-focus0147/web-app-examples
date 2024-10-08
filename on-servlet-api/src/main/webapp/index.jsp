<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
</head>
<body>
<a href="${pageContext.request.contextPath}/slogan">Страница работает через PrintWriter</a><br>
<a href="${pageContext.request.contextPath}/throw">Страница выкидывает ошибку</a><br>
<a href="${pageContext.request.contextPath}/resource/1">Получаем ресурс из webapp/WEB-INF</a><br>
<a href="${pageContext.request.contextPath}/resource/2">Получаем ресурс из webapp</a><br>
<a href="${pageContext.request.contextPath}/resource/31">Перенаправляем из сервлета в ресурс</a><br>
<a href="${pageContext.request.contextPath}/resource/32">Получаем ресурс из /WEB-INF/classes/view/</a><br>
<a href="${pageContext.request.contextPath}/secret">Аутентификация</a><br>
<a href="${pageContext.request.contextPath}/annotation">Используем аннотацию, а не web.xml</a><br>
</body>
</html>