use sakila;

DELIMITER $$
CREATE PROCEDURE sakilaCustomerCount() -- sakila데이터베이스의 고객명수 확인 프로시져
BEGIN
    DECLARE customer_cnt INT;
    DECLARE add_number INT; -- 변수 선언

    SET customer_cnt = 0;
    SET add_number = 0;

    SET customer_cnt = (select count(*) from customer);

    SELECT customer_cnt + add_number;

end $$
DELIMITER ;


call sakilaCustomerCount(); -- 저장 프로시저 호출

show create procedure sakilaCustomerCount;  -- 저장 프로시저 내용 확인

DROP PROCEDURE sakilaCustomerCount;


-- 제어문 IF
-- IF 조건식 THEN (조건식이 참일때) 실행할 식
-- ELSE (조건식이 거짓일때) 실행할 식
-- END IF;

SELECT store_id , IF(store_id = 1,'일','이') as ONE_TWO
FROM customer group by store_id;

DROP PROCEDURE IF EXISTS customerif;

DELIMITER $$
CREATE PROCEDURE customer_if(customer_id_input int)
    BEGIN
    DECLARE store_id_i INT;
    DECLARE s_id_one INT;
    DECLARE s_id_two INT;

    SET store_id_i = (select store_id from customer where customer_id = customer_id_input);

    IF store_id_i = 1 THEN SET s_id_one =1;
    ELSE SET s_id_two = 2;
    END IF;

    SELECT store_id_i,s_id_one,s_id_two;

end $$
DELIMITER ;

call customer_if(1);


select *
from payment;


select customer_id,sum(amount) as amount,
    CASE
    WHEN sum(amount) >= 150 THEN 'VVIP'
    WHEN sum(amount) >= 120 THEN 'VIP'
    WHEN sum(amount) >= 100 THEN 'GOLD'
    WHEN sum(amount) >= 80 THEN 'SILVER'
  ELSE 'BRONZE'
END AS customer_level
from payment
group by customer_id;



DELIMITER $$

CREATE PROCEDURE customer_level_case(customer_id_input int)
BEGIN
    DECLARE customer_level varchar(20);
    DECLARE amount_sum float;

    SET amount_sum = (select sum(amount) from payment where customer_id=customer_id_input group by customer_id);

    CASE
        WHEN amount_sum >= 150 THEN SET customer_level = 'VVIP';
        WHEN amount_sum >= 120 THEN SET customer_level = 'VIP';
        WHEN amount_sum >= 100 THEN SET customer_level = 'GOLD';
        WHEN amount_sum >= 80 THEN SET customer_level = 'SILVER';
        ELSE SET customer_level = 'BRONZE';
        end case;


    SELECT customer_id_input as customer_id , amount_sum , customer_level;

END $$
DELIMITER ;

call customer_level_case(59);


-- WHILE문 : 반복문으로 사용자가 지정한 조건이 만족할 때 까지 같은  내용을반복

# 문법 : WHILE 조건식 Do 명령문 END WHILE;


DELIMITER $$
CREATE PROCEDURE value_while(param1 INT,param2 INT)
BEGIN
    DECLARE i INT;
    DECLARE result INT;

    SET i = 1;
    SET result = 0;

    mywhile:
    WHILE (i <= param1)
        DO
        SET result = result + param2;
        SET i = i+1;

        IF(result > 100) THEN LEAVE mywhile;
        END IF;
    END WHILE ;

    SELECT result;

end $$
DELIMITER ;

DROP PROCEDURE value_while;

call value_while(100,23);

-- 동적 SQL

PREPARE dynamic_query1 FROM 'SELECT * FROM customer WHERE customer_id = ?';

SET @a = 1;
EXECUTE dynamic_query1 USING @a;

DELIMITER $$
CREATE PROCEDURE dynamic_query2(t_name VARCHAR(50),c_name VARCHAR(50),customer_id int)
BEGIN
    SET @t_name = t_name;
    SET @c_name = c_name;
    SET @customer_id = customer_id;
    SET @sql = concat('SELECT ',@c_name,' FROM ',@t_name,' WHERE customer_id = ',@customer_id);

    SELECT @sql;
    PREPARE dynamic_query FROM @sql;
    EXECUTE dynamic_query;
    DEALLOCATE PREPARE dynamic_query;

end $$
DELIMITER ;

DROP procedure dynamic_query2;

call dynamic_query2('payment','*',1);
