-- 코드를 입력하세요
SELECT distinct(r.car_id)
from car_rental_company_car r inner join car_rental_company_rental_history h
on r.car_id = h.car_id
where to_char(h.start_date, 'mm') = '10' and r.car_type = '세단'
order by car_id desc;