/**
 * 
 */
package com.own.proyect.singletons.threadsafety;

/**
 * Inner static helper class or Initialization on Demand Holder
 */
public class SingletonFive {
	
	private SingletonFive(){}
    
    private static class SingletonHelper{
        private static final SingletonFive INSTANCE = new SingletonFive();
    }
    
    public static SingletonFive getInstance(){
        return SingletonHelper.INSTANCE;
    }

}
