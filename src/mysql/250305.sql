
use ssgdb;
CREATE TABLE CODE1(cId int,cName VARCHAR(20));
select  * from CODE1;
INSERT INTO CODE1 VALUES (1,'프론트디자이너');

DELIMITER $$
CREATE PROCEDURE p_insertcodes(in cData varchar(255),in cTName varchar(255),out resultMsg varchar(255))
    BEGIN
        -- 쿼리문 작성
        SET @strsql = CONCAT('INSERT INTO ', cTName, ' (cId, cName) ', ' SELECT COALESCE(MAX(cId),0) + 1 , ? FROM ', cTname );

        -- 바인딩할 변수 설정
        SET @cData = cData;
        SET resultMsg = 'Insert Success';

        PREPARE stmt FROM @strsql;
        EXECUTE stmt using @cData;
        EXECUTE stmt using @resultMsg;
        deallocate prepare stmt;

        -- 트랜잭션 확정

        COMMIT;

END $$
DELIMITER ;

CALL p_insertcodes('백엔드 자바 개발자','CODE1','Insert Success');

select *
from CODE1;

DROP PROCEDURE p_insertcodes;


-- TB_MEMBER 테이블에 callableStemEx03 클래스 작성하여서 SP_MEMBER_INSERT PROCEDURE 를 CALL하여
-- 회원을 입력하도록 작성해주세요
-- 입력 성공시 "회원 정보가 안전하게 저장되었습니다." 메세지 출력!

CREATE TABLE TB_MEMBER(
    m_seq INT AUTO_INCREMENT PRIMARY KEY,
    m_userid VARCHAR(20) NOT NULL,
    m_pwd VARCHAR(20) NOT NULL ,
    m_email VARCHAR(50) NOT NULL ,
    m_hp VARCHAR(20) NOT NULL ,
    m_registdate DATETIME DEFAULT NOW(),
    m_point INT DEFAULT 0
);

select *
from TB_MEMBER;

DELIMITER $$
CREATE PROCEDURE p_insertcodes3
(userID varchar(255),
 in userPW varchar(255),
 in useremail varchar(255),
 in hp varchar(255),
 out resultMsg varchar(255))
BEGIN
    SET @ID =userID;
    SET @PW =userPW;
    SET @EMAIL =useremail;
    SET @HP =hp;
    SET resultMsg = '회원 정보가 안전하게 저장되었습니다.';
    -- 쿼리문 작성
        SET @strsql2 = 'INSERT INTO TB_MEMBER (m_userid, m_pwd, m_email, m_hp) VAlUES (?, ?, ?, ?);';

#     SET @strsql = CONCAT('INSERT INTO ', cTName, ' (cId, cName) ', ' SELECT COALESCE(MAX(cId),0) + 1 , ? FROM ', cTname );

    -- 바인딩할 변수 설정

    PREPARE stmt FROM @strsql2;
    EXECUTE stmt using @ID, @PW, @EMAIL, @HP;
    deallocate prepare stmt;

    COMMIT;
END $$
DELIMITER ;


SET @resultMsg = '';
call p_insertcodes3('test2','test2','test2@test2','test2',@resultMsg);
SELECT @resultMsg;

DROP procedure p_insertcodes3;

select *
from TB_MEMBER;

use ssgdb;

CREATE TABLE product_TB(
    Prod_Code varchar(50),
    Prod_Num integer,
    Prod_Date datetime,
    State varchar(50)
);

alter table product_TB add PRIMARY KEY (Prod_Code,Prod_Num);

desc product_TB;

INSERT INTO product_TB VALUES
                           ('AAA',0001,'2023.10.10','판매완료'),
                           ('AAA',0002,'2023.10.11','매장진열'),
                           ('BBB',0001,'2023.10.12','재고창고'),
                           ('CCC',0001,'2023.10.13','판매완료'),
                           ('CCC',0002,'2023.10.14','매장진열');



SELECT Prod_Code,Prod_Num
FROM product_TB;


CREATE PROCEDURE INPUT_Prod(
    IN Code VARCHAR(50),
    IN Date DATETIME,
    IN State VARCHAR(50)
)
BEGIN
    DECLARE maxnum INT;

    -- 최대 Prod_Num 찾기 (없으면 0으로 처리하고 +1)
    SELECT IFNULL(MAX(Prod_Num), 0) + 1 INTO maxnum
    FROM product_TB
    WHERE Prod_Code = Code;

    -- INSERT 문 생성
    SET @input = CONCAT('INSERT INTO product_TB (Prod_Code, Prod_Num, Prod_Date, State) VALUES (',
                        "'", Code, "', ", maxnum, ", '", Date, "', '", State, "')");

    -- 실행
    PREPARE stmt FROM @input;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;

END $$
DELIMITER ;


DROP PROCEDURE INPUT_Prod;


call INPUT_Prod('DDD','2023-05-06','재고창고');

select *
from product_TB;

CREATE view v_userbuytbl as
    SELECT u.userid , u.name , u.addr
    from usertbl u ;

select * from v_userbuytbl where name = '김범수';


SHOW VARIABLES LIKE 'innodb_data_file_path';


-- 1.innodb_file_per_table 상태 정보를 On 상태인지 확인
SHOW VARIABLES LIKE 'innodb_file_per_table';

-- 테이블 스페이스 설정
CREATE TABLESPACE ts_aa add datafile 'ts_aa.ibd';
CREATE TABLESPACE ts_bb add datafile 'ts_bb.ibd';
CREATE TABLESPACE ts_cc add datafile 'ts_cc.ibd';


use ssgdb;
create table table_a(id int) tablespace ts_aa;
SELECT * FROM information_schema.FILES WHERE TABLESPACE_NAME = 'ts_aa';
ALTER table table_a tablespace ts_bb;

create table table_c (select * from sakila.customer);
select *
from table_c;