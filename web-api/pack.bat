@echo off

if "%1"=="" (echo empty) else (
    echo %1
    cd web
    mvn clean package -f pom-war.xml -P %1
    cd ..
)