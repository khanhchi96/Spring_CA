insert into semester(semester_label, start_date, end_date) values
('[2017-2018] Semester 1', '2019-09-04', '2017-12-20'),
('[2017-2018] Semester 2', '2018-01-15', '2018-05-20'),
('[2018-2019] Semester 1', '2018-09-04', '2018-12-20'),
('[2018-2019] Semester 2', '2019-01-15', '2019-05-20'),
('[2019-2020] Semester 1', '2019-09-04', '2019-12-20'),
('[2019-2020] Semester 2', '2020-01-15', '2020-05-20');

insert into degree(degree_label) values('Graduate Diploma in System Analysis'), ('Master of Technology in Software Engineering');

insert into student(first_name, last_name, middle_name, birth_date, gender, email, mobile, level, status, semester_id, degree_id, address, GPA)
values('Chi', 'Phung', 'Khanh', '1996-08-25', 'Female', 'khanhchi2596@gmail.com', '98912598','Year 1', 'Enrolling', 5, 1, '', 0.0),
('Ying', 'Feng', 'Li', '1995-09-25', 'Female', 'fengliying@gmail.com', '87654321', 'Year 1', 'Enrolling', 5, 1, '', 0.0),
('Bo', 'Wang', 'Yi', '1997-04-23', 'Male', 'wangyibo@gmail.com', '86083571', 'Year 1', 'Enrolling', 5, 1, '', 0.0),
('Zhan', 'Xiao', '', '1991-08-11', 'Male', 'xiaozhan@gmail.com', '71672878', 'Year 1', 'Enrolling', 5, 1, '', 0.0),
('Fan', 'Wu', 'Yi', '1992-05-21', 'Male', 'kriswu@gmail.com', '92376743', 'Year 1', 'Enrolling', 5, 1, '', 0.0),
('Hun', 'Oh', 'Se', '1990-07-07', 'Male', 'ohsehun@gmail.com', '81387481','Year 1', 'Enrolling', 5, 1, '', 0.0),
('Kyo', 'Song', 'Hye', '1988-02-26', 'Female', 'songhyekyo@gmail.com', '81368434','Year 1', 'Enrolling', 5, 1, '', 0.0),
('Bonnie', 'Tan','meimei','1992-02-28','Female','bonnietan@gmail.com','98989898','Year 1','Enrolling',5,1,'',0.0),
('Wayne', 'Carlos','David','1997-03-13','Male','waynecarlos@gmail.com','91237878','Year 1','Enrolling',5,1,'',0.0),
('Micheal', 'Lim','maige','1993-01-01','Male','micheallim@gmail.com','81239828','Year 1','Enrolling',5,1,'',0.0),
('Susu', 'Su','','1994-11-17','Female','sususu@gmail.com','98989898','Year 1','Enrolling',5,1,'',0.0),
('Mara', 'Gupta','','1987-02-28','Female','maragupta@gmail.com','91234567','Year 1','Enrolling',5,1,'',0.0),
('Elsa', 'Lin','Ru','2000-07-27','Female','elsalin@gmail.com','92222222','Year 1','Enrolling',5,1,'',0.0),
('Will', 'Tan','DaMan','1988-04-28','Male','willtan@gmail.com','91111111','Year 1','Enrolling',5,1,'',0.0),
('Mary', 'Has','Alamb','1993-08-08','Female','maryhasalamv@gmail.com','93333333','Year 1','Enrolling',5,1,'',0.0),
('Liam', 'Pache','Bo','1982-06-09','Male','liampache@gmail.com','94444444','Year 1','Enrolling',5,1,'',0.0),
('Hane', 'Son','','1998-09-12','Male','hansolo@gmail.com','97772222','Year 1','Enrolling',5,1,'',0.0),
('Yeo', 'Hy','Deo','1998-09-12','Female','yeohydeoo@gmail.com','96788536','Year 1','Enrolling',5,1,'',0.0),
('Yang', 'Yang','','1998-09-12','Male','yangyang@gmail.com','95379327','Year 1','Enrolling',5,1,'',0.0),
('Ki', 'Song','Joong','1998-09-12','Male','songjoongki@gmail.com','90075423','Year 1','Enrolling',5,1,'',0.0),
('Ho', 'Lee','Min','1998-09-12','Female','leeminho@gmail.com','96478665','Year 2','Enrolling',4,1,'',0.0),
('Na', 'Yoon','','1998-09-12','Male','yoonna@gmail.com','97908657','Year 1','Enrolling',5,1,'',0.0),
('Re', 'Lee','Ho','1998-09-12','Female','leehore@gmail.com','97652146','Year 1','Enrolling',5,1,'',0.0),
('Shuang', 'Zheng','','1998-09-12','Male','zhengshuang@gmail.com','90987654','Year 2','Enrolling',4,1,'',0.0),
('Lee', 'Xiang','','1998-09-12','Male','leexiang@gmail.com','96789088','Year 1','Enrolling',5,1,'',0.0),
('Xi', 'Ming','','1998-09-12','Female','mingxi@gmail.com','90985578','Year 1','Enrolling',5,1,'',0.0),
('Liu', 'Wen','','1998-09-12','Female','liuwen@gmail.com','99865448','Year 1','Enrolling',5,1,'',0.0),
('Hye', 'Song','','1998-09-12','Male','songhye@gmail.com','90986545','Year 1','Enrolling',5,1,'',0.0),
('Kyo', 'Lee','Hye','1998-09-12','Male','leehyekyo@gmail.com','90875439','Year 1','Enrolling',5,1,'',0.0),
('Xie', 'Hang','','1998-09-12','Female','hangxie@gmail.com','90654346','Year 1','Enrolling',5,1,'',0.0),
('Ly', 'Kang','','1998-09-12','Male','kangly@gmail.com','95879997','Year 1','Enrolling',5,1,'',0.0),
('Han', 'Na','','1998-09-12','Female','hanna@gmail.com','908765568','Year 1','Enrolling',5,1,'',0.0);


