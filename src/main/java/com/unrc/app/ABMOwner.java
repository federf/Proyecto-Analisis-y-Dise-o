package com.unrc.app;

import java.util.*;

import com.unrc.app.models.City;
import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.realEstate;

public class ABMOwner {


	public static void createOwner(String email, String nombre, String apellido,int dni, String calle, String barrio, int pc_ciudad) throws NullCityException{
		Owner buscar= Owner.findFirst("dni=?", dni); //buscamos si el elemento existe
		City ciudad=City.findFirst("postal_code=?",pc_ciudad);
		if (ciudad!=null) {
			if (buscar==null) { // si no existe, lo creamos
				Owner o=Owner.createIt("email", email,"first_name", nombre,"last_name",apellido,"street",calle,"dni",dni, "neighborhood", barrio, "city_id",ciudad.getInteger("id"));
				Relaciones.conectar_owner_city(o, pc_ciudad); //conectamos dueño con ciudad
			} 
		} else 
			throw new NullCityException ("ABMOwner.createOwner: NullCityException");		
	}

	public static void modifOwner(int dniBuscado,String email, String nombre, String apellido,int dniNuevo, String calle, String barrio, int pc_ciudad) throws NullCityException, NullOwnerException {
		Owner aModif = Owner.findFirst("dni=?",dniBuscado);
		City ciudad=City.findFirst("postal_code=?",pc_ciudad);
		if (ciudad!=null) {
			if (aModif!=null) {		
				aModif.set("email", email);
				aModif.set("first_name", nombre);
				aModif.set("last_name", apellido);
				aModif.set("dni", dniNuevo);
				aModif.set("street", calle);
				aModif.set("neighborhood", barrio);
				aModif.set("city_id", ciudad.getId());
				aModif.saveIt();
			} else 
				throw new NullOwnerException ("ABMOwner.modifOwner: NullOwnerException");		

		} else 
			throw new NullCityException ("ABMOwner.modifOwner: NullCityException");		

	}
	
	public static void removeOwner(int dni){
		Owner o= Owner.findFirst("dni=?", dni);//buscamos el dueño por su dni
		List<Building> inmuebles = o.getAll(Building.class); //buscamos todos los inmuebles
		for(int i=0; i<inmuebles.size(); i++){ //para todos los inmuebles
			Relaciones.desconectar_owner_building(o, inmuebles.get(i).getString("street")); //quitamos las relaciones inmueble-dueño
			Building unInm=inmuebles.get(i);//obtenemos un inmueble
			if(unInm.get("owner_id")== o.getId()){ //si esta relacionado
				try {
					ABMBuilding.removeBuilding(unInm.getString("street"),unInm.getString("neighborhood"),unInm.getInteger("city_id")); //removemos los inmuebles
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		List<realEstate> inmob = o.getAll(realEstate.class); //buscamos todas las inmobiliarias
		for(int i=0; i<inmob.size(); i++){ //para todas las inmobiliarias
			Relaciones.desconectar_owner_real_estate(o, inmob.get(i).getString("name")); //quitamos las relaciones inmobiliaria-dueño
		}
		o.delete(); //borramos el dueño
	}
}
