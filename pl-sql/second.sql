DECLARE 
v_salary NUMBER;
v_name  VARCHAR2(20 BYTE);
BEGIN
SELECT salary,name into v_salary, v_name from EMPLOYEES
where ID= '1002';
DBMS_OUTPUT.PUT_LINE(v_name || ' Has salary ' ||v_salary);
END;