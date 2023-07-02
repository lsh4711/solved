SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF
JOIN ICECREAM_INFO
USING(FLAVOR)
GROUP BY 1
ORDER BY 2;