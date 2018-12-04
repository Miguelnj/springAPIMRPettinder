INSERT INTO subforum VALUES(1,'Forum with topic: Dogs','Dogs')
INSERT INTO subforum VALUES(2,'Forum with topic: Cats','Cats')
INSERT INTO subforum VALUES(3,'Forum with topic: Birds','Birds')
INSERT INTO subforum VALUES(4,'Forum with topic: Fishes','Fishes')
INSERT INTO subforum VALUES(5,'Forum with topic: pigs','Pigs')
INSERT INTO subforum VALUES(6,'Forum with topic: Exotics','Exotics')
INSERT INTO subforum VALUES(7,'Forum with topic: Horses','Horses')
INSERT INTO subforum VALUES(8,'Forum with topic: Guinean Pigs','Guinean Pigs')

INSERT INTO threads VALUES(1,'Pepito','2018-11-02 14:51:52.69','Please help me! My dog have not eaten since yesterday morning!!',TRUE,'My dog is not eating!')
INSERT INTO threads VALUES(2,'Juanito','2018-11-02 14:53:03.14','Just writing to say thanks to everybody, timothy is now eating',TRUE,'My dog is now eating!')
INSERT INTO threads VALUES(3,'Pepito','2018-11-02 14:59:51.32','Hi, i am a troll',TRUE,'I am a crocodile')
INSERT INTO threads VALUES(4,'Pepito','2018-11-02 14:51:52.69','Please help me! My dog have not eaten since yesterday morning!!',TRUE,'My dog is not eating!')
INSERT INTO threads VALUES(5,'Juanito','2018-11-02 14:53:03.14','Just writing to say thanks to everybody, timothy is now eating',TRUE,'My dog is now eating!')
INSERT INTO threads VALUES(6,'Pepito','2018-11-02 14:59:51.32','Hi, i am a troll',TRUE,'I am a crocodile')
INSERT INTO threads VALUES(7,'Pepito','2018-11-02 14:51:52.69','Please help me! My dog have not eaten since yesterday morning!!',TRUE,'My dog is not eating!')
INSERT INTO threads VALUES(8,'Juanito','2018-11-02 14:53:03.14','Just writing to say thanks to everybody, timothy is now eating',TRUE,'My dog is now eating!')
INSERT INTO threads VALUES(9,'Pepito','2018-11-02 14:59:51.32','Hi, i am a troll',TRUE,'I am a crocodile')

INSERT INTO subforum_threads VALUES(1,1)
INSERT INTO subforum_threads VALUES(1,2)
INSERT INTO subforum_threads VALUES(2,3)
INSERT INTO subforum_threads VALUES(3,4)
INSERT INTO subforum_threads VALUES(4,5)
INSERT INTO subforum_threads VALUES(5,6)
INSERT INTO subforum_threads VALUES(6,7)
INSERT INTO subforum_threads VALUES(7,8)
INSERT INTO subforum_threads VALUES(8,9)

INSERT INTO messages VALUES(1,'Hey! This is my first message, how are you all?','2018-11-02 14:59:51.32',1,'Pepito','2018-11-02 14:59:51.32')
INSERT INTO threads_messages VALUES(1,1)

INSERT INTO profile VALUES(1,'1996-10-03','pepito.grillo@gmail.com','Pepito','Grillo')
INSERT INTO user VALUES(1,'$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','Pedrito','admin',1)
INSERT INTO profile VALUES(2,'1996-10-03','pepito.grillo@gmail.com','Pepito','Grillo')
INSERT INTO user VALUES(2,'$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','Manolito','user',2)


INSERT INTO profile (id, name, surname, date, email) VALUES (3,'Veterinario3','Apellido de Veterinario3','1996-10-03','vet3.grillo@gmail.com')
INSERT INTO vet (id, username, password, available, profile_id) VALUES (1,'vet3','$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','true',3)
INSERT INTO profile (id, name, surname, date, email) VALUES (4,'Veterinario4','Apellido de Veterinario4','1996-10-03','vet4.grillo@gmail.com')
INSERT INTO vet (id, username, password, available, profile_id) VALUES (2,'vet4','$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','true',4)
INSERT INTO profile (id, name, surname, date, email) VALUES (5,'Veterinario5','Apellido de Veterinario5','1996-10-03','vet5.grillo@gmail.com')
INSERT INTO vet (id, username, password, available, profile_id) VALUES (3,'vet5','$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','false',5)
INSERT INTO profile (id, name, surname, date, email) VALUES (6,'Veterinario6','Apellido de Veterinario6','1996-10-03','vet6.grillo@gmail.com')
INSERT INTO vet (id, username, password, available, profile_id) VALUES (4,'vet6','$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','true',6)
INSERT INTO profile (id, name, surname, date, email) VALUES (7,'Veterinario7','Apellido de Veterinario7','1996-10-03','vet7.grillo@gmail.com')
INSERT INTO vet (id, username, password, available, profile_id) VALUES (5,'vet7','$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','false',7)
INSERT INTO profile (id, name, surname, date, email) VALUES (8,'Veterinario8','Apellido de Veterinario8','1996-10-03','vet8.grillo@gmail.com')
INSERT INTO vet (id, username, password, available, profile_id) VALUES (6,'vet8','$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','true',8)


INSERT INTO roles VALUES(1,'ROLE_ADMIN')
INSERT INTO roles VALUES(2,'ROLE_USER')

INSERT INTO user_roles VALUES(1,1)
INSERT INTO user_roles VALUES(2,2)


