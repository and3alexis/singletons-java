/**
 * 
 */
package com.own.proyect.singletons.threadsafety;

/**
 * Thread Safe Singleton
 */
public class SingletonFour {
	
	private static SingletonFour instance;
    
    private SingletonFour(){}
    
    public static synchronized SingletonFour getInstance(){
        if(instance == null){
            instance = new SingletonFour();
        }
        return instance;
    }

}
