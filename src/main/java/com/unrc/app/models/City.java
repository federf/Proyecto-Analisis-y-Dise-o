package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class City extends Model{
	static{
<<<<<<< HEAD
		validatePresenceOf("postal_code","name");
=======
		validatePresenceOf("name","postal_code");
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
	}
}
