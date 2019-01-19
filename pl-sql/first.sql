DECLARE
v_salary number;
BEGIN
select salary into v_salary from EMPLOYEES where ID = '1001';
DBMS_OUTPUT.PUT_LINE(v_salary);
END;