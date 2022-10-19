-- member table
create table member(
    id varchar2(20) primary key ,
    pw varchar2(100) not null,
    name varchar2(20) not null
);

-- auth table
create table auth(
    id varchar2(20),
    auth varchar2(20)
);

delete member where ID='aaaaa';

drop table member;

select * from member;
