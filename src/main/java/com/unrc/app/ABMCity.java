package com.unrc.app;

import com.unrc.app.models.City;

public class ABMCity {

	public static void crearCiudad(int PC, String name){
		City buscar= City.findFirst("postal_code=?",PC);
		if(buscar==null){
			City.createIt("postal_code",PC, "name", name);
		}
	}

	public static void modifCiudad(int pc_viejo, int pc_nuevo, String nombre) throws NullCityException {
		City aModif= City.findFirst("postal_code=?", pc_viejo);
		if (aModif!=null) {
			aModif.set("name", nombre);
			aModif.set("postal_code", pc_nuevo);
			aModif.saveIt();
		} else
			throw new NullCityException ("ABMCitie.modifCiudad: NullCityException");
	}

	public static void removeCiudad(int pc){
		City c= City.findFirst("postal_code=?", pc);
		if (c!=null)
			c.delete();
	}

}
