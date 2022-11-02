--커뮤니티 글등록 테이블 생성

create table comu_post(
  comu_no number(38) not null primary key --자료실번호
  ,title varchar2(200) not null --글제목
  ,content varchar2(4000) not null --글내용
  ,writer varchar2(20) not null --글쓴이
  ,regdate date  --글등록 날짜 
  ,viewcnt number(38) default 0 --조회수 
  ,userid_fk varchar2(20)
  ,FOREIGN KEY (userid_fk) REFERENCES member (userid)
);

select comu_no,title,nickname,regdate,viewcnt from member inner join comu_post on member.userid =
comu_post.writer;

SELECT comu_no,title,content,nickname,regdate,viewcnt FROM member inner join comu_post on member.userid =
comu_post.writer WHERE
		comu_no = 11;

select count(comu_no) from member inner join comu_post on member.userid =
comu_post.writer;

select comu_no,title,nickname,regdate,viewcnt  from member m,comu_post c
where m.userid=c.writer; 


drop table comu_post;

select * from comu_post order by comu_no desc;

create SEQUENCE comu_no_seq
start with 1 --1부터 시작
INCREMENT by 1 --1씩증가
nocache; --임시메모리를 사용하지 않음

--bbs_no_seq 시퀀스 다음 번호값 확인
select comu_no_seq.nextval from dual;


commit;

--댓글테이블
create table comu_reply(
  reply_no number(38) not null primary key
  ,comu_no number(38) not null
  ,reviewer varchar2(20) not null
  ,content varchar2(4000) not null
  ,regdate date
);

drop table comu_reply;

--rno_seq 시퀀스(번호 발생기) 생성
create SEQUENCE reply_no_seq
start with 1 --1부터 시작옵션
increment by 1 --1씩증가옵션
nocache;

--rno_seq시퀀스 다음 번호값 확인
select reply_no_seq.nextval from dual;

select * from comu_reply order by reply_no desc;


select nickname from comu_post left join member on comu_post.writer = member.userid;

    select reply_no,nickname,content,regdate from member inner join comu_reply on 
    member.userid =comu_reply.reviewer where comu_no=12 order by reply_no desc

