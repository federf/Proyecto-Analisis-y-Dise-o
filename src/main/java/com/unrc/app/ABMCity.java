package com.unrc.app;

import com.unrc.app.models.City;

public class ABMCity {

	public static void crearCiudad(int PC, String name){
		City buscar= City.findFirst("postal_code=?",PC);
		if(buscar==null){
			City.createIt("postal_code",PC, "name", name);
		}
	}

	public static void modifCiudad(int pc, String name){
		City aModif= City.findFirst("postal_code=?", pc);
		aModif.set("name=?", name);
		aModif.saveIt();
	}

	public static void removeCiudad(int pc){
		City c= City.findFirst("postal_code=?", pc);
		c.delete();
	}

}
