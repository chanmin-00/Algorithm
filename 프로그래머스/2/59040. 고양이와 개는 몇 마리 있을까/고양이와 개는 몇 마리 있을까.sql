-- 코드를 입력하세요
SELECT animal_type, count(*) count
from animal_ins
where animal_type = 'Cat' or animal_type = 'Dog'
group by animal_type
order by animal_type;