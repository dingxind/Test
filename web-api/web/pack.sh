#!/bin/sh

if [ ! -n "$1" ]
then
	echo "打包环境参数不能为空"
else
	mvn clean package -f pom-war.xml -P $1
fi