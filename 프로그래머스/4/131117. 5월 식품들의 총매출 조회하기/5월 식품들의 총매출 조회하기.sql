-- 코드를 입력하세요
SELECT f.product_id, f.product_name, sum(f.price * o.amount) total_sales
from food_product f inner join food_order o
on f.product_id = o.product_id
where to_char(o.produce_date, 'yyyymm') = '202205'
group by f.product_id, f.product_name
order by total_sales desc, f.product_id asc;