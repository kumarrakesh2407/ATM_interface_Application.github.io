@echo off
cd /d %~dp0\src\main\java
javac *.java
java ATM
pause
