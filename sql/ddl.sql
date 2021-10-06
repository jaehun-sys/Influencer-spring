show variables like 'c%';

alter database infdb_aws character set 'utf8' collate 'utf8_unicode_ci';


alter table comm_info     convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table feed_engage   convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table feed_info     convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table feed_list     convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table feed_upload   convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table fol_list      convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table fol_profile   convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table folwing_list  convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table inf_engage    convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table inf_fol_rate  convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table inf_profile   convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table inf_text      convert to character set utf8mb4 collate utf8mb4_unicode_ci;
alter table liked_by_info convert to character set utf8mb4 collate utf8mb4_unicode_ci;


drop table comm_info     ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table feed_engage   ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table feed_info     ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table feed_list     ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table feed_upload   ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table fol_list      ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table fol_profile   ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table folwing_list  ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table inf_engage    ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table inf_fol_rate  ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table inf_profile   ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table inf_text      ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;
drop table liked_by_info ;#convert to character set utf8mb4 collate utf8mb4_unicode_ci;


commit;

alter table comm_info add primary key(INF_PK, F_ID, COMM_PK);
alter table feed_engage add primary key(INF_PK);
alter table feed_info add primary key(INF_PK, F_ID);
alter table feed_list add primary key(INF_PK, F_ID);
alter table feed_upload add primary key(INF_PK);
alter table fol_list add primary key(INF_PK, FOL_PK);
alter table fol_profile add primary key(FOL_PK);
alter table folwing_list add primary key(INF_PK, FOLWING_PK);
alter table inf_engage add primary key(INF_PK);
alter table inf_fol_rate add primary key(INF_PK);
alter table inf_profile add primary key(INF_PK);
alter table inf_text add primary key(INF_PK);
alter table liked_by_info add primary key(INF_PK, F_ID);



