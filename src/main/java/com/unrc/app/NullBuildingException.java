package com.unrc.app;

public class NullBuildingException extends Exception {
	private static final long serialVersionUID = 1L;
	public NullBuildingException (){ 
		super ();
	}
	public NullBuildingException (String s){ 
		super (s);
	}
}
