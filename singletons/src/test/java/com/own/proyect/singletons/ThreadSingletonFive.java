/**
 * 
 */
package com.own.proyect.singletons;

import java.util.concurrent.Callable;

import com.own.proyect.singletons.threadsafety.SingletonFive;

/**
 *
 */
public class ThreadSingletonFive implements Callable<SingletonFive> {

	public SingletonFive call() throws Exception {
		return SingletonFive.getInstance();
	}

}