insert into department(department_name) values('Institute of System Science'), ('School of computing'), ('Business school'), ('Faculty of Science');

insert into course(course_code, course_name, course_unit, department_id) values
('SA4101', 'Software Analysis and Design', 6, 1),
('SA4102', 'Enterprise Solution Design', 8, 1),
('SA4103', 'Software Engineering', 4, 1),
('SA4104', 'Mobile Application Development', 6, 1),
('SA4105', 'Web Application Development', 8, 1),
('BS4101', 'Business Analytics', 6, 2),
('CS4101', 'Machine learning', 8, 3),
('CS4102', 'Natural language processing', 6, 2),
('CS4103', 'Computer vision', 6, 2),
('CS4104', 'Advanced algorithm', 8, 2),
('CS4105', 'Human Computer Interaction', 6, 2),
('CS4106', 'Database infrastructure', 8, 2),
('CS4107', 'Discrete maths', 8, 2);

insert into student_course(course_id, semester_id, student_id, score, status) values
(1, 5, 1, 0.0, 'Approved'), (1, 5, 2, 0.0, 'Approved'), (1, 5, 3, 0.0, 'Approved'), (1, 5, 4, 0.0, 'Approved'),
(1, 5, 5, 0.0, 'Approved'), (1, 5, 6, 0.0, 'Approved'), (1, 5, 7, 0.0, 'Approved'),
(2, 5, 1, 0.0, 'Approved'), (2, 5, 2, 0.0, 'Pending'), (2, 5, 3, 0.0, 'Approved'), (2, 5, 4, 0.0, 'Approved'),
(2, 5, 5, 0.0, 'Approved'), (2, 5, 6, 0.0, 'Approved'), (2, 5, 7, 0.0, 'Approved'),
(3, 5, 1, 0.0, 'Approved'), (3, 5, 2, 0.0, 'Approved'), (3, 5, 3, 0.0, 'Approved'), (3, 5, 4, 0.0, 'Approved'),
(3, 5, 5, 0.0, 'Approved'), (3, 5, 6, 0.0, 'Approved'), (3, 5, 7, 0.0, 'Approved'),
(4, 5, 1, 0.0, 'Approved'), (4, 5, 2, 0.0, 'Approved'), (4, 5, 3, 0.0, 'Approved'), (4, 5, 4, 0.0, 'Approved'),
(4, 5, 5, 0.0, 'Approved'), (4, 5, 6, 0.0, 'Rejected'), (4, 5, 7, 0.0, 'Approved'),
(5, 5, 1, 0.0, 'Approved'), (5, 5, 2, 0.0, 'Approved'), (5, 5, 3, 0.0, 'Approved'), (5, 5, 4, 0.0, 'Approved'),
(5, 5, 6, 0.0, 'Approved'), (5, 5, 7, 0.0, 'Approved'),
(6, 5, 8, 0.0, 'Approved'), (6, 5, 9, 0.0, 'Approved'), (6, 5, 12, 0.0, 'Approved'), (6, 6, 7, 0.0, 'Approved'),
(7, 6, 9, 0.0, 'Pending'), (7, 6, 8, 0.0, 'Pending'), (7, 6, 13, 0.0, 'Pending'),
(8, 5, 10, 0.0, 'Approved'), (8, 5, 12, 0.0, 'Pending'), (8, 5, 11, 0.0, 'Approved'), (8, 6, 13, 0.0, 'Approved'),
(9, 6, 11, 0.0, 'Pending'), (3, 5, 11, 0.0, 'Approved'), (9, 6, 10, 0.0, 'Pending'),
(10, 5, 12, 0.0, 'Approved'), (10, 6, 13, 0.0, 'Approved'), (10, 5, 8, 0.0, 'Approved'), (10, 5, 7, 0.0, 'Approved'),
(11, 5, 13, 0.0, 'Approved'), (11, 5, 10, 0.0, 'Pending'), (11, 5, 11, 0.0, 'Approved'),
(12, 6, 8, 0.0, 'Pending'), (12, 5, 7, 0.0, 'Approved'), (12, 6, 13, 0.0, 'Pending'), (12, 5, 9, 0.0, 'Approved'),
(13, 5, 9, 0.0, 'Approved'), (13, 5, 10, 0.0, 'Rejected'), (13, 5, 11, 0.0, 'Approved'),
(6, 6, 10, 0.0, 'Pending'), (6, 5, 7, 0.0, 'Approved'), (6, 6, 9, 0.0, 'Pending'), (6, 5, 2, 0.0, 'Approved'),
(7, 6, 11, 0.0, 'Pending'), (7, 5, 6, 0.0, 'Approved'), (7, 6, 12, 0.0, 'Approved');

