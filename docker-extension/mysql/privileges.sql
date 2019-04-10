
use mysql;

select host, user from user;

create user root identified by 'Cisco123';

grant all privileges on *.* to root@'%' identified by 'Cisco123' with grant option;

flush privileges;