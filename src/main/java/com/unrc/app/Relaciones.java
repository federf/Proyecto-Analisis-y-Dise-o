//esta clase sera utilizada para realizar las correspondientes conexiones entre dato de las tablas
package com.unrc.app;

import com.unrc.app.models.*;

public class Relaciones {
	//conecta dueño e inmueble
	public static void conectar_owner_building(Owner o, String street_building){
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el inmueble por su direccion
		o.add(inmueble); //agregamos la relacion entre el dueño y su inmueble
	}
	//conecta dueño e inmobiliaria
	public static void conectar_owner_real_estate(Owner o, String name_re){
		realEstate inmo= realEstate.findFirst("name=?",name_re); //buscamos la inmobiliaria por su nombre
		inmo.add(o); //agregamos la relacion entre el dueño e inmobiliaria
	}
	//conecta inmobiliaria e inmueble
	public static void conectar_real_estate_building(realEstate r, String street_building){
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el dueño segun el dni
		r.add(inmueble); //agregamos la relacion entre el inmueble e inmobiliaria
	}
	//conecta inmueble y ciudad
	public static void conectar_building_city(Building b/*String street_building,String barrio_building*/, int pc_city){
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		ciudad.add(b); //agregamos la relacion entre el inmueble y la ciudad
	}
	//conecta inmobiliaria y ciudad
	public static void conectar_real_estate_city(realEstate r, int pc_city){
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		ciudad.add(r); //agregamos la relacion entre inmobiliaria y ciudad
	}
	//conecta dueño y ciudad
	public static void conectar_owner_city(Owner o, int pc_city){
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		ciudad.add(o); //agregamos la relacion entre el dueño y la ciudad
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//--------------------------------------DESCONEXIONES------------------------------------------------------//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//desconecta dueño e inmueble
	public static void desconectar_owner_building(Owner o, String street_building){
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el inmueble por su direccion
		if (Building.belongsTo(Owner.class)){
			o.remove(inmueble); //quitamos la relacion entre el dueño y su inmueble
		}
	}
	//desconecta inmobiliaria e inmueble	
	public static void desconectar_real_estate_building(realEstate r, String street_building){
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el dueño segun el dni
		if(Building.belongsTo(realEstate.class)){
			r.remove(inmueble); //quitamos la relacion entre el inmueble e inmobiliaria
		}
	}
	//desconecta dueño e inmobiliaria	
	public static void desconectar_owner_real_estate(Owner o, String name_re){
		realEstate inmo= realEstate.findFirst("name=?",name_re); //buscamos la inmobiliaria por su nombre
		if(realEstate.belongsTo(Owner.class)){
			o.remove(inmo); //quitamos la relacion entre el dueño e inmobiliaria
		}
	}
	//desconecta inmueble y ciudad
	public static void desconectar_building_city(Building b, int pc_city){
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		if(Building.belongsTo(City.class)){		
		ciudad.remove(b); //quitamos la relacion entre el inmueble y la ciudad
		}
	}
	//desconecta inmobiliaria y ciudad
	public static void desconectar_real_estate_city(realEstate r, int pc_city){
		City ciudad= City.findFirst("id=?",pc_city); //buscamos la ciudad por su codigo postal
		if(realEstate.belongsTo(City.class)){
			ciudad.remove(r); //quitamos la relacion entre la inmobiliaria y la ciudad
		}
	}
	//desconecta dueño y ciudad
	public static void desconectar_owner_city(Owner o, int pc_city){
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		if(Owner.belongsTo(City.class)){
			ciudad.remove(o); //agregamos la relacion entre el dueño y la ciudad
		}
	}
}
