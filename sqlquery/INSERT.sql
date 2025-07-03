INSERT INTO contact_tbl (name, phoneNumber, zipNumber, email, addr)
VALUES ('홍길동', '010-11', '21324', 'hong', '서울시 영등포구')
, ('이순신', '010-22', '34111', 'lee', '인천시 계양구')
, ('을지문덕', '010-33', '93828', 'ul', '서울시 구로구');



INSERT INTO location_tbl (location)
VALUES ('서울시 영등포구')
, ('인천시 계양구')
, ('경기도 일산시');


INSERT INTO saled_tbl (sale_dt, price, qty, product, location_id, discount, contact_id)
VALUES ('2025-07-03', 2500, 2, '곰보빵', 1,0,1)
, ('2025-07-03', 3000, 1, '우유', 2,0,2)
, ('2025-07-02', 31000, 1, '쌀 10kg', 2,1000,2)
, ('2025-07-02', 26000, 2, '밀가루 20kg', 2,2000,2)
, ('2025-07-02', 85000, 1, '밥솥', 3,5000,3)
, ('2025-07-03', 12000, 2, '빗자루', 3,0,3);

INSERT INTO learn_tbl (lecture_id, socre, contact_id)
VALUES (1 , 0, 3)
, (2 , 62, 2)
, (3 , 68, 1)
, (2 , 66, 1)
, (1 , 0, 3);

INSERT INTO lecture_tbl (subject, teacher, root_num, start_dt, end_dt)
VALUES ('데이터통신', '김교수', '705', '2025-07-01', '2025-07-10')
, ('데이터보안', '이교수;', '813', '2025-06-10', '2025-06-25')
, ('웹서버', '최교수', '60A', '2025-06-05', '2025-06-15');




