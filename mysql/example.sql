-- 데이터베이스 테이블 생성 
CREATE DATABASE shop_db;

-- 데이터베이스 선택
USE shop_db;

-- 회원 테이블 만들기 (DDL)
CREATE TABLE member (
	member_id CHAR(8) PRIMARY KEY,
    member_name VARCHAR(20) NOT NULL,
    member_addr VARCHAR(30)
);

-- 상품 테이블 만들기
CREATE TABLE product (
	product_name CHAR(4) PRIMARY KEY,
    cost INT NOT NULL,
    make_date DATE,
    company CHAR(5),
    amount INT NOT NULL
);

-- 테이블 구조 확인하기
DESC member;
DESC product;

-- 회원 테이블에 데이터를 삽입하기 (DML : INSERT, UPDATE, DELETE, SELECT)
INSERT INTO member (member_id, member_name, member_addr)
	VALUES ('M001', '아이유', '서울시 강남구'), ('M002', '장원영','서울시 서초구');

SELECT * FROM member;

-- 상품 테이블에 데이터 입력
INSERT INTO product (product_name, cost, make_date, company, amount)
VALUES ('키보드', 25000, '2024-12-18', '로지텍', 50), ('마우스', 15000, '2025-01-01', '삼성', 120);

SELECT * from product;

-- 특정 조건으로 검색하기
SELECT member_name, member_addr FROM member WHERE member_id = 'M002';

drop table member;
drop table product;

-- SELECT 문 : 데이터를 조회하는 가장 기본적이고 중요한 문법
-- 회원 테이블 생성
CREATE TABLE member (
	mem_id CHAR(8) PRIMARY KEY,	-- NOT NULL, UNIQUE, INDEX 테이블 등록
    mem_name VARCHAR(10) NOT NULL,			  -- 이름
    mem_number  INT NOT NULL,                 -- 인원수
	addr        CHAR(2) NOT NULL,             -- 지역(예: 서울, 경기)
	phone1      CHAR(3),                      -- 국번(02, 031 등)
	phone2      CHAR(8),                      -- 전화번호 뒷자리
	height      SMALLINT,                     -- 평균 키
	debut_date  DATE                          -- 데뷔 일자
);

-- 구매 테이블 생성
CREATE TABLE buy (
  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
  mem_id      CHAR(8) NOT NULL,                        -- 회원 아이디(FK)
  prod_name   CHAR(6) NOT NULL,                        -- 제품 이름
  group_name  CHAR(4),                                 -- 분류
  price       INT NOT NULL,                            -- 가격
  amount      SMALLINT NOT NULL,                       -- 수량
  FOREIGN KEY (mem_id) REFERENCES member(mem_id)       -- 회원 테이블 참조
);

-- 데이터 삽입
INSERT INTO member
VALUES
('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19'),
('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15'),
('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21'),
('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02'),
('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12'),
('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01'),
('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10'),
('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25'),
('ESP', '에스파', 4, '전남', '061', '99999999', 165, '2019.06.19'),
('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');

INSERT INTO member
VALUES
('MMU', '마마무', 9, '서울', '02', '00000000', 167, '2015.10.19');

INSERT INTO buy
VALUES
(NULL, 'BLK', '지갑', NULL, 30, 2),
(NULL, 'BLK', '맥북프로', '디지털', 1000, 1),
(NULL, 'APN', '아이폰', '디지털', 200, 1),
(NULL, 'BLK', '청바지', '패션', 50, 3),
(NULL, 'GRL', 'SQL', '서적', 15, 5),
(NULL, 'APN', 'JAVA', '서적', 15, 2),
(NULL, 'MMU', '뷰', '서적', 15, 2),
(NULL, 'APN', '청바지', '패션', 50, 1),
(NULL, 'APN', '리액트', '서적', 15, 1);

-- 전체 열과 전체 행 조회
SELECT * FROM member;
SELECT * FROM buy;

-- 특정 열 조회
SELECT mem_name, addr FROM member;

-- 열 이름에 별칭 부여
SELECT mem_name AS "이 름", addr AS "주 소" FROM member;

-- 정렬과 제한
SELECT mem_name, height FROM member ORDER BY height DESC LIMIT 5;

-- 관계연산자
SELECT * FROM member WHERE height >= 165 AND mem_number > 6;
SELECT * FROM member WHERE height <= 165 OR addr = "서울";

-- BETWEEN ~ AND : 숫자나 날짜의 범위 지정하여 필터링
SELECT mem_name, height FROM member WHERE height BETWEEN 163 AND 165;

-- IN 연산자 : 열의 값이 지정된 목록에 있는 경우 조회
SELECT mem_name, addr FROM member WHERE addr IN("경기", "전남", "경남");

-- LIKE 연산자 : % -> 0개 이상의 임의의 문자와 일치, _ -> 한 개의 임의의 문자와 일치
SELECT * FROM member WHERE mem_name LIKE "우%";
SELECT * FROM member WHERE mem_name LIKE "__핑크";

