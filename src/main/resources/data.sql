INSERT INTO subforum VALUES(1,'Dogs','Forum with topic: Dogs')
INSERT INTO subforum VALUES(2,'Cats','Forum with topic: Cats')
INSERT INTO subforum VALUES(3,'Birds','Forum with topic: Birds')
INSERT INTO subforum VALUES(4,'Fishes','Forum with topic: Fishes')
INSERT INTO threads VALUES(1,'Pepito','2018-11-02 14:51:52.69','Please help me! My dog have not eaten since yesterday morning!!',TRUE,'My dog is not eating!')
INSERT INTO threads VALUES(2,'Pepito','2018-11-02 14:53:03.14','Just writing to say thanks to everybody, timothy is now eating',TRUE,'My dog is now eating!')
INSERT INTO threads VALUES(3,'Pepito','2018-11-02 14:59:51.32','Hi, i am a troll',TRUE,'I am a crocodile')
INSERT INTO messages VALUES(1,'Hey! This is my first message, how are you all?','2018-11-02 14:59:51.32',1,'Pepito','2018-11-02 14:59:51.32')
INSERT INTO threads_messages VALUES(1,1)
INSERT INTO subforum_threads VALUES(1,1)
INSERT INTO subforum_threads VALUES(1,2)
INSERT INTO subforum_threads VALUES(2,3)

INSERT INTO profile VALUES(1,'1996-10-03','pepito.grillo@gmail.com','Pepito','Grillo')
INSERT INTO user VALUES(1,'$2a$11$cyTFJaiomsiUHRMdoClAguC4cQek1g/0SVS2DmqUkkwVw6wg4AEZG','user',1)



INSERT INTO roles VALUES(1,'ROLE_ADMIN')
INSERT INTO roles VALUES(2,'ROLE_USER')

INSERT INTO user_roles VALUES(1,1)
INSERT INTO user_roles VALUES(1,2)
