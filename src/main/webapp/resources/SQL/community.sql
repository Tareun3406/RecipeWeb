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
  ,reviewer varchar2(50) not null
  ,content varchar2(4000) not null
  ,regdate date
);

--rno_seq 시퀀스(번호 발생기) 생성
create SEQUENCE reply_no_seq
start with 1 --1부터 시작옵션
increment by 1 --1씩증가옵션
nocache;

--rno_seq시퀀스 다음 번호값 확인
select reply_no_seq.nextval from dual;

select * from comu_reply order by reply_no desc;





