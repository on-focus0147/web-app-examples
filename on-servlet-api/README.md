Простое приложение на Jakarta Servlet.

# Как запустить из IDE
## Если war
1. Собрать war : mvn clean package
2. В `docker-compose.yaml` запустить `tomcat11-manager-on-servlet-api` 
3. Открыть URL по адресу http://localhost:8888/on-servlet-api-1.0/
## Если exploded war
1. Собрать war : mvn clean war:exploded
2. В `docker-compose.yaml` запустить `tomcat11-manager-on-servlet-api-exploded`
3. Открыть URL по адресу http://localhost:8888/on-servlet-api-1.0/
# Как запустить из готового Docker-образа



