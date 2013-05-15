package com.unrc.app;

import com.unrc.app.models.Owner;

public class ABMOwner {

	public static void createOwner(String email, String nombre, String apellido,int dni, String calle, String barrio, String ciudad){
		Owner.createIt("email", email,"first_name", nombre,"last_name",apellido,"street",calle,"dni",dni, "neighborhood", barrio, "city",ciudad);
	}
	
	public static void modifOwner(String email, String nombre, String apellido,int dni, String calle, String barrio, String ciudad){
		Owner aModif = Owner.findFirst("dni=?",dni);
		aModif.set("email", email);
		aModif.set("first_name", nombre);
		aModif.set("last_name", apellido);
		aModif.set("street", calle);
		aModif.set("neighborhood", barrio);
		aModif.set("city", ciudad);
	}
	
	public static void removeOwner(int dni){
		Owner.delete("dni=?",dni);
	}

	public static Owner searchOwner(int dni) {
		return Owner.findFirst("dni=?", dni);
	}
}
