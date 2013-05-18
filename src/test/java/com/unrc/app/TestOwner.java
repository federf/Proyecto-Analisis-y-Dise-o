package com.unrc.app;

import com.unrc.app.models.*;
import com.unrc.app.*;

public class TestOwner {

	public static void testOwner() {
		City rioCuarto;
		rioCuarto = City.createIt("postal_code", 58433,"name", "Rio Cuarto");
		//Creo Dueño		
		ABMOwner.createOwner("a@h.com", "nombre", "String apellido", 39939393, "String calle", "String barrio", rioCuarto.getInteger("id"));
		//Modifico Dueño
		ABMOwner.modifOwner("b@h.com", "nombre2", "String apellido", 39939393, "String calle", "String barrio", rioCuarto.getInteger("id"));
		//Elimino Dueño
//		ABMOwner.removeOwner(39939393);
	}
}