CREATE TABLE INF_PROFILE(
	INF_PK				BIGINT			NOT NULL      COMMENT '인플루언서 PK'		 ,
	INF_USERNAME		VARCHAR(30)		null     	  COMMENT '인플루언서 USERNAME'	 ,
	BIO					TEXT			NULL		  COMMENT '바이오그라피'		 ,
	FOL_COUNT			INT				NULL		  COMMENT '팔로워 수'			 ,
	FOLWING_COUNT		INT				NULL		  COMMENT '팔로윙 수'			 ,
	FEED_COUNT			INT				NULL		  COMMENT '피드 수'			 ,
	CAT					VARCHAR(30)		NULL		  COMMENT '카테고리명'			 ,
	BUS_CAT_NAME		VARCHAR(60)		NULL		  COMMENT '비즈니스 카테고리명'	 ,
	CAT_ENUM			VARCHAR(30)		NULL		  COMMENT '상세 카테고리명'		 ,
	INF_SEX				CHAR(1)			NULL		  COMMENT '성별'				 ,
	INF_AGE				VARCHAR(10)		NULL		  COMMENT '나이'				 ,
	PIC_URL				TEXT			NULL		  COMMENT '프로필'			 ,
	REAL_FOL_COUNT		INT			    NULL          COMMENT '진짜 팔로워 수'       ,
	PRIMARY KEY(INF_PK)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;

RENAME TABLE infprofile TO INF_PROFILE;



CREATE TABLE FOL_LIST(
	INF_PK				BIGINT 		NOT NULL		COMMENT	'인플루언서 pk'	    ,
	FOL_PK				BIGINT		NOT NULL		COMMENT	'팔로워 pk'		,
	FOL_USERNAME		VARCHAR(30)	null     		COMMENT	'팔로워 username'	,
	PRIMARY KEY(INF_PK, FOL_PK)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



CREATE TABLE FOLWING_LIST(
	INF_PK				BIGINT		NOT NULL		COMMENT	'인플루언서 pk'       ,
	FOLWING_PK			BIGINT		NOT NULL		COMMENT	'팔로윙 pk'		   ,
	FOLWING_USERNAME	VARCHAR(30) null    		COMMENT	'팔로윙 username'    ,
	PRIMARY KEY(INF_PK, FOLWING_PK)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



CREATE TABLE FOL_PROFILE(
	FOL_PK				BIGINT		NOT NULL						COMMENT	'팔로워 pk'	      ,
	FOL_FOL_COUNT		INT			NULL							COMMENT	'팔로워 수'		  ,
	FOL_FOLWING_COUNT	INT			NULL							COMMENT	'팔로윙 수'		  ,
	FOL_FEED_COUNT		INT			NULL							COMMENT '피드수(영상+사진)'	  ,
	FOL_BUS_CAT_NAME	VARCHAR(60) NULL							COMMENT '비즈니스카테고리'     ,
	FOL_CAT_ENUM        VARCHAR(30) NULL        				    COMMENT '상세카테고리명'       ,
	FOL_IS_PRIVATE      CHAR(1)     NULL        DEFAULT 'Y'	        COMMENT '계정 공개 여부'      ,
	FOL_SEX				CHAR(1)		NULL							COMMENT	'성별'			  ,
	FOL_AGE				VARCHAR(10)	NULL		 					COMMENT '연령대' 	  	      , #다음엔 RANGE로 하자. 헷갈린다.
	FOL_PIC_URL		    TEXT		NULL							COMMENT '프로필 URL'		  ,
	FOL_TYPE  			CHAR(1)     NULL							COMMENT '오디언스 타입
																			 I: Influencer
																			 M: Mass Followers
																			 S: Suspicious Account
																			 R: Real People'       ,
	PRIMARY KEY(FOL_PK)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



CREATE TABLE FEED_LIST(
	INF_PK				BIGINT			NOT NULL		COMMENT	'인플루언서 pk'	   	    ,
	F_ID				BIGINT			NOT NULL		COMMENT '피드 id'			    ,
	F_SHORTCODE			VARCHAR(30) 	NOT NULL		COMMENT '피드 고유 SHORTCODE'  ,
	F_TYPENAME			VARCHAR(20) 	NULL			COMMENT	'게시물 타입'	        ,
	PRIMARY KEY(INF_PK, F_ID)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



CREATE TABLE FEED_INFO(
	INF_PK				BIGINT		NOT NULL 	COMMENT	 '인플루언서 pk'		   ,
	F_ID				BIGINT		NOT NULL	COMMENT	 '피드 id'			   ,
	F_TIMESTAMP			DATE        NULL      	COMMENT  '피드 게시일'			   ,
	DIFF_TIME			INT			NULL  		COMMENT  '피드 간 게시일 차이'  	   ,
	COMM_COUNT			INT			NULL		COMMENT  '댓글 수'		       ,
	LIKED_COUNT 		INT 		NULL		COMMENT	'좋아요 수'		       ,
	F_TEXT				TEXT		NULL		COMMENT  '피드 글 텍스트'		   ,
	F_CAPTION			VARCHAR(30) NULL		COMMENT  '피드 캡션' 		       ,
	F_URL				TEXT		NULL		COMMENT  '피드 URL'			   ,
	PRIMARY KEY(INF_PK, F_ID)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;


alter table COMM_INFO drop COMM_BY_FOL;
alter table COMM_INFO drop COMM_BY_REAL;

alter table	COMM_INFO
ADD(
	COMM_BY_FOL		CHAR(1)		null	default 'N'		COMMENT '팔로워의 댓글인지 판별(TRUE/FALSE)'	,
	COMM_BY_REAL	CHAR(1)		null	DEFAULT 'N'		COMMENT '가짜계정에서 작성한 것인지(TRUE/FALSE)'
);

CREATE TABLE COMM_INFO(
	INF_PK				BIGINT		NOT NULL		COMMENT	 '인플루언서 pk'                          ,
	F_ID				BIGINT		NOT NULL		COMMENT	 '피드 id'				               ,
	COMM_PK				bigint      not null        COMMENT  '댓글 PK'      				           ,
	COMM_BY_ID			BIGINT		NULL			COMMENT  '댓글 작성 계정 ID'                       ,
    COMM_BY_FOL         BOOLEAN     NULL            COMMENT  '팔로워의 댓글인지 판별(TRUE/FALSE)'         ,
    COMM_BY_REAL		BOOLEAN     NULL            COMMENT  '가짜계정에서 작성한 것인지(TRUE/FALSE)'      ,
   PRIMARY KEY(INF_PK, F_ID, COMM_PK)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



CREATE TABLE LIKED_BY_INFO(
	INF_PK				BIGINT		NOT NULL		COMMENT	'인플루언서 pk'				             	,
	F_ID				BIGINT	    NOT NULL		COMMENT '피드 id'									,
	LIKED_BY_ID			BIGINT		NULL			COMMENT	'좋아요 클릭 계정 id'                    	,
	LIKED_BY_FOL		INT			NULL			COMMENT	'팔로워의 좋아요 클릭인지(TRUE/FALSE)'  		,
	LIKED_BY_REAL		INT			NULL			COMMENT '가짜 계정이 클릭한 것인지 아닌지(TRUE/FALSE)'	,
	PRIMARY KEY(INF_PK, F_ID)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;







#통계 테이블

#팔로워 성별비율 -> 팔로워타입 별 비율도 추가했음
create table INF_FOL_RATE(
	INF_PK            bigint        not null          COMMENT '인플루언서 PK'          ,
	RATE_SEX_F        DECIMAL(3,1)  null              COMMENT '여성 팔로워 비율'        ,
	RATE_SEX_M        DECIMAL(3,1)  null              COMMENT '남성 팔로워 비율'        ,
	RATE_SUSP         DECIMAL(3,1)  null              COMMENT 'SUSPICIOUS 팔로워 비율' ,
	RATE_REAL         DECIMAL(3,1)  null              COMMENT 'REAL 팔로워 비율'       ,
	RATE_MASS         DECIMAL(3,1)  null              COMMENT 'MASS 팔로워 비율'       ,
	RATE_INF          DECIMAL(3,1)  null              COMMENT 'INFLUENCE 팔로워 비율'  ,
	REAL_FOL_COUNT    INT           null              COMMENT 'REAl 팔로워 수'         ,
	REAL_FOL_RATE     DECIMAL(3,1)  null              COMMENT 'REAL 팔로워 비율'       ,
	primary KEY(INF_PK)
)default CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



#인플루언서별 인게이지
create table INF_ENGAGE(
	INF_PK            	bigint        not null          COMMENT '인플루언서 PK'              								  ,
	ALL_FEED_C_TOT      INT			  null              COMMENT '모든 피드의 인게이지 수'   	  								  ,
	ALL_FEED_R_TOT      INT    	      null              COMMENT '모든 피드의 진짜 인게이지 수'   								  ,
	ALL_ENGAGE_BY_FOL   DECIMAL(3,1)  null              COMMENT '(계정 전체/팔로워만) 총합(팔로워 코멘트+팔로워 좋아요)/진짜 인게이지 수'  ,
	AVG_LIKED         	DECIMAL(3,1)  null              COMMENT '평균 좋아요 수'       										  ,
	AVG_LIKED_BY_FOL    DECIMAL(3,1)  null              COMMENT '(팔로워만) 평균 좋아요 수'							          ,
	AVG_COMM          	DECIMAL(3,1)  null              COMMENT '평균 댓글 수'												  ,
	AVG_COMM_BY_FOL    	DECIMAL(3,1)  null              COMMENT '(팔로워만) 평균 댓글 수' 							          ,
	FEED_COUNT     		INT			  null              COMMENT 'FEED 수(영상 + 사진 개수)'  											      ,
	primary KEY(INF_PK)
)default CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



#피드별 업로드 주기 빈도별 인게이지
create table FEED_UPLOAD(
	INF_PK            bigint        not null          COMMENT '인플루언서 PK'               ,
	AVG_POST		  INT 		    null			  COMMENT '피드 업로드 주기(주간/최근3개월)' ,
	FEED_COUNT		  INT     		null			  COMMENT '피드 수',
	primary KEY(INF_PK)
)default CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



#피드별 인게이지
alter table FEED_ENGAGE modify FEED_ENGAGE_BY_FOL FLOAT null COMMENT '진짜 인게이지/총 인게이지';

create table FEED_ENGAGE(
	INF_PK             bigint        not null          COMMENT '인플루언서 PK'              	,
	F_ID	           bigint        not null          COMMENT '피드 ID'        	        	,
	FEED_C_TOT         INT		     null              COMMENT '좋아요 + 댓글수 합'          	,
	FEED_R_TOT         INT 		     null              COMMENT '(팔로워만) 좋아요 + 댓글수 합'		,
	FEED_ENGAGE_BY_FOL DECIMAL(3,1)  null              COMMENT '진짜 인게이지/총 인게이지'		    ,
	primary KEY(INF_PK, F_ID)
)default CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;



drop table inf_text;

#텍스트
create table INF_TEXT(
	INF_PK            bigint        not null          COMMENT '인플루언서 PK'          ,
	WORD  	          mediumtext	null              COMMENT '단어 모음(명사, 형용사만)' ,
	HASH        	  mediumtext	null              COMMENT '해시태그 모음'          	,
	CAPTION           TEXT	        null              COMMENT '캡션 모음' 				,
	primary KEY(INF_PK)
)default CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;


#회원
create table MEMBER(
	MEMBERNO BIGINT      not null auto_increment COMMENT '멤버 번호'  	,
	MEMBERID VARCHAR(30) not null 				 COMMENT '아이디'   	,
	NAME     VARCHAR(30) not null 				 COMMENT '이름'    	,
	NICKNAME VARCHAR(30) not null 				 COMMENT '닉네임'   	,
	PASSWORD VARCHAR(50) not null 				 COMMENT '패스워드'  	,
	EMAIL    VARCHAR(40) null     				 COMMENT '이메일주소'  ,
	BIRTHDAY VARCHAR(20) null 				 	 COMMENT '생일'     	,
	MEM_SEX  CHAR(1) 	 null 					 COMMENT '성별'		,
	PHONENO  VARCHAR(11) null 				 	 COMMENT '휴대전화번호'	,
	primary KEY(memberNo, MEMBERID)
)default CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;

#해시태그(테이블 새로 만들기)
CREATE TABLE HASHTAG(
	INF_PK		 	 BIGINT		 NOT NULL		COMMENT '인플루언서 PK'      	,
	KEYWORD		 	 VARCHAR(50) NOT NULL		COMMENT '검색 키워드'    		,
	RELATED_RANK 	 INT		 NULL			COMMENT '연관도 높은 순서'    	,
	RELATED_HASH 	 VARCHAR(50) NULL			COMMENT '연관 해시태그'       	,
	AVG_LIKED		 DOUBLE		 NULL			COMMENT '평균 좋아요 수'        ,
	RELATED_USERNAME VARCHAR(50) NULL			COMMENT '인플루언서 USERNAME'  	,
	PRIMARY KEY(INF_PK,RELATED_HASH)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;

#키워드(테이블 새로 만들기)
CREATE TABLE TERM(
	INF_PK		 	 BIGINT		 NOT NULL		COMMENT '인플루언서 PK'      	,
	TERM_RANK        INT		 NULL			COMMENT '연관도 높은 순서'    	,
	RELATED_TERM	 VARCHAR(50) NOT NULL		COMMENT '연관 키워드'    		,
	SIMILARITY 	     DOUBLE      NULL			COMMENT '연관도'       		,
	KEYTERM		 	 VARCHAR(50) NULL			COMMENT '검색 캐워드'        ,
	PRIMARY KEY(INF_PK,RELATED_TERM)
)DEFAULT CHARSET=UTF8MB4 collate UTF8MB4_UNICODE_CI;
alter table TERM modify SIMILARITY DECIMAL(6,5);
show columns from TERM;
drop table term;

