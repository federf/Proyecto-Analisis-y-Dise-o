DROP TABLE IF EXISTS Owners;
CREATE TABLE Owners(
    idOwner  int(11) NOT NULL  auto_increment PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    direccion varchar(60),
    email varchar(80),
    inmobiliarias varchar(200)
);

drop table if exists realStates;
create table realStates(
	idRS int(11) not null auto_increment primary key,
	nombre varchar(40),
	direccion varchar(60),
	telefono integer(12),
    email varchar(70),
    website varchar(60),
    owners varchar(200)
);

drop table if exists Buildings;
create table Buildings(
	idBuilding int(11) not null auto_increment primary key,
	tipo enum('Departamento','Casa','Local','Cochera'),
	direccion varchar(60),
    descripcion varchar(400),
    precio float,
	estado enum('Venta','Alquiler')
);
