package com.unrc.app;

import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.realEstate;
import com.unrc.app.models.City;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmo {
    public static void main( String[] args ){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");

		City rioCuarto;
		rioCuarto = City.createIt("postal_code", 12345,"name", "Rio Cuarto");

		Owner owner;
		owner = Owner.createIt("email", "fede@email.com","first_name", "Fede","last_name", "Franco","street", "Caseros 269", "neighborhood", "centro", "city", 12345, "dni", 37167263);

		realEstate re;
		re=realEstate.createIt("name", "InmoRio","street", "Pedernera 2340", "neighborhood", "centro", "city", 12345,"telephone", 4453283,"website", "www.InmoRio.com.ar");

		Building b;
		b = Building.createIt("owner_id",owner.getId(),"type", "Departament","street", "Caseros 269", "neighborhood", "centro", "city", 12345,"description", "esta es una descripcion","price", 500000,"status", "Sell", "real_estate_id", re.getId());


		System.out.println( "Carga Finalizada Correctamente" );
    }
}