------------------------관리자 전용 DB
------------------------공지사항 테이블(작성자 : 류영석)
drop table notice;

create table notice(
	no number constraint notice_pk primary key, 	--번호(삭제 편리)
	write  		varchar2(1000)  not null,			--제목
	contents 	varchar2(1000) not null,			--공지사항 내용
	wdate date -- default sysdate					--언제 작성했는지 확인
);


insert into notice(no,write,contents,wdate) 
values('2','[안내] 태풍‘솔릭(SOULIK)’으로 인한 항공사별 운항 취소&amp;변경','test2','2018-08-16');
insert into notice(no,write,contents,wdate) 
values('3','[결제 안내] M 포인트 결제 서비스 일시 중지','test2','2018-08-16');
insert into notice(no,write,contents,wdate) 
values('4','[Funshop 시스템 점검 안내]','test2','2018-08-16');
------------------------상품 번호(테이블에 number생성시 짝궁)
drop sequence notice_seq;

create sequence notice_seq
   start with 1
   increment by 1
   nocache
   nocycle;
select count(id) from member;
------------------------공지사항 테이블 전체 조회
select * from notice;


------------------------회원가입 테이블 전체 조회(관리자 회원관리) : 작성자 이예린
select * from member;					--회원가입 테이블 전체 조회

drop table member;

create table member(						
	id varchar2(30) constraint member primary key,					--회원 아이디
	pw varchar2(30),												--회원 비번
	name varchar2(30),												--회원 이름
	email varchar2(50), 											--회원 이메일
	phone varchar2(15),												--회원 폰 번호
	addr varchar2(80),												--회원 주소
	question varchar2(300),											--비번 찾기 질문
	answer varchar2(300),											--질문 답
    rank varchar2(50) default '브론즈',								--등급
	wdate date 														
);


------------------------회원가입 번호(테이블에 number생성시 짝궁) : 추가
drop sequence member_seq;

create sequence member_seq
   start with 1
   increment by 1
   nocache
   nocycle;
------------------------회원가입 Test
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test1','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test2','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test3','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test4','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test5','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test6','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test7','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test8','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test9','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test10','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test11','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test12','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test13','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test14','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test15','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test16','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test17','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test18','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test19','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test20','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test21','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');
insert into member(id,pw,name,email,phone,addr,question,answer,rank,wdate) 
values ('test22','1234','테스트1','test@naver.com','010-1234-5678','서울시 서초구1','별명은?','무지','브론즈','2018-08-16');





------------------------상품등록 테이블 : 작성자 서승환(상품등록에 사용 예정)
DROP TABLE PRODUCT;
CREATE TABLE PRODUCT (
	PRODUCT_NO NUMBER NOT NULL, 				/* PRODUCT_NO */ 			--번호
	PRODUCT_NAME VARCHAR2(50) NOT NULL, 		/* PRODUCT_NAME */			--상품이름
	PRODUCT_SUMMARY VARCHAR2(500) NOT NULL, 	/* PRODUCT_SUMMARY */		--상품설명
	PRODUCT_DESCRIPTION VARCHAR2(100) NOT NULL, /* PRODUCT_DESCRIPTION */	--상품설명2
	PRODUCT_MAINIMG VARCHAR2(100) NOT NULL, 	/* PRODUCT_MAINIMG */		--이미지 경로
	PRODUCT_STATE VARCHAR2(15) NOT NULL, 		/* PRODUCT_STATE */			--판매중, 매진 상태 표시
	PRODUCT_TYPE VARCHAR2(15), 					/* PRODUCT_TYPE */			--장소
	PRODUCT_TIME VARCHAR2(20), 					/* PRODUCT_TIME */			--시간
	PRODUCT_SEASON VARCHAR2(20) 				/* PRODUCT_SEASON */		--시즌(봄,여름,가을,겨울)
);
------------------------상품등록 번호 시퀀스
DROP SEQUENCE PRODUCT_SEQ;
CREATE SEQUENCE PRODUCT_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;
------------------------상품등록 Test
delete from product;
insert into product values(product_seq.nextval,'오두막집','오두막에서 살고 싶니?', '통나무향이 가득 밴 집',
'../img/portfolio/cabin.png', '판매중', '장소','아침','여름');

insert into product values(product_seq.nextval,'케이크','생일에 케이크 먹고 싶지 않아?', '생크림이 가득한 케이크',
'../img/portfolio/cake.png', '판매종료', '음식','저녁','겨울');

insert into product values(product_seq.nextval,'서커스','다양한 능력을 가진 사람들', '세계 전지역 1위 서커스단',
'../img/portfolio/circus.png', '판매중', '장소','점심','봄');

