Простое приложение на Jakarta Servlet.

Простой RESTful сервис на основе JAX-RS. Только GET запросы.
# Технологии
* Jersey как реализация JAX-RS
* Grizzly в качестве сервера
* HK2 для DI
# Как запустить из IDE
1. На Application выполнить Run
2. Открыть URL по адресу http://localhost:8888/
# Информационная справка

#### REST
REpresentational State Transfer - архитектурный стиль взаимодействия компонентов распределённого приложения в сети.
#### JAX-RS
Java API for RESTful Web Services - спецификация разработки веб-сервисов Java, построенных в соответствии с REST.
#### Jersey RESTful Web Services
Формально Glassfish Jersey или Eclipse Jersey - это  open-source фреймворк для разработки RESTful веб-сервисов на Java.
Реализация JAX-RS.

#### GlassFish
Сервер приложений с открытым исходным кодом, реализующий спецификации Java EE, изначально разработанный Sun Microsystems. В настоящее время спонсируется корпорацией Oracle.
В качестве сервлет-контейнера в нём используется модифицированный Apache Tomcat, дополненный компонентом Grizzly, использующим технологию Java NIO.
#### Grizzly
Eclipse Grizzly/Grizzly NIO - фреймфорк non-blocking I/O (NIO) API.
#### HK2
Hundred-Kilobyte Kernel является динамическим DI фреймворком и частью GlassFish Application Server.
