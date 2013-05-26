package com.unrc.app;

import com.unrc.app.models.*;

public class ABMBuilding {

	public static void createBuilding(int dni_Dueño, String tipo, String calle, String barrio, int pc_ciudad, String descripcion, float precio, String estado, String nombre_real_estate) throws NullCityException, NullOwnerException, TypeBuildingException{
		if ((tipo=="Land") || (tipo=="House") || ( tipo=="Departament") || ( tipo=="Garage") || (tipo=="Farm")) { 		
			City ciudad=City.findFirst("postal_code=?",pc_ciudad);
			if (ciudad!=null) {
				Building buscar= Building.findFirst("street=? and neighborhood=? and citie_id=?", calle, barrio, ciudad.getInteger("id")); //buscamos si existe el elemento anteriormente
				if (buscar==null){ //si no existe lo creamos
					Owner o= Owner.findFirst("dni=?",dni_Dueño);
					if (o!=null) {
						realEstate r=realEstate.findFirst("name=?", nombre_real_estate);
						Building b= Building.createIt("owner_id",o.getInteger("id"),"real_estate_id",r.getInteger("id"),"type", tipo,"street",calle, "neighborhood", barrio, "city_id",pc_ciudad,"description", descripcion ,"price", precio,"status", estado);
						Relaciones.conectar_owner_building(o, calle); // conectamos dueño-inmueble
						Relaciones.conectar_real_estate_building(r, calle); //conectamos inmobiliara-inmueble
						Relaciones.conectar_building_city(b, pc_ciudad); //conectamos inmueble-ciudad
					} else 
						throw new NullOwnerException("ABMBuilding.createBuilding: NullOwnerException");
				}
			} else 
				throw new NullCityException("ABMBuilding.createBuilding: NullCityException");
		} else 
			throw new TypeBuildingException("ABMBuilding.createBuilding: TypeBuildingException");
	}


	public static void modifBuilding(String calleBuscada, String barrioBuscado, int pc_ciudadBuscada, String tipo, String calleNueva, String barrioNuevo, int pc_ciudadNueva, String descripcion, float precio, String estado, int Dni_Dueño, String real_state_nombre) throws TypeBuildingException, NullBuildingException, NullCityException,  NullOwnerException{
		City ciudad=City.findFirst("postal_code=?",pc_ciudadBuscada);
		if (ciudad!=null) {
			Owner o=Owner.findFirst("dni=?",Dni_Dueño);
			if (o!=null) {
				Building aModif= Building.findFirst("street=? and neighborhood=? and city_id=?", calleBuscada, barrioBuscado, ciudad.getInteger("id"));
				City ciudad2=City.findFirst("postal_code=?",pc_ciudadNueva);
				if (ciudad2!=null) {
					if ((tipo=="Land") || (tipo=="House") || ( tipo=="Departament") || ( tipo=="Garage") || (tipo=="Farm")) {
						if (aModif!=null) {
							aModif.set("type", tipo);
							aModif.set("street", calleNueva);
							aModif.set("neighborhood", barrioNuevo);
							aModif.set("description", descripcion);
							aModif.set("price", precio);
							aModif.set("status", estado);
							aModif.set("city_id", ciudad2.getInteger("id"));
							aModif.set("owner_id", o.getInteger("id"));
							realEstate r=realEstate.findFirst("name=?", real_state_nombre);
							if (r!=null)
								aModif.set("real_estate_id", r.getInteger("id"));					
							aModif.saveIt();
						} else 
							throw new NullBuildingException("ABMBuilding.modifBuilding: NullBuildingException");
					} else 
						throw new TypeBuildingException("ABMBuilding.modifBuilding: TypeBuildingException");
				} else		
					throw new NullCityException("ABMBuilding.modifBuilding: NullCityException, pc_ciudadNueva");
			} else 		
				throw new NullOwnerException("ABMBuilding.modifBuilding: NullOwnerException");
		} else 
			throw new NullCityException("ABMBuilding.modifBuilding: NullCityException, pc_ciudadVieja");
	}
	
	public static void removeBuilding(String calle, String barrio, int pc_ciudad) throws NullCityException{
		City ciudad=City.findFirst("postal_code=?",pc_ciudad);
		if (ciudad!=null) {
			Building b= Building.findFirst("street=? and neighborhood=? and city_id=?", calle, barrio, ciudad.getInteger("id"));
			Relaciones.desconectar_building_city(b, pc_ciudad); //quitamos la relacion edificio-ciudad
		//	b.delete(); //borramos el edificio
		} else 
			throw new NullCityException("ABMBuilding.removeBuilding: NullCityException");			
	}
}
