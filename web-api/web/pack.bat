@echo off

if "%1"=="" (echo empty) else (
    echo %1
    mvn clean package -f pom-war.xml -P %1
)