Тестовое задание. Закончил реализацию 01.12.2021

Обращение на порт 80
http://localhost/weather

Документация Swagger http://localhost/swagger-ui/#

Write a REST service with a single endpoint /weather.

When called, this service must query a database for today's weather (temperature) in the table "weather_history". If no record is found in the database for the current date, then it must read the current temperature value from page "yandex.ru". After reading temperature, it must insert a new record in "weather_history". In the end, it must return the temperature value back to the user.

Notes:
You can use any Java framework to build a web service (e.g. Spring).
You can use any database to keep historical data (e.g. PostgreSQL).
You can use JDBC or JPA interfaces to interact with the database.
To read a web page and extract temperature values, use standard Java classes (no need to use an additional library).
Table weather_history has two columns:

weather_date DATE
weather_value VARCHAR
Test results
Create a project on GitHub for your task.
Send us a link to your project.
