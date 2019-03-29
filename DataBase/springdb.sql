
#alter table professor add foreign key (university_id) references university(id)
#ALTER TABLE professor DROP FOREIGN KEY professor_ibfk_1;
#alter table student add foreign key (subject_id) references subject(id)

 use springdb;
 /*
 alter table professor add foreign key (university_id) references university(id);
 alter table prof_subject add foreign key (professor_id) references professor(id);
 alter table prof_subject add foreign key (subject_id) references subject(id);
 alter table student add foreign key (subject_id) references subject(id);
 alter table mark add foreign key (subject_id) references subject(id);
 alter table mark add foreign key (student_id) references student(id);
*/

/*
 CREATE DATABASE springdb;
 use springdb;

create table university
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
  university_id int not null,
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
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (2,"Legal Department",44);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (3,"Public Relations",30);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (4,"Tech Support",38);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (5,"Sales and Marketing",40);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (6,"Media Relations",20);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (7,"Customer Service",50);
INSERT INTO `subject` (`id`,`name`,`number_hour`) VALUES (8,"Help Desk",55);


CREATE TABLE `student` (
  `id` int,
  `first_name` varchar(255) default NULL,
  `last_name` varchar(255) default NULL,
  `subject_id` int default NULL,
  PRIMARY KEY (`id`)
)engine = InnoDB;

INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (1,"Reese","Finley",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (2,"Preston","Osborne",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (3,"Theodore","Skinner",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (4,"Rooney","Duran",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (5,"Carl","Allison",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (6,"Fitzgerald","Vaughn",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (7,"Caleb","Harris",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (8,"Clinton","Serrano",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (9,"Sebastian","Whitley",4);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (10,"Kennan","Wynn",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (11,"Alfonso","Kinney",4);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (12,"Drew","Duran",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (13,"Damian","Williamson",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (14,"Leonard","Hudson",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (15,"Galvin","Mcconnell",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (16,"Acton","Wall",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (17,"Jermaine","Brady",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (18,"Kelly","Conley",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (19,"Mannix","Gonzales",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (20,"Brett","Pearson",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (21,"Samson","Weiss",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (22,"Stuart","Carey",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (23,"Laith","Clarke",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (24,"Salvador","Santos",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (25,"Aladdin","Mcclure",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (26,"Russell","Gonzales",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (27,"Fuller","Graves",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (28,"Melvin","Montoya",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (29,"Uriel","Hardin",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (30,"Gregory","Benton",7);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (31,"Kibo","Murphy",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (32,"Kermit","Wilder",7);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (33,"Peter","Leblanc",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (34,"Hamilton","Delacruz",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (35,"Lucian","Roy",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (36,"Len","Manning",4);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (37,"Harding","Sawyer",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (38,"Todd","Hughes",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (39,"Abdul","Willis",4);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (40,"Gabriel","Acosta",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (41,"Colorado","Hutchinson",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (42,"Andrew","Kent",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (43,"Dustin","Dominguez",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (44,"Kasimir","Nelson",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (45,"Fletcher","Webster",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (46,"Alvin","Wilkins",7);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (47,"Branden","Glass",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (48,"Magee","Horne",4);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (49,"Daquan","Baird",4);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (50,"Jonas","Gardner",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (51,"Alvin","Bonner",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (52,"Elmo","Cunningham",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (53,"Jesse","Leblanc",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (54,"Addison","Love",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (55,"Lamar","Adams",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (56,"Gabriel","Osborn",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (57,"Joel","Cross",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (58,"Justin","Rush",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (59,"Allen","Warren",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (60,"Owen","Richardson",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (61,"Xander","Andrews",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (62,"Adam","Reyes",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (63,"Gil","Dejesus",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (64,"Samson","Chase",7);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (65,"Conan","Mckay",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (66,"Jordan","Foreman",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (67,"George","Harvey",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (68,"Octavius","Atkinson",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (69,"Nicholas","Olson",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (70,"Andrew","Snyder",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (71,"Gabriel","Steele",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (72,"Abel","Boyd",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (73,"Garrison","Glass",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (74,"Allistair","Lynn",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (75,"Kibo","Long",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (76,"Odysseus","Velasquez",7);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (77,"Dieter","Wallace",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (78,"Stuart","White",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (79,"Cody","Hayden",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (80,"Deacon","Brennan",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (81,"Prescott","Barrera",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (82,"Keane","Hendricks",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (83,"Bevis","Santos",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (84,"Brennan","Knox",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (85,"Cain","Perry",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (86,"Brett","West",4);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (87,"Merritt","Schneider",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (88,"Brady","Lee",5);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (89,"Gannon","Yang",2);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (90,"Cade","Parks",7);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (91,"Alvin","Chan",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (92,"Zeus","Nixon",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (93,"Perry","Green",3);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (94,"Mason","Burks",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (95,"Rigel","Henry",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (96,"Merrill","Avery",6);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (97,"Kane","Buck",1);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (98,"Wing","Fisher",8);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (99,"Orlando","Tran",4);
INSERT INTO `student` (`id`,`first_name`,`last_name`,`subject_id`) VALUES (100,"Dennis","Lee",1);



CREATE TABLE `mark` (
  `id` int,
  `student_id` int default NULL,
  `subject_id` int default NULL,
  `value` int default NULL,
  PRIMARY KEY (`id`)
)engine = InnoDB;

INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (1,36,5,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (2,83,4,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (3,42,4,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (4,26,8,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (5,64,1,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (6,4,1,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (7,17,2,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (8,10,3,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (9,94,6,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (10,81,4,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (11,61,6,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (12,64,2,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (13,86,7,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (14,61,1,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (15,51,2,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (16,29,5,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (17,50,1,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (18,17,4,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (19,78,2,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (20,54,4,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (21,59,4,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (22,89,8,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (23,22,8,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (24,75,5,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (25,66,7,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (26,21,1,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (27,15,4,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (28,92,2,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (29,8,1,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (30,14,6,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (31,37,5,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (32,32,8,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (33,93,8,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (34,8,6,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (35,94,7,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (36,22,3,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (37,12,6,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (38,7,1,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (39,90,7,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (40,58,8,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (41,57,3,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (42,49,5,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (43,68,8,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (44,87,6,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (45,87,3,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (46,50,2,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (47,98,5,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (48,6,1,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (49,85,5,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (50,78,1,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (51,65,6,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (52,45,1,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (53,57,1,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (54,76,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (55,56,2,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (56,60,5,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (57,46,2,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (58,91,2,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (59,93,3,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (60,27,4,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (61,45,8,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (62,51,5,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (63,50,7,8);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (64,98,4,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (65,41,7,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (66,18,6,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (67,93,2,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (68,21,2,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (69,7,6,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (70,74,8,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (71,53,5,3);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (72,16,8,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (73,60,4,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (74,32,7,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (75,44,7,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (76,51,7,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (77,90,6,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (78,4,1,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (79,48,5,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (80,96,7,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (81,41,5,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (82,91,5,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (83,60,2,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (84,46,8,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (85,98,3,5);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (86,57,6,9);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (87,64,8,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (88,46,7,4);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (89,81,2,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (90,76,3,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (91,50,1,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (92,8,4,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (93,26,6,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (94,12,4,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (95,78,3,7);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (96,6,5,10);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (97,56,2,2);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (98,83,2,1);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (99,6,2,6);
INSERT INTO `mark` (`id`,`student_id`,`subject_id`,`value`) VALUES (100,21,2,4);




CREATE TABLE prof_subject (
  id int,
  professor_id int not null,
  subject_id int not null,
  PRIMARY KEY (`id`)
)engine = InnoDB;
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (1,8,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (2,3,8);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (3,20,7);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (4,18,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (5,1,6);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (6,7,5);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (7,24,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (8,28,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (9,20,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (10,6,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (11,19,7);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (12,21,8);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (13,11,6);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (14,9,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (15,21,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (16,7,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (17,6,8);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (18,3,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (19,10,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (20,9,7);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (21,14,1);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (22,17,2);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (23,24,8);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (24,27,7);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (25,27,4);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (26,12,5);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (27,20,3);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (28,22,8);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (29,18,5);
INSERT INTO `prof_subject` (`id`,`professor_id`,`subject_id`) VALUES (30,27,7);
*/