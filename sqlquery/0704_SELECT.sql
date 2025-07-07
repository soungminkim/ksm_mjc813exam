-- 판매정보 VIEW
CREATE OR REPLACE VIEW vw_sale_info AS
SELECT 
  s.id AS sale_id,
  s.sale_dt,
  c.name AS customer,
  s.product,
  l.location,
  s.price,
  s.qty,
  s.discount,
  (s.price * s.qty - s.discount) AS total_price
FROM saled_tbl s
JOIN contact_tbl c ON s.contact_id = c.id
JOIN location_tbl l ON s.location_id = l.id;

-- 수강정보 VIEW
CREATE OR REPLACE VIEW vw_learn_info AS
SELECT 
  ct.name AS student,
  lt.subject,
  l.socre,
  lt.start_dt,
  lt.end_dt
FROM learn_tbl l
JOIN contact_tbl ct ON l.contact_id = ct.id
JOIN lecture_tbl lt ON l.lecture_id = lt.id;

-- 유니크키를 한데이터에 두개 이상 잡으면 해당 값들이 중복되지않게도 할수 있다.
-- ALTER TABLE example.learn_tbl ADD CONSTRAINT learn_tbl_unique UNIQUE KEY (lecture_id,contact_id);

SELECT * FROM vw_learn_info;

-- 각 고객별 판매총금액
SELECT 
  c.name AS customer,
  SUM(s.price * s.qty - s.discount) AS total_amount
FROM saled_tbl s
JOIN contact_tbl c ON s.contact_id = c.id
GROUP BY c.name
ORDER BY total_amount DESC;

-- 각 상품별로 판매 총금액
SELECT 
  s.product,
  SUM(s.price * s.qty - s.discount) AS total_amount
FROM saled_tbl s
GROUP BY s.product
ORDER BY total_amount DESC;


-- 수강학생 조회 쿼리 
-- 수강 학생 별 가장 빠른 시작일자, 가장 늦은 끝 일자.
SELECT 
  ct.name AS student,
  MIN(lt.start_dt) AS first_lecture_start,
  MAX(lt.end_dt) AS last_lecture_end
FROM learn_tbl l
JOIN contact_tbl ct ON l.contact_id = ct.id
JOIN lecture_tbl lt ON l.lecture_id = lt.id
GROUP BY ct.name;

-- 각 과목별로 수강하는 학생 인원수
SELECT 
  lt.subject,
  COUNT(DISTINCT l.contact_id) AS student_count
FROM learn_tbl l
JOIN lecture_tbl lt ON l.lecture_id = lt.id
GROUP BY lt.subject;

-- 각 과목별 최우수점수 학생 이름과 score 맨위 정렬
SELECT
  lt.subject,
  c.name AS top_student,
  t.max_score
FROM (
  SELECT
    l.lecture_id,
    MAX(l.socre) AS max_score
  FROM learn_tbl l
  GROUP BY l.lecture_id
) t
JOIN lecture_tbl lt ON t.lecture_id = lt.id
JOIN learn_tbl l2 ON l2.lecture_id = t.lecture_id AND l2.socre = t.max_score
JOIN contact_tbl c ON l2.contact_id = c.id
ORDER BY lt.subject, t.max_score DESC;


-- 각 과목별 최하위점수 학생 이름과 score 맨 위로 정렬
SELECT
  lt.subject,
  c.name AS lowest_student,
  t.min_score
FROM (
  SELECT
    l.lecture_id,
    MIN(l.socre) AS min_score
  FROM learn_tbl l
  GROUP BY l.lecture_id
) t
JOIN lecture_tbl lt ON t.lecture_id = lt.id
JOIN learn_tbl l2 ON l2.lecture_id = t.lecture_id AND l2.socre = t.min_score
JOIN contact_tbl c ON l2.contact_id = c.id
ORDER BY lt.subject, t.min_score ASC;

