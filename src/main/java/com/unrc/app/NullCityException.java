package com.unrc.app;

public class NullCityException extends Exception {
	private static final long serialVersionUID = 1L;
	public NullCityException (){ 
		super ();
	}
	public NullCityException (String s){ 
		super (s);
	}
}

