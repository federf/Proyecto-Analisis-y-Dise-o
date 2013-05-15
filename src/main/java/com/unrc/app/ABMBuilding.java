package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.Owner;

public class ABMBuilding {
	public static void createBuilding(int dni_Dueño, String tipo, String calle, String barrio, String ciudad, String descripcion, float precio, String estado){
		Building.createIt("owner_id",Owner.findFirst("dni=?",dni_Dueño).getId(),"type", tipo,"street",calle, "neighborhood", barrio, "city",ciudad,"description", descripcion ,"price", precio,"status", estado);
	}
	
	public static void modifBuilding( String tipo, String calle, String barrio, String ciudad, String descripcion, float precio, String estado){
		Building aModif = Building.findFirst("street=?",calle);
		aModif.set("type", tipo);
		aModif.set("street", calle);
		aModif.set("neighborhood", barrio);
		aModif.set("description", descripcion);
		aModif.set("price", precio);
		aModif.set("status", estado);
	}
	
	public static void removeBuilding(String street){
		Building.delete("street=?",street);
	}
}
