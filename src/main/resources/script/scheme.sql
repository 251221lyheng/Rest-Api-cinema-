
CREATE DATABASE demoMybatis;

CREATE TABLE departments(
    department_id serial primary key ,
    department_name varchar(255) not null ,
    location varchar(255) not null
);

CREATE TABLE projects(
    project_id serial primary key ,
    project_name varchar(255) not null ,
    description varchar(255) not null
);

CREATE TABLE employees(
    employee_id serial primary key ,
    employee_name varchar(255) not null ,
    date_of_birth TIMESTAMP ,
    department_id INT not null ,
    CONSTRAINT department_fk FOREIGN KEY (department_id) REFERENCES departments(department_id)
                      ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE employee_project(
    id serial primary key ,
    project_id INT NOT NULL ,
    employee_id INT NOT NULL ,
    CONSTRAINT project_fk FOREIGN KEY (project_id) REFERENCES projects(project_id),
    CONSTRAINT empolyee_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
)