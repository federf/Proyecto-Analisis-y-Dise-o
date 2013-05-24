package com.unrc.app.models;

import org.javalite.activejdbc.Model;



public class ownersRealEstates extends Model{
	static{
		validatePresenceOf("owner_id","real_estate_id");
	}
}