insert into lecturer(first_name, middle_name, last_name, gender, birth_date, email, mobile, department_id)
values('Esther', '', 'Tan', 'Female', '1982-07-12', 'esthertan@gmail.com', '89217764', 1),
('Kwan', 'Yuen', 'Chia', 'Male', '1962-07-12', 'chiayuenkwan@gmail.com', '89838764', 1),
('Wah', 'Cher', 'Tan', 'Male', '1982-03-12', 'tancherwah@gmail.com', '73678489', 1),
('Tin', 'Tri', 'Nguyen', 'Male', '1988-06-19', 'nguyentritin@gmail.com', '93277643', 1),
('Kee', 'Boon', 'Lee', 'Male', '1972-04-16', 'leeboonkee@gmail.com', '87485376', 1),
('Fecilitas', '', 'Seah', 'Female', '1972-04-23', 'felicitas@gmail.com', '32766747', 1),
('Andrew', '', 'Ng', 'Male', '1972-07-12', 'andrewng@gmail.com', '89986468', 2),
('Bill', '', 'Gates', 'Male', '1962-07-12', 'billgates@gmail.com', '89838764', 2),
('Mark', '', 'Zuckerberg', 'Male', '1982-03-12', 'mark@gmail.com', '73678489', 2),
('Sean', '', 'Smith', 'Male', '1988-06-19', 'sean@gmail.com', '93277643', 2),
('Tom', '', 'Cruise', 'Male', '1972-04-16', 'tomcruise@gmail.com', '87485376', 3),
('Justin', '', 'Bieber', 'Male', '1972-04-23', 'bieber@gmail.com', '32766747', 3);

