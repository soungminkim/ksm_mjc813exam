CREATE TABLE number_tbl (
	id INT UNSIGNED NOT NULL auto_increment
	, num INT
	, CONSTRAINT pk_number PRIMARY KEY (id)
);

INSERT INTO number_tbl (num)
VALUES (1) ,(2) ,(3) ,(4) ,(5) ,(6) ,(7) ,(8) ,(9); 

SELECT dan.num AS dan, gop.num AS num, dan.num * gop.num AS result
FROM number_tbl as dan
JOIN number_tbl as gop
WHERE dan.num BETWEEN 2 AND 9
ORDER BY dan.num, gop.num;