@echo off
cd src
javac model\*.java repository\*.java service\*.java util\*.java app\Main.java
java app.Main
pause
