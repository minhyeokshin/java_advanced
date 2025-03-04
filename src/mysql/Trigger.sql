use ssgdb;

CREATE TABLE orderTbl -- 구매 테이블
(orderNo INT AUTO_INCREMENT PRIMARY KEY, -- 구매 일련번호
 userID VARCHAR(5), -- 구매한 회원아이디
 prodName VARCHAR(5), -- 구매한 물건
 orderamount INT );  -- 구매한 개수
CREATE TABLE prodTbl -- 물품 테이블
( prodName VARCHAR(5), -- 물건 이름
  account INT ); -- 남은 물건수량
CREATE TABLE deliverTbl -- 배송 테이블
( deliverNo  INT AUTO_INCREMENT PRIMARY KEY, -- 배송 일련번호
  prodName VARCHAR(5), -- 배송할 물건
  account INT UNIQUE); -- 배송할 물건개수

INSERT INTO prodTbl VALUES('사과', 100);
INSERT INTO prodTbl VALUES('배', 100);
INSERT INTO prodTbl VALUES('귤', 100);

-- 물품 테이블에서 개수를 감소시키는 트리거
DROP TRIGGER IF EXISTS orderTrg;
DELIMITER //
CREATE TRIGGER orderTrg  -- 트리거 이름
    AFTER  INSERT
    ON orderTBL -- 트리거를 부착할 테이블
    FOR EACH ROW
BEGIN
    UPDATE prodTbl SET account = account - NEW.orderamount
    WHERE prodName = NEW.prodName ;
END //
DELIMITER ;

-- 배송테이블에 새 배송 건을 입력하는 트리거
DROP TRIGGER IF EXISTS prodTrg;
DELIMITER //
CREATE TRIGGER prodTrg  -- 트리거 이름
    AFTER  UPDATE
    ON prodTBL -- 트리거를 부착할 테이블
    FOR EACH ROW
BEGIN
    DECLARE orderAmount INT;
    -- 주문 개수 = (변경 전의 개수 - 변경 후의 개수)
    SET orderAmount = OLD.account - NEW.account;
    INSERT INTO deliverTbl(prodName, account)
    VALUES(NEW.prodName, orderAmount);
END //
DELIMITER ;

INSERT INTO orderTbl VALUES (NULL,'JOHN', '배', 5);

SELECT * FROM orderTbl;
SELECT * FROM prodTbl;
SELECT * FROM deliverTbl;

SELECT * FROM orderTbl;
SELECT * FROM prodTbl;
SELECT * FROM deliverTbl;

ALTER TABLE deliverTBL CHANGE prodName productName VARCHAR(5);

ALTER TABLE deliverTBL CHANGE prodName productName VARCHAR(5);

INSERT INTO orderTbl VALUES (NULL, 'DANG', '사과', 9);

SELECT * FROM orderTbl;
SELECT * FROM prodTbl;
SELECT * FROM deliverTbl;