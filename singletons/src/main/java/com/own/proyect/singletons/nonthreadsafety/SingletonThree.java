package com.own.proyect.singletons.nonthreadsafety;

/**
 * Lazy Initialization
 */
public class SingletonThree{
	
	private static SingletonThree instance = null;

	private SingletonThree() {}

	public static SingletonThree getInstance() {
		if (instance == null) {
			instance = new SingletonThree();
		}
		return instance;
	}

}
