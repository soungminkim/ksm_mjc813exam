SELECT * FROM contact_tbl;
SELECT * FROM location_tbl;
SELECT * FROM saled_tbl;
SELECT * FROM lecture_tbl;
SELECT * FROM learn_tbl;

SELECT * FROM contact_tbl WHERE name = '이순신';
SELECT * FROM saled_tbl WHERE sale_dt = '2025-07-03';
SELECT * FROM saled_tbl WHERE price  = 12000;

SELECT s.id, s.sale_dt, s.price, s.qty, s.product, l.location
FROM saled_tbl s
LEFT JOIN location_tbl l ON s.location_id = l.id;

SELECT s.id, s.sale_dt, s.product, c.name, c.phoneNumber
FROM saled_tbl s
LEFT JOIN contact_tbl c ON s.contact_id = c.id;

SELECT l.id AS learn_id, lt.subject, ct.name AS student, l.socre
FROM learn_tbl l
LEFT JOIN lecture_tbl lt ON l.lecture_id = lt.id
LEFT JOIN contact_tbl ct ON l.contact_id = ct.id;

SELECT * FROM saled_tbl ORDER BY price DESC;

SELECT c.name
FROM (
    SELECT contact_id
    FROM learn_tbl
    GROUP BY contact_id
    HAVING COUNT(*) >= 2
) AS ids
JOIN contact_tbl c ON ids.contact_id = c.id;

SELECT c.*
FROM contact_tbl c
WHERE c.id IN (
    SELECT contact_id
    FROM saled_tbl
    GROUP BY contact_id
    HAVING COUNT(*) >= 2
);



