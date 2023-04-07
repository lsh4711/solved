SELECT MEMBER_ID, MEMBER_NAME, GENDER, LEFT(DATE_OF_BIRTH, 10) AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W' AND TLNO IS NOT NULL AND MONTH(DATE_OF_BIRTH) = 3
ORDER BY 1;