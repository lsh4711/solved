SELECT b.BOOK_ID, a.AUTHOR_NAME, LEFT(b.PUBLISHED_DATE, 10) AS 'PUBLISHED_DATE'
FROM BOOK AS b
JOIN AUTHOR AS a
USING(AUTHOR_ID)
WHERE b.CATEGORY = '경제'
ORDER BY 3;