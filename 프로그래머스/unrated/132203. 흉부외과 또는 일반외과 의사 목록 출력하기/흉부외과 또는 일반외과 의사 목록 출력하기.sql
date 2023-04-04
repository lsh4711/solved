SELECT DR_NAME, DR_ID, MCDP_CD, LEFT(HIRE_YMD, 10)
FROM DOCTOR
WHERE MCDP_CD REGEXP 'CS|GS'
ORDER BY 4 DESC, 1;