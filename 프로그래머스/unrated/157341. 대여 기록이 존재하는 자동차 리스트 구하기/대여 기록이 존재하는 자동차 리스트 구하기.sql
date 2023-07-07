SELECT DISTINCT(CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR crc
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY ccrh
USING(CAR_ID)
WHERE CAR_TYPE = "세단"
AND MONTH(START_DATE) = 10
ORDER BY 1 DESC;