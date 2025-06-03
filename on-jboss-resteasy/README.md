Простой RestFull сервис на основе сервлетов. Только GET запросы.
# Технологии
* Jakarta Servlet API (jakarta.servlet:jakarta.servlet-api) - для работы с сервлетами
* RESTeasy (JBoss) - реализация JAX-RS
* resteasy-jaxb-provider - для работы с сериализацией объектов в XML-формат.
* Lombok - для генерации геттеров, сеттеров
# Как запустить из IDE
## Через docker на tomcat 11
1. Собрать war : mvn clean package
2. Включить докер
2. В `docker-compose.yaml` запустить `tomcat11-manager-on-servlet-api` 
3. Открыть URL по адресу http://localhost:8888/on-jboss-resteasy-1.0/



