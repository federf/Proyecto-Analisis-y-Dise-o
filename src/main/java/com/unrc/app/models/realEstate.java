package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class realEstate extends Model{
	static{
		validatePresenceOf("name","telephone","website", "street","neighborhood", "city_id");
	}
}
