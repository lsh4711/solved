SELECT LEFT(PRODUCT_CODE, 2) AS 'CATEGORY', COUNT(1)
FROM PRODUCT
GROUP BY 1
ORDER BY 1;