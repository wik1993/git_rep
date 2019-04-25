
/*
 CREATE DATABASE springdb;
 use springdb;

CREATE TABLE university
(
	id int not null auto_increment,
    name varchar(255),
    short_name varchar (255),
    primary key (id)
)engine = InnoDB;
INSERT INTO university (`id`, `name`, `short_name`) VALUES (1, "Academia de Studii Economice", "ASEM");
INSERT INTO university (`id`, `name`, `short_name`) VALUES (2, "Universitatea tehnica a Moldovei", "USM");



CREATE TABLE professor 
(
  id int not null auto_increment,
  first_name varchar(255),
  last_name varchar(255),
  university_id int,
  PRIMARY KEY (id)
)engine = InnoDB;

INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (1,"Avram","Mcpherson",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (2,"Gray","Delacruz",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (3,"Trevor","Silva",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (4,"Maxwell","Cote",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (5,"Gareth","Ortega",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (6,"Barry","William",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (7,"Eric","Barrera",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (8,"Alec","Hall",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (9,"Beau","Mccullough",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (10,"Jarrod","Vasquez",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (11,"Dexter","Gilmore",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (12,"Tobias","Cameron",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (13,"Alfonso","Byrd",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (14,"Jameson","Hoover",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (15,"Len","Obrien",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (16,"Kadeem","Santiago",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (17,"Clinton","Holden",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (18,"Xenos","Preston",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (19,"Keane","Nielsen",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (20,"Asher","Robbins",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (21,"Cain","Moreno",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (22,"Ali","Velasquez",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (23,"Carl","Murphy",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (24,"Raja","Williams",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (25,"Hayden","Olson",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (26,"Quinn","Griffin",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (27,"Abel","Mckinney",1);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (28,"Daquan","Patrick",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (29,"Giacomo","Rich",2);
INSERT INTO `professor` (`id`,`first_name`,`last_name`,`university_id`) VALUES (30,"Kenneth","Sexton",2);


CREATE TABLE `subject` (
  `id` int,
  `name` varchar(255) default NULL,
  `number_hour` int,
PRIMARY KEY (`id`)
)engine = InnoDB;
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (1,"Programing Languages",60);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (2,"Tech Support",38);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (3,"Customer Service",50);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (4,"Help Desk",55);


CREATE TABLE `student` (
   id int not null auto_increment,
  `first_name` varchar(255) default NULL,
  `last_name` varchar(255) default NULL,
  `subject_id` int default NULL,
  `responsible_email` varchar(255) default NULL,
  PRIMARY KEY (`id`)
)engine = InnoDB;


INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (1,"Ryder","Burnett",1,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (2,"Quinlan","Page",1,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (3,"Hall","Gibbs",3,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (4,"Lars","Frost",3,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (5,"Baker","Rodriguez",2,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (6,"Seth","Johnson",3,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (7,"Hasad","Knox",4,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (8,"Chandler","Vasquez",1,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (9,"Yasir","George",4,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (10,"Gray","Bowen",2,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (11,"Omar","Fleming",3,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (12,"Zeph","Maddox",2,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (13,"Abdul","Frank",4,"gligor.viktor@gmail.com");
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`,`responsible_email`) VALUES (14,"Peter","Lowery",3,"gligor.viktor@gmail.com");



CREATE TABLE `mark` (
  id int not null auto_increment,
  `student_id` int default NULL,
  `subject_id` int default NULL,
  `value` int default NULL,
  PRIMARY KEY (`id`)
)engine = InnoDB;

INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (1,8,4,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (2,7,3,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (3,4,1,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (4,6,1,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (5,1,1,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (6,9,3,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (7,7,1,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (8,9,3,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (9,11,1,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (10,2,4,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (11,3,4,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (12,4,1,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (13,5,2,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (14,12,4,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (15,1,4,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (16,8,1,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (17,7,2,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (18,4,4,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (19,5,4,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (20,7,4,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (21,8,2,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (22,1,2,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (23,3,3,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (24,9,2,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (25,5,3,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (26,11,4,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (27,9,4,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (28,4,1,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (29,11,1,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (30,5,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (31,10,2,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (32,8,3,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (33,7,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (34,14,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (35,11,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (36,6,2,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (37,1,4,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (38,1,2,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (39,5,4,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (40,1,3,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (41,2,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (42,10,4,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (43,5,3,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (44,10,4,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (45,12,3,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (46,8,4,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (47,13,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (48,1,4,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (49,6,1,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (50,6,4,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (51,5,3,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (52,9,3,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (53,2,2,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (54,3,3,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (55,11,3,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (56,9,2,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (57,5,1,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (58,8,1,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (59,11,2,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (60,9,3,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (61,11,3,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (62,12,2,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (63,1,2,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (64,3,2,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (65,3,4,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (66,3,1,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (67,6,3,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (68,5,4,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (69,2,2,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (70,9,1,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (71,4,3,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (72,6,1,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (73,11,3,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (74,14,4,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (75,13,1,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (76,10,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (77,2,4,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (78,14,4,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (79,9,4,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (80,1,1,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (81,12,3,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (82,1,1,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (83,12,4,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (84,12,2,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (85,2,3,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (86,4,3,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (87,2,3,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (88,13,2,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (89,2,2,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (90,11,1,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (91,1,2,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (92,9,1,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (93,14,2,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (94,4,2,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (95,5,2,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (96,1,4,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (97,8,4,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (98,1,3,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (99,8,3,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (100,10,4,6);




CREATE TABLE prof_subject (
  id int not null auto_increment,
  professor_id int not null,
  subject_id int not null,
  PRIMARY KEY (`id`)
)engine = InnoDB;

INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (1,21,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (2,6,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (3,1,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (4,21,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (5,17,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (6,4,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (7,5,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (8,25,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (9,1,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (10,4,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (11,19,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (12,25,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (13,3,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (14,24,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (15,1,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (16,3,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (17,28,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (18,16,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (19,18,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (20,22,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (21,26,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (22,13,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (23,8,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (24,13,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (25,25,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (26,17,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (27,12,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (28,17,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (29,22,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (30,21,4);
  
 
 alter table professor add foreign key (university_id) references university(id);
 alter table prof_subject add foreign key (professor_id) references professor(id);
 alter table prof_subject add foreign key (subject_id) references subject(id);
 alter table student add foreign key (subject_id) references subject(id);
 alter table mark add foreign key (subject_id) references subject(id);
 alter table mark add foreign key (student_id) references student(id);
*/
