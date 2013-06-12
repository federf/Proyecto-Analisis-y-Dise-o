package com.unrc.app;

import java.util.Iterator;
import java.util.List;

import com.unrc.app.models.*;

public class search{
	public static List<Building> busquedaBuildings(String type, String status, float minPrice, float maxPrice, int pc_city, String realEstateName, int dniOwner){
		List<Building> lb= Building.findAll();
		if(type!="null"){
			lb = searchByType(type,lb);
		}
		if(status!="null"){
			lb = searchByStatus(status,lb);
		}
		if(minPrice>=0){
			lb = searchByPrice(minPrice,lb,1);
		}
		if((maxPrice>=0) && (maxPrice>=minPrice)){
			lb = searchByPrice(maxPrice,lb,2);
		}
		if(realEstateName!="null"){
			realEstate r=realEstate.findFirst("name=?", realEstateName);
			if(r!=null){
				int idRE=(int)r.getInteger("id");
				lb=searchByRealEstate(idRE, lb);
			}
		}
		if(dniOwner>0){
			Owner o=Owner.findFirst("dni=?",dniOwner);
			int idOwner=(int)o.getInteger("id");
			if(o!=null){
				lb=searchByOwner(idOwner, lb);
			}
		}
		if(pc_city!=0){
			lb = searchByCity(pc_city,lb);
		}
		return lb;
	}
	
	private static List<Building> searchByOwner(int idOwner, List<Building> lb) {
		Iterator<Building> iter = lb.iterator();
		while(iter.hasNext()){
			Building b = iter.next();
			if(b.getInteger("owner_id")!=idOwner){
				iter.remove();
			}
		}
		return lb;
	}

	private static List<Building> searchByStatus(String status,List<Building> lb) {
		Iterator<Building> iter = lb.iterator();
		while(iter.hasNext()){
			Building b = iter.next();
			if(!(b.getString("status").equals(status))){
				iter.remove();
			}
		}
		return lb;
	}

	private static List<Building> searchByType(String type,List<Building> lb) {
		Iterator<Building> iter = lb.iterator();
		while(iter.hasNext()){
			Building b = iter.next();
			if(!(b.getString("type").equals(type))){
				iter.remove();
			}
		}
		return lb;
	}

	private static List<Building> searchByPrice(float value,List<Building> lb,int cmp){
		if(value >= 0){
			Iterator<Building> iter = lb.iterator();
			while(iter.hasNext()){
				Building b = iter.next();
				switch(cmp){
					case 1: //remueve valores menores al precio minimo exigido
						if(b.getInteger("price") < value){
							iter.remove();
						}	
					break;
					//default:
					case 2: //remueve valores mayores al precio maximo exigido 
						if(b.getInteger("price") > value){
							iter.remove();
						}
					break;
				}
			}
		}
		return lb;
	}
	
	private static List<Building> searchByCity(int pc_city, List<Building> lb){
		Iterator<Building> iter=lb.iterator();
		City c=City.findFirst("postal_code=?",pc_city);
		while(iter.hasNext()){
			Building b= iter.next();
			int bID=(int)b.getInteger("city_id");
			int cID=(int)c.getInteger("id");
			if(bID != cID){
				iter.remove();
			}
		}
		return lb;
	}
	
	private static List<Building> searchByRealEstate(int idRealEstate,List<Building> lb) {
		Iterator<Building> iter = lb.iterator();
		while(iter.hasNext()){
			Building b = iter.next();
			if((int)b.getInteger("real_estate_id")!=idRealEstate){
				iter.remove();
			}
		}
		return lb;
	}
}