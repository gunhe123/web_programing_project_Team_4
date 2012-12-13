CREATE DATABASE web_game;

GRANT ALL ON web_game.* TO 'id001' IDENTIFIED BY 'pwd001';

use web_game;


CREATE TABLE users (
	id VARCHAR(30) PRIMARY KEY, 
	password VARCHAR(255) NOT NULL, 
	email VARCHAR(100) NOT NULL,
	flag boolean DEFAULT 1 NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE game_player (
	userid VARCHAR(30) PRIMARY KEY, 
	name VARCHAR(30) NOT NULL, 
	wish VARCHAR(360) NOT NULL,
	level int DEFAULT 1 NOT NULL,
	hp int DEFAULT 1 NOT NULL,
	mp int DEFAULT 1 NOT NULL,
	attack int DEFAULT 1 NOT NULL,
	deffence int DEFAULT 1 NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	location int DEFAULT 1 NOT NULL,
	valid_flag boolean DEFAULT 1 NOT NULL,
	avata int NOT NULL,
	armor int DEFAULT 0 NOT NULL,
	deffence int DEFAULT 0 NOT NULL

);


INSERT INTO users(id,password,email,flag) VALUES ('sososo', '1234567','tommy@gmail.com',1 );