package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
	static{
		validatePresenceOf("description","price","status","type", "owner_id", "real_estate_id", "street","neighborhood", "city_id");
	}
}
