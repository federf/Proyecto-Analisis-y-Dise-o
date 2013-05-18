DROP TABLE IF EXISTS owners;
CREATE TABLE owners(
	id smallint(100) not null auto_increment,
	first_name VARCHAR(50) not null,
	last_name VARCHAR(50) not null,
	dni int(15),
	email varchar(40),
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city int(11) not null references cities(postal_code),
	constraint pk_owners primary key (id)
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
	city int(11) not null references cities(postal_code),
	constraint pk_real_estates primary key (id)
);

drop table if exists buildings;
create table buildings(
	id smallint(100) not null auto_increment,
	type enum('Land','Farm','House','Departament','Garage') not null,	
	owner_id smallint(100) not null references owners(id),
	real_estate_id smallint(100) not null references real_estates(id),
	description varchar(400),
	price float not null,
	status enum('Sell','Rent') not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city int(11) not null references cities(postal_code),
	constraint pk_buildings primary key (id)
);

drop table if exists cities;
create table cities(
	postal_code int(11) not null primary key,
	name varchar(40) not null
);

drop table if exists owner_has_real_estates;
create table owner__has__real__estates(
	owner_id smallint(100),
	real_estate_id smallint(100),
	constraint fk_owner foreign key (owner_id) references owners(id),
	constraint fk_real_estate foreign key (real_estate_id) references real_estates(id)
);
