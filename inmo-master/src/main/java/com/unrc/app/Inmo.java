package com.unrc.app;

import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.realEstate;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmo {
    public static void main( String[] args ){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");

		Owner owner;
		owner = Owner.createIt("email", "fede@email.com","first_name", "Fede","last_name", "Franco","street", "Caseros 269", "neighborhood", "centro", "city", "Rio Cuarto");
		//e.saveIt();

		Building.createIt("owner_id",owner.getId(),"type", "Departament","street", "Caseros 269", "neighborhood", "centro", "city", "Rio Cuarto","description", "Departamento de 3 ambientes en zona centrica con balcon, todos los servicios, amoblado","price", 500000,"status", "Sell");

		realEstate.createIt("name", "InmoRio","street", "Pedernera 2340", "neighborhood", "centro", "city", "Rio Cuarto","telephone", 4453283,"website", "www.InmoRio.com.ar");

		System.out.println( "Hello World!" );
    }
}
