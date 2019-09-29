#!/bin/sh

if [ ! -n "$1" ]
then
	echo "打包环境参数不能为空"
else
	cd web
	mvn clean package -f pom-war.xml -P $1
	cd ..
fi