insert into lecturer_course(course_id, lecturer_id, semester_id) values
(1, 1, 5), (1, 2, 5), (2, 2, 5), (2, 3, 5), (2, 4, 5), (3, 5, 5), (3, 6, 5), (4, 2, 5), (4, 3, 5), (5, 3, 5), (5, 4, 5),
(1, 2, 6), (1, 4, 6), (2, 3, 6), (2, 4, 6), (3, 1, 6), (3, 5, 6), (6, 12, 6), (6, 11, 6), (7, 7, 6), (7, 9, 6), (8, 9,6),
(8, 10,6), (9, 8, 6), (9, 10, 6), (10, 7, 6), (10, 10, 6), (11, 7, 6), (11, 9, 6), (12, 10, 6), (12, 8, 6), (13, 9, 6), (13, 7,6);

insert into lecturer_leave(lecturer_id, start_date, end_date, status) values
(1, '2019-12-23', '2020-01-02', 'Approved'),
(2, '2020-03-12', '2020-04-29', 'Pending'),
(3, '2020-01-12', '2020-01-29', 'Pending'),
(4, '2020-01-15', '2020-01-28', 'Pending'),
(5, '2020-01-14', '2020-01-22', 'Pending'),
(6, '2020-01-26', '2020-02-20', 'Pending'),
(7, '2020-01-11', '2020-01-22', 'Pending'),
(8, '2020-02-23', '2020-03-20', 'Pending'),
(9, '2020-01-11', '2020-02-12', 'Pending'),
(10, '2020-01-10', '2020-01-29', 'Pending'),
(11, '2020-02-06', '2020-03-29', 'Pending'),
(12, '2020-04-12', '2020-05-29', 'Pending'),
(1, '2020-02-01', '2020-03-29', 'Pending'),
(2, '2020-01-21', '2020-02-25', 'Pending'),
(3, '2020-02-02', '2020-03-29', 'Pending'),
(4, '2020-01-03', '2020-02-27', 'Pending'),
(5, '2020-01-04', '2020-01-25', 'Pending'),
(6, '2020-02-05', '2020-01-23', 'Pending'),
(7, '2020-06-12', '2020-07-12', 'Pending'),
(8, '2020-05-12', '2020-05-29', 'Pending'),
(9, '2020-03-12', '2020-04-29', 'Pending'),
(10, '2020-03-17', '2020-05-28', 'Pending'),
(11, '2020-03-12', '2020-05-29', 'Pending'),
(12, '2020-01-12', '2020-04-29', 'Pending'),
(2, '2020-03-01', '2020-06-29', 'Pending');

insert into admin(first_name, middle_name, last_name, gender, birth_date, email, mobile) values
('Lee', 'Chia', 'Tay', 'Female', '1990-12-01', 'taychialee@gmail.com', '98387643'),
('Megan', '', 'Wang', 'Female', '1986-11-12', 'meganwang@gmail.com', '98737646');

insert into admin_user(admin_id, username, password) values
(1, 'A0000001', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(2, 'A0000002', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS');


insert into lecturer_user(lecturer_id, username, password) values
(1, 'L0000001', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(2, 'L0000002', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(3, 'L0000003', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(4, 'L0000004', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(5, 'L0000005', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(6, 'L0000006', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(7, 'L0000007', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(8, 'L0000008', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(9, 'L0000009', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(10, 'L0000010', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(11, 'L0000011', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(12, 'L0000012', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS');


insert into student_user(student_id, username, password) values
(1, 'S0000001', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(2, 'S0000002', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(3, 'S0000003', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(4, 'S0000004', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(5, 'S0000005', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(6, 'S0000006', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(7, 'S0000007', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(8, 'S0000008', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(9, 'S0000009', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(10, 'S0000010', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(11, 'S0000011', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(12, 'S0000012', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(13, 'S0000013', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(14, 'S0000014', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(15, 'S0000015', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(16, 'S0000016', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(17, 'S0000017', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(18, 'S0000018', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(19, 'S0000019', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(20, 'S0000020', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(21, 'S0000021', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(22, 'S0000022', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(23, 'S0000023', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(24, 'S0000024', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(25, 'S0000025', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(26, 'S0000026', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(27, 'S0000027', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(28, 'S0000028', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(29, 'S0000029', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(30, 'S0000030', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(31, 'S0000031', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS'),
(32, 'S0000032', '$2y$12$MXISci0nld0o6UBqSef0wOg1j137w7aMpI0QSdKry5ybiWneqy9aS');



