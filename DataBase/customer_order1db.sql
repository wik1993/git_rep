use customers_order1sDb;
 alter table order1 add foreign key (customer_id) references customer(id);
/*
CREATE DATABASE customers_order1sDb;
 use customers_order1sDb;
 
CREATE TABLE customer (
  id int  NOT NULL auto_increment,
  name varchar(255) NOT NULL ,
  email varchar(255)  ,
  PRIMARY KEY (id)
)engine = InnoDB;

INSERT INTO customer (name,email) VALUES ("Leo Patterson","primis.in.faucibus@In.com");
INSERT INTO customer (name,email) VALUES ("Alan Gilmore","vulputate@acfeugiat.edu");
INSERT INTO customer (name,email) VALUES ("Bevis Cochran","Cras.vulputate.velit@loremDonec.edu");
INSERT INTO customer (name,email) VALUES ("Benjamin Madden","odio.Phasellus@etcommodoat.ca");
INSERT INTO customer (name,email) VALUES ("Marshall Cochran","magnis.dis.parturient@DonecestNunc.ca");
INSERT INTO customer (name,email) VALUES ("Gabriel Snider","eget.ipsum.Donec@eu.com");
INSERT INTO customer (name,email) VALUES ("Macon Wise","senectus.et@eudoloregestas.net");
INSERT INTO customer (name,email) VALUES ("Yuli Glass","Nullam.lobortis.quam@semperegestasurna.net");
INSERT INTO customer (name,email) VALUES ("Nash Washington","iaculis.odio@Pellentesqueultriciesdignissim.co.uk");
INSERT INTO customer (name,email) VALUES ("Byron Phillips","neque.tellus@liberoest.net");
INSERT INTO customer (name,email) VALUES ("Darius Davenport","arcu.vel.quam@orciquislectus.ca");
INSERT INTO customer (name,email) VALUES ("Hayden Myers","amet.nulla@atvelitPellentesque.org");
INSERT INTO customer (name,email) VALUES ("Marshall Howard","iaculis.enim@Cras.com");
INSERT INTO customer (name,email) VALUES ("Nash Hebert","elit@Maurisnondui.edu");
INSERT INTO customer (name,email) VALUES ("Jermaine Bradley","amet@sitametrisus.co.uk");
INSERT INTO customer (name,email) VALUES ("Walter Robles","ut@lobortismaurisSuspendisse.edu");
INSERT INTO customer (name,email) VALUES ("Isaac Holloway","nisl@Curabitur.co.uk");
INSERT INTO customer (name,email) VALUES ("Jackson Phelps","mollis.dui@Pellentesqueutipsum.net");
INSERT INTO customer (name,email) VALUES ("Seth Marquez","velit.justo.nec@elitAliquam.edu");
INSERT INTO customer (name,email) VALUES ("Xavier Chase","velit@sedpedeCum.edu");
INSERT INTO customer (name,email) VALUES ("Tanek Hernandez","metus.In@tortordictum.org");
INSERT INTO customer (name,email) VALUES ("Dominic Mullins","sit.amet.metus@quamPellentesquehabitant.ca");
INSERT INTO customer (name,email) VALUES ("Jonah Bright","Morbi.neque@InfaucibusMorbi.com");
INSERT INTO customer (name,email) VALUES ("Holmes Cash","Integer.vulputate@dolor.org");
INSERT INTO customer (name,email) VALUES ("Orlando Morrow","scelerisque.neque.sed@magna.edu");
INSERT INTO customer (name,email) VALUES ("Arden Alston","Suspendisse.eleifend@eueleifend.ca");
INSERT INTO customer (name,email) VALUES ("Hakeem Sexton","sociis.natoque.penatibus@purus.com");
INSERT INTO customer (name,email) VALUES ("Darius Hays","dictum.cursus.Nunc@molestieSed.net");
INSERT INTO customer (name,email) VALUES ("Lyle Knowles","justo.sit.amet@eueuismod.org");
INSERT INTO customer (name,email) VALUES ("Amery Bryant","fermentum@elit.org");
INSERT INTO customer (name,email) VALUES ("Abel Mcmillan","senectus.et.netus@purus.org");
INSERT INTO customer (name,email) VALUES ("Ezekiel Blankenship","accumsan@elementumpurusaccumsan.net");
INSERT INTO customer (name,email) VALUES ("Norman Giles","sit.amet@DonecestNunc.com");
INSERT INTO customer (name,email) VALUES ("Erasmus Mann","felis@dui.net");
INSERT INTO customer (name,email) VALUES ("Gil Morris","erat.Vivamus.nisi@Sed.ca");
INSERT INTO customer (name,email) VALUES ("Paki Chase","elit@natoquepenatibus.org");
INSERT INTO customer (name,email) VALUES ("Kaseem Ford","Morbi@Duisrisus.org");
INSERT INTO customer (name,email) VALUES ("Ray Burgess","Lorem.ipsum.dolor@duiFusce.edu");
INSERT INTO customer (name,email) VALUES ("Walker Wynn","tristique.neque@sodalesMauris.net");
INSERT INTO customer (name,email) VALUES ("Walker Sanford","Morbi.metus@enimCurabiturmassa.edu");
INSERT INTO customer (name,email) VALUES ("Kasimir Hanson","elit@egetlaoreetposuere.org");
INSERT INTO customer (name,email) VALUES ("Barclay Peters","magnis.dis.parturient@atarcuVestibulum.com");
INSERT INTO customer (name,email) VALUES ("Omar Hurst","volutpat@ridiculusmus.co.uk");
INSERT INTO customer (name,email) VALUES ("Mufutau Ewing","non.nisi.Aenean@neque.net");
INSERT INTO customer (name,email) VALUES ("Driscoll Cunningham","a.sollicitudin@consequatdolor.org");
INSERT INTO customer (name,email) VALUES ("Joshua Hudson","imperdiet.erat.nonummy@necluctus.co.uk");
INSERT INTO customer (name,email) VALUES ("Garrison Foreman","Donec.egestas@risusNullaeget.net");
INSERT INTO customer (name,email) VALUES ("Lawrence Vasquez","Phasellus.elit.pede@convallis.com");
INSERT INTO customer (name,email) VALUES ("Paki Maynard","at.arcu@congueIn.com");
INSERT INTO customer (name,email) VALUES ("Xander Banks","congue@faucibusMorbivehicula.net");
INSERT INTO customer (name,email) VALUES ("Ignatius Melendez","accumsan.interdum.libero@Mauris.org");
INSERT INTO customer (name,email) VALUES ("Hayes Morgan","nunc@felis.org");
INSERT INTO customer (name,email) VALUES ("Julian Montoya","blandit.enim.consequat@nequevenenatis.edu");
INSERT INTO customer (name,email) VALUES ("Dean Neal","diam.at.pretium@inceptos.ca");
INSERT INTO customer (name,email) VALUES ("Kieran Mcpherson","erat.vel.pede@Aeneansed.edu");
INSERT INTO customer (name,email) VALUES ("Holmes Bird","Etiam@lacusNullatincidunt.net");
INSERT INTO customer (name,email) VALUES ("Demetrius Garza","tempus.mauris@mauris.co.uk");
INSERT INTO customer (name,email) VALUES ("Dustin Sweeney","lacus.Mauris@Vivamus.com");
INSERT INTO customer (name,email) VALUES ("Bernard Glover","Quisque.fringilla@diamvelarcu.org");
INSERT INTO customer (name,email) VALUES ("Kareem Williams","sed.dui@lacus.co.uk");
INSERT INTO customer (name,email) VALUES ("Jin Conrad","cursus@loremac.com");
INSERT INTO customer (name,email) VALUES ("Sawyer Shepherd","Maecenas@adipiscingenim.edu");
INSERT INTO customer (name,email) VALUES ("Felix Wilder","tempor.diam@nibhAliquamornare.co.uk");
INSERT INTO customer (name,email) VALUES ("Yuli Fulton","Donec.egestas.Aliquam@nibhlacinia.edu");
INSERT INTO customer (name,email) VALUES ("Arsenio Barnett","ligula.consectetuer@sollicitudinorci.ca");
INSERT INTO customer (name,email) VALUES ("Jackson Byers","ante.dictum.mi@dolorNulla.ca");
INSERT INTO customer (name,email) VALUES ("Josiah Kim","eu.accumsan@fermentumrisus.com");
INSERT INTO customer (name,email) VALUES ("Deacon Juarez","neque.tellus.imperdiet@adipiscingfringillaporttitor.ca");
INSERT INTO customer (name,email) VALUES ("Aquila Robinson","sit@arcu.org");
INSERT INTO customer (name,email) VALUES ("Hu Bullock","adipiscing.Mauris.molestie@atiaculis.edu");
INSERT INTO customer (name,email) VALUES ("Henry Bentley","Donec.consectetuer@semper.com");
INSERT INTO customer (name,email) VALUES ("Henry Salinas","nascetur.ridiculus.mus@maurisSuspendisse.net");
INSERT INTO customer (name,email) VALUES ("Clayton Huff","aliquam.eu@purus.co.uk");
INSERT INTO customer (name,email) VALUES ("Magee Powell","lacus@ultricesposuere.org");
INSERT INTO customer (name,email) VALUES ("Ahmed Oneil","eget@nisidictum.org");
INSERT INTO customer (name,email) VALUES ("Kane Cook","orci.Ut.semper@a.ca");
INSERT INTO customer (name,email) VALUES ("Odysseus Sanford","Quisque@lacusQuisque.ca");
INSERT INTO customer (name,email) VALUES ("Timon Madden","ridiculus@tellus.co.uk");
INSERT INTO customer (name,email) VALUES ("Hayes Barrera","quis.massa.Mauris@laoreetlectusquis.com");
INSERT INTO customer (name,email) VALUES ("Gray Beck","imperdiet.dictum.magna@nullaatsem.ca");
INSERT INTO customer (name,email) VALUES ("Lyle Vinson","a.facilisis@scelerisque.net");
INSERT INTO customer (name,email) VALUES ("Thomas Lynch","mattis.Cras@quamPellentesque.edu");
INSERT INTO customer (name,email) VALUES ("Myles Francis","dictum.augue@nislMaecenas.co.uk");
INSERT INTO customer (name,email) VALUES ("James Daniels","consectetuer.euismod.est@ipsumdolorsit.org");
INSERT INTO customer (name,email) VALUES ("Adam Johns","libero.mauris@ut.co.uk");
INSERT INTO customer (name,email) VALUES ("Uriel Little","eget.magna@auctor.com");
INSERT INTO customer (name,email) VALUES ("Abel Dickerson","Sed.et@odiosempercursus.co.uk");
INSERT INTO customer (name,email) VALUES ("Raja Moody","Nulla.facilisi.Sed@sit.edu");
INSERT INTO customer (name,email) VALUES ("Yardley Vasquez","fringilla.Donec@Proinultrices.org");
INSERT INTO customer (name,email) VALUES ("Timothy Delaney","nibh@aliquam.com");
INSERT INTO customer (name,email) VALUES ("Demetrius Ball","mauris.rhoncus@eu.co.uk");
INSERT INTO customer (name,email) VALUES ("Colby Kramer","mauris@musProinvel.com");
INSERT INTO customer (name,email) VALUES ("Benedict Sullivan","purus@lobortisquama.com");
INSERT INTO customer (name,email) VALUES ("Zephania Goodwin","velit@Nunclaoreetlectus.net");
INSERT INTO customer (name,email) VALUES ("Michael Leblanc","vel.est.tempor@odioAliquamvulputate.edu");
INSERT INTO customer (name,email) VALUES ("Elijah Saunders","erat.eget@feugiatLoremipsum.net");
INSERT INTO customer (name,email) VALUES ("Roth Torres","adipiscing@Duismi.org");
INSERT INTO customer (name,email) VALUES ("Carter Morgan","sagittis.placerat.Cras@egetvariusultrices.co.uk");
INSERT INTO customer (name,email) VALUES ("Nehru Jarvis","vestibulum.nec.euismod@eueratsemper.edu");
INSERT INTO customer (name,email) VALUES ("Wylie Short","senectus.et@arcu.edu");

CREATE TABLE order1 (
  id int NOT NULL auto_increment,
  price int NOT NULL,
  created_date varchar(255),
  customer_id int,
  PRIMARY KEY (id)
)engine = InnoDB;

INSERT INTO order1 (price,created_date,customer_id) VALUES (32,"25/05/2018",1);
INSERT INTO order1 (price,created_date,customer_id) VALUES (92,"04/11/2018",2);
INSERT INTO order1 (price,created_date,customer_id) VALUES (93,"03/08/2018",3);
INSERT INTO order1 (price,created_date,customer_id) VALUES (66,"03/01/2019",4);
INSERT INTO order1 (price,created_date,customer_id) VALUES (40,"26/04/2018",5);
INSERT INTO order1 (price,created_date,customer_id) VALUES (46,"26/02/2019",6);
INSERT INTO order1 (price,created_date,customer_id) VALUES (71,"20/11/2018",7);
INSERT INTO order1 (price,created_date,customer_id) VALUES (19,"29/06/2018",8);
INSERT INTO order1 (price,created_date,customer_id) VALUES (20,"08/07/2018",9);
INSERT INTO order1 (price,created_date,customer_id) VALUES (60,"03/08/2018",10);
INSERT INTO order1 (price,created_date,customer_id) VALUES (91,"03/12/2018",11);
INSERT INTO order1 (price,created_date,customer_id) VALUES (6,"26/04/2018",12);
INSERT INTO order1 (price,created_date,customer_id) VALUES (11,"20/03/2019",13);
INSERT INTO order1 (price,created_date,customer_id) VALUES (83,"29/06/2018",14);
INSERT INTO order1 (price,created_date,customer_id) VALUES (14,"16/10/2018",15);
INSERT INTO order1 (price,created_date,customer_id) VALUES (84,"23/09/2018",16);
INSERT INTO order1 (price,created_date,customer_id) VALUES (34,"26/08/2018",17);
INSERT INTO order1 (price,created_date,customer_id) VALUES (94,"09/06/2018",18);
INSERT INTO order1 (price,created_date,customer_id) VALUES (54,"28/03/2019",19);
INSERT INTO order1 (price,created_date,customer_id) VALUES (27,"09/02/2019",20);
INSERT INTO order1 (price,created_date,customer_id) VALUES (75,"06/05/2018",21);
INSERT INTO order1 (price,created_date,customer_id) VALUES (52,"10/07/2018",22);
INSERT INTO order1 (price,created_date,customer_id) VALUES (80,"10/11/2018",23);
INSERT INTO order1 (price,created_date,customer_id) VALUES (51,"28/03/2019",24);
INSERT INTO order1 (price,created_date,customer_id) VALUES (90,"20/05/2018",25);
INSERT INTO order1 (price,created_date,customer_id) VALUES (71,"06/05/2018",26);
INSERT INTO order1 (price,created_date,customer_id) VALUES (96,"23/11/2018",27);
INSERT INTO order1 (price,created_date,customer_id) VALUES (3,"12/04/2018",28);
INSERT INTO order1 (price,created_date,customer_id) VALUES (39,"20/10/2018",29);
INSERT INTO order1 (price,created_date,customer_id) VALUES (93,"04/06/2018",30);
INSERT INTO order1 (price,created_date,customer_id) VALUES (65,"25/07/2018",31);
INSERT INTO order1 (price,created_date,customer_id) VALUES (68,"08/12/2018",32);
INSERT INTO order1 (price,created_date,customer_id) VALUES (4,"03/08/2018",33);
INSERT INTO order1 (price,created_date,customer_id) VALUES (12,"10/05/2018",34);
INSERT INTO order1 (price,created_date,customer_id) VALUES (89,"20/03/2019",35);
INSERT INTO order1 (price,created_date,customer_id) VALUES (87,"05/05/2018",36);
INSERT INTO order1 (price,created_date,customer_id) VALUES (3,"17/08/2018",37);
INSERT INTO order1 (price,created_date,customer_id) VALUES (90,"18/12/2018",38);
INSERT INTO order1 (price,created_date,customer_id) VALUES (65,"08/11/2018",39);
INSERT INTO order1 (price,created_date,customer_id) VALUES (8,"05/04/2019",40);
INSERT INTO order1 (price,created_date,customer_id) VALUES (26,"18/04/2018",41);
INSERT INTO order1 (price,created_date,customer_id) VALUES (9,"01/10/2018",42);
INSERT INTO order1 (price,created_date,customer_id) VALUES (51,"08/03/2019",43);
INSERT INTO order1 (price,created_date,customer_id) VALUES (89,"30/12/2018",44);
INSERT INTO order1 (price,created_date,customer_id) VALUES (81,"04/05/2018",45);
INSERT INTO order1 (price,created_date,customer_id) VALUES (36,"12/12/2018",46);
INSERT INTO order1 (price,created_date,customer_id) VALUES (32,"15/01/2019",47);
INSERT INTO order1 (price,created_date,customer_id) VALUES (70,"16/12/2018",48);
INSERT INTO order1 (price,created_date,customer_id) VALUES (96,"03/01/2019",49);
INSERT INTO order1 (price,created_date,customer_id) VALUES (67,"03/02/2019",50);
INSERT INTO order1 (price,created_date,customer_id) VALUES (77,"26/03/2019",51);
INSERT INTO order1 (price,created_date,customer_id) VALUES (41,"03/01/2019",52);
INSERT INTO order1 (price,created_date,customer_id) VALUES (47,"12/03/2019",53);
INSERT INTO order1 (price,created_date,customer_id) VALUES (65,"07/04/2018",54);
INSERT INTO order1 (price,created_date,customer_id) VALUES (65,"07/11/2018",55);
INSERT INTO order1 (price,created_date,customer_id) VALUES (27,"23/11/2018",56);
INSERT INTO order1 (price,created_date,customer_id) VALUES (67,"13/12/2018",57);
INSERT INTO order1 (price,created_date,customer_id) VALUES (22,"28/10/2018",58);
INSERT INTO order1 (price,created_date,customer_id) VALUES (82,"31/05/2018",59);
INSERT INTO order1 (price,created_date,customer_id) VALUES (68,"01/12/2018",60);
INSERT INTO order1 (price,created_date,customer_id) VALUES (22,"15/04/2018",61);
INSERT INTO order1 (price,created_date,customer_id) VALUES (67,"06/08/2018",62);
INSERT INTO order1 (price,created_date,customer_id) VALUES (75,"04/05/2018",63);
INSERT INTO order1 (price,created_date,customer_id) VALUES (62,"14/12/2018",64);
INSERT INTO order1 (price,created_date,customer_id) VALUES (59,"05/06/2018",65);
INSERT INTO order1 (price,created_date,customer_id) VALUES (16,"11/02/2019",66);
INSERT INTO order1 (price,created_date,customer_id) VALUES (43,"13/11/2018",67);
INSERT INTO order1 (price,created_date,customer_id) VALUES (10,"13/06/2018",68);
INSERT INTO order1 (price,created_date,customer_id) VALUES (98,"27/09/2018",69);
INSERT INTO order1 (price,created_date,customer_id) VALUES (19,"08/10/2018",70);
INSERT INTO order1 (price,created_date,customer_id) VALUES (9,"06/06/2018",71);
INSERT INTO order1 (price,created_date,customer_id) VALUES (37,"30/03/2019",72);
INSERT INTO order1 (price,created_date,customer_id) VALUES (12,"01/08/2018",73);
INSERT INTO order1 (price,created_date,customer_id) VALUES (62,"28/11/2018",74);
INSERT INTO order1 (price,created_date,customer_id) VALUES (34,"17/05/2018",75);
INSERT INTO order1 (price,created_date,customer_id) VALUES (62,"26/06/2018",76);
INSERT INTO order1 (price,created_date,customer_id) VALUES (34,"25/04/2018",77);
INSERT INTO order1 (price,created_date,customer_id) VALUES (91,"30/01/2019",78);
INSERT INTO order1 (price,created_date,customer_id) VALUES (60,"15/04/2018",79);
INSERT INTO order1 (price,created_date,customer_id) VALUES (53,"05/11/2018",80);
INSERT INTO order1 (price,created_date,customer_id) VALUES (57,"27/01/2019",81);
INSERT INTO order1 (price,created_date,customer_id) VALUES (9,"01/05/2018",82);
INSERT INTO order1 (price,created_date,customer_id) VALUES (38,"20/02/2019",83);
INSERT INTO order1 (price,created_date,customer_id) VALUES (13,"15/05/2018",84);
INSERT INTO order1 (price,created_date,customer_id) VALUES (83,"17/12/2018",85);
INSERT INTO order1 (price,created_date,customer_id) VALUES (41,"07/09/2018",86);
INSERT INTO order1 (price,created_date,customer_id) VALUES (82,"02/01/2019",87);
INSERT INTO order1 (price,created_date,customer_id) VALUES (66,"24/12/2018",88);
INSERT INTO order1 (price,created_date,customer_id) VALUES (26,"26/05/2018",89);
INSERT INTO order1 (price,created_date,customer_id) VALUES (69,"01/05/2018",90);
INSERT INTO order1 (price,created_date,customer_id) VALUES (40,"24/07/2018",91);
INSERT INTO order1 (price,created_date,customer_id) VALUES (65,"09/10/2018",92);
INSERT INTO order1 (price,created_date,customer_id) VALUES (37,"01/11/2018",93);
INSERT INTO order1 (price,created_date,customer_id) VALUES (74,"14/11/2018",94);
INSERT INTO order1 (price,created_date,customer_id) VALUES (11,"26/09/2018",95);
INSERT INTO order1 (price,created_date,customer_id) VALUES (47,"19/06/2018",96);
INSERT INTO order1 (price,created_date,customer_id) VALUES (80,"03/02/2019",97);
INSERT INTO order1 (price,created_date,customer_id) VALUES (38,"11/12/2018",98);
INSERT INTO order1 (price,created_date,customer_id) VALUES (12,"10/07/2018",99);
INSERT INTO order1 (price,created_date,customer_id) VALUES (56,"30/01/2019",100);
*/
