package com.unrc.app;

import com.unrc.app.models.realEstate;

public class ABMreal_estates {
	public static void createRealEstate(String nombre, int telefono, String website, String calle, String barrio, String ciudad){
		realEstate.createIt("name", nombre,"street",calle, "neighborhood", barrio, "city", ciudad,"telephone", telefono,"website", website);
	}
	
	public static void modifBuilding(String nombre, int telefono, String website, String calle, String barrio, String ciudad){
		realEstate aModif = realEstate.findFirst("name=?",nombre);
		aModif.set("name", nombre);
		aModif.set("telephone", telefono);
		aModif.set("website", website);
		aModif.set("street", calle);
		aModif.set("neighborhood", barrio);
		aModif.set("city", ciudad);
	}
	
	public static void removeRealEstate(String nombre){
		realEstate.delete("name=?",nombre);
	}

}
