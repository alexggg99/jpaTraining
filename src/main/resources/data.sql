insert into department (id, name) values (1, 'development');
insert into department (id, name) values (2, 'finance');

INSERT INTO address (id, street) VALUES (1, "Стачек 11");
INSERT INTO address (id, street) VALUES (2, "Жукова 120");
INSERT INTO address (id, street) VALUES (3, "Невский 65");
INSERT INTO address (id, street) VALUES (4, "Сокольников переулок 4");

insert into employee (id, name, salary, department_id, address_id) VALUE (1, 'Ivanov', 55000, 1, 1);
insert into employee (id, name, salary, address_id) VALUE (2, 'Smirnov', 68000, 2);
insert into employee (id, name, salary, department_id, address_id) VALUE (3, 'Drobish', 46000, 1, 3);
insert into employee (id, name, salary, department_id, address_id) VALUE (4, 'Nikonov', 90000, 2, 4);

insert into phone (id, number, type, employee_id) values (1, "8 911 9826578", "MOBILE", 1);
insert into phone (id, number, type, employee_id) values (2, "8 907 5656578", "MOBILE", 3);
insert into phone (id, number, type, employee_id) values (3, "8 981 8789578", "MOBILE", 2);
insert into phone (id, number, type, employee_id) values (4, "8 911 0999287", "MOBILE", 4);

INSERT INTO project (id, name, dtype) VALUES (1, "ernest", "quality");
INSERT INTO project (id, name, dtype) VALUES (2, "fama", "quality");
INSERT INTO project (id, name, dtype) VALUES (3, "erik", "design");

INSERT INTO employee_project (employee_id, project_id) VALUES (1 , 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (2 , 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (1 , 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (2 , 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (3 , 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (4 , 3);