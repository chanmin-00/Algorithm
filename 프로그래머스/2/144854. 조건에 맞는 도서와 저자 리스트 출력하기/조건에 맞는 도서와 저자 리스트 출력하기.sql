-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK AS B inner join AUTHOR AS A 
ON B.author_id = A.author_id
WHERE b.category = '경제'
order by b.published_date;