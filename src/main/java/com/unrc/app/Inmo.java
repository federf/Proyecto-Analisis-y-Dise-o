package com.unrc.app;

import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.realEstate;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmo {
    public static void main( String[] args ){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "64784");

		System.out.println( "Hello World!" );
    }
}
