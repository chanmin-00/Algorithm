-- 코드를 입력하세요
-- 서브 쿼리를 조인의 결과로 삼기
select i.food_type, i.rest_id, i.rest_name, i.favorites
from rest_info i inner join (select food_type, max(favorites) best  from rest_info group by food_type) f
on i.food_type = f.food_type
where i.favorites = f.best
order by i.food_type desc;