
SELECT * FROM employees;

SELECT * FROM departments WHERE  department_id = 1;

SELECT * FROM  projects inner join employee_project ep on projects.project_id = ep.project_id WHERE employee_id = 1;

INSERT INTO employee_project VALUES (default,1,2);