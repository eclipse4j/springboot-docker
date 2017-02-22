$ docker pull mysql
$ docker run --detach --env MYSQL_ROOT_PASSWORD=0000 --env MYSQL_USER=grissom --env MYSQL_PASSWORD=grissom --env MYSQL_DATABASE=study --name local_mysql --publish 4306:3306 mysql:latest;

// Docker 컨테이너로 접속
$ docker exec -it local_mysql bash

// Docker 컨테이너의 mysql db로 로그인 
root@61d4b964853e:/# mysql -u grissom -p
root@61d4b964853e:/# use study;

// table 생성하기
create table employees (id bigint(20) not null auto_increment, name varchar(255) not null, primary key (id));


$ docker run -p 8080:8080 --name springboot-docker --link local_mysql:local_mysql -t springboot-docker:0.0.1