package com.unrc.app;

import java.util.*;
import com.unrc.app.models.*;


public class ABMreal_estates {
	public static void createRealEstate(String nombre, int telefono,String email, String website, String calle, String barrio, int pc_ciudad, int dni_dueño) throws NullCityException, NullOwnerException{
		Owner o=Owner.findFirst("dni=?", dni_dueño);
		if (!(o==null)){ //si no existe, lo creamos
			realEstate buscar=realEstate.findFirst("name=?", nombre); //buscamos la existencia del elemento
			if(buscar==null) {
				City ciudad= City.findFirst("postal_code=?", pc_ciudad);
				if (ciudad!=null) {
					realEstate r= realEstate.createIt("name",nombre, "telephone", telefono, "email", email, "website", website,"street", calle, "neighborhood", barrio, "city_id", pc_ciudad);//COMPLETAR!!!!
					Relaciones.conectar_owner_real_estate(o, nombre); //conectamos dueño-inmobiliaria
					Relaciones.conectar_real_estate_city(r, pc_ciudad); //conectamos inmobiliaria-ciudad
				} else {
					throw new NullCityException ("ABMreal_estates.createRealEstate: NullCityException");
				}

			}
		}
		else{
			throw new NullOwnerException ("ABMreal_estates.createRealEstate: NullOwnerException");
		}
	}	
	
	public static void modifRealEstate(String nombreViejo, String nombreNuevo, int telefono, String newEmail, String website, String calle, String barrio, int ciudad) throws NullCityException {
		realEstate aModif = realEstate.findFirst("name=?",nombreViejo);
		if (aModif!=null) {
			int id_viejo=aModif.getInteger("city_id");
			City city= City.findFirst("id=?", id_viejo);
			Relaciones.desconectar_real_estate_city(aModif, city.getInteger("postal_code"));
			aModif.set("name", nombreNuevo);
			aModif.set("telephone", telefono);
			aModif.set("email", newEmail);
			aModif.set("website", website);
			aModif.set("street", calle);
			aModif.set("neighborhood", barrio);
			City cityNueva= City.findFirst("postal_code=?", ciudad);
			if (cityNueva!=null) {
				Relaciones.conectar_real_estate_city(aModif, ciudad); //conectamos inmobiliaria-ciudad
				aModif.saveIt();
			} else 
				throw new NullCityException ("ABMreal_estates.createRealEstate: NullCityException");
		}
	}

	public static void removeRealEstate(String nombre) throws NullRealEstatesException{
		realEstate r= realEstate.findFirst("name=?", nombre);//buscamos la inmobiliaria
		if (r!=null) {
			List<Building> inmuebles= r.getAll(Building.class); 
		
			for(int i=0; i<inmuebles.size(); i++){//desconectamos los inmuebles de la inmobiliaria
				Relaciones.desconectar_real_estate_building(r, inmuebles.get(i).getString("Street"));
			}
		
			List<Owner> o= r.getAll(Owner.class);
			for(int i=0; i<o.size(); i++){ //desconectamos los owners de la inmobiliaria
				Owner duenio= o.get(i);
				Relaciones.desconectar_owner_real_estate(duenio, nombre); //desconectamos dueño-inmobiliaria
			}
		
			ownersRealEstates.delete("real_estate_id=?", r.getInteger("id"));//buscamos el registro relacion en la tabla Owner_has_real_estates
			Relaciones.desconectar_real_estate_city(r, r.getInteger("city_id")); //desconectamos inmobiliaria-ciudad
		
			//r.delete();//borramos la inmobiliaria
		} else 
			throw new NullRealEstatesException  ("ABMRealEstates.removeREalEstates: NullRealEstatesException");
	}
}
