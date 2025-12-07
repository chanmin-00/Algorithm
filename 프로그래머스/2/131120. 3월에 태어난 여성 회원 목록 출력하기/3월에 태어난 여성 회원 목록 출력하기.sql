-- 코드를 입력하세요
-- Oracle은 날짜 형식 변화를 위해서 TO_CHAR를 사용
SELECT member_id, member_name, gender, 
TO_CHAR(date_of_birth, 'YYYY-MM-DD') date_of_birth
from member_profile
where TO_CHAR(date_of_birth, 'MM') = '03' and TLNO is not null 
and gender = 'W'
order by member_id;