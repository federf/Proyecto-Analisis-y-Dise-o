package com.unrc.app;

import java.util.*;
import com.unrc.app.models.*;

public class ABMOwner {

	public static void createOwner(String email, String nombre, String apellido,int dni, String calle, String barrio, int pc_ciudad){
		Owner buscar= Owner.findFirst("dni=?", dni); //buscamos si el elemento existe
		City c=City.findFirst("postal_code=?", pc_ciudad);
		if (buscar==null &&(c!=null)){ // si no existe, lo creamos
			Owner o= Owner.createIt("email", email,"first_name", nombre,"last_name",apellido,"street",calle,"dni",dni, "neighborhood", barrio, "city_id",pc_ciudad);
			Relaciones.conectar_owner_city(o, pc_ciudad); //conectamos dueño con ciudad
		}		
	}
	public static void modifOwner(int dniBuscado,String email, String nombre, String apellido,int dniNuevo, String calle, String barrio, int pc_ciudad){
		City c= City.findFirst("postal_code=?",pc_ciudad);
		Owner aModif = Owner.findFirst("dni=?",dniBuscado);
		if ((aModif!=null)&&(c!=null)){
			aModif.set("email", email);
			aModif.set("first_name", nombre);
			aModif.set("last_name", apellido);
			aModif.set("dni", dniNuevo);
			aModif.set("street", calle);
			aModif.set("neighborhood", barrio);
			aModif.set("city_id", c.getId());
			aModif.saveIt();
		}
	}
	
	public static void removeOwner(int dni){
		Owner o= Owner.findFirst("dni=?", dni);//buscamos el dueño por su dni
		List<Building> inmuebles = o.getAll(Building.class); //buscamos todos los inmuebles
		for(int i=0; i<inmuebles.size(); i++){ //para todos los inmuebles
			Relaciones.desconectar_owner_building(o, inmuebles.get(i).getString("street")); //quitamos las relaciones inmueble-dueño
			Building unInm=inmuebles.get(i);//obtenemos un inmueble
			if(unInm.get("owner_id")== o.getId()){ //si esta relacionado
				ABMBuilding.removeBuilding(unInm.getString("street"),unInm.getString("neighborhood"),unInm.getInteger("city_id")); //removemos los inmuebles
			}
		}
		List<realEstate> inmob = o.getAll(realEstate.class); //buscamos todas las inmobiliarias
		for(int i=0; i<inmob.size(); i++){ //para todas las inmobiliarias
			Relaciones.desconectar_owner_real_estate(o, inmob.get(i).getString("name")); //quitamos las relaciones inmobiliaria-dueño
		}
		o.delete(); //borramos el dueño
	}
	
	
	public static String toString(Owner o) {
		City c=City.findFirst("id=?",o.getInteger("city_id"));
		return "DNI= "+o.getInteger("dni").toString()+" Nombre= "+o.getString("first_name")+" Apellido= "+o.getString("last_name")+" Email= "+o.getString("email")+" Direccion= "+o.getString("street")+", Barrio "+o.getString("neighborhood")+", "+c.getString("name");
	}
}
