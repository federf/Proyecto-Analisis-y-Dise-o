package com.unrc.app;

import com.unrc.app.models.*;

public class ABMBuilding {
	public static void createBuilding(int dni_Dueño, String tipo, String calle, String barrio, int pc_ciudad, String descripcion, int	 precio, String estado, String nombre_real_estate){
		City c=City.findFirst("postal_code=?",pc_ciudad);
		Building buscar= Building.findFirst("street=? and neighborhood=? and city_id=?", calle, barrio, c.getId()); //buscamos si existe el elemento anteriormente
		if (buscar==null&&(c!=null)){ //si no existe lo creamos
			Owner o= Owner.findFirst("dni=?",dni_Dueño);
			realEstate r=realEstate.findFirst("name=?", nombre_real_estate);
			Building b= Building.createIt("owner_id",o.getId(),"real_estate_id",r.getId(),"type", tipo,"street",calle, "neighborhood", barrio, "city_id",pc_ciudad,"description", descripcion ,"price", precio,"status", estado);
			Relaciones.conectar_owner_building(o, calle); // conectamos dueño-inmueble
			Relaciones.conectar_real_estate_building(r, calle); //conectamos inmobiliara-inmueble
			Relaciones.conectar_building_city(b, pc_ciudad); //conectamos inmueble-ciudad
		}
	}

	public static void modifBuilding(String calleBuscada, int pc_ciudadBuscada, String tipo, String calleNueva, String barrioNuevo, int pc_ciudadNueva, String descripcion, float precio, String estado){
		City c= City.findFirst("postal_code=?",pc_ciudadBuscada);
		Building aModif= Building.findFirst("street=? and city_id=?", calleBuscada, c.getId());
		City c2=City.findFirst("postal_code=?",pc_ciudadNueva);
		if ((aModif!=null)&&(c!=null)&&(c2!=null)){
			aModif.set("type", tipo);
			aModif.set("street", calleNueva);
			aModif.set("neighborhood", barrioNuevo);
			aModif.set("city_id", c2.getId());
			aModif.set("description", descripcion);
			aModif.set("price", precio);
			aModif.set("status", estado);
			aModif.saveIt();
		}
	}
	
	public static void removeBuilding(String calle, String barrio, int pc_ciudad){
		City c=City.findFirst("postal_code=?", pc_ciudad); //buscamos la ciudad por codigo postal
		Building b= Building.findFirst("street=? and neighborhood=? and city_id=?", calle, barrio, c.getId());//buscamos el inmueble a borrar
		Relaciones.desconectar_building_city(b, pc_ciudad); //quitamos la relacion edificio-ciudad
	}

	public static String toString(Building b) {
		City c=City.findFirst("id=?", b.getInteger("city_id"));
		return "Tipo= "+b.getString("type")+" Direccion= "+b.getString("street")+", Barrio "+b.getString("neighborhood")+", "+c.getString("name")+" Descripcion="+b.getString("description")+" Status="+b.getString("status")+" Price="+b.getInteger("price").toString();
	}
}
