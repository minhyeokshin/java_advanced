use ssgdb;


DELIMITER $$
CREATE PROCEDURE SP_MEMBER_LIST()
BEGIN
    SET @sqlquery = 'SELECT * FROM TB_MEMBER;';
#     SELECT @sqlquery;
#
    PREPARE stmt FROM @sqlquery;
    EXECUTE stmt;
    deallocate prepare stmt;

end $$
DELIMITER ;


call SP_MEMBER_LIST();
DROP PROCEDURE SP_MEMBER_LIST