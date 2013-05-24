DROP TABLE IF EXISTS owners;
CREATE TABLE owners(
<<<<<<< HEAD
	id integer(100) not null auto_increment,
=======
	id smallint(100) not null auto_increment,
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
	first_name VARCHAR(50) not null,
	last_name VARCHAR(50) not null,
	dni int(15),
	email varchar(40),
	street varchar(45) not null,
	neighborhood varchar(45) not null,
<<<<<<< HEAD
	city_id int(11) not null references cities(id),
=======
	city_id smallint(100) not null references cities(id),
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
	constraint pk_owners primary key (id)
);

drop table if exists real_estates;
create table real_estates(
<<<<<<< HEAD
	id integer(100) not null auto_increment,
=======
	id smallint(100) not null auto_increment,
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
	name varchar(40) not null,
	telephone integer(12) not null,
	email varchar(40),
	website varchar(60) not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
<<<<<<< HEAD
	city_id int(11) not null references cities(id),
=======
	city_id smallint(100) not null references cities(id),
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
	constraint pk_real_estates primary key (id)
);

drop table if exists buildings;
create table buildings(
<<<<<<< HEAD
	id integer(100) not null auto_increment,
	type enum('Land','Farm','House','Departament','Garage') not null,	
	owner_id integer(100) not null references owners(id),
	real_estate_id integer(100) not null references real_estates(id),
=======
	id smallint(100) not null auto_increment,
	type enum('Land','Farm','House','Departament','Garage') not null,	
	owner_id smallint(100) not null references owners(id),
	real_estate_id smallint(40) not null references real_estates(id),
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
	description varchar(400),
	price float not null,
	status enum('Sell','Rent') not null,
	street varchar(45) not null,
	neighborhood varchar(45) not null,
<<<<<<< HEAD
	city_id int(11) not null references cities(id),
=======
	city_id smallint(100) not null references cities(id),
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
	constraint pk_buildings primary key (id)
);

drop table if exists cities;
create table cities(
<<<<<<< HEAD
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
=======
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
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
);