-- 서브쿼리 : SELECT문 내에서 다른 SELECT문이 포함된 것을 서브쿼리
-- 예) 에이핑크 키보다 큰 그룹 조회
SELECT mem_name, height FROM member WHERE height > (
	SELECT height FROM member WHERE mem_name = "에이핑크"
);

-- 실습 예제
-- 1. 평균 키가 165 이상인 멤버 이름과 키
SELECT mem_name AS "멤버 이름", height AS "키" FROM member WHERE height <= 165;
-- 2. '디지털' 분류의 상품을 구매한 기록
SELECT * FROM buy WHERE group_name = "디지털";
-- 3. 지역이 '서울'이 아닌 멤버 목록
SELECT * FROM member WHERE addr != "서울";
-- 4. 상품 이름에 '지갑'이 포함된 구매 내역
SELECT * FROM buy WHERE prod_name LIKE "%지갑%";
-- 5. 블랙핑크가 구매한 모든 상품 이름과 금액
SELECT prod_name AS "상품 이름", price AS "금액" FROM buy WHERE mem_id = "BLK";
-- 6. 그룹별 평균 구매 금액
SELECT group_name, AVG(price * amount) AS "평균금액" FROM buy GROUP BY group_name;
-- 7. 키가 가장 작은 멤버
SELECT mem_name FROM member ORDER BY height ASC LIMIT 1;

-- 그룹화 및 집계 : 같은 값을 기준으로 행을 그룹화
-- SUM(), AVG(), MIN(), MAX(), COUNT()행의 개수

-- 회원별 총 구매 개수
SELECT mem_id, SUM(amount) FROM buy GROUP BY mem_id;

-- 회원별 총 구매 금액
SELECT mem_id AS "회원 아이디", SUM(price * amount) AS "총 구매 금액" FROM buy GROUP BY mem_id;

-- HAVING 절 사용 : GROUP BY 사용 이후 조건 처리가 필요한 경우
SELECT mem_id "회원 아이디", SUM(price * amount) AS "총 구매 금액" FROM buy
    GROUP BY mem_id
    HAVING SUM(price * amount) > 1000
    ORDER BY "총 구매 금액" DESC;

-- 실습 문제
-- 1. 키(height)가 165 이상인 회원을 debut_date 내림차순으로 정렬하여 5명만 출력하세요.
SELECT * FROM member WHERE height >= 165 ORDER BY debut_date DESC LIMIT 5;
-- 2. 지역(addr)의 중복 없는 고유값 목록을 출력하세요.
SELECT DISTINCT addr FROM member;
-- 3. 구매 테이블에서 회원별 평균 구매 개수가 3 이상인 회원만 출력하고, 평균값 기준으로 내림차순 정렬하세요.
SELECT mem_id, AVG(amount) AS "평균값" FROM buy GROUP BY mem_id HAVING AVG(amount) >= 3 ORDER BY "평균값" DESC;
-- 4. 회원별 총 구매 금액을 계산하고, 1000원 이상인 회원만 출력하세요.
SELECT mem_id, SUM(price * amount) AS avg_mount FROM buy GROUP BY mem_id HAVING avg_mount >= 1000;
-- 5. 회원 테이블에서 mem_id와 mem_name을 조회하되, 이름이 '김'으로 시작하는 회원만 오름차순으로 정렬하여 출력하세요.
SELECT mem_id, mem_name FROM member WHERE mem_name LIKE "김%" ORDER BY mem_name ASC;


-- DML : 데이터베이스를 만든 후 데이터를 변경하는 입력/수정/삭제 기능을 수행
-- 새로운 회원을 추가 : INSERT
-- 회원의 정보를 수정 : UPDATE
-- 회원을 삭제 : DELETE

CREATE TABLE hd_info (
	toy_id INT,
    toy_name CHAR(4),
    age INT
);
INSERT INTO hd_info VALUES (1, "우디", 25);
INSERT INTO hd_info (toy_id, age) VALUES (2, 23);
INSERT INTO hd_info (toy_id, age, toy_name) VALUES (2, 23, "버즈");

SELECT * FROM hd_info;

CREATE TABLE hd_info2 (
	toy_id INT AUTO_INCREMENT PRIMARY KEY,
    toy_name CHAR(4),
    age INT
);
INSERT INTO hd_info2 VALUES(NULL, "보핍", 25);
INSERT INTO hd_info2 VALUES(NULL, "슬링키", 22);
INSERT INTO hd_info2 (toy_name, age) VALUES("렉스", 21);
INSERT INTO hd_info2 (toy_name, age) VALUES("보안관", 30);

SELECT * FROM hd_info2;


-- 데이터 수정 : UPDATE, 행 데이터 수정
-- UPDATE hd_info2 SET 열 이름1 = 값1, 열 이름 = 값2 WHERE 조건;
UPDATE hd_info2 SET toy_name = "사육사", age = 20 WHERE toy_name = "곰돌이";

commit;
rollback;

DELETE FROM hd_info2;