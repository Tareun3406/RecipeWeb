--recipe �Խ���

create table category(
 bbs_no number(38) primary key --
 ,bbs_name varchar2(50) not null --
 ,bbs_title varchar2(200) not null --
 ,bbs_pwd varchar2(20) not null --
 ,bbs_cont varchar2(4000)not null --
 ,bbs_file varchar2(300) --
 ,bbs_hit number(38) default 0 --
 ,bbs_ref number(38) --
 ,bbs_step number(38) --
 ,bbs_level number(38) --
 ,bbs_date date--
);

insert  into category values(2,'guk','title2','1234','�۳����Դϴ�2','F:\20220607\RecipeWeb\target\controller-1.0.0-BUILD-SNAPSHOT\resources\images\food\image2.jpg',
0,1,1,1,sysdate);

select * from category order by bbs_no asc;




create table user(
 ID varchar2(50) pri
);