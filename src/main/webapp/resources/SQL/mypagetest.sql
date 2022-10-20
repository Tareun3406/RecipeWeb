--유저정보 테이블생성
create table member(
 userid varchar2(50)  primary key--아이디
 ,userpw varchar2(200) not null  --비번
 ,nickname varchar2(100) not null--닉네임

);


insert into member values ('userid01','123123','김치맨');
insert into member values ('userid02','123123','세균맨');
insert into member values ('userid03','123123','호빵맨');
insert into member values ('userid04','123123','식빵맨');
insert into member values ('userid05','123123','짤짤이');

select * from member order by userid asc ;

commit;

--구독테이블
create table subscribe(
    subscriber_id varchar2(50) --구독자아이디
    ,target_id varchar2(50) --구독받는 아이디
);


alter table SUBSCRIBE
    add constraint foreign_key_name
        foreign key (TARGET_ID) references MEMBER (USERID) ON DELETE CASCADE;
--컬럼 참조키 설정하는 방법 ON DELETE CASCADE는 참조하는애가 삭제될때 같이 삭제

insert into subscribe values ('userid01','userid02');
insert into subscribe values ('userid01','userid03');
insert into subscribe values ('userid01','userid04');
insert into subscribe values ('userid02','userid01');
insert into subscribe values ('userid03','userid01');
insert into subscribe values ('userid03','userid02');
insert into subscribe values ('userid03','userid05');
insert into subscribe values ('userid04','userid01');
insert into subscribe values ('userid04','userid03');
insert into subscribe values ('userid05','userid02');

commit;

select a.userid, a.userpw,a.nickname ,b.subscriber_id,b.target_id
from member a inner join subscribe b
    on (a.userid = b.subscriber_id and b.subscriber_id in 'userid01') ;

