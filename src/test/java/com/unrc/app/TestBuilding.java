package com.unrc.app;

import junit.framework.TestCase;

import com.unrc.app.models.*;
import com.unrc.app.*;
import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class TestBuilding extends TestCase {
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

	public static void testBuilding() {
		City rioCuarto;
		rioCuarto = City.createIt("postal_code", 58433,"name", "Rio Cuarto");
		Owner o=Owner.createIt("a@h.com", "nombre", "String apellido", 39939393, "String calle", "String barrio", 1);
		realEstate r=realEstate.createIt("Nombre","telephone","website", "street","neighborhood", "city_id");
		try {
			ABMBuilding.createBuilding(39939393, "House", "String calle", "String barrio", 1, "Descripcion", 12, "Estado", "Nombre");
			//Modifico Dueño
			ABMBuilding.modifBuilding("String calle","String barrio", 58433, "House", "String calleNueva", "String barrioNuevo", 1, "String descripcion", 123, "String estado",39939393, "Nombre");
			//Elimino Dueño
			ABMBuilding.removeBuilding("String calleNueva", "String barrioNuevo", 1);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
