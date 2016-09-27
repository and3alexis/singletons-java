/**
 * 
 */
package com.own.proyect.singletons.threadsafety;

/**
 * Lazy Initialization + ThreadSafe with synchronized block
 */
public class SingletonOne {
	
	private static SingletonOne instance = null;
	
	private SingletonOne(){}

	public static SingletonOne getInstance(){
		if(instance == null){
			synchronized (SingletonOne.class){
				if(instance == null) instance = new SingletonOne();
			}
		}
		return instance;
	}


}
