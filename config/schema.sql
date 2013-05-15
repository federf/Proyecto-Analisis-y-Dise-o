DROP TABLE IF EXISTS owners;
CREATE TABLE owners(
	id smallint(100) not null auto_increment,
	first_name VARCHAR(50) not null,
	last_name VARCHAR(50) not null,
	dni int(15),
	email varchar(40),
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city_id smallint(100) not null references cities(id),
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
	city_id smallint(100) not null references cities(id),
	constraint pk_real_estates primary key (id)
);

drop table if exists buildings;
create table buildings(
	id smallint(100) not null auto_increment,
	type enum('Land','Farm','House','Departament','Garage') not null,	
	owner_id smallint(100) not null references owners(id),
	real_estate_id smallint(40) not null references real_estates(id),
	description varchar(400),
	price float not null,
	status enum('Sell','Rent') not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
	city_id smallint(100) not null references cities(id),
	constraint pk_buildings primary key (id)
);

drop table if exists cities;
create table cities(
	id smallint(100) not null auto_increment primary key, 
	name varchar(100),
	postal_code smallint(100)
);

drop table if exists owners_has_real_estates;
create table owners_has_real_estates(
	owner_id smallint(100),
	real_estates_id smallint(100),
	constraint del_owner_id foreign key (owner_id) references owners(id) on delete cascade,
	constraint del_real_estates_id foreign key (real_estates_id) references real_estates(id) on delete cascade
);
