package com.unrc.app;

import java.util.*;
import com.unrc.app.models.*;/*
import com.unrc.app.models.realEstate;
import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;*/

public class ABMreal_estates {
	public static void createRealEstate(String nombre, int telefono, String website, String calle, String barrio, int pc_ciudad, int dni_dueño){
		realEstate buscar=realEstate.findFirst("name=?", nombre); //buscamos la existencia del elemento
		if (buscar==null){ //si no existe, lo creamos
			realEstate.createIt("name", nombre,"street",calle, "neighborhood", barrio, "city", pc_ciudad,"telephone", telefono,"website", website);
			Relaciones.conectar_owner_real_estate(dni_dueño, nombre); //conectamos dueño-inmobiliaria
			Relaciones.conectar_real_estate_city(nombre, pc_ciudad); //conectamos inmobiliaria-ciudad
		}
	}
	
	public static void modifRealEstate(String nombre, int telefono, String website, String calle, String barrio, int ciudad){
		realEstate aModif = realEstate.findFirst("name=?",nombre);
		aModif.set("name", nombre);
		aModif.set("telephone", telefono);
		aModif.set("website", website);
		aModif.set("street", calle);
		aModif.set("neighborhood", barrio);
		aModif.set("city", ciudad);
		aModif.saveIt();
	}
	
	public static void removeRealEstate(String nombre){
		realEstate r= realEstate.findFirst("name=?", nombre);
		List<Building> inmuebles= r.getAll(Building.class); 
		for(int i=0; i<inmuebles.size(); i++){//desconectamos los inmuebles de la inmobiliaria
			Relaciones.desconectar_real_estate_building(nombre, inmuebles.get(i).getString("Street"));
		}
		List<Owner> o= r.getAll(Owner.class);
		for(int i=0; i<o.size(); i++){ //desconectamos los owners de la inmobiliaria
			int dniOwner=o.get(i).getInteger("dni");
			Relaciones.desconectar_owner_real_estate(dniOwner, nombre); //desconectamos dueño-inmobiliaria
		}
		Relaciones.desconectar_real_estate_city(nombre, r.getInteger("city")); //desconectamos inmobiliaria-ciudad
		r.delete();//borramos la inmobiliaria
	}

}
