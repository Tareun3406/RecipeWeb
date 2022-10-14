--커뮤니티 글등록 테이블 생성

create table commu_list(
  comm_no number(38) primary key --자료실번호
  ,comm_name varchar2(50) not null --글쓴이
  ,comm_title varchar2(200) not null --글제목
  ,comm_pwd varchar2(20) not null --비번
  ,comm_cont varchar2(4000) not null --글내용
  ,comm_file varchar2(300) --이진파일명
  ,comm_hit number(38) default 0 --조회수
  ,comm_ref number(38)--글 그룹 번호 역할=>원본글과 답변글을 서로 묶어주는 기능
  ,comm_step number(38) --첫번째 답변글이면 1, 두번째 답변글이면 2, 원본글이면 0,즉 원본
  --글과 답변글을 구분하는 기준이면서 몇번째 답변글인가를 알려준다.
  ,comm_level number(38) --답변글 정렬순서, 답변글과 연관있는 컬럼명은 bbs_ref,bbs_step,comm_level 이 된다.
  ,comm_date date --글등록 날짜
);



select * from comm_list order by comm_no desc;
