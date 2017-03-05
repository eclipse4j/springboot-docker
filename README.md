# springboot-docker

https://slipp.net/wiki/pages/viewpage.action?pageId=26640888


# Mysql 설치 하기 
$ docker pull mysql
$ docker run --detach --env MYSQL_ROOT_PASSWORD=0000 --env MYSQL_USER=grissom --env MYSQL_PASSWORD=grissom --env MYSQL_DATABASE=study --name local_mysql --publish 4306:3306 mysql:latest;

// Docker 컨테이너로 접속
$ docker exec -it local_mysql bash

// Docker 컨테이너의 mysql db로 로그인 
root@61d4b964853e:/# mysql -u grissom -p
root@61d4b964853e:/# use study;

// table 생성하기
create table employees (id bigint(20) not null auto_increment, name varchar(255) not null, primary key (id));


# 소스 image로 전환 후, WebApplication 과 Mysql연동 Image 실행하기 
$ docker run -p 8080:8080 --name springboot-docker -t springboot-docker:0.0.1


# SSM 적용하기
DockerSpringappsSSMConfiguation.java

// 기본 설정을 import한다.
https://github.com/chandraonline/simple-spring-memcached/blob/master/simple-spring-memcached/src/main/resources/simplesm-context.xml

// 그외 커스텀 설정 DockerSpringappsSSMConfiguration 
