SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS AS ins
INNER JOIN ANIMAL_OUTS AS outs
ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.DATETIME > outs.DATETIME
ORDER BY ins.DATETIME;