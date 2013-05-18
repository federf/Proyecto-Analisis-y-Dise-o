package com.unrc.app;

import com.unrc.app.models.*;

public class TestRealEstate {

	public static void testRealEstate() {
		City rioCuarto;
		rioCuarto = City.createIt("postal_code", 58433,"name", "Rio Cuarto");
		//Creo Inmobiliaria		
		ABMreal_estates.createRealEstate("String nombre", 123, "String website", "String calle", "String barrio", 1, 39939393);
		//Modifico Inmobiliaria
		//modifRealEstate(String nombre, int telefono, String website, String calle, String barrio, int ciudad)
		ABMreal_estates.modifRealEstate("nombreInmo", 1232, "web.com", "Calle", "calleej", "barrioej", 39939393);
		//Elimino Inmobiliaria
		ABMreal_estates.removeRealEstate("b@h.com");
	}
}