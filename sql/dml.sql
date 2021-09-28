#팔로워로부터의 댓글인지 판별하는 sp
select INF_PK, F_ID, COMM_BY_ID
from   COMM_INFO;

select INF_PK, FOL_PK
from   FOL_LIST;

update (SELECT *
 FROM   COMM_INFO 
 WHERE  COMM_BY_ID 
 IN 
	(SELECT DISTINCT(FOL_PK) 
     FROM   FOL_LIST
	)
)
set COMM_BY_FOL = 'Y'
;


insert into member(MEMBERID ,NAME   ,NICKNAME ,PASSWORD  	,EMAIL				, BIRTHDAY    , MEM_SEX, PHONENO)
		   values ('us03098','이재훈' ,'이좨훈'	  ,'이재훈12#$'	,'us03098@gmail.com', '1996-10-11','M', '01097173070');
insert into member(MEMBERID ,NAME   ,NICKNAME ,PASSWORD  	,EMAIL				, BIRTHDAY    , MEM_SEX, PHONENO)
		   values ('test'   ,'테스트' ,'퇘스트'	  ,'test12#$'	,'test@test.com'    , '2021-09-03','F', '01012345678');



#진짜가짜 화면
	PIC_URL
	INF_USERNAME
	FOL_COUNT
	FOLWING_COUNT
	REAL_FOL_COUNT
	RATE_REAL
<SQL>
select i.INF_USERNAME , i.PIC_URL , i.FOL_COUNT , i.FOLWING_COUNT , i.REAL_FOL_COUNT
from   INF_PROFILE i
where  i.INF_USERNAME = 'jiiinu_bb';


#해시태그 검색
<SQL>
#키워드, 연관해시태그, 평균좋아요수, 연관인플루언서
SELECT KEYWORD, RELATED_HASH, AVG_LIKED, RELATED_USERNAME
FROM   HASHTAG
WHERE  KEYWORD LIKE '%코디%';



#인플루언서 추천
#순위, 프사, 계정명, 바이오, 팔로워 수 , 카테고리, 활성도, 반응도
select 				RANK() over (order by ie.avg_post desc) 순위, ip.PIC_URL, ip.INF_USERNAME, ip.BIO, ip.CAT, ie.ALL_FEED_AVG, ie.AVG_POST, ip.FOL_COUNT
from				inf_profile ip
left outer join		inf_engage ie
	on				ip.INF_PK = ie.INF_PK
left outer join		inf_text it
	on				ie.INF_PK = it.INF_PK
where  				ip.CAT = '패션'
	#and				it.word like '%겨울%'
	and				ip.INF_SEX = 'M'				#인플루언서 성별 여
	and 			ip.inf_age between 20 and 30	#인플루언서 연령
	and				ie.RATE_SEX_F < 50				#오디언스 성별 남
	and 			ie.AVG_AGE between 20 and 30
;

#상세페이지
select				ip.PIC_URL , ip.INF_USERNAME , ip.BIO , ip.CAT , ie.FEED_COUNT , ip.FOL_COUNT , ip.FOLWING_COUNT
					, ie.REAL_FOL_MIN , ie.REAL_FOL_MAX , ie.ALL_FEED_AVG , ie.AVG_POST , ie.AVG_AGE
					,case
						when	ie.RATE_SEX_F > 50	then	CONCAT('여성(', ie.RATE_SEX_F, 	  '%)')
						when	ie.RATE_SEX_F < 50	then	CONCAT('남성(', 100-ie.RATE_SEX_F, '%)')
						else								'성비 동일'
					end as AUD_SEX
from 				inf_profile ip
left outer join 	inf_engage ie
	on				ip.INF_PK = ie.INF_PK
where				ip.inf_username = 'jiiinu_bb'
;




#
select             i.PIC_URL, i.INF_USERNAME, i.BIO, i.FOL_COUNT, i.CAT
from               inf_profile i
left outer join    inf_text    t
on               i.inf_pk = t.inf_pk
left outer join    ( select M , F , INF_PK)
           group by
 ) Z
 on I. = T.
where             i.CAT = '-1'
and             i.INF_AGE = '-1'
and               t.WORD like '%겨울%';










#진짜 가짜 판별
select a.inf_username, a.PIC_URL, a.FOL_COUNT, a.FOLWING_COUNT, a.REAL_FOL_COUNT, b.rate_real
from   inf_profile a inner join inf_fol_rate b on a.inf_pk = b.inf_pk
where  a.inf_username = 'ddins_official';

#해시태그 검색
SELECT   h.KEYWORD, h.RELATED_HASH, h.AVG_LIKED, h.RELATED_USERNAME 
FROM     HASHTAG h
WHERE    h.KEYWORD LIKE '%운동화%'
order by h.RELATED_RANK; 

#인플루언서 추천-목록
select a.pic_url, a.inf_username, a.bio, b.ALL_ENGAGE_BY_FOL, a.FOL_COUNT, a.cat, f.FOL_SEX
from   (select * from inf_profile a inner join inf_engage b on a.INF_PK = b.INF_PK) 
      inner join 
      (select * 
       from inf_text d inner join (select * 
                             from fol_list e inner join fol_profile f on e.FOL_PK = f.FOL_PK) g 
                   on d.inf_pk = g.inf_pk)
where  a.inf_username = 'ddins_official';
-- where  a.cat = '-1' 
--    and d.WORD like '%추위%'
--    and a.INF_SEX = '-'
--    ;