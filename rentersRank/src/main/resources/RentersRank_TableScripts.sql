DROP SCHEMA IF EXISTS renters_rank_db;

CREATE SCHEMA renters_rank_db;
USE renters_rank_db;

CREATE TABLE apartment (
	apartment_id INT PRIMARY KEY,
	address VARCHAR(50) NOT NULL,
	occupied_from DATE,
	occupied_to DATE,
	rent INT,
	score INT NOT NULL,
	status BIT NOT NULL
);

CREATE TABLE Landlord (
	landlord_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	email_id VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Renter (
	renter_id INT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	email_id VARCHAR(100) NOT NULL UNIQUE,
	moveIn_date DATE NOT NULL,
	moveOut_date DATE NOT NULL
);

CREATE TABLE User (
	username VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL,
	role VARCHAR(50) NOT NULL
);

INSERT INTO LandLord (landLord_id, name, email_id) VALUES(100, "Frajer", "frajer@gmail.com");

INSERT INTO apartment (apartment_id, address, occupied_from, occupied_to, rent, score, status) VALUES (1000, "BP Street", "2022-12-01", "2023-12-01", 2500, 3, 0);
