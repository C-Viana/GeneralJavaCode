-- Database: ecomtraining

-- DROP DATABASE IF EXISTS ecomtraining;

CREATE DATABASE ecomtraining
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

USE ecomtraining;

CREATE TABLE product(
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	brand VARCHAR(50),
	description VARCHAR(1000),
	quantity INTEGER NOT NULL DEFAULT 0,
	price REAL NOT NULL
);
