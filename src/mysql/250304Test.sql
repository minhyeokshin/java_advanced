use ssgdb;
CREATE TABLE usertbl -- 회원 테이블
( userID  	CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  name    	VARCHAR(10) NOT NULL, -- 이름
  birthYear   INT NOT NULL,  -- 출생년도
  addr	  	CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1	CHAR(3), -- 휴대폰의 국번(011, 016, 017, 018, 019, 010 등)
  mobile2	CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 키
  mDate    	DATE  -- 회원 가입일
);

CREATE TABLE buytbl -- 회원 구매 테이블(Buy Table의 약자)
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   userID  	CHAR(8) NOT NULL, -- 아이디(FK)
   prodName 	CHAR(6) NOT NULL, --  물품명
   groupName 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 단가
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (userID) REFERENCES usertbl(userID)
);

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buytbl VALUES(NULL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buytbl VALUES(NULL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
commit;

SELECT * FROM usertbl;
SELECT * FROM buytbl;


-- 1.1 userTbl테이블을 대상으로 1개의 이름을 입력하여 해당 회원의 정보를 출력하는 프로시저를 작성하고 실행시키세요  '조관우' 회원의 정보를 출력하세요

DELIMITER $$
CREATE PROCEDURE dynamic_query(t_name VARCHAR(50),c_name VARCHAR(50),user_name varchar(50))
BEGIN
    SET @t_name = t_name;
    SET @c_name = c_name;
    SET @user_name = user_name;
    SET @sql = concat('SELECT ',@c_name,' FROM ',@t_name,' WHERE name = ','@user_name');

    SELECT @sql;
    PREPARE dynamic_query FROM @sql;
    EXECUTE dynamic_query;
    DEALLOCATE PREPARE dynamic_query;

end $$
DELIMITER ;

call dynamic_query('usertbl','*','조관우');




-- 1.2 userTbl 테이블  : 회원중 출생년도가 1970 이후 출생자이면서 키가 178 초과 인 회원의 정보를 출력하는 프로시저를 작성하고 실행시키세요

select *
from usertbl
where birthYear > 1970 and height > 178;


DELIMITER $$
CREATE PROCEDURE dynamic_query2(t_name VARCHAR(50),c_name VARCHAR(50),b_year int,height int)
BEGIN
    SET @t_name2 = t_name;
    SET @c_name2 = c_name;
    SET @b_year = b_year;
    SET @height = height;
    SET @sql2 = concat('SELECT ',@c_name2,' FROM ',@t_name2,' WHERE birthYear > ',' @b_year',' and ','height > ','@height');

    SELECT @sql2;
    PREPARE dynamic_query2 FROM @sql2;
    EXECUTE dynamic_query2;
    DEALLOCATE PREPARE dynamic_query2;

end $$
DELIMITER ;

call dynamic_query2('usertbl','*',1970,178);

DROP procedure dynamic_query2;

-- 1.3 usertbl 테이블 :  1980년 이후 출생자에게는 "고객님 건강보험 생애 전환 서비스 가입에 해당하지 않습니다."
-- 1980년 이전 출생자들에게는 "고객님 건강보험 생애 전환 서비스 가입에 해당하오니 가입해 주시길 바랍니다." 출력하는 프로시저 작성

    select *,IF(birthYear>1980,'고객님 건강보험 생애 전환 서비스 가입에 해당하지 않습니다.','고객님 건강보험 생애 전환 서비스 가입에 해당하오니 가입해 주시길 바랍니다.') as '건강보험 가입'
    from usertbl;


    DROP procedure if exists ifelseProc;
    DELIMITER $$
    CREATE PROCEDURE ifelseProc(in userName VARCHAR(20))
        BEGIN
            DECLARE
                birthYear INT;

            SELECT birthYear into birthYear From usertbl where name = userName;
            if(birthYear >= 1980) THEN select '고객님 건강보험 생애 전환 서비스 가입에 해당하지 않습니다.' as '건강보험';
            else
                SELECT '고객님 건강보험 생애 전환 서비스 가입에 해당하오니 가입해 주시길 바랍니다.' as '건강보험';
                END IF;
    END $$
    DELIMITER ;

call ifelseProc('은지원');

-- 1.4 while문을 활용하여 구구단을 문자열로 생성해서 테이블에 입력하는 프로시저를 작성해 보자

DROP Table IF EXISTS guguTBL;
CREATE TABLE guguTBL(txt VARCHAR(100)); -- 구구단 저장용 테이블

DROP PROCEDURE if exists whileProcgugu;

DELIMITER $$
CREATE PROCEDURE whileProcgugu()
BEGIN
   DECLARE i int;
   DECLARE j int;
   DECLARE str VARCHAR(100);

   set i = 2;

   WHILE(i < 10) DO  -- 2단 ~ 9단까지

    SET j = 1;
   WHILE(j<10) DO
           set str = concat(i,' x ',j,' = ',i*j);
           INSERT INTO guguTBL VALUES (str);
           set j = j+1;
   END WHILE;

      set i = i + 1;

       END WHILE;

END $$
DELIMITER ;

drop procedure whileProcgugu;

call whileProcgugu();


select *
from guguTBL;


-- 1.4 1부터 100까지 합계를 구하는 totalSum(1,100) 프로시저를 작성해보세요.
    -- 출력  포맷 : '1-100의 총합은 5050입니다.'

DELIMITER $$
CREATE PROCEDURE totalSum(min int,max int)
BEGIN
    DECLARE result int;
    DECLARE i int;
    SET i = min;
    set result = 0;

    WHILE(i <= max ) DO

            set result = result + i;
            set i = i + 1;
        END WHILE;

    select concat(min,'-',max,'의 총합은 ',result,'입니다.') as 'TotalSum';

END $$
DELIMITER ;

call totalSum(1,100);


-- 1.5 DECARE~ HANDLER 를 이용해서 오류처리 구문을 추가해 보자 . ex) 1부터 숫자를 더하여 합계가 정수형(int)데이터 형식의 오버플로우가 발생하면 멈추고 오류처리를 해보자
DELIMITER $$
CREATE PROCEDURE totalSum2()
BEGIN
    DECLARE result int;
    DECLARE i int;
    DECLARE savepointResult int;

    DECLARE EXIT HANDLER FOR 1264

    BEGIN
        SELECT CONCAT('INT 오버플로 직전의 합계 --> ',savepointResult),
        CONCAT('1+2+3+.....+ ',i,' = 오버플로');
    end ;

    set i = 1;
    set result = 0;

    while(true)
        Do
        SET savepointResult = result;
        SET result = result + i;
        SET i = i + 1;

        end while;

END $$
DELIMITER ;

DROP procedure totalSum2;
call TotalSum2;

-- 1.6 현재 저장된 프로시저의 이름과 내용을 확인해 보자

    use information_schema;

SELECT ROUTINE_NAME,ROUTINE_DEFINITION,DTD_IDENTIFIER
FROM information_schema.ROUTINES
WHERE ROUTINE_SCHEMA = 'ssgdb' and ROUTINE_TYPE = 'PROCEDURE';


-- 1.7 파라미터도 확인해 보자

SELECT parameter_mode,PARAMETER_NAME,DTD_IDENTIFIER
FROM information_schema.PARAMETERS
where SPECIFIC_NAME = 'TotalSum';

-- 1.8 테이블 이름을 파라미터로 전달해 보자
use ssgdb;

DELIMITER $$
CREATE PROCEDURE nameTblProc(IN tblname VARCHAR(20))
    BEGIN
         SELECT * FROM tblname;

END $$
DELIMITER ;



call nameTblProc(usertbl);



DELIMITER $$
CREATE PROCEDURE nameTblProc2(IN tblname VARCHAR(20))
BEGIN
    SET @sqlQuery = concat('SELECT * FROM ', tblname);
    PREPARE myQuery FROM @sqlQuery;
    EXECUTE myQuery;
    deallocate PREPARE myQuery;

END $$
DELIMITER ;

call nameTblProc2('usertbl');

-- 1.9 배송담당자는 사용자의 정보를 접근할 수 있는 프로시저(delivProc)를 이용하여 사용자의 주소와 이름을 확인한다.'

select *
from usertbl;

DELIMITER $$
CREATE PROCEDURE delivProc(in user_id VARCHAR(20))

BEGIN

    SET @sqlQuery2 = concat('select userID, name , addr , mobile1 , mobile2 FROM usertbl WHERE userID = ','\'',user_id,'\'');
    PREPARE myQuery2 FROM @sqlQuery2;
    EXECUTE myQuery2;
    deallocate PREPARE myQuery2;

END $$
DELIMITER ;


call delivProc('BBK');

DROP PROCEDURE delivProc;

/*
DELIMITER $$
CREATE FUNCTION
    RETURN

END $$
DELIMITER ;

SELECT
 */

DROP FUNCTION IF EXISTS userFunc;
DELIMITER $$
CREATE FUNCTION userFunc(value1 INT,value2 INT)
    RETURNS INT
BEGIN
    RETURN  value1 + value2;
end $$
DELIMITER ;

SELECT userFunc(100,200);

DROP FUNCTION IF EXISTS getAgeFunc;
DELIMITER $$
CREATE FUNCTION getAgeFunc(bYear Int)
RETURNS INT
BEGIN
    DECLARE age INT;
    SET age = YEAR(CURDATE()) - bYear;
    RETURN age;
end $$
DELIMITER ;

SELECT getAgeFunc(1997);

SELECT concat(YEAR(CURDATE())-getAgeFunc(1997),'년생은 ',YEAR(CURDATE()),'년 현재 ',getAgeFunc(1997),'살입니다.') as 나이계산;

DELIMITER $$
CREATE FUNCTION getAgeFunc2(bYear Int)
    RETURNS VARCHAR(50)
BEGIN
    DECLARE age INT;
    DECLARE printage VARCHAR(50);
    SET age = YEAR(CURDATE()) - bYear;
    SET printage = concat(bYear,'년생은 ',YEAR(CURDATE()),'년 현재 ',age,'살입니다.');
    RETURN printage;
end $$
DELIMITER ;

SELECT getAgeFunc2(1997) as '나이계산';

DROP FUNCTION getAgeFunc2;




DROP PROCEDURE IF EXISTS cursorProc;
DELIMITER $$
CREATE PROCEDURE cursorProc()
BEGIN
    DECLARE userHeight INT;
    DECLARE cnt INT DEFAULT 0;
    DECLARE totalheight INT DEFAULT 0;

    DECLARE endOfRow BOOLEAN DEFAULT FALSE;

    DECLARE userCursor CURSOR FOR
        SELECT height FROM usertbl;
    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET endOfRow = TRUE;
    OPEN userCursor;

    cursor_loop: LOOP
        FETCH userCursor INTO userHeight;

        IF endOfRow THEN
            LEAVE cursor_loop;
        end if;

        SET cnt = cnt + 1;
        SET totalheight = totalheight + userHeight;
    end loop cursor_loop;

    SELECT concat('고객 키의 평균 => ',format(totalheight/cnt,2)) as '평균 키';

    CLOSE userCursor;
end $$
DELIMITER ;

call cursorProc;

DROP PROCEDURE cursorProc;


CREATE TABLE IF NOT EXISTS testTbl(id INT,txt VARCHAR(10));
INSERT INTO testTbl VALUES (1,'레드벨벳'),(2,'잇지'),(3,'블랙핑크');

select *
from testTbl;

DROP TRIGGER IF EXISTS testTrg;

DELIMITER //
CREATE TRIGGER testTRG
    AFTER DELETE
    ON testTbl
    FOR EACH ROW
BEGIN
    SET @msg = '가수 그룹이 삭제됨';
end //
DELIMITER ;

SET @msg = '';
INSERT INTO testTbl VALUES (4,'마마무');

select *
from testTbl;

SELECT @msg;
UPDATE testTbl SET txt = '블핑' WHERE id = 3;

SELECT @msg;
DELETE FROM testTbl WHERE id = 4;

SELECT @msg;


Use ssgdb;
DROP TABLE buytbl;
CREATE TABLE backup_userTbl
(
    userID    CHAR(8)     NOT NULL PRIMARY KEY,
    name      VARCHAR(10) NOT NULL,
    birthYear INT         NOT NULL,
    addr      CHAR(2)     NOT NULL,
    mobile1   CHAR(3),
    mobile2   CHAR(8),
    height    SMALLINT,
    mDate     DATE,
    modType   CHAR(2),
    modDate   DATE,
    modUser   VARCHAR(256)
);

DROP TRIGGER IF EXISTS backUserTbl_UpdateTrg;
DELIMITER //
CREATE TRIGGER backuUserTbl_UpdateTrg
    AFTER UPDATE
    ON usertbl
    FOR EACH ROW
BEGIN
    INSERT INTO backup_userTbl VALUES (OLD.userID,OLD.name,OLD.birthYear,OLD.addr,OLD.mobile1,OLD.mobile2,OLD.height,OLD.mDate,'수정',CURDATE(),CURRENT_USER());
end //
DELIMITER ;

DROP TRIGGER IF EXISTS backUserTbl_DeleteTrg;
DELIMITER //
CREATE TRIGGER backuUserTbl_DeleteTrg
    AFTER DELETE
    ON usertbl
    FOR EACH ROW
BEGIN
    INSERT INTO backup_userTbl VALUES (OLD.userID,OLD.name,OLD.birthYear,OLD.addr,OLD.mobile1,OLD.mobile2,OLD.height,OLD.mDate,'삭제',CURDATE(),CURRENT_USER());
end //
DELIMITER ;

DROP TRIGGER backuUserTbl_DeleteTrg;
DROP TRIGGER backuUserTbl_UpdateTrg;


select *
from backup_userTbl;

select *
from usertbl;

use ssgdb;
UPDATE usertbl SET addr = '주소변경' WHERE userID = 'BBB';
DELETE FROM usertbl WHERE height >= 177;

SELECT * FROM usertbl WHERE height >= 177;

select *
from usertbl
WHERE userID = 'JKW';

SELECT @@autocommit;
SHOW TRIGGERS FROM ssgdb;

SHOW TABLES LIKE 'backup_userTbl';
DESC backup_userTbl;
DESC usertbl;

TRUNCATE TABLE usertbl;

DROP TRIGGER IF EXISTS usertbl_InsertTrg;
DELIMITER //
CREATE TRIGGER userTbl_InsertTbl
    AFTER INSERT
    ON usertbl
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = '데이터의 입력을 시도했습니다. 귀하의 정보가 서버에 기록되었습니다.';
    end //
DELIMITER ;

INSERT INTO usertbl VALUES ('ABC','에비씨','1977','서울','01,','1111111','181','2019-12-25');

select * from usertbl;
select * from backup_userTbl;

use ssgdb;

DROP TRIGGER IF EXISTS userTbl_BeforeInsertTrg;
DELIMITER //
CREATE TRIGGER userTbl_BeforeInsertTrg
    BEFORE INSERT
    ON usertbl
    FOR EACH ROW

BEGIN
    IF NEW.birthYear < 1900 THEN
        SET NEW.birthYear = 0;
    ELSEIF NEW.birthYear > YEAR(CURDATE()) THEN
        SET NEW.birthYear = YEAR(CURDATE());
    END IF;

end //
DELIMITER ;

INSERT INTO usertbl VALUES
                        ('AAA','에이','1877','서울','011','1112222','181','2022-12-25');

INSERT INTO usertbl VALUES
                        ('BBB','비이','2977','경기','011','1113333','171','2019-3-25');

select *
from usertbl;

select *
from backup_userTbl;

drop TRIGGER userTbl_InsertTbl;

SELECT * FROM usertbl WHERE userID = 'BBB';

UPDATE usertbl SET addr = '서울' WHERE userID = 'AAA';

SELECT * FROM backup_userTbl;
SHOW WARNINGS;

select u.userID, u.name, u.addr as '신주소', b.addr as '이전주소',b.modDate as '변경일'
from usertbl u
         join backup_userTbl b
              on u.userID = b.userID
where b.modType = '수정';


SHOW TRIGGERS FROM ssgdb;