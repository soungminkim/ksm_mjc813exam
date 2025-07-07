https://school.programmers.co.kr/learn/courses/30/lessons/59406
SELECT COUNT(*) FROM ANIMAL_INS;

https://school.programmers.co.kr/learn/courses/30/lessons/59036
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID;

https://school.programmers.co.kr/learn/courses/30/lessons/59038
SELECT MIN(DATETIME)
FROM ANIMAL_INS

https://school.programmers.co.kr/learn/courses/30/lessons/59039
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
ORDER BY ANIMAL_ID;

https://school.programmers.co.kr/learn/courses/30/lessons/59041
SELECT NAME, COUNT(NAME) AS 'COUNT'
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME) > 1
ORDER BY NAME;

https://school.programmers.co.kr/learn/courses/30/lessons/59047
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE LOWER(NAME) LIKE LOWER('%el%') AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;