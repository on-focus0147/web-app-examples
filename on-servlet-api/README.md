Простой RestFull сервис на основе сервлетов. Только GET запросы.
# Технологии
Jakarta Servlet (jakarta.servlet:jakarta.servlet-api)
Java Authentication and Authorization Service (JAAS)
# Как запустить из IDE
## Если war
1. Собрать war : mvn clean package
2. Включить докер
2. В `docker-compose.yaml` запустить `tomcat11-manager-on-servlet-api` 
3. Открыть URL по адресу http://localhost:8888/on-servlet-api-1.0/
   1. slogan - просто текст
   2. resource/* - эксперименты путей к ресурсам
   3. throw - настройка выкидывания ошибки
   4. secret - страница, требуюшая авторизации
   5. logout - стереть данные об авторизации



