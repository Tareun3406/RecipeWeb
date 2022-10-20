--�������� ���̺����
create table member(
 userid varchar2(50)  primary key--���̵�
 ,userpw varchar2(200) not null  --���
 ,nickname varchar2(100) not null--�г���

);


insert into member values ('userid01','123123','��ġ��');
insert into member values ('userid02','123123','���ո�');
insert into member values ('userid03','123123','ȣ����');
insert into member values ('userid04','123123','�Ļ���');
insert into member values ('userid05','123123','©©��');

select * from member order by userid asc ;

commit;

--�������̺�
create table subscribe(
    subscriber_id varchar2(50) --�����ھ��̵�
    ,target_id varchar2(50) --�����޴� ���̵�
);


alter table SUBSCRIBE
    add constraint foreign_key_name
        foreign key (TARGET_ID) references MEMBER (USERID) ON DELETE CASCADE;
--�÷� ����Ű �����ϴ� ��� ON DELETE CASCADE�� �����ϴ¾ְ� �����ɶ� ���� ����

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

