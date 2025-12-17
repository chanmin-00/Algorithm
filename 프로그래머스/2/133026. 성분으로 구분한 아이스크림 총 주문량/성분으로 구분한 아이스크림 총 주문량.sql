-- 코드를 입력하세요
SELECT ingredient_type, sum(f.total_order) total_order
from first_half f inner join icecream_info i
on f.flavor = i.flavor
group by i.ingredient_type
order by total_order;