package com.unrc.app;

import com.unrc.app.models.realEstate;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.javalite.test.jspec.JSpec.the;

public class TestRealEstate {

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
    @Test
	public void testRealEstate() {
        realEstate real = new realEstate();

        //check errors
        the(real).shouldNotBe("valid");
        the(real.errors().get("name")).shouldBeEqual("value is missing");
        the(real.errors().get("telephone")).shouldBeEqual("value is missing");
        the(real.errors().get("website")).shouldBeEqual("value is missing");
        the(real.errors().get("street")).shouldBeEqual("value is missing");
        the(real.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(real.errors().get("city_id")).shouldBeEqual("value is missing");
       	ABMCity.crearCiudad(58433,"Rio Cuarto");
       	//set missing values
       	real.set("name", "nombre", "telephone", 123132, "website", "website", "street","street","neighborhood", "neighborhood", "city_id",58433);
       	//all is good:
       	the(real).shouldBe("valid");
	}
}
