-- DROP TABLE IF is EXISTS course_customer_relation;
-- DROP TABLE schedules;
-- DROP TABLE courses;
-- DROP TABLE customers;
-- DROP TABLE employees;
-- DROP TABLE users;



CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employeeName VARCHAR(100),
    role VARCHAR(20) NOT NULL

);
CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    employeeId INT,
    userName VARCHAR(100) NOT NULL ,
    password CHAR(100) NOT NULL,
    FOREIGN KEY (employeeId) REFERENCES employees(id)
    );


CREATE TABLE courses (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employeeId INT,
    courseName VARCHAR(100) NOT NULL,
    FOREIGN KEY (employeeId) REFERENCES employees(id)
);

CREATE TABLE schedules (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    courseId INT,
    time DATE NOT NULL,
    FOREIGN KEY (courseId) REFERENCES courses(id)
);

CREATE TABLE customers (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employeeId INT,
    customerName VARCHAR(100),
    FOREIGN KEY (employeeId) REFERENCES employees(id)
);

CREATE TABLE course_customer_relation (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    courseId INT,
    customerId INT,
    FOREIGN KEY (courseId) REFERENCES courses(id),
    FOREIGN KEY (customerId) REFERENCES customers(id)
);
