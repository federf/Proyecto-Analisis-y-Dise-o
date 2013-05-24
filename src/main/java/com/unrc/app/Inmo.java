package com.unrc.app;
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
}
