package com.unrc.app;

import com.unrc.app.models.*;
import com.unrc.app.*;
import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestCity extends TestCase {

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
	public static void testOwner() {
		//Creo Dueño		
		ABMCity.crearCiudad(58433, "Rio Cuarto");
		//Modifico Dueño
		ABMCity.modifCiudad(58433,"Vicuña Mackenna");
		//Elimino Dueño
		ABMCity.removeCiudad(58433);
	}


}
