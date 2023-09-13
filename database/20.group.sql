-- 그룹(group by) 
-- - 특정 항목을 기준으로 하여 무언가를 집계할 경우 사용
-- - 집계 함수를 사용한다(count, sum, avg, min, max)
-- - 그룹 조건을 추가할 수 있다(having)
select member_level name, count(*) cnt
from member group by member_level;

-- 포켓몬스터 속성별 마리수 출력(많은 것부터)
select type name, count(*) cnt from 
pocketmon group by type
order by cnt desc;

-- 포켓몬스터 속성별 마리수 출력(150마리 이상인 그룹만)
select 
	type name, count(*) cnt 
from pocketmon group by type having count(*) >= 150
order by cnt desc;
