--유저정보 테이블생성
create table recipe_post(
    post_no number(38) primary key --글 번호
    ,title varchar2(200) --글제목
    ,writer varchar2(50) --글쓴이
);

create table member(
 id varchar2(50) primary key --아이디
 ,pw varchar2(200) not null  --비번
 ,name varchar2(100) not null --닉네임
 ,subscript varchar2(5000) --구독
 ,bookmark varchar2(5000) --즐겨찾기
 ,post_no number(38) --쓴글 번호
 ,re_no number(38) --쓴댓글 번호
);

alter table member add constraint  member_post_no
foreign key (post_no) references  recipe_post(post_no);

insert into member values ('id1','123','닉네임1','id3,id4','');
insert into member values ('id2','123','닉네임2','id1,id3','');
insert into member values ('id3','123','닉네임3','id1,id2','');
insert into member values ('id4','123','닉네임1','id2,id3','');
insert into member values ('id5','123','닉네임5','','');

select * from member order by id asc ;

commit;
