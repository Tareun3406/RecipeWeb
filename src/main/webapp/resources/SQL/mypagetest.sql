--�������� ���̺����
create table recipe_post(
    post_no number(38) primary key --�� ��ȣ
    ,title varchar2(200) --������
    ,writer varchar2(50) --�۾���
);

create table member(
 id varchar2(50) primary key --���̵�
 ,pw varchar2(200) not null  --���
 ,name varchar2(100) not null --�г���
 ,subscript varchar2(5000) --����
 ,bookmark varchar2(5000) --���ã��
 ,post_no number(38) --���� ��ȣ
 ,re_no number(38) --����� ��ȣ
);

alter table member add constraint  member_post_no
foreign key (post_no) references  recipe_post(post_no);

insert into member values ('id1','123','�г���1','id3,id4','');
insert into member values ('id2','123','�г���2','id1,id3','');
insert into member values ('id3','123','�г���3','id1,id2','');
insert into member values ('id4','123','�г���1','id2,id3','');
insert into member values ('id5','123','�г���5','','');

select * from member order by id asc ;

commit;
