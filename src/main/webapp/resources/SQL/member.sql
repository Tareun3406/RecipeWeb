-- member table
create table member(
    userid varchar2(20) primary key ,
    userpw varchar2(100) not null,
    nickname varchar2(20) not null,
    email varchar2(100) not null
);

-- auth table
create table auth(
    userid varchar2(20),
    auth varchar2(20)
);

create table subscribe(
  subscriber_id varchar2(20) not null ,
  target_id varchar2(20) not null
);

create table bookmark(
    userid varchar2(20) not null ,
    post_no number(30) not null
);


delete member where userid='aaaaa';

drop table subscribe;
drop table bookmark;

drop table member;
drop table auth;
select * from member;
