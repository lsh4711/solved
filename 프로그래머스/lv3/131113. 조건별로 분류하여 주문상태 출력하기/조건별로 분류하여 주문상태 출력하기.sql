SELECT ORDER_ID, PRODUCT_ID, LEFT(OUT_DATE, 10) AS OUT_DATE, IF(OUT_DATE IS NULL, '출고미정', IF(OUT_DATE <= '2022-05-01', '출고완료', '출고대기')) AS '출고여부'
FROM FOOD_ORDER
ORDER BY 1;