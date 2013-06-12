package com.unrc.app;

import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class OwnersSpec{

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
    public void shouldValidateMandatoryFields(){

        Owner owner = new Owner();

        //check errors
        the(owner).shouldNotBe("valid");
        the(owner.errors().get("first_name")).shouldBeEqual("value is missing");
        the(owner.errors().get("last_name")).shouldBeEqual("value is missing");

        //set missing values
        owner.set("first_name", "Federico", "last_name", "Franco");

        //all is good:
        the(owner).shouldBe("valid");
    }
}
