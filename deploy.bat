@echo off

set JAVA_HOME=C:\Program Files\Java\jdk17
set PATH=%JAVA_HOME%\bin;%PATH% 255252

start java -jar dist/your-app.jar

echo Деплой завершен успешно.