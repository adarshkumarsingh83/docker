
DROP PROCEDURE IF EXISTS getEmployee;
//
CREATE PROCEDURE getEmployee(IN EMP_NO INT(10))
BEGIN
   SELECT GROUP_CONCAT(EMP_ID,' ', FIRST_NAME,' ',LAST_NAME,' ',CAREER) FROM EMPLOYEE WHERE EMP_ID = EMP_NO;
END //
//

