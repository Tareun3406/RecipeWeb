-- member table
create table member(
    userid varchar2(20) primary key ,
    userpw varchar2(100) not null,
    nickname varchar2(20) not null
);

-- auth table
create table auth(
    userid varchar2(20),
    auth varchar2(20)
);


delete member where userid='aaaaa';

drop table member;
drop table auth;
select * from member;
