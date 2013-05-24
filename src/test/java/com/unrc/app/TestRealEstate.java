package com.unrc.app;

import junit.framework.TestCase;

import com.unrc.app.models.*;
import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class TestRealEstate extends TestCase {

	@Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "64784");
        Base.openTransaction();
    }

    @After
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }

	public static void testRealEstate() {
	
		City.createIt("postal_code", 58433,"name", "Rio Cuarto");
		//Creo Inmobiliaria		
		ABMreal_estates.createRealEstate("String nombre", 123,"string email", "String website", "String calle", "String barrio", 1, 39939393);
		//Modifico Inmobiliaria
		//modifRealEstate(String nombre, int telefono, String website, String calle, String barrio, int ciudad)
		ABMreal_estates.modifRealEstate("nombreInmo","nombreInmo2", 1232,"email@ejemplo.com", "web.com", "calleej", "barrioej", 39939393);
		//Elimino Inmobiliaria
		ABMreal_estates.removeRealEstate("b@h.com");
	}
}
