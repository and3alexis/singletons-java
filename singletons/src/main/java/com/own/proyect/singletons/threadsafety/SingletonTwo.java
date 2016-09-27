/**
 * 
 */
package com.own.proyect.singletons.threadsafety;

/**
 * Auto ThreadSafe + Eager initialization
 */
public class SingletonTwo {
	
	private static final SingletonTwo instance = new SingletonTwo();
	 
	private SingletonTwo() {}
 
	// Runtime initialization By defualt ThreadSafe
	public static SingletonTwo getInstance() {
		return instance;
	}

}
