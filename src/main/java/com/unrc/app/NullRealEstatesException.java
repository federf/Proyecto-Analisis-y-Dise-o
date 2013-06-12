package com.unrc.app;

public class NullRealEstatesException extends Exception {
	private static final long serialVersionUID = 1L;
	public NullRealEstatesException (){ 
		super ();
	}
	public NullRealEstatesException (String s){ 
		super (s);
	}
}