insert into product values(product_seq.nextval,'게임','늘 게임을 하고 싶어?', '게임 티셔츠를 가질 수 있는 절호의 기회',
'../img/portfolio/game.png', '판매중', '의류','아침','가을');


------------------------회원 주문내역 : 작성자 오진환
-----------------------------------주문내역--------------------------------------------
drop table buyHis;
create table buyHis (
--	buyHis_no number constraints buyHis_pk primary key, --주문번호(매출 현황에 사용예정),(제품구매에 사용예정)
--	buyHis_date date not null, 							--날짜(제품구매에 사용예정)
--	member_id varchar2(20) not null, 					--구매자아이디(매출 현황에 사용예정),(제품구매에 사용예정)
--	product_no number not null, 						--물품번호(제품구매에 사용예정)
	buyHis_payment number not null, 					--결제금액(매출 현황에 사용예정),(제품구매에 사용예정)
--	buyHis_addr varchar2(300) not null,					--배송지주소(제품구매에 사용예정)
	buyHis_payType varchar2(30), 						--결제종류(제품구매에 사용예정)
	buyHis_payInfo varchar2(30), 						--결제정보(제품구매에 사용예정)
	buyHis_discount number default 0, 					--할인금액(매출 현황에 사용예정),(제품구매에 사용예정)
	buyHis_cond varchar2(30) 							--상태(제품구매에 사용예정)
);

drop sequence buyHis_seq;
create sequence buyHis_seq
start with 1
increment by 1
nocycle
nocache;

--sample data
insert into buyHis(buyHis_no,buyHis_date,product_no number,buyHis_payment number,buyHis_payType,buyHis_payInfo,buyHis_discount,buyHis_cond) values(buyHistory_seq.nextval,sysdate,'gildong',1,1000,'서울시');

insert into buyHis(buyHis_payment,buyHis_discount) values('50000','10000');
insert into buyHis(buyHis_payment,buyHis_discount) values('10000','5000');
insert into buyHis(buyHis_payment,buyHis_discount) values('100000','1500');
insert into buyHis(buyHis_payment,buyHis_discount) values('2000','100');
insert into buyHis(buyHis_payment,buyHis_discount) values('500','0');

-----------------------------------장바구니--------------------------------------------
drop table basket;
create table basket(
	basket_no number constraints basket_pk primary key, --장바구니번호
	member_id varchar2(20) not null, --구매자아이디
	product_no number not null --물품번호
);

drop sequence basket_seq;
create sequence basket_seq
start with 1
increment by 1
nocycle
nocache;

--sample data
insert into basket(basket_no,member_id,product_no) values(basket_seq.nextval,'gildong',1);
insert into basket(basket_no,member_id,product_no) values(basket_seq.nextval,'gildong',2);
insert into basket(basket_no,member_id,product_no) values(basket_seq.nextval,'gildong',3);

-----------------------------------정기구매--------------------------------------------
drop table regBuy;
create table regBuy(
	regBuy_no number constraints regBuy_pk primary key, --정기구매번호
	regBuy_date date, --신청날짜
	member_id varchar2(20) not null, --구매자아이디
	product_no number not null --물품번호
);

drop sequence regBuy_seq;
create sequence regBuy_seq
start with 1
increment by 1
nocycle
nocache;

--sample data
insert into regBuy(regBuy_no,regBuy_date,member_id,product_no) values(regBuy_seq.nextval,sysdate,'gildong',1);
insert into regBuy(regBuy_no,regBuy_date,member_id,product_no) values(regBuy_seq.nextval,sysdate,'gildong',2);
insert into regBuy(regBuy_no,regBuy_date,member_id,product_no) values(regBuy_seq.nextval,sysdate,'gildong',3);

-----------------------------------포인트--------------------------------------------
drop table point;
create table point(
	point_no number constraints point_pk primary key, --포인트번호
	point_date date, --포인트 적립날짜
	member_id varchar2(20) not null, --구매자아이디
	point_point number --포인트
);

drop sequence point_seq;
create sequence point_seq
start with 1
increment by 1
nocycle
nocache;

--sample data
insert into point(point_no,point_date,member_id,point_point) values(point_seq.nextval,sysdate,'gildong',100);
insert into point(point_no,point_date,member_id,point_point) values(point_seq.nextval,sysdate-1,'gildong',200);
insert into point(point_no,point_date,member_id,point_point) values(point_seq.nextval,sysdate-2,'gildong',300);









--매출(구매금액 - 할인금액)
--select sum(buyHis_payment-buyHis_discount) from buyHis;
select buyHis_payment,buyHis_discount from buyHis;
