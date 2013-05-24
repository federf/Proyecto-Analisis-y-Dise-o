/*package com.unrc.app;

import com.unrc.app.models.*;
import com.unrc.app.*;
import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestOwner {
    @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
        Base.openTransaction();
    }

    @After
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }

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
*/