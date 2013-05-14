DROP TABLE IF EXISTS owners;
CREATE TABLE owners(
	id  smallint(100) not null auto_increment,
	first_name VARCHAR(50) not null,
	last_name VARCHAR(50) not null,
	dni int(15),
	email varchar(40),
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city varchar(45) not null,
	buildings_id smallint(100) references buildings(idBuildings),	
	constraint primary_key_owners primary key (id, dni)
);

drop table if exists real_estates;
create table real_estates(
	id smallint(100) not null auto_increment,
	name varchar(40) not null,
	telephone integer(12) not null,
	email varchar(40),
	website varchar(60) not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city varchar(45) not null,
	buildings_id smallint(100) references buildings(idBuildings), 
	constraint primary_key_real_estates primary key (id)
);

drop table if exists buildings;
create table buildings(
	id smallint(100) not null auto_increment,
	type enum('Land','Farm','House','Departament','Garage') not null,	
	description varchar(400),
	price float not null,
	status enum('Sell','Rent') not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city varchar(45) not null,
	constraint primary_buildings primary key (id)
);

drop table if exists owners_has_real_states;
create table owners_has_real_states(
	owner_id smallint(100) references owners(idOwner),
	real_estates_id smallint(100) references real_states(idReal_estates),
	constraint primary_owners_has_real_states primary key (owner_id, real_estates_id)
);
