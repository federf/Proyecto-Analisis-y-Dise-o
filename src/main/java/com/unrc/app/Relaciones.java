//esta clase sera utilizada para realizar las correspondientes conexiones entre dato de las tablas
package com.unrc.app;

import com.unrc.app.models.*;

public class Relaciones {
	//conecta dueño e inmueble
	public static void conectar_owner_building(int dni_owner, String street_building){
		Owner dueño= Owner.findFirst("dni=?",dni_owner); //buscamos el dueño segun el dni
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el inmueble por su direccion
		dueño.add(inmueble); //agregamos la relacion entre el dueño y su inmueble
	}
	//conecta dueño e inmobiliaria
	public static void conectar_owner_real_estate(int dni_owner, String name_re){
		Owner dueño= Owner.findFirst("dni=?",dni_owner); //buscamos el dueño segun el dni
		realEstate inmo= realEstate.findFirst("name=?",name_re); //buscamos la inmobiliaria por su nombre
		dueño.add(inmo); //agregamos la relacion entre el dueño e inmobiliaria
	}
	//conecta inmobiliaria e inmueble
	public static void conectar_real_estate_building(String name_re, String street_building){
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el dueño segun el dni
		realEstate inmo= realEstate.findFirst("name=?",name_re); //buscamos la inmobiliaria por su nombre
		inmo.add(inmueble); //agregamos la relacion entre el inmueble e inmobiliaria
	}
	//conecta inmueble y ciudad
	public static void conectar_building_city(String street_building, int pc_city){
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el inmueble por su direccion
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		ciudad.add(inmueble); //agregamos la relacion entre el inmueble y la ciudad
	}
	//conecta inmobiliaria y ciudad
	public static void conectar_real_estate_city(String name_re, int pc_city){
		realEstate inmo= realEstate.findFirst("name=?",name_re); //buscamos la inmobiliaria segun su nombre
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		ciudad.add(inmo); //agregamos la relacion entre inmobiliaria y ciudad
	}
	//conecta dueño y ciudad
	public static void conectar_owner_city(int dniOwner, int pc_city){
		Owner dueño= Owner.findFirst("dni=?",dniOwner); //buscamos el dueño segun el dni
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		ciudad.add(dueño); //agregamos la relacion entre el dueño y la ciudad
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//--------------------------------------DESCONEXIONES------------------------------------------------------//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//desconecta dueño e inmueble
	public static void desconectar_owner_building(int dni_owner, String street_building){
		Owner dueño= Owner.findFirst("dni=?",dni_owner); //buscamos el dueño segun el dni
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el inmueble por su direccion
		if (Building.belongsTo(Owner.class)){
			dueño.remove(inmueble); //quitamos la relacion entre el dueño y su inmueble
		}
	}
	//desconecta inmobiliaria e inmueble	
	public static void desconectar_real_estate_building(String name_re, String street_building){
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el dueño segun el dni
		realEstate inmo= realEstate.findFirst("name=?",name_re); //buscamos la inmobiliaria por su nombre
		if(Building.belongsTo(realEstate.class)){
			inmo.remove(inmueble); //quitamos la relacion entre el inmueble e inmobiliaria
		}
	}
	//desconecta dueño e inmobiliaria	
	public static void desconectar_owner_real_estate(int dni_owner, String name_re){
		Owner dueño= Owner.findFirst("dni=?",dni_owner); //buscamos el dueño segun el dni
		realEstate inmo= realEstate.findFirst("name=?",name_re); //buscamos la inmobiliaria por su nombre
		if(realEstate.belongsTo(Owner.class)){
			dueño.remove(inmo); //quitamos la relacion entre el dueño e inmobiliaria
		}
	}
	//desconecta inmueble y ciudad
	public static void desconectar_building_city(String street_building, int pc_city){
		Building inmueble= Building.findFirst("street=?",street_building); //buscamos el inmueble por su direccion
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		if(Building.belongsTo(City.class)){		
		ciudad.remove(inmueble); //quitamos la relacion entre el inmueble y la ciudad
		}
	}
	//desconecta inmobiliaria y ciudad
	public static void desconectar_real_estate_city(String name_re, int pc_city){
		realEstate inmo= realEstate.findFirst("name=?",name_re); //buscamos la inmobiliaria por su nombre
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		if(realEstate.belongsTo(City.class)){
			ciudad.remove(inmo); //quitamos la relacion entre la inmobiliaria y la ciudad
		}
	}
	//desconecta dueño y ciudad
	public static void desconectar_owner_city(int dniOwner, int pc_city){
		Owner dueño= Owner.findFirst("dni=?",dniOwner); //buscamos el dueño segun el dni
		City ciudad= City.findFirst("postal_code=?",pc_city); //buscamos la ciudad por su codigo postal
		if(Owner.belongsTo(City.class)){
			ciudad.add(dueño); //agregamos la relacion entre el dueño y la ciudad
		}
	}
}