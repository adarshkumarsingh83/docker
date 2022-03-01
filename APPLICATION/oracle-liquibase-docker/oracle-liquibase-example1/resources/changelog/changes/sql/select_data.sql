CREATE OR REPLACE PROCEDURE SYSTEM.GET_EMPLOYEE_INFO
( V_EMP_ID IN EMPLOYEE.EMP_ID%TYPE, V_EMP_MSG OUT VARCHAR )
AS
BEGIN
   SELECT EMP_ID ||' '|| FIRST_NAME ||' '|| LAST_NAME ||' '|| CAREER INTO V_EMP_MSG
   FROM SYSTEM.EMPLOYEE WHERE SYSTEM.EMPLOYEE.EMP_ID = V_EMP_ID;
END;

//

