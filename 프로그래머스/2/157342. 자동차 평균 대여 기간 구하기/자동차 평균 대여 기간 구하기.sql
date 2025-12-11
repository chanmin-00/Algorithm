-- 코드를 입력하세요
-- 무조건 소수가 표현되게 하기 위해서는 TO_CHAR를 사용하던 문자로 변환이 필요하다
-- 기간이므로 1을 더해야 한다
-- 그리고 to_char로 바꾼걸로 정렬을 하면 안된다.
-- 왜냐하면 문자열 정렬이 되기 때문이다.

select car_id, to_char(ROUND(avg(duration), 1), 'fm9999.0') average_duration
from 
(select car_id, end_date - start_date + 1 duration from car_rental_company_rental_history)
group by car_id
having round(avg(duration), 1) >= 7
order by round(avg(duration), 1) desc, car_id desc
;