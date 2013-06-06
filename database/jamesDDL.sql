<<<<<<< HEAD
connect 'jdbc:derby://localhost:1527/james_db;create=true;user=james;password=james';

create table "JAMES".ID_GEN(GEN_NAME VARCHAR(50) not null primary key,GEN_VAL NUMERIC(5) not null);
create table "JAMES".ANSWER(ID NUMERIC(5) not null primary key, ANSWERTEXT VARCHAR(255) not null, QUESTIONID VARCHAR(255) not null);
create table "JAMES".QUESTION(ID VARCHAR(255) not null primary key,	QUESTIONTEXT VARCHAR(255));

insert into "JAMES".QUESTION values ('q1', 'Your favorite app?');
insert into "JAMES".QUESTION values ('q2', 'Your favorite colour?');
=======
connect 'jdbc:derby://localhost:1527/james_db;create=true;user=james;password=james';

create table "JAMES".ID_GEN(GEN_NAME VARCHAR(50) not null primary key,GEN_VAL NUMERIC(5) not null);
create table "JAMES".ANSWER(ID NUMERIC(5) not null primary key, ANSWERTEXT VARCHAR(255) not null, QUESTIONID VARCHAR(255) not null);
create table "JAMES".QUESTION(ID VARCHAR(255) not null primary key,	QUESTIONTEXT VARCHAR(255));

insert into "JAMES".QUESTION values ('q1', 'Your favorite app?');
insert into "JAMES".QUESTION values ('q2', 'Your favorite colour?');
>>>>>>> d20b4e0f4b0cc05feeb338eeff9e1fc37a8b5065
insert into "JAMES".QUESTION values ('q3', 'Your favorite dish?');