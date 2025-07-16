-- 7월4일 문제 해결을 위하여 기존 select 쿼리에 create or replace view <뷰명> as 를 추가
-- 판매정보 개별데이터 조회
CREATE OR REPLACE VIEW SALE_VIEW
AS
SELECT
	st.id
	, st.product
	, st.price
	, st.qty
	, st.discount
	, st.price * st.qty - st.discount AS prc
	, ct.name
	, IFNULL(lt.location, '') loca
FROM saled_tbl st
INNER JOIN contact_tbl AS ct
	ON st.contact_id = ct.id
LEFT JOIN location_tbl AS lt
	ON st.location_id = lt.id
WHERE 1=1
-- AND IFNULL(lt.location, '') LIKE '%강%'
;

-- 수강정보 개별데이터 조회
CREATE OR REPLACE VIEW LEARN_VIEW
AS
SELECT
	ct.name
	, ct.email
	, lt.score
--	, lt.id
	, lt2.subject
	, lt2.teacher
	, lt2.room_num 
	, lt2.start_dt
	, lt2.end_dt
FROM learn_tbl lt
INNER JOIN lecture_tbl lt2 
	ON lt.lecture_id = lt2.id
INNER JOIN contact_tbl ct 
	ON ct.id = lt.contact_id
-- WHERE start_dt <= '2025-08-30'
-- ORDER BY start_dt
;

-- 1. 수강학생별로 수강중인 과목의 가장빠른 시작일자시간과 가장늦은 끝일자시간을 출력
-- view 를 사용하여 학생별 수강일자 최저시작일, 최대종료일
select name
	, min(start_dt) as sd
	, max(end_dt) as ed
from learn_view
group by name
order by name
;

-- sub query 를 사용하여 학생별 수강일자 최저시작일, 최대종료일
select t1.name
	, min(t1.start_dt)
	, max(t1.end_dt)
from (
	SELECT
		ct.name
		, ct.email
		, lt.score
		, lt2.subject
		, lt2.teacher
		, lt2.room_num 
		, lt2.start_dt
		, lt2.end_dt
	FROM learn_tbl lt
	INNER JOIN lecture_tbl lt2 
		ON lt.lecture_id = lt2.id
	INNER JOIN contact_tbl ct 
		ON ct.id = lt.contact_id
) AS t1
group by t1.name
order by t1.name
;

-- select join 으로 연결한 후에 각 테이블의 컬럼을 group, 집합연산을 사용하여 학생별 수강일자 최저시작일, 최대종료일
select ct.name
	, min(lt2.start_dt)
	, max(lt2.end_dt)
FROM learn_tbl lt
INNER JOIN lecture_tbl lt2 
	ON lt.lecture_id = lt2.id
INNER JOIN contact_tbl ct 
	ON ct.id = lt.contact_id
group by ct.name
order by ct.name
;

-- 2. 각과목별로 수강하는 학생 인원수를 출력
-- count 는 행의 갯수를 리턴하는 함수, count(*), count(컬럼)
select lt.lecture_id, lt2.subject, count(*)
from learn_tbl lt
inner join lecture_tbl lt2 on lt.lecture_id = lt2.id
group by lt.lecture_id, lt2.subject
order by lt2.subject
;

-- 3. 각과목별로 최우수점수 학생 이름과 score 가 맨위로 정렬
-- 최고점수 순서로 정렬을 해본다.
select lecture_id, score, contact_id
from learn_tbl
order by lecture_id, score desc
; -- 준비단계

-- 과목정보 출력
select subject, id
from lecture_tbl
order by subject
; -- 준비단계

-- 3. 과목정보에 과목명, 가장 높은 점수 1개, 가장높은점수의 학생이름 출력 해결
-- select a, b, (select a from t .. 1개의 행과 1개의 컬럼 값만 가져와야지 된다.), c, d from (데이터)
select lt.subject, lt.id
	, (select ln.score	-- 내부쿼리는 1개의 행, 1개의 컬럼
		from learn_tbl ln
		where ln.lecture_id = lt.id -- 수강정보테이블의 과목이 같은 행들
		order by ln.score desc -- 수강점수 내림차순
		limit 1 offset 0	-- 결과 데이터의 첫번째 행만 가져온다.
		) as max_score -- 별명
	, (select ct.name -- 학생의 이름
		from contact_tbl ct
		where ct.id = ( -- 1개의 컬럼, n개의 행
			select ln.contact_id
			from learn_tbl ln
			where ln.lecture_id = lt.id
			order by ln.score desc limit 1 offset 0
		) -- 수강정보의 과목이 같은 데이터행들 중에서 가장 점수가 높은 행 1개의 학생번호
	) as name
from lecture_tbl lt
;

-- 4. 과목정보에 과목명, 가장 낮은 점수 1개, 가장낮은점수의 학생이름 출력


-- 5. 판매정보 쿼리 뷰
select *
from SALE_VIEW;

-- 6. 각 고객별로 판매총금액을 내림차순으로 출력
select name, sum(prc) as price
from SALE_VIEW
group by name
order by price desc;


-- 7. 각 상품별로 판매총금액을 내림차순으로 출력
