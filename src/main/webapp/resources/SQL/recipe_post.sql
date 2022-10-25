create table RECIPE_POST(
    post_no number(38) not null primary key    -- 글번호
    ,writer varchar2(200) not null   -- 글쓴이     -- 수정할부분
    ,title varchar2(300) not null   -- 글제목      -- 수정할부분
    ,post_tag varchar2(1000) not null     -- 태그
    ,ingredient varchar2(1000) not null   -- 재료
    ,tip varchar2(1000)     -- 나만의 팁
    ,thumnail varchar2(4000)    -- 썸네일
    ,hit varchar2(500)    -- 조회수
    ,recommend varchar2(500)    -- 추천수
    ,regdate date     -- 등록날짜
    ,editdate date    -- 수정날짜
);


drop table recipe_post;

select * from recipe_post;

-- 레시피 글번호 시퀀스 생성
create sequence post_no_seq
start with 1   -- 0부터 시작
increment by 1   -- 1씩 증가
nocache;   -- 임시메모리 x

select post_no_seq.nextval from dual;


create table recipe_content(
    STEP NUMBER(38)
   ,IMAGE VARCHAR2(200) NOT NULL
   ,MANUAL VARCHAR2(4000) NOT NULL
   ,POST_NO NUMBER(38)
   CONSTRAINT FOREIGN_KEY_recipe_content_POST_NO references RECIPE_POST
);

select * from recipe_content;