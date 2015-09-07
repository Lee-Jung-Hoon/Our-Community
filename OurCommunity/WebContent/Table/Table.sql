

#########################################

취업정보 테이블 3개,

갤러리 테이블 4개,

학습자료실 테이블 4개,

투표 테이블 3개,

맛집 테이블 4개,

회원가입 테이블 4개,

메세지 테이블 2개,

관리자 테이블 2개,

비트캠프 공지 테이블 4개,

반 공지 테이블 4개

##################################






##################################################################
         취업정보  테이블  3개
##################################################################


1.

create table t_workInfo_board (
       no Number primary key, 
       id varchar2(1000),
       url varchar2(1000),
       active varchar2(1000),
       posting_timeStamp varchar2(1000),
       opening_timeStamp varchar2(1000),
       expiration_timeStamp varchar2(1000),
      company varchar2(1000),
       title varchar2(1000),
       job_type varchar2(1000),
       job_category varchar2(1000),
       open_quantity varchar2(1000),
       experience_level varchar2(1000),
       salary varchar2(50),
       check_cnt Number 
   );
   

2.

create table t_temp (
      id varchar2(1000)
   );
   

3. 

create sequence seq_t_workInfo_board_no



##################################################################
         갤러리  테이블  4개
##################################################################

1.

create table t_community_gallery_comment(
    id varchar2(30) not null,
    comment_no number not null,
    comment_content varchar2(600),
    board_no number not null,
    comment_reg_date date default sysdate
    )

2.

create sequence s_community_gallery_comment


3.

 create table t_community_Gallery_board (
    id varchar2(30) not null,
    no number not null,
    title varchar2(150),
    content varchar2(1500),
    reg_date date default sysdate,
    check_cnt number,
    scope number(1),
    file_name varchar(120),
    origin_file_name varchar2(120),
    file_path varchar(210)
    )


4.


create sequence s_community_Gallery_board


##################################################################
         학습게시판  테이블  4개
##################################################################


1.

create table t_community_studyFile_comment(
   id varchar2(20) not null,
   no number not null,
   comment_no number primary key not null,
   content varchar2(300) not null,
   reg_date date default sysdate
);


2.

create sequence seq_studyFile_comment_no;


3.

create table t_community_studyFile_board (
 id varchar2(30) not null,
 no number not null,
 title varchar2(150),
 type varchar2(50),
 content varchar2(1500),
 reg_date date default sysdate,
 check_cnt number,
 scope varchar(200),
 file_name varchar(1000),
 origin_file_name varchar2(1000),
 file_path varchar(1000)
 )
 

4.

create sequence s_community_studyFile_board_no



##################################################################
         투표게시판  테이블  3개
##################################################################



1.

create table t_vote_board( 
 id varchar2(20) not null ,
 v_no number not null primary key, 
 start_date date default sysdate, 
  end_date date, 
  v_title varchar2(50) not null, 
  v_progress char(1) not null, 
  v_clicks number not null
  );


2.


create table t_vote_items( 
  v_no number not null, 
  subsection varchar2(50) not null, 
  count number not null 
  );


3.

create sequence seq_t_vote_no







##################################################################
         맛집게시판  테이블  4개
##################################################################

1.

create table recommend_menu_comment (
 no number primary key,
 num number not null,
 id varchar2(20) not null,
 menu_comment varchar2(500),
 comment_date date default sysdate )


2.

create sequence seq_recommend_menu_comment_no


3.

create table recommend_menu (
num number primary key,
id varchar2(20) not null,
title varchar2(50) not null,
content varchar2(300),
reg_date date default sysdate,
latitude varchar2(30),
longitude varchar2(30),
count number default 0,
restaurant_name varchar(50) not null )


4.

create sequence seq_recommend_menu_num




##################################################################
         회원가입  테이블  4개
##################################################################


1.

create table t_member (
    id varchar2(20) primary key not null,
    name varchar2(20) not null,
    password varchar2(30) not null,
    secession varchar2(20) not null,
    email_id varchar2(10) not null,
    email_domain varchar2(20) not null,
    tel varchar2(30) not null,
    address varchar2(30) not null,
    gender varchar2(8) not null,
    grade varchar2(10),
    join_date date default sysdate,
    hint varchar2(20) not null,
    hint_answer varchar2(200) not null);


##################################################################
         메세지  테이블  2개
##################################################################

1.

create sequence seq_t_message_no


2.

create table t_message (
no varchar2(4),
id varchar2(20),
title varchar2(100),
sendid varchar2(20),
content varchar2(600),
bin char(3),
send_date date default sysdate
);



##################################################################
         관리자 게시판  테이블  2개
##################################################################

1.

create table t_notice_admin_board(
   id varchar2(20) not null,
   no number primary key not null,
   title varchar2(50) not null,
   content varchar2(300) not null,
   reg_date date default sysdate,
   check_cnt number not null);
   
   
2.

create sequence seq_t_notice_admin_board_no;





##################################################################
         비트캠프 공지사항   테이블  4개
##################################################################


1.

create table t_notice_bitcamp_board(
   id varchar2(20) not null,
   no number primary key not null,
   boardhead varchar2(30) not null,
   title varchar2(50) not null,
   content varchar2(300) not null,
   reg_date date default sysdate,
   scope varchar2(20) not null,
   check_cnt number not null);
   
   
2.

create sequence t_notice_bitcamp_board_no;



3.

create table t_notice_bitcamp_comment(
id varchar2(20) not null,
no number not null,
comment_no number primary key not null,
content varchar2(300) not null,
reg_date date default sysdate);



4.

create sequence seq_t_notice_bit_comment_no;





##################################################################
         반 공지사항   테이블  4개
##################################################################


1.

 create table t_notice_class_board(
id varchar2(20),
no number  primary key,
boardhead varchar2(20),
title varchar2(50),
content varchar2(300),
reg_date DATE default sysdate,
check_cnt number default 0,
scope varchar2(10)
)


2.

create sequence seq_t_notice_class_board_no


3.


create table t_notice_class_comment(
id varchar2(20),
no number,
comment_no number,
content varchar(300),
reg_date DATE default sysdate
)


4.

create sequence seq_t_notice_class_comment_no


