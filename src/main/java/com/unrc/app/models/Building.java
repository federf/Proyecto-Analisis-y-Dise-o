package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
	static{
<<<<<<< HEAD
		validatePresenceOf("owner_id","description","price","status","type", "street","neighborhood", "city_id","real_estate_id");
=======
		validatePresenceOf("description","price","status","type", "owner_id", "real_estate_id", "street","neighborhood", "city_id");
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
	}
}
