<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
<p>Hello World GET запросы</p>
<a href="${model.helloWorld1}">${model.helloWorld1}</a><br>
<a href="${model.helloWorld2}">${model.helloWorld2}</a><br>
<a href="${model.helloWorld3}">${model.helloWorld3}</a><br>
<a href="${model.helloWorld4}">${model.helloWorld4}</a><br>

<p>Просто получить готовую страничку</p>
<a href="${model.simpleSend1}">${model.simpleSend1}</a><br>
<a href="${model.simpleSend2}">${model.simpleSend2}</a><br>

<p>DI</p>
<a href="${model.di1}">${model.di1}</a><br>

<p>Валидация (ожидаем ошибки)</p>
<a href="${model.val1}">${model.val1}</a><br>

<p>На response</p>
<a href="${model.baseUri}response/ok">${model.baseUri}response/ok</a><br>
<a href="${model.baseUri}response/not_ok">${model.baseUri}response/not_ok</a><br>
<a href="${model.baseUri}response/text_plain">${model.baseUri}response/text_plain</a><br>
<a href="${model.baseUri}response/text_plain_annotation">${model.baseUri}response/text_plain_annotation</a><br>
<a href="${model.baseUri}response/json">${model.baseUri}response/json</a><br>
<a href="${model.baseUri}response/xml">${model.baseUri}response/xml</a><br>
<a href="${model.baseUri}response/html">${model.baseUri}response/html</a><br>
</body>
</html>