drop table guest;

create table guest(
   no number constraint guest_pk primary key,
   writer varchar2(20) not null,
   email varchar2(50),
   tel   varchar2(15),
   pass  varchar2(15)  not null,
   contents varchar2(300) not null,
   wdate date -- default sysdate
);

select * from guest;