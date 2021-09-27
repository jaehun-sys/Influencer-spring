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