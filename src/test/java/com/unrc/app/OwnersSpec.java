/*package com.unrc.app;

<<<<<<< HEAD
import com.unrc.app.models.Owner;
=======
import com.unrc.app.models.Owners;
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class OwnersSpec{

    @Before
    public void before(){
<<<<<<< HEAD
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
=======
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
        Base.openTransaction();
    }

    @After
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }

    @Test
    public void shouldValidateMandatoryFields(){

<<<<<<< HEAD
        Owner owner = new Owner();
=======
        Owners owner = new Owners();
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108

        //check errors
        the(owner).shouldNotBe("valid");
        the(owner.errors().get("first_name")).shouldBeEqual("value is missing");
        the(owner.errors().get("last_name")).shouldBeEqual("value is missing");

        //set missing values
        owner.set("first_name", "Fede", "last_name", "Franco");

        //all is good:
        the(owner).shouldBe("valid");
    }
}*/
