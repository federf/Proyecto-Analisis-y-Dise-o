DROP TABLE IF EXISTS owners;
CREATE TABLE owners(
	id integer(100) not null auto_increment,
	first_name VARCHAR(50) not null,
	last_name VARCHAR(50) not null,
	dni int(15),
	email varchar(40),
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city_id int(11) not null references citys(id),
	constraint pk_owners primary key (id)
);

drop table if exists real_estates;
create table real_estates(
	id integer(100) not null auto_increment,
	name varchar(40) not null,
	telephone integer(12) not null,
	email varchar(40),
	website varchar(60) not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city_id int(11) not null references citys(id),
	constraint pk_real_estates primary key (id)
);

drop table if exists buildings;
create table buildings(
	id integer(100) not null auto_increment,
	type enum('Land','Farm','House','Departament','Garage') not null,	
	owner_id integer(100) not null references owners(id),
	real_estate_id integer(100) not null references real_estates(id),
	description varchar(400),
	price float not null,
	status enum('Sell','Rent') not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city_id int(11) not null references citys(id),
	constraint pk_buildings primary key (id)
);

drop table if exists citys;
create table citys(
	id int(11) not null auto_increment,
	postal_code integer(10) not null,	
	name varchar(40) not null,
	constraint pk_city primary key (id)
);

drop table if exists owners_real_estates;
create table owners_real_estates(
	id integer(11) not null auto_increment,
	owner_id integer(100) not null,
	real_estate_id integer(100) not null,
	constraint pk_ore_id primary key (id),
	constraint fk_owner foreign key (owner_id) references owners(id),
	constraint fk_real_estate foreign key (real_estate_id) references real_estates(id)
);
