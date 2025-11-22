-- 코드를 입력하세요
-- 중복 행을 제거하기 위해서는 DISTINCT 키워드를 사용할 수 있다.
SELECT COUNT(DISTINCT NAME) AS count
FROM ANIMAL_INS
WHERE NAME IS NOT NULL