package com.unrc.app;
<<<<<<< HEAD
import org.javalite.activejdbc.Base;

import com.unrc.app.models.Building;
import com.unrc.app.models.City;

public class Inmo {
	
	public static void main( String[] args ){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");

		//ABMCity.crearCiudad(12345,"Rio Cuarto");
		
		//ABMOwner.createOwner("fede@email.com","Fede","Franco", 37167263,"Caseros 269","centro", 12345);
		//ABMOwner.modifOwner(37167263,"fede_franco@hotmail.com","Federico","Franco", 37167263,"Caseros 269","centro", 12345);
		//ABMOwner.removeOwner(37167263); //--falta arreglar los remove
		
		//ABMreal_estates.createRealEstate("inmo", 4829482,"email@prueba.com", "www.inmo.com","calle falsa 123", "centro", 12345, 37167263);
		//ABMreal_estates.modifRealEstate("inmo","inmoB", 4829482,"email@prueba.com", "www.inmo.com","calle falsedad 123", "centro", 12345);
		//ABMreal_estates.removeRealEstate("inmoB");
		
		//ABMBuilding.createBuilding(37167263, "House", "Caseros 269", "Centro", 12345, "descripcion prueba", 129574, "Sell", "inmo");
		//ABMBuilding.modifBuilding("Caseros 269", 12345,"House", "Caseros 270", "Centrosur", 1, "descripcion nueva", 12345, "Sell");
		//ABMBuilding.removeBuilding("Caseros 270", "Centrosur", 12345);
		Base.close();
		System.out.println( "Finalizado Correctamente" );
    }

	/* PASOS PARA PROBAR CORRECTAMENTE
	 * 1- CREAR CIUDAD, OWNER, REAL_ESTATE Y BUILDING TODO JUNTO, COMENTAR ESOS METODOS
	 * 2- DESCOMENTAR LOS MODIF Y PROBARLOS, COMENTARLOS LUEGO
	 * 3- PARA BORRAR TENER EN CUENTA LO SIGUENTE:
	 * 		SI SE BORRA EL OWNER SE BORRARA TODO MENOS LOS REAL_ESTATE ASOCIADOS A EL
	 * 		SI SE BORRA EL REAL ESTATE SE BORRAN TODOS LOS INMUEBLES DEL MISMO
	 * 		SI SE BORRA BUILDING NO SE AFECTA TABLAS EXTERNAS
	 */
=======

import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.realEstate;
import com.unrc.app.models.City;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmo {
    public static void main( String[] args ){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "64784");

		City city=City.createIt("name", "Rio IV", "postal_code", 100);

		Owner owner;
		owner = Owner.createIt("email", "fede@email.com","first_name", "Fede","last_name", "Franco","street", "Caseros 269", "neighborhood", "centro", "city_id", city.getId());

		realEstate re;
		re=realEstate.createIt("name", "InmoRio","street", "Pedernera 2340", "neighborhood", "centro", "city_id", city.getId(),"telephone", 4453283,"website", "www.InmoRio.com.ar");

		Building.createIt("owner_id",owner.getId(),"type", "Departament","street", "Caseros 269", "neighborhood", "centro", "city_id", city.getId(),"description", "esta es una descripcion","price", 500000,"status", "Sell", "real_estate_id", re.getId());
		System.out.println( "Hello World!" );
    }
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
}
