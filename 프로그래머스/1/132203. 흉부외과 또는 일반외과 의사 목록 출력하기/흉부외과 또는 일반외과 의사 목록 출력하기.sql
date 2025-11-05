-- 코드를 입력하세요
-- DATE_FORMAT(날짜, '%Y-,%m-%d')
-- %Y : 4자리 연도
-- %m : 두자리 월
-- %d : 두자리 일자
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') HIRE_YMD
FROM DOCTOR WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS' ORDER BY HIRE_YMD DESC,  DR_NAME ASC;