-- 코드를 입력하세요
-- 오라클의 substring 함수는 substr(문자열, 시작위치, 길이)를 사용한다.
-- 오라클의 문자열 연결 함수는 || 

SELECT U.USER_ID, U.NICKNAME, 
U.CITY || ' ' ||  U.STREET_ADDRESS1 || ' ' || U.STREET_ADDRESS2 AS 전체주소, 
substr(TLNO, 0, 3) || '-' || substr(TLNO, 4, 4) || '-' || substr(TLNO, 8, 4) AS 전화번호
FROM USED_GOODS_USER U
WHERE (SELECT COUNT(*) FROM USED_GOODS_BOARD B WHERE B.WRITER_ID = U.USER_ID) > 2
ORDER BY U.USER_ID DESC;
