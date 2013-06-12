package com.unrc.app;

import java.util.*;
import com.unrc.app.models.*;


public class ABMreal_estates {
	public static void createRealEstate(String nombre, int telefono,String email, String website, String calle, String barrio, int pc_ciudad, int dni_dueño){
		realEstate buscar=realEstate.findFirst("name=?", nombre); //buscamos la existencia del elemento
		Owner o=Owner.findFirst("dni=?", dni_dueño);
		if ((buscar==null)&&!(o==null)){ //si no existe, lo creamos
			realEstate r= realEstate.createIt("name",nombre, "telephone", telefono, "email", email, "website", website,"street", calle, "neighborhood", barrio, "city_id", pc_ciudad);
			Relaciones.conectar_owner_real_estate(o, nombre); //conectamos dueño-inmobiliaria
			Relaciones.conectar_real_estate_city(r, pc_ciudad); //conectamos inmobiliaria-ciudad
		}
	}
	public static void modifRealEstate(String nombreBuscado, String nuevoNombre, int telefono,String newEmail, String website, String calle, String barrio, int pc_ciudad){
		City c= City.findFirst("postal_code=?",pc_ciudad);
		realEstate aModif = realEstate.findFirst("name=?",nombreBuscado);
		if ((aModif!=null)&&(c!=null)){
			aModif.set("name", nuevoNombre);
			aModif.set("telephone", telefono);
			aModif.set("email",newEmail);
			aModif.set("website", website);
			aModif.set("street", calle);
			aModif.set("neighborhood", barrio);
			aModif.set("city_id", c.getId());
			aModif.saveIt();
		}
	}
	
	public static void removeRealEstate(String nombre){
		realEstate r= realEstate.findFirst("name=?", nombre);//buscamos la inmobiliaria
		System.out.println("1");
		
		List<Building> inmuebles= r.getAll(Building.class); 
		
		System.out.println("2");
		
		for(int i=0; i<inmuebles.size(); i++){//desconectamos los inmuebles de la inmobiliaria
			Relaciones.desconectar_real_estate_building(r, inmuebles.get(i).getString("Street"));
		}
		
		System.out.println("3");
		
		List<Owner> o= r.getAll(Owner.class);
		for(int i=0; i<o.size(); i++){ //desconectamos los owners de la inmobiliaria
			Owner duenio= o.get(i);
			Relaciones.desconectar_owner_real_estate(duenio, nombre); //desconectamos dueño-inmobiliaria
		}
		
		ownersRealEstates.delete("real_estate_id=?", r.getId());//buscamos el registro relacion en la tabla Owner_has_real_estates
				
		System.out.println("4");
		
		
		Relaciones.desconectar_real_estate_city(r, r.getInteger("city_id")); //desconectamos inmobiliaria-ciudad
		
		System.out.println("5");
		
		//r.delete();//borramos la inmobiliaria
	}
	public static String toString(realEstate r) {
		City c=City.findFirst("id=?", r.getInteger("city_id"));
		return "Nombre inmobiliaria= "+r.getString("name")+" Telefono= "+r.getInteger("telephone").toString()+" Email= "+r.getString("email")+" Website= "+r.getString("website")+" Direccion= "+r.getString("street")+", Barrio "+r.getString("neighborhood")+", "+c.getString("name");
	}

}
