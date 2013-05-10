DROP TABLE IF EXISTS owners;
CREATE TABLE owners(
	id  smallint(100) not null auto_increment PRIMARY KEY,
	first_name VARCHAR(50) not null,
	last_name VARCHAR(50) not null,
	dni int(15),
	email varchar(40),
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city varchar(45) not null
);

drop table if exists real_estates;
create table real_estates(
	id smallint(100) not null auto_increment primary key,
	name varchar(40) not null,
	telephone integer(12) not null,
	email varchar(40),
	website varchar(60) not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city varchar(45) not null
);

drop table if exists buildings;
create table buildings(
	id smallint(100) not null auto_increment primary key,
	type enum('Land','Farm','House','Departament','Garage') not null,	
	owner_id smallint(100) not null references owners(id),
	description varchar(400),
	price float not null,
	status enum('Sell','Rent') not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city varchar(45) not null
);

drop table if exists owners_has_real_states;
create table owners_has_real_states(
	owner_dni int(15) references owners(dni),
	owner_id smallint(100) references owners(idOwner),
	real_states_id smallint(100) references real_states(idRE),
	RS_name varchar(40) references real_states(name)
);
