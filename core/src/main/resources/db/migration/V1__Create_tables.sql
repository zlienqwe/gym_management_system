use gym_management_system;
DROP TABLE course_customer_relation;
DROP TABLE schedules;
DROP TABLE courses;
DROP TABLE customers;
DROP TABLE employees;
DROP TABLE users;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    userName VARCHAR(100) NOT NULL ,
    password CHAR(100) NOT NULL
    );

CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userId INT,
    employeeName VARCHAR(100),
    role VARCHAR(20) NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(id)
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

INSERT INTO users VALUES (NULL, "zlien", "111");
INSERT INTO users VALUES (NULL, "zll", "111");
INSERT INTO users VALUES (NULL, "yjy", "111");
INSERT INTO users VALUES (NULL, "zzh", "111");
INSERT INTO employees VALUES (NULL, 1, "zhujiang", "coach");
INSERT INTO employees VALUES (NULL, 2, "zhaolele", "OPs");
INSERT INTO employees VALUES (NULL, 3, "yanjiayang", "HR");
INSERT INTO employees VALUES (NULL, 4, "zhangzhihui", "coach");
INSERT INTO courses VALUES (NULL, 1, "yoga");
INSERT INTO courses VALUES (NULL, 4, "latin");
INSERT INTO schedules VALUES (NULL, 1, "2015-07-01");
INSERT INTO schedules VALUES (NULL, 2, "2015-07-02");
INSERT INTO schedules VALUES (NULL, 1, "2015-07-02");
INSERT INTO schedules VALUES (NULL, 2, "2015-07-03");
INSERT INTO customers VALUES (NULL, 1, "wanghuan");
INSERT INTO customers VALUES (NULL, 4, "cuifugang");
INSERT INTO course_customer_relation VALUES (NULL, 1, 1);
INSERT INTO course_customer_relation VALUES (NULL, 2, 2);