package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.Owner;

public class ABMBuilding {
	public static void createBuilding(int dni_Dueño, String tipo, String calle, String barrio, int pc_ciudad, String descripcion, float precio, String estado, String nombre_real_estate){
		Building buscar= Building.findFirst("street=?", calle, "neighborhood=?", barrio, "city=?", pc_ciudad); //buscamos si existe el elemento anteriormente
		if (buscar==null){ //si no existe lo creamos
			Building.createIt("owner_id",Owner.findFirst("dni=?",dni_Dueño).getId(),"type", tipo,"street",calle, "neighborhood", barrio, "city",pc_ciudad,"description", descripcion ,"price", precio,"status", estado);
			Relaciones.conectar_owner_building(dni_Dueño, calle); // conectamos dueño-inmueble
			Relaciones.conectar_real_estate_building(nombre_real_estate, calle); //conectamos inmobiliara-inmueble
			Relaciones.conectar_building_city(calle, pc_ciudad); //conectamos inmueble-ciudad
		}
	}
	
	public static void modifBuilding( String tipo, String calle, String barrio, int pc_ciudad, String descripcion, float precio, String estado){
		Building aModif = Building.findFirst("street=?", calle, "neighborhood=?", barrio, "city=?", pc_ciudad);
		aModif.set("type", tipo);
		aModif.set("street", calle);
		aModif.set("neighborhood", barrio);
		aModif.set("description", descripcion);
		aModif.set("price", precio);
		aModif.set("status", estado);
		aModif.set("ciudad", pc_ciudad);
		aModif.saveIt();
	}
	
	public static void removeBuilding(String calle, String barrio, int pc_ciudad){
		Building b= Building.findFirst("street=?", calle, "neighborhood=?", barrio, "city=?", pc_ciudad);//buscamos el edificio
		Relaciones.desconectar_building_city(calle, pc_ciudad); //quitamos la relacion edificio-ciudad
		b.delete(); //borramos el edificio
	}
}
