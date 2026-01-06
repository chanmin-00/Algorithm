-- 코드를 입력하세요
select flavor from 
(select f.flavor
from first_half f inner join
(select flavor, sum(total_order) total_order from july group by flavor) j
on f.flavor = j.flavor
order by (f.total_order + j.total_order) desc)
where ROWNUM <= 3
;

