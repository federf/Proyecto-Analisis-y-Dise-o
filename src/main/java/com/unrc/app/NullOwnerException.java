package com.unrc.app;

public class NullOwnerException extends Exception {
	private static final long serialVersionUID = 1L;
	public NullOwnerException (){ 
		super ();
	}
	public NullOwnerException (String s){ 
		super (s);
	}
}
