package com.unrc.app;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static spark.Spark.*;
import spark.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import com.unrc.app.models.*;
import com.unrc.app.*;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Configuration;
import com.unrc.app.models.Building;

import java.util.*;

public class Inmo {
	
	public static void main( String[] args ){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
/*
 * ------------------METODOS FREEMARKER---------------------------------------------------------------------------------		
*/
	get(new Route("/Principal") { //metodo para insertar inmobiliaria
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("Principal.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/ABMOwner") { //metodo para regresar a abmowner
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("ABMOwner.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/ABMBuilding") { //metodo para regresar a abmbuilding
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("ABMBuilding.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/ABMRealEstate") { //metodo para regresar a abmrealestate
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("ABMRealEstate.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });

		get(new Route("/insertRealEstate") { //metodo para insertar inmobiliaria
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("InsertRealEstate.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/insertBuilding") { //metodo para insertar inmueble
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("InsertBuilding.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/insertOwner") { //metodo para insertar dueño
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("InsertOwner.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });

		get(new Route("/editRealEstate") { //metodo para modificar una inmobiliaria 
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("ModifRealEstate.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/editBuilding") { //metodo para modificar un inmueble
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("ModifBuilding.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/editOwner") { //metodo para modificar un inmueble
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("ModifOwner.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/removeRealEstate") { //metodo para borrar una inmobiliaria
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("DeleteRealEstate.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/removeBuilding") { //metodo para borrar un inmueble
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("DeleteBuilding.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/removeOwner") { //metodo para borrar un dueño
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("DeleteOwner.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
		
		get(new Route("/search") { ///TERMINAR!!!!!!!
			public Object handle(Request request, Response response) {
				Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				Base.openTransaction();
				StringWriter writer = new StringWriter();
				final Configuration configuracion = new Configuration();	
				configuracion.setClassForTemplateLoading(Inmo.class, "/");
				Template plantillaInmo = null;
				try {
					plantillaInmo = configuracion.getTemplate("busquedaInmu.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Map<String, Object> buildingMap = new HashMap<String, Object>();
				try {
					plantillaInmo.process(buildingMap, writer);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
		
					e.printStackTrace();
				}
				Base.commitTransaction();
				Base.close();
				 return writer;
		     };
			 });
/*
* ------------------METODOS SPARK---------------------------------------------------------------------------------		
*/
		get(new Route("/owners") {//muestra todos los dueños
	         @Override
	         public Object handle(Request request, Response response) {
	        	 Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
	        	 List<Owner> dueños=Owner.findAll();
	        	 String pantalla="";
	        	 Iterator<Owner> iter=dueños.iterator();
	        	 while(iter.hasNext()){
	        		 Owner o=iter.next();
	        		 pantalla=pantalla+ABMOwner.toString(o)+("\n")+"<br>";	
		        	}
			        Base.close();
	                String color = "<body BGCOLOR=lightblue>";
	                return color+pantalla;
	         }
	      });
				
		post(new Route("/createOwner") {//crea un dueño
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
	        	String first_name="";
				String lastName="";
				String email="";
				String Calle="";
				String Barrio="";
				int dni=-1;
				int city=-1;
				Set<String> params=request.queryParams();
		        if(params.contains("city")){
		        	city= (int)Integer.parseInt(request.queryParams("city"));
		        }
		        if(params.contains("email")){
		        	email= request.queryParams("email");
		        }
		        if(params.contains("street")){
		        	Calle= request.queryParams("street");
		        }
		        if(params.contains("neighborhood")){
		        	Barrio= request.queryParams("neighborhood");
		        }
		        if(params.contains("name")){
		        	first_name=request.queryParams("name");
		        }
		        if(params.contains("lastName")){
		        	lastName=request.queryParams("lastName");
		        }
		        if(params.contains("dni")){
		        	dni=(int)Integer.parseInt(request.queryParams("dni"));
		        }
		        //createOwner(String email, String nombre, String apellido,int dni, String calle, String barrio, int pc_ciudad)
				ABMOwner.createOwner(email, first_name, lastName, dni, Calle, Barrio, city);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Due&ntilde;o registrado</strong>";
	         }
	      });
		
		get(new Route("/modifOwner") {//modifica un dueño
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
	        	String first_name="";
				String lastName="";
				String email="";
				String Calle="";
				String Barrio="";
				int dniBusc=-1;
				int dni=-1;
				int city=-1;
				Set<String> params=request.queryParams();
				System.out.println(params);
		        if(params.contains("dni1")){
		        	dniBusc=(int)Integer.parseInt(request.queryParams("dni1"));
		        }
		        if(params.contains("city")){
		        	city= (int)Integer.parseInt(request.queryParams("city"));
		        }
		        if(params.contains("email")){
		        	email= request.queryParams("email");
		        }
		        if(params.contains("street")){
		        	Calle= request.queryParams("street");
		        }
		        if(params.contains("neighborhood")){
		        	Barrio= request.queryParams("neighborhood");
		        }
		        if(params.contains("name")){
		        	first_name=request.queryParams("name");
		        }
		        if(params.contains("lastName")){
		        	lastName=request.queryParams("lastName");
		        }
		        if(params.contains("dni2")){
		        	dni=(int)Integer.parseInt(request.queryParams("dni2"));
		        }
		        System.out.println(dniBusc+ email + first_name + lastName + dni+  Calle + Barrio + city);
				ABMOwner.modifOwner(dniBusc,email, first_name, lastName, dni, Calle, Barrio, city);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Due&ntilde;o modificado</strong>";
	         }
	      });
		
		get(new Route("/deleteOwner") {//borra un dueño segun su dni
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				int dni=-1;
				Set<String> params=request.queryParams();
		        if(params.contains("dni")){
		        	dni=(int)Integer.parseInt(request.queryParams("dni"));
		        }
		        //createOwner(String email, String nombre, String apellido,int dni, String calle, String barrio, int pc_ciudad)
				ABMOwner.removeOwner(dni);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Due&ntilde;o borrado</strong>";
	         }
	      });
		
		get(new Route("/buildings") { //muestra todos los edificios
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
	        	List<Building> inmuebles=Building.findAll();
	        	String pantalla="";
	        	Iterator<Building> iter=inmuebles.iterator();
	        	while(iter.hasNext()){
	        	 Building b=iter.next();
	        	 pantalla=pantalla+ABMBuilding.toString(b)+("\n")+"<br>";	
	        	}
		        Base.close();
                String color = "<body BGCOLOR=lightblue>";
                return color+pantalla;
	         }
	      });
		
		post(new Route("/createBuilding") {//crea un inmueble
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				int city=-1;
	        	String calle="";
				String barrio="";
				String type="";
				String realEstate="";
				String descripcion="";
				String status="";
				int precio=0;
				int dniOwner=0;
				Set<String> params=request.queryParams();
				System.out.println(params);
		        if(params.contains("city")){
		        	city= (int)Integer.parseInt(request.queryParams("city"));
		        }
		        if(params.contains("street")){
		        	calle= request.queryParams("street");
		        }
		        if(params.contains("neighborhood")){
		        	barrio= request.queryParams("neighborhood");
		        }
		        if(params.contains("type")){
		        	type= request.queryParams("type");
		        }
		        if(params.contains("realEstateName")){
		        	realEstate= request.queryParams("realEstateName");
		        }
		        if(params.contains("description")){
		        	descripcion= request.queryParams("description");
		        }
		        if(params.contains("status")){
		        	status= request.queryParams("status");
		        }
		        if(params.contains("price")){
		        	precio=Integer.parseInt(request.queryParams("price"));
		        } 
		        if(params.contains("dniOwner")){
		        	dniOwner=(int)Integer.parseInt(request.queryParams("dniOwner"));
		        }
				ABMBuilding.createBuilding(dniOwner,type,calle,barrio,city, descripcion, precio,status, realEstate);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Inmueble registrado</strong>";
	         }
	      });
		
		get(new Route("/modifBuilding") {//modifica un inmueble
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				int city=-1;
	        	String calle="";
				int citybusc=-1;
	        	String callebusc="";
				String barrio="";
				String type="";
				String descripcion="";
				String status="";
				int precio=-1;
				Set<String> params=request.queryParams();
		        if(params.contains("cityBusc")){
		        	citybusc= (int)Integer.parseInt(request.queryParams("cityBusc"));
		        }
		        if(params.contains("street1")){
		        	callebusc= request.queryParams("street1");
		        }
		        if(params.contains("cityNew")){
		        	city= (int)Integer.parseInt(request.queryParams("cityNew"));
		        }
		        if(params.contains("street2")){
		        	calle= request.queryParams("street2");
		        }
		        if(params.contains("neighborhood")){
		        	barrio= request.queryParams("neighborhood");
		        }
		        if(params.contains("type")){
		        	type= request.queryParams("type");
		        }
		        if(params.contains("description")){
		        	descripcion= request.queryParams("description");
		        }
		        if(params.contains("status")){
		        	status= request.queryParams("status");
		        }
		        if(params.contains("price")){
		        	precio=Integer.parseInt(request.queryParams("price"));
		        } 
				ABMBuilding.modifBuilding(callebusc,citybusc, type,calle,barrio,city, descripcion, precio,status);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Inmueble modificado</strong>";
	         }
	      });
		
		delete(new Route("/deleteBuilding") {//borra un inmueble segun su direccion
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				int city=-1;
	        	String calle="";
				String barrio="";
				Set<String> params=request.queryParams();
				if(params.contains("city")){
		        	city= (int)Integer.parseInt(request.queryParams("city"));
		        }
		        if(params.contains("street")){
		        	calle= request.queryParams("street");
		        }
		        if(params.contains("neighborhood")){
		        	barrio= request.queryParams("neighborhood");
		        }
				ABMBuilding.removeBuilding(calle,barrio,city);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Inmueble Borrado</strong>";
	         }
	      });
		
		get(new Route("/realEstates") { //muestra todas las inmobiliarias
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
	        	List<realEstate> inmo=realEstate.findAll();
	        	String pantalla="";
	        	Iterator<realEstate> iter=inmo.iterator();
	        	while(iter.hasNext()){
	        	 realEstate b=iter.next();
	        	 pantalla=pantalla+ABMreal_estates.toString(b)+("\n")+"<br>";	
	        	}
		        Base.close();
                String color = "<body BGCOLOR=lightblue>";
                return color+pantalla;
	         }
	      });
		
	post(new Route("/createRealEstate") {//crea una inmobiliaria
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				int city=-1;
	        	String calle="";
				String barrio="";
				String name="";
				String email="";
				String web="";
				int telefono=-1;
				int dniOwner=-1;
				Set<String> params=request.queryParams();
		        if(params.contains("city")){
		        	city= (int)Integer.parseInt(request.queryParams("city"));
		        }
		        if(params.contains("telephone")){
		        	telefono= (int)Integer.parseInt(request.queryParams("telephone"));
		        }
		        if(params.contains("street")){
		        	calle= request.queryParams("street");
		        }
		        if(params.contains("neighborhood")){
		        	barrio= request.queryParams("neighborhood");
		        }
		        if(params.contains("name")){
		        	name= request.queryParams("name");
		        }
		        if(params.contains("email")){
		        	email= request.queryParams("email");
		        }
		        if(params.contains("website")){
		        	web= request.queryParams("website");
		        }
		        if(params.contains("dniOwner")){
		        	dniOwner=(int)Integer.parseInt(request.queryParams("dniOwner"));
		        }
		        //public static void createRealEstate(String nombre, int telefono,String email, String website, String calle, String barrio, int pc_ciudad, int dni_dueño)
				ABMreal_estates.createRealEstate(name, telefono, email, web, calle, barrio, city, dniOwner);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Inmobiliaria registrada</strong>";
	         }
	      });
		
		get(new Route("/modifRealEstate") {//modifica una inmobiliaria
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				int city=-1;
				String name1="";
	        	String calle="";
				String barrio="";
				String name2="";
				String email="";
				String web="";
				int telefono=-1;
				Set<String> params=request.queryParams();
		        if(params.contains("city")){
		        	city= (int)Integer.parseInt(request.queryParams("city"));
		        }
		        if(params.contains("telephone")){
		        	telefono= (int)Integer.parseInt(request.queryParams("telephone"));
		        }
		        if(params.contains("street")){
		        	calle= request.queryParams("street");
		        }
		        if(params.contains("neighborhood")){
		        	barrio= request.queryParams("neighborhood");
		        }
		        if(params.contains("nameViejo")){
		        	name1= request.queryParams("nameViejo");
		        }
		        if(params.contains("nameNuevo")){
		        	name2= request.queryParams("nameNuevo");
		        }
		        if(params.contains("email")){
		        	email= request.queryParams("email");
		        }
		        if(params.contains("website")){
		        	web= request.queryParams("website");
		        }
				ABMreal_estates.modifRealEstate(name1,name2, telefono, email, web, calle, barrio, city);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Inmobiliaria modificada</strong>";
	         }
	      });
		
		delete(new Route("/deleteRealEstate") {//remueve una inmobiliaria segun su nombre
	         @Override
	         public Object handle(Request request, Response response) {
	        	Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
				String name="";
				Set<String> params=request.queryParams();
		        if(params.contains("name")){
		        	name= request.queryParams("name");
		        }
		        ABMreal_estates.removeRealEstate(name);
	        	Base.close();
	        	response.status(201);
                String color = "<body BGCOLOR=lightblue>";
                return color + "<strong>Inmobiliaria Borrada</strong>";
	         }
	      });
		
		get(new Route("/searchBuilding"){ 
			 public Object handle(Request request, Response response) {
		    		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmo", "root", "root");
		    		String pantalla="";
		        	
		        	int city;
		        	if (request.queryParams("city").equals(""))
		        		city=-1;
		        	else
		        		city=Integer.parseInt(request.queryParams("city"));
		        	String status= request.queryParams("status");
		        	int minPrice= Integer.parseInt(request.queryParams("minPrice"));
		        	int maxPrice= Integer.parseInt(request.queryParams("maxPrice"));
		        	/*if (minPrice>maxPrice) {
		        		int aux=minPrice;
		        		minPrice=maxPrice;
		        		maxPrice=minPrice;
		        	}*/
		        	String type=request.queryParams("type");
		        	String realEstateName=request.queryParams("realEstateName");
		        	int dniOwner;
		        	if (request.queryParams("dniOwner").equals(""))
		        		dniOwner=-1;
		        	else
		        		dniOwner=Integer.parseInt(request.queryParams("dniOwner"));
		        	System.out.println("city="+city+" realEstate="+realEstateName+" dniOwner="+dniOwner+" maxPrice="+maxPrice+" minPrice="+minPrice+" status="+status+" type="+type);
		        	List<Building> b=search2.busquedaBuildings2(type, status, minPrice, maxPrice,city, realEstateName, dniOwner);
		        	for(int i=0; i<b.size(); i++){
		        		Building inmo=b.get(i);
		        		pantalla+=ABMBuilding.toString(inmo).concat("\n")+"<br>";	
		        	}
		    		Base.close();
	                String color = "<body BGCOLOR=lightblue>";
	                return color+pantalla;
		         }
		});
		Base.close();
    }
}

