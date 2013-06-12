package com.unrc.app;

import com.unrc.app.models.*;

import java.util.LinkedList;
import java.util.List;

public class search2 {
	public static List<Building> busquedaBuildings2(String type, String status, int minPrice, int maxPrice, int pc_city, String nombreInmo, int dniOwner ){
		List<Building> lb;
		realEstate r=realEstate.findFirst("name=?", nombreInmo);
		City c=City.findFirst("postal_code=?", pc_city);
		Owner o=Owner.findFirst("dni=?", dniOwner);
		if(!type.equals("")){ 
			if(!status.equals("")){ 
				if(o!=null){ 
					if(c!=null){
						if (r!=null) {
							lb=Building.find("type=? and owner_id=? and city_id=? and real_estate_id=? and status=?",
							type,o.getId(), c.getId(), r.getId(), status);
						}else{
							lb=Building.find("type=? and owner_id=? and city_id=? and status=?",
							type,o.getId(), c.getId(), status);
						}
					} else {
						if (r!=null) {
							lb=Building.find("type=? and owner_id=? and real_estate_id=? and status=?",
							type,o.getId(), r.getId(), status);
						}else{
							lb=Building.find("type=? and owner_id=? and status=?",
							type,o.getId(), status);
						}
					}
				} else {
					if(c!=null){
						if (r!=null) {
							lb=Building.find("type=? and city_id=? and real_estate_id=? and status=?",
							type, c.getId(), r.getId(), status);
						}else{
							lb=Building.find("type=? and city_id=? and status=?",
							type, c.getId(), status);
						}
					} else {
						if (r!=null) {
							lb=Building.find("type=? and real_estate_id=? and status=?",
							type, r.getId(), status);
						}else{
							lb=Building.find("type=? and status=?",
							type, status);
						}
					}
				}
			} else {
				if(o!=null){ 
					if(c!=null){
						if (r!=null) {
							lb=Building.find("type=? and owner_id=? and city_id=? and real_estate_id=?",
							type,o.getId(), c.getId(), r.getId());
						}else{
							lb=Building.find("type=? and owner_id=? and city_id=?",
							type,o.getId(), c.getId());
						}
					} else {
						if (r!=null) {
							lb=Building.find("type=? and owner_id=? and real_estate_id=?",
							type,o.getId(), r.getId());
						}else{
							lb=Building.find("type=? and owner_id=?",
							type,o.getId());
						}
					}
				} else {
					if(c!=null){
						if (r!=null) {
							lb=Building.find("type=? and city_id=? and real_estate_id=?",
							type, c.getId(), r.getId());
						}else{
							lb=Building.find("type=? and city_id=?",
							type, c.getId());
						}
					} else {
						if (r!=null) {
							lb=Building.find("type=? and real_estate_id=?",
							type, r.getId());
						}else{
							lb=Building.find("type=?",
							type);
						}
					}
				}
			}
		} else {
			if(!status.equals("")){ 
				if(o!=null){ 
					if(c!=null){
						if (r!=null) {
							lb=Building.find("type=? and owner_id=? and city_id=? and real_estate_id=? and status=?",
							type,o.getId(), c.getId(), r.getId(), status);
						}else{
							lb=Building.find("type=? and owner_id=? and city_id=? and status=?",
							type,o.getId(), c.getId(), status);
						}
					} else {
						if (r!=null) {
							lb=Building.find("type=? and owner_id=? and real_estate_id=? and status=?",
							type,o.getId(), r.getId(), status);
						}else{
							lb=Building.find("type=? and owner_id=? and status=?",
							type,o.getId(), status);
						}
					}
				} else {
					if(c!=null){
						if (r!=null) {
							lb=Building.find("type=? and city_id=? and real_estate_id=? and status=?",
							type, c.getId(), r.getId(), status);
						}else{
							lb=Building.find("type=? and city_id=? and status=?",
							type, c.getId(), status);
						}
					} else {
						if (r!=null) {
							lb=Building.find("type=? and real_estate_id=? and status=?",
							type, r.getId(), status);
						}else{
							lb=Building.find("type=? and status=?",
							type, status);
						}
					}
				}
			} else {
				if(o!=null){ 
					if(c!=null){
						if (r!=null) {
							lb=Building.find("owner_id=? and city_id=? and real_estate_id=?",
							o.getId(), c.getId(), r.getId());
						}else{
							lb=Building.find("owner_id=? and city_id=?",
							o.getId(), c.getId());
						}
					} else {
						if (r!=null) {
							lb=Building.find("owner_id=? and real_estate_id=?",
							o.getId(), r.getId());
						}else{
							lb=Building.find("owner_id=?",
							o.getId());
						}
					}
				} else {
					if(c!=null){
						if (r!=null) {
							lb=Building.find("city_id=? and real_estate_id=?",
							c.getId(), r.getId());
						}else{
							lb=Building.find("city_id=?",
							c.getId());
						}
					} else {
						if (r!=null) {
							lb=Building.find("real_estate_id=?",
							r.getId());
						}else{
							lb=Building.findAll();
						}
					}
				}
			}
		}
		if((minPrice==0)&&(maxPrice==0)){
			return lb;
		}else{
			if(minPrice<maxPrice){
				lb=searchByPrice(minPrice, maxPrice, lb, 1);
			}else{
				if((maxPrice==0)&&(minPrice!=0)){
					lb=searchByPrice(minPrice, Integer.MAX_VALUE, lb, 1);	
				}
			}
		}
		return lb;
	}
	
	private static List<Building> searchByPrice(int min,int max,List<Building> lb,int cmp){
		List<Building> res=new LinkedList<Building>();
		for (int i=0; i<lb.size();i++){
			Building b = lb.get(i);
			if( (b.getInteger("price")) >= min){
				if((b.getInteger("price")) <= max){
					res.add(b);
				}
			}
		}
		return res;
	}
}
