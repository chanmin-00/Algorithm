-- 코드를 입력하세요
-- 오라클에서는 Mysql의 Limit과 같은 기능을 제공하기 위해 ROWNUM을 활용할 수 있다.
SELECT name, datetime from 
(select * from animal_ins 
where not animal_id in (select animal_id from animal_outs)
order by datetime) 
where ROWNUM <= 3;
