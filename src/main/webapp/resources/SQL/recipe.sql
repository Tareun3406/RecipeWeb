--recipe �Խ���

create table recipe_post(
 post_no number(38) primary key -- 글번호
 ,title varchar2(200) not null -- 글제목
 ,hit number(38) default 0 -- 조회수
 ,regdate varchar2(100) not null -- 작성 날짜
 ,updatedate varchar2(100) null -- 수정 날짜
 ,thumnail varchar(200) not null -- 썸네일이미지 경로
 ,ingredient varchar2(1000) not null --재료
 ,recommend number(38) default 0 -- 추천수
 ,post_tag varchar2(1000) -- 태그
 ,tip varchar2(500)-- 팁
);

create sequence post_no_sequence
start with 1 increment by 1 nocache;

insert	into	recipe_post	values	(	post_no_sequence.nextval,	'첫번째 레시피',	'2',	sysdate,null,	'"../../../resources/images/food/image1.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'두번째 레시피',	'3',	sysdate,null,	'"../../../resources/images/food/image2.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'세번째 레시피',	'4',	sysdate,null,	'"../../../resources/images/food/image3.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'네번째 레시피',	'2',	sysdate,null,	'"../../../resources/images/food/image4.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'다섯번째 레시피',	'3',	sysdate,null,	'"../../../resources/images/food/image5.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'여섯번째 레시피',	'4',	sysdate,null,	'"../../../resources/images/food/image6.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'일곱번째 레시피',	'2',	sysdate,null,	'"../../../resources/images/food/image7.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'여덞번째 레시피',	'3',	sysdate,null,	'"../../../resources/images/food/image8.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'아홉번째 레시피',	'4',	sysdate,null,	'"../../../resources/images/food/image9.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열번째 레시피',	'2',	sysdate,null,	'"../../../resources/images/food/image10.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열한번째 레시피',	'3',	sysdate,null,	'"../../../resources/images/food/image11.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열두번째 레시피',	'4',	sysdate,null,	'"../../../resources/images/food/image12.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열세번째 레시피',	'2',	sysdate,null,	'"../../../resources/images/food/image13.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열네번째 레시피',	'3',	sysdate,null,	'"../../../resources/images/food/image14.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열다섯번째 레시피',	'4',	sysdate,null,	'"../../../resources/images/food/image15.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열여섯번째 레시피',	'2',	sysdate,null,	'"../../../resources/images/food/image16.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열일곱번째 레시피',	'3',	sysdate,null,	'"../../../resources/images/food/image17.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;
insert	into	recipe_post	values	(	post_no_sequence.nextval,	'열여덞번째 레시피',	'4',	sysdate,null,	'"../../../resources/images/food/image18.jpg"',	'배추',	'0',	'김치,배추김치,김장',	'잘 절인다'	)	;

select * from recipe_post order by post_no asc;

commit